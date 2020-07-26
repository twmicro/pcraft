package com.twmicro.practical.types;

import com.twmicro.practical.utils.classes.RegistryList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;

public class ModSounds extends RegistryList<SoundEvent> {
    public static final SoundEvent TNT_TANK_IDLE = new SoundEvent(new ResourceLocation("practical", "entity.tnt_tank.idle"));
    public static final SoundEvent TNT_TANK_SHOT = new SoundEvent(new ResourceLocation("practical", "entity.tnt_tank.shot"));
    public static final SoundEvent TNT_TANK_EXPLOSION = new SoundEvent(new ResourceLocation("practical", "entity.tnt_tank.explosion"));

    public ModSounds()
    {
        add(TNT_TANK_IDLE, "entity.tnt_tank.idle");
        add(TNT_TANK_SHOT, "entity.tnt_tank.shot");
        add(TNT_TANK_EXPLOSION, "entity.tnt_tank.explosion");
    }
}
