package com.twmicro.practical.types;

import com.twmicro.practical.entities.*;
import com.twmicro.practical.utils.classes.RegistryList;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;

public class ModEntities extends RegistryList<EntityType<?>> {
    public static final EntityType<TNTTank> TNT_TANK = EntityType.Builder.<TNTTank>create(TNTTank::new, EntityClassification.CREATURE)
            .size(1, 1)
            .setShouldReceiveVelocityUpdates(false)
            .build("tnt_tank");

    public static final EntityType<LightningArrow> LIGHTNING_ARROW = EntityType.Builder.<LightningArrow>create(LightningArrow::new, EntityClassification.CREATURE)
            .size(1, 1)
            .setShouldReceiveVelocityUpdates(false)
            .build("lightning_arrow");

    public static final EntityType<TeleportingArrow> TELEPORTING_ARROW = EntityType.Builder.<TeleportingArrow>create(TeleportingArrow::new, EntityClassification.CREATURE)
            .size(1, 1)
            .setShouldReceiveVelocityUpdates(false)
            .build("teleporting_arrow");

    public static final EntityType<TNTArrow> TNT_ARROW = EntityType.Builder.<TNTArrow>create(TNTArrow::new, EntityClassification.CREATURE)
            .size(1, 1)
            .setShouldReceiveVelocityUpdates(false)
            .build("tnt_arrow");

    public static final EntityType<HookArrow> HOOK_ARROW = EntityType.Builder.<HookArrow>create(HookArrow::new, EntityClassification.CREATURE)
            .size(1, 1)
            .setShouldReceiveVelocityUpdates(false)
            .build("hook_arrow");

    public static final EntityType<RubyPiglinEntity> RUBY_PIGLIN = EntityType.Builder.<RubyPiglinEntity>create(RubyPiglinEntity::new, EntityClassification.MONSTER)
            .size(1, 1)
            .setShouldReceiveVelocityUpdates(false)
            .build("ruby_piglin");


    public ModEntities()
    {
        add(TNT_TANK, "tnt_tank");
        add(LIGHTNING_ARROW, "lightning_arrow");
        add(TELEPORTING_ARROW, "teleporting_arrow");
        add(TNT_ARROW, "tnt_arrow");
        add(HOOK_ARROW, "hook_arrow");
        add(RUBY_PIGLIN, "ruby_piglin");
    }
}
