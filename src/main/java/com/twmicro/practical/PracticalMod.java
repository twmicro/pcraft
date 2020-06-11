package com.twmicro.practical;

import com.twmicro.practical.proxy.ClientProxy;
import com.twmicro.practical.proxy.IProxy;
import com.twmicro.practical.proxy.ModSubscriber;
import com.twmicro.practical.proxy.ServerProxy;
import com.twmicro.practical.setup.ModRegistry;
import com.twmicro.practical.setup.OreGenerator;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.FeatureRadiusConfig;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.structure.IStructurePieceType;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.placement.ChanceConfig;
import net.minecraft.world.gen.placement.IPlacementConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.ObjectHolder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Iterator;
import java.util.Random;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("practical")
public class PracticalMod
{
    // Directly reference a log4j logger.
    public static final Random RANDOM = new Random();
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MODID = "practical";
    public static PracticalMod ModInstance;
    public static IEventBus BUS;
    public static IProxy proxy = DistExecutor.runForDist(() -> () -> new ClientProxy(), () -> () -> new ServerProxy());
    public static final ResourceLocation BASE_LOC = new ResourceLocation(MODID, "legendary_base");
    public static IStructurePieceType LEGENDARY_BASE_PIECE = null;
    @ObjectHolder(MODID+":legendary_base")
    public static Structure<NoFeatureConfig> LEGENDARY_PLAYER_BASE;

    public PracticalMod() {
        ModRegistry.init();
        MinecraftForge.EVENT_BUS.register(this);
        MinecraftForge.EVENT_BUS.register(new ModSubscriber());
        ModInstance = this;
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::loadComplete);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(ModSubscriber::init);
        //FMLJavaModLoadingContext.get().getModEventBus().addListener(ModSubscriber::onClientTickEvent);
    }
    private void setup(final FMLCommonSetupEvent event)
    {
        OreGenerator.setup();
    }
    private void loadComplete(FMLLoadCompleteEvent e)
    {
        LEGENDARY_PLAYER_BASE = ModRegistry.BASE_FEATURE.get();
        Biomes.GRAVELLY_MOUNTAINS.addStructure(LEGENDARY_PLAYER_BASE.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
        Biomes.GRAVELLY_MOUNTAINS.addFeature(GenerationStage.Decoration.SURFACE_STRUCTURES, LEGENDARY_PLAYER_BASE.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.NOPE.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));
    }

}
