package com.twmicro.practical.proxy;

import com.twmicro.practical.PracticalMod;
import com.twmicro.practical.entities.renderers.*;
import com.twmicro.practical.setup.ModRegistry;
import com.twmicro.practical.setup.RandomTradeBuilder;
import com.twmicro.practical.structures.pieces.LegendaryBasePiece;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.merchant.villager.VillagerProfession;
import net.minecraft.item.ItemStack;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.GameRules;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ModSubscriber {
    public static KeyBinding USE_SPECIAL_FEATURE = new KeyBinding("key.use_special_feature.desc", 82, "key.categories.misc");
    public static GameRules.RuleKey<GameRules.BooleanValue> ENABLE_TANK_RANDOM_MOVEMENT;
    public static void init(final FMLClientSetupEvent event){
        ClientRegistry.registerKeyBinding(USE_SPECIAL_FEATURE);
        RenderingRegistry.registerEntityRenderingHandler(ModRegistry.TNT_TANK_ENTITY.get(), TNTTankRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(ModRegistry.HOOK_ARROW_ENTITY.get(), HookArrowRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(ModRegistry.LIGHTNING_ARROW_ENTITY.get(), LightningArrowRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(ModRegistry.TELEPORTING_ARROW_ENTITY.get(), TeleportingArrowRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(ModRegistry.TNT_ARROW_ENTITY.get(), TNTArrowRenderer::new);
        PracticalMod.LEGENDARY_BASE_PIECE = Registry.register(Registry.STRUCTURE_PIECE, PracticalMod.BASE_LOC, LegendaryBasePiece.Piece::new);
        try {
            Method createBoolean = ObfuscationReflectionHelper.findMethod(GameRules.BooleanValue.class, "func_223568_b", boolean.class);
            Object boolFalse = createBoolean.invoke(GameRules.BooleanValue.class, false);
            createBoolean.setAccessible(true);
            ENABLE_TANK_RANDOM_MOVEMENT = GameRules.register("enableTankRandomMovement", (GameRules.RuleType<GameRules.BooleanValue>) boolFalse);
        }
        catch (IllegalAccessException e ) {}
        catch (InvocationTargetException e) {}
    }

    @SubscribeEvent
    public void onTradesSetup(VillagerTradesEvent event) {
        if (event.getType() == VillagerProfession.ARMORER) {
            ItemStack enchantedChestplate = new ItemStack(ModRegistry.EMERALD_CHESTPLATE.get());
            ItemStack enchantedLeggings = new ItemStack(ModRegistry.EMERALD_LEGGINGS.get());
            ItemStack enchantedHelmet = new ItemStack(ModRegistry.EMERALD_HELMET.get());
            ItemStack enchantedBoots = new ItemStack(ModRegistry.EMERALD_BOOTS.get());
            ItemStack[] enchantedSet = {enchantedHelmet, enchantedBoots, enchantedChestplate, enchantedLeggings};
            for (int i = 0; i < enchantedSet.length; i++) {
                enchantedSet[i].addEnchantment(Enchantments.UNBREAKING, 3);
                enchantedSet[i].addEnchantment(Enchantments.PROTECTION, 1);
                int finalI = i;
                event.getTrades().get(2).add(
                        new RandomTradeBuilder(2, 2, 0.5F).
                                setEmeraldPrice(12, 16).
                                setForSale((random) -> (enchantedSet[finalI])).
                                build()
                );
            }
        } else if (event.getType() == VillagerProfession.TOOLSMITH) {
            ItemStack enchantedPickaxe = new ItemStack(ModRegistry.EMERALD_PICKAXE.get());
            ItemStack enchantedAxe = new ItemStack(ModRegistry.EMERALD_AXE.get());
            ItemStack enchantedHoe = new ItemStack(ModRegistry.EMERALD_HOE.get());
            ItemStack enchantedShovel = new ItemStack(ModRegistry.EMERALD_SHOVEL.get());
            ItemStack enchantedUniversalTool = new ItemStack(ModRegistry.EMERALD_UNIVERSAL_TOOL.get());
            ItemStack[] enchantedSet = {enchantedPickaxe, enchantedAxe, enchantedHoe, enchantedShovel, enchantedUniversalTool};
            for (int i = 0; i < enchantedSet.length; i++) {
                enchantedSet[i].addEnchantment(Enchantments.UNBREAKING, 3);
                enchantedSet[i].addEnchantment(Enchantments.EFFICIENCY, 1);
                int finalI = i;
                event.getTrades().get(2).add(
                        new RandomTradeBuilder(2, 2, 0.5F).
                                setEmeraldPrice(12, 16).
                                setForSale((random) -> (enchantedSet[finalI])).
                                build()
                );
            }
        } else if (event.getType() == VillagerProfession.FARMER) {
            event.getTrades().get(4).add(
                    new RandomTradeBuilder(5, 2, 0.5F).
                            setEmeraldPrice(64, 64).
                            setForSale(RandomTradeBuilder.createFunction(ModRegistry.GOD_APPLE.get(), 1, 1)).
                            build()
            );
        }
    }
}
