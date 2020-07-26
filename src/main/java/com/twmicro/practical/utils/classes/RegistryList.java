package com.twmicro.practical.utils.classes;

import com.google.common.collect.ImmutableMap;
import net.minecraft.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.IForgeRegistryEntry;

import java.util.Map;

public abstract class RegistryList<T extends IForgeRegistryEntry<T>> {
    protected ImmutableMap.Builder<T, String> REGISTRY_MAP = (new ImmutableMap.Builder<>());
    protected DeferredRegister<T> DEFERRED_REGISTER = null;

    protected void add(T type, String name)
    {
        REGISTRY_MAP.put(type, name);
    }

    public void setDeferredRegister(DeferredRegister<?> register)
    {
        DEFERRED_REGISTER = (DeferredRegister<T>) register;
    }

    public Map<T, String> getRegistryNames()
    {
        return REGISTRY_MAP.build();
    }

    public void register()
    {
        Map<T, String> MAP = getRegistryNames();
        MAP.forEach((type, name) -> DEFERRED_REGISTER.register(name, () -> type));
    }
}
