package com.twmicro.practical.types;

import com.google.common.collect.ImmutableMap;
import com.twmicro.practical.entities.sensors.RubyPiglinMobsSensor;
import com.twmicro.practical.utils.interfaces.IRegistryList;
import net.minecraft.entity.ai.brain.sensor.Sensor;
import net.minecraft.entity.ai.brain.sensor.SensorType;
import net.minecraft.entity.monster.piglin.PiglinEntity;
import net.minecraftforge.registries.DeferredRegister;

import java.util.Map;

public class ModSensors implements IRegistryList<SensorType<?>> {
    private static final ImmutableMap.Builder<SensorType<?>, String> REGISTRY_MAP = (new ImmutableMap.Builder<>());
    private static DeferredRegister<SensorType<?>> DEFERRED_REGISTER = null;

    public static final SensorType<? extends Sensor<? super PiglinEntity>> RUBY_PIGLIN_MOBS_SENSOR = new SensorType<>(RubyPiglinMobsSensor::new);

    static
    {
        add(RUBY_PIGLIN_MOBS_SENSOR, "ruby_piglin_mobs_sensor");
    }

    private static void add(SensorType<?> sensorType, String name)
    {
        REGISTRY_MAP.put(sensorType, name);
    }

    @Override
    public void setDeferredRegister(DeferredRegister<?> register) {
        DEFERRED_REGISTER = (DeferredRegister<SensorType<?>>) register;
    }

    @Override
    public Map<SensorType<?>, String> getRegistryNames() {
        return REGISTRY_MAP.build();
    }

    @Override
    public void register() {
        Map<SensorType<?>, String> MAP = getRegistryNames();
        MAP.forEach((sensorType, name) -> DEFERRED_REGISTER.register(name, () -> sensorType));
    }
}
