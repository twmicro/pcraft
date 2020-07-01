package com.twmicro.practical.types;

import com.google.common.collect.ImmutableMap;
import com.twmicro.practical.utils.interfaces.IRegistryList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.registries.DeferredRegister;

import java.util.Map;

public class ModSounds implements IRegistryList<SoundEvent> {
    private static final ImmutableMap.Builder<SoundEvent, String> REGISTRY_MAP = (new ImmutableMap.Builder<>());
    private static DeferredRegister<SoundEvent> DEFERRED_REGISTER = null;
    public static final SoundEvent TNT_TANK_IDLE = new SoundEvent(new ResourceLocation("practical", "entity.tnt_tank.idle"));
    public static final SoundEvent TNT_TANK_SHOT = new SoundEvent(new ResourceLocation("practical", "entity.tnt_tank.shot"));
    public static final SoundEvent TNT_TANK_EXPLOSION = new SoundEvent(new ResourceLocation("practical", "entity.tnt_tank.explosion"));

    private static void add(SoundEvent sound, String name)
    {
        REGISTRY_MAP.put(sound, name);
    }

    static
    {
        add(TNT_TANK_IDLE, "entity.tnt_tank.idle");
        add(TNT_TANK_SHOT, "entity.tnt_tank.shot");
        add(TNT_TANK_EXPLOSION, "entity.tnt_tank.explosion");
    }

    @Override
    public void setDeferredRegister(DeferredRegister<?> register) {
        DEFERRED_REGISTER = (DeferredRegister<SoundEvent>) register;
    }

    @Override
    public Map<SoundEvent, String> getRegistryNames() {
        return REGISTRY_MAP.build();
    }

    @Override
    public void register() {
        Map<SoundEvent, String> MAP = getRegistryNames();
        MAP.forEach((sound, name) -> DEFERRED_REGISTER.register(name, () -> sound));
    }
}
