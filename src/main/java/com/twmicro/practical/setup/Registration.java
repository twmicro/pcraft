package com.twmicro.practical.setup;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.twmicro.practical.PracticalMod;
import com.twmicro.practical.entities.renderers.*;
import com.twmicro.practical.types.ModSensors;
import com.twmicro.practical.types.ModSounds;
import com.twmicro.practical.types.*;
import com.twmicro.practical.types.not_deferred.ModGamerules;
import com.twmicro.practical.types.not_deferred.ModKeybindings;
import com.twmicro.practical.utils.interfaces.INotDeferredList;
import com.twmicro.practical.utils.interfaces.IRegistryList;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.brain.sensor.SensorType;
import net.minecraft.item.Item;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.*;

public class Registration {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, PracticalMod.MODID);
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, PracticalMod.MODID);
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, PracticalMod.MODID);
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, PracticalMod.MODID);
    public static final DeferredRegister<SensorType<?>> SENSORS = DeferredRegister.create(ForgeRegistries.SENSOR_TYPES, PracticalMod.MODID);

    public static void init() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        ArrayList<DeferredRegister<?>> arrayList = new ArrayList<>();
        Map<IRegistryList<?>, DeferredRegister<?>> registries = new ImmutableMap.Builder<IRegistryList<?>, DeferredRegister<?>>().
                put(new ModBlocks(), BLOCKS).
                put(new ModEntities(), ENTITIES).
                put(new ModBlockItems(), ITEMS).
                put(new ModItems(), ITEMS).
                put(new ModToolItems(), ITEMS).
                put(new ModArmor(), ITEMS).
                put(new ModSwords(), ITEMS).
                put(new ModArrowItems(), ITEMS).
                put(new ModSounds(), SOUND_EVENTS).
                put(new ModSensors(), SENSORS).
                build();
        Set<INotDeferredList<?>> notDeferredLists = ImmutableSet.of(new ModKeybindings(),
                                                                    new ModGamerules());
        registries.forEach((list, register) ->
        {
            list.setDeferredRegister(register);
            list.register();
            if(!(arrayList.contains(register)))
            {
                register.register(bus);
                arrayList.add(register);
            }
        });

        for(INotDeferredList<?> list : notDeferredLists)
            list.register();

        registerRenderers();
    }

    private static void registerRenderers()
    {
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.TNT_TANK, TNTTankRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.HOOK_ARROW, HookArrowRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.LIGHTNING_ARROW, LightningArrowRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.TELEPORTING_ARROW, TeleportingArrowRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.TNT_ARROW, TNTArrowRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.RUBY_PIGLIN, (IRenderFactory<MobEntity>) manager -> new RubyPiglinRenderer(manager, false));
    }
}
