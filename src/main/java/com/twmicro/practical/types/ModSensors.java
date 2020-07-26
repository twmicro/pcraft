package com.twmicro.practical.types;

import com.twmicro.practical.entities.sensors.RubyPiglinMobsSensor;
import com.twmicro.practical.utils.classes.RegistryList;
import net.minecraft.entity.ai.brain.sensor.Sensor;
import net.minecraft.entity.ai.brain.sensor.SensorType;
import net.minecraft.entity.monster.piglin.PiglinEntity;

public class ModSensors extends RegistryList<SensorType<?>> {
    public static final SensorType<? extends Sensor<? super PiglinEntity>> RUBY_PIGLIN_MOBS_SENSOR = new SensorType<>(RubyPiglinMobsSensor::new);

    public ModSensors()
    {
        add(RUBY_PIGLIN_MOBS_SENSOR, "ruby_piglin_mobs_sensor");
    }
}
