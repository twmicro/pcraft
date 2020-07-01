package com.twmicro.practical;

import com.twmicro.practical.types.ModEntities;
import com.twmicro.practical.proxy.ClientProxy;
import com.twmicro.practical.utils.interfaces.IProxy;
import com.twmicro.practical.setup.Events;
import com.twmicro.practical.proxy.ServerProxy;
import com.twmicro.practical.setup.Registration;
import com.twmicro.practical.world.gen.OreGenerator;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.structure.IStructurePieceType;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ObjectHolder;

import java.util.Random;

@Mod("practical")
public class PracticalMod
{
    public static final String MODID = "practical";
    public static IProxy PROXY = DistExecutor.runForDist(() -> ClientProxy::new, () -> ServerProxy::new);
    public static final Random RANDOM = new Random();


    public PracticalMod() {
        Events events = new Events();
        Registration.init();
        MinecraftForge.EVENT_BUS.register(this);
        MinecraftForge.EVENT_BUS.register(events);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(events::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(events::initialSpawn);
    }
}
