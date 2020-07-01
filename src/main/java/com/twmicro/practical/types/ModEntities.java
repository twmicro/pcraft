package com.twmicro.practical.types;

import com.google.common.collect.ImmutableMap;
import com.twmicro.practical.entities.*;
import com.twmicro.practical.utils.interfaces.IRegistryList;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraftforge.registries.DeferredRegister;

import java.util.Map;

public class ModEntities implements IRegistryList<EntityType<?>> {
    private static final ImmutableMap.Builder<EntityType<?>, String> REGISTRY_MAP = (new ImmutableMap.Builder<>());
    private static DeferredRegister<EntityType<?>> DEFERRED_REGISTER = null;

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


    static
    {
        add(TNT_TANK, "tnt_tank");
        add(LIGHTNING_ARROW, "lightning_arrow");
        add(TELEPORTING_ARROW, "teleporting_arrow");
        add(TNT_ARROW, "tnt_arrow");
        add(HOOK_ARROW, "hook_arrow");
        add(RUBY_PIGLIN, "ruby_piglin");
    }

    private static void add(EntityType<?> entity, String name)
    {
        REGISTRY_MAP.put(entity, name);
    }

    @Override
    public void setDeferredRegister(DeferredRegister<?> register) {
        DEFERRED_REGISTER = (DeferredRegister<EntityType<?>>) register;
    }

    @Override
    public Map<EntityType<?>, String> getRegistryNames() {
        return REGISTRY_MAP.build();
    }

    @Override
    public void register() {
        Map<EntityType<?>, String> MAP = getRegistryNames();
        MAP.forEach((entity, name) -> DEFERRED_REGISTER.register(name, () -> entity));
    }
}
