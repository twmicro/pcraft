package com.twmicro.practical.utils.interfaces;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.IForgeRegistryEntry;

import java.util.Map;

public interface IRegistryList<T extends IForgeRegistryEntry<T>> {
    void setDeferredRegister(DeferredRegister<?> register);
    Map<T, String> getRegistryNames();
    void register();
}
