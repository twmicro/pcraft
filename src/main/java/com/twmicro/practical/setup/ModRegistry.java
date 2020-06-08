package com.twmicro.practical.setup;

import com.twmicro.practical.PracticalMod;
import com.twmicro.practical.blocks.*;
import com.twmicro.practical.entities.HookArrowEntity;
import com.twmicro.practical.entities.LightningArrow;
import com.twmicro.practical.entities.TNTTankEntity;
import com.twmicro.practical.entities.TeleportingArrow;
import com.twmicro.practical.items.food.GodApple;
import com.twmicro.practical.items.ingredients.*;
import com.twmicro.practical.items.spawn_wands.TNTTankItem;
import com.twmicro.practical.items.swords.*;
import com.twmicro.practical.items.tools.emerald.*;
import com.twmicro.practical.items.tools.ruby.*;
import com.twmicro.practical.proxy.ClientProxy;
import com.twmicro.practical.utils.enums.ModArmorMaterials;
import net.minecraft.block.Block;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModRegistry {
    public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, PracticalMod.MODID);
    public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, PracticalMod.MODID);
    public static final DeferredRegister<EntityType<?>> ENTITIES = new DeferredRegister<>(ForgeRegistries.ENTITIES, PracticalMod.MODID);
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS = new DeferredRegister<>(ForgeRegistries.SOUND_EVENTS, PracticalMod.MODID);
    public static void init() {
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ENTITIES.register(FMLJavaModLoadingContext.get().getModEventBus());
        SOUND_EVENTS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
    public static final RegistryObject<Block> VARRACK = BLOCKS.register("varrack", VarrackBlock::new);
    public static final RegistryObject<Item> VARRACK_BLOCK_ITEM = ITEMS.register("varrack", () -> new BlockItemBase(VARRACK.get()));
    public static final RegistryObject<Block> RUBY_SHARD_ORE = BLOCKS.register("ruby_shard_ore", RubyShardOre::new);
    public static final RegistryObject<Item> RUBY_SHARD_ORE_ITEM = ITEMS.register("ruby_shard_ore", () -> new BlockItemBase(RUBY_SHARD_ORE.get()));
    public static final RegistryObject<Block> RAINBOW_BLOCK = BLOCKS.register("rainbow_block", RainbowBlock::new);
    public static final RegistryObject<Item> RAINBOW_BLOCK_ITEM = ITEMS.register("rainbow_block", () -> new BlockItemBase(RAINBOW_BLOCK.get()));
    public static final RegistryObject<Item> GOD_SWORD = ITEMS.register("god_sword", GodSword::new);
    public static final RegistryObject<Item> EMERALD_SWORD = ITEMS.register("emerald_sword", EmeraldSword::new);
    public static final RegistryObject<Item> POISON_SWORD = ITEMS.register("poison_sword", PoisonSword::new);
    public static final RegistryObject<Item> ANGER_SWORD = ITEMS.register("sword_of_anger", AngerSword::new);
    public static final RegistryObject<Item> RUBY_SHARD = ITEMS.register("ruby_shard", RubyShard::new);
    public static final RegistryObject<Item> RUBY_INGOT = ITEMS.register("ruby_ingot", RubyIngot::new);
    public static final RegistryObject<Item> RUBY_SWORD = ITEMS.register("ruby_sword", RubySword::new);
    public static final RegistryObject<Item> RUBY_AXE = ITEMS.register("ruby_axe", RubyAxe::new);
    public static final RegistryObject<Item> RUBY_PICKAXE = ITEMS.register("ruby_pickaxe", RubyPickaxe::new);
    public static final RegistryObject<Item> RUBY_SHOVEL = ITEMS.register("ruby_shovel", RubyShovel::new);
    public static final RegistryObject<Item> RUBY_HOE = ITEMS.register("ruby_hoe", RubyHoe::new);
    public static final RegistryObject<Item> HERO_SWORD = ITEMS.register("hero_sword", HeroSword::new);
    public static final RegistryObject<Item> EMERALD_AXE = ITEMS.register("emerald_axe", EmeraldAxe::new);
    public static final RegistryObject<Item> EMERALD_PICKAXE = ITEMS.register("emerald_pickaxe", EmeraldPickaxe::new);
    public static final RegistryObject<Item> EMERALD_SHOVEL = ITEMS.register("emerald_shovel", EmeraldShovel::new);
    public static final RegistryObject<Item> EMERALD_HOE = ITEMS.register("emerald_hoe", EmeraldHoe::new);
    public static final RegistryObject<Item> GOD_APPLE = ITEMS.register("god_apple", GodApple::new);
    public static final RegistryObject<ArmorItem> RUBY_HELMET = ITEMS.register("ruby_helmet",
            () -> new ArmorItem(ModArmorMaterials.RUBY_ARMOR_MATERIAL, EquipmentSlotType.HEAD,
                    new Item.Properties().group(ItemGroup.COMBAT)));

    public static final RegistryObject<ArmorItem> RUBY_CHESTPLATE = ITEMS.register("ruby_chestplate",
            () -> new ArmorItem(ModArmorMaterials.RUBY_ARMOR_MATERIAL, EquipmentSlotType.CHEST,
                    new Item.Properties().group(ItemGroup.COMBAT)));

    public static final RegistryObject<ArmorItem> RUBY_LEGGINGS = ITEMS.register("ruby_leggings",
            () -> new ArmorItem(ModArmorMaterials.RUBY_ARMOR_MATERIAL, EquipmentSlotType.LEGS,
                    new Item.Properties().group(ItemGroup.COMBAT)));

    public static final RegistryObject<ArmorItem> RUBY_BOOTS = ITEMS.register("ruby_boots",
            () -> new ArmorItem(ModArmorMaterials.RUBY_ARMOR_MATERIAL, EquipmentSlotType.FEET,
                    new Item.Properties().group(ItemGroup.COMBAT)));
    public static final RegistryObject<ArmorItem> EMERALD_HELMET = ITEMS.register("emerald_helmet",
            () -> new ArmorItem(ModArmorMaterials.EMERALD_ARMOR_MATERIAL, EquipmentSlotType.HEAD,
                    new Item.Properties().group(ItemGroup.COMBAT)));

    public static final RegistryObject<ArmorItem> EMERALD_CHESTPLATE = ITEMS.register("emerald_chestplate",
            () -> new ArmorItem(ModArmorMaterials.EMERALD_ARMOR_MATERIAL, EquipmentSlotType.CHEST,
                    new Item.Properties().group(ItemGroup.COMBAT)));

    public static final RegistryObject<ArmorItem> EMERALD_LEGGINGS = ITEMS.register("emerald_leggings",
            () -> new ArmorItem(ModArmorMaterials.EMERALD_ARMOR_MATERIAL, EquipmentSlotType.LEGS,
                    new Item.Properties().group(ItemGroup.COMBAT)));

    public static final RegistryObject<ArmorItem> EMERALD_BOOTS = ITEMS.register("emerald_boots",
            () -> new ArmorItem(ModArmorMaterials.EMERALD_ARMOR_MATERIAL, EquipmentSlotType.FEET,
                    new Item.Properties().group(ItemGroup.COMBAT)));
    public static final RegistryObject<EntityType<TNTTankEntity>> TNT_TANK_ENTITY = ENTITIES.register("tnt_tank", () -> EntityType.Builder.create(TNTTankEntity::new, EntityClassification.CREATURE)
            .size(1, 1)
            .setShouldReceiveVelocityUpdates(false)
            .build("tnt_tank"));
    public static final RegistryObject<Item> TNT_TANK_ITEM = ITEMS.register("tnt_tank_item", TNTTankItem::new);
    public static final RegistryObject<SoundEvent> TANK_SHOT = SOUND_EVENTS.register("sounds/tank_shot", () -> new SoundEvent(new ResourceLocation("practical", "tank_shot")));
    public static final RegistryObject<EntityType<HookArrowEntity>> HOOK_ARROW_ENTITY = ENTITIES.register("hook_arrow", () -> EntityType.Builder.<HookArrowEntity>create(HookArrowEntity::new, EntityClassification.CREATURE)
            .size(1, 1)
            .setShouldReceiveVelocityUpdates(false)
            .build("hook_arrow"));
    public static final RegistryObject<Item> HOOK_ARROW_ITEM = ITEMS.register("hook_arrow_item", HookArrowItem::new);
    public static final RegistryObject<EntityType<LightningArrow>> LIGHTNING_ARROW_ENTITY = ENTITIES.register("lightning_arrow", () -> EntityType.Builder.<LightningArrow>create(LightningArrow::new, EntityClassification.CREATURE)
            .size(1, 1)
            .setShouldReceiveVelocityUpdates(false)
            .build("lightning_arrow"));
    public static final RegistryObject<Item> LIGHTNING_ARROW_ITEM = ITEMS.register("lightning_arrow_item", LightningArrowItem::new);
    public static final RegistryObject<EntityType<TeleportingArrow>> TELEPORTING_ARROW_ENTITY = ENTITIES.register("teleporting_arrow", () -> EntityType.Builder.<TeleportingArrow>create(TeleportingArrow::new, EntityClassification.CREATURE)
            .size(1, 1)
            .setShouldReceiveVelocityUpdates(false)
            .build("teleporting_arrow"));
    public static final RegistryObject<Item> TELEPORTING_ARROW_ITEM = ITEMS.register("teleporting_arrow_item", TeleportingArrowItem::new);
    public static final RegistryObject<Block> RUBY_BLOCK = BLOCKS.register("ruby_block", RubyBlock::new);
    public static final RegistryObject<Item> RUBY_BLOCK_ITEM = ITEMS.register("ruby_block", () -> new BlockItemBase(RUBY_BLOCK.get()));
    public static final RegistryObject<Item> EMERALD_UNIVERSAL_TOOL = ITEMS.register("universal_emerald_tool", UniversalEmeraldTool::new);
    public static final RegistryObject<SoundEvent> TNT_TANK_IDLE = SOUND_EVENTS.register("entity.tnt_tank.tank_idle", () -> new SoundEvent(new ResourceLocation("practical", "entity.tnt_tank.idle")));
    public static final RegistryObject<SoundEvent> TNT_TANK_SHOT = SOUND_EVENTS.register("entity.tnt_tank.tank_shot", () -> new SoundEvent(new ResourceLocation("practical", "entity.tnt_tank.shot")));
    public static final RegistryObject<SoundEvent> TNT_TANK_EXPLOSION = SOUND_EVENTS.register("entity.tnt_tank.tank_explosion", () -> new SoundEvent(new ResourceLocation("practical", "entity.tnt_tank.explosion")));
    public static final RegistryObject<Item> RUBY_UNIVERSAL_TOOL = ITEMS.register("universal_ruby_tool", UniversalRubyTool::new);
}
