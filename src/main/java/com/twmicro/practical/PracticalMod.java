package com.twmicro.practical;

import com.twmicro.practical.proxy.ClientProxy;
import com.twmicro.practical.utils.interfaces.IProxy;
import com.twmicro.practical.setup.Events;
import com.twmicro.practical.proxy.ServerProxy;
import com.twmicro.practical.setup.Registration;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import java.util.Random;

@Mod(PracticalMod.MODID)
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
