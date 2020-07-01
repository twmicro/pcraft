package com.twmicro.practical.setup;

import com.twmicro.practical.types.ModEntities;
import com.twmicro.practical.entities.renderers.*;
import com.twmicro.practical.types.ModArmor;
import com.twmicro.practical.types.ModItems;
import com.twmicro.practical.types.ModToolItems;
import com.twmicro.practical.types.not_deferred.ModKeybindings;
import com.twmicro.practical.types.not_deferred.ModTrades;
import com.twmicro.practical.utils.classes.RandomTradeBuilder;
import com.twmicro.practical.world.gen.OreGenerator;
import net.minecraft.client.gui.screen.EditGamerulesScreen;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.merchant.villager.VillagerProfession;
import net.minecraft.item.ItemStack;
import net.minecraft.world.GameRules;
import net.minecraft.world.biome.Biomes;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Events {

    @SubscribeEvent
    public void onTradesSetup(VillagerTradesEvent event) {
        ModTrades modTrades = new ModTrades();
        modTrades.addEvent(event);
        modTrades.register();
    }

    public void initialSpawn(FMLLoadCompleteEvent event) {
        // Add ruby piglin's spawn at Crimson Forest and Nether Wastes
        Biomes.field_235253_az_.func_235058_a_(ModEntities.RUBY_PIGLIN);
        Biomes.field_235254_j_.func_235058_a_(ModEntities.RUBY_PIGLIN);
    }

    public void setup(final FMLCommonSetupEvent event)
    {
        OreGenerator.setup();
    }
}
