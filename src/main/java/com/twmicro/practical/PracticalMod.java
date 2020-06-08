package com.twmicro.practical;

import com.twmicro.practical.proxy.ClientProxy;
import com.twmicro.practical.proxy.IProxy;
import com.twmicro.practical.proxy.ModSubscriber;
import com.twmicro.practical.proxy.ServerProxy;
import com.twmicro.practical.setup.ModRegistry;
import com.twmicro.practical.setup.OreGenerator;
import net.minecraft.client.Minecraft;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("practical")
public class PracticalMod
{
    // Directly reference a log4j logger.
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MODID = "practical";
    public static PracticalMod ModInstance;
    public static IEventBus BUS;
    public static IProxy proxy = DistExecutor.runForDist(() -> () -> new ClientProxy(), () -> () -> new ServerProxy());

    public PracticalMod() {
        ModRegistry.init();
        MinecraftForge.EVENT_BUS.register(this);
        MinecraftForge.EVENT_BUS.register(new ModSubscriber());
        ModInstance = this;
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(ModSubscriber::init);
        //FMLJavaModLoadingContext.get().getModEventBus().addListener(ModSubscriber::onClientTickEvent);
    }
    private void setup(final FMLCommonSetupEvent event)
    {
        OreGenerator.setup();
    }

}
