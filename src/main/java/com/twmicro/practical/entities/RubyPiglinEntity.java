package com.twmicro.practical.entities;

import com.google.common.collect.ImmutableList;
import com.mojang.serialization.Dynamic;
import com.twmicro.practical.types.ModSensors;
import com.twmicro.practical.types.ModArmor;
import com.twmicro.practical.types.ModSwords;
import com.twmicro.practical.types.ModEntities;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierManager;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.brain.Brain;
import net.minecraft.entity.ai.brain.sensor.SensorType;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.monster.ZombifiedPiglinEntity;
import net.minecraft.entity.monster.piglin.AbstractPiglinEntity;
import net.minecraft.entity.monster.piglin.PiglinEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.*;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import javax.annotation.Nullable;
import java.lang.reflect.Field;

public class RubyPiglinEntity extends PiglinEntity {

    public RubyPiglinEntity(World worldIn) {
        super(ModEntities.RUBY_PIGLIN, worldIn);
    }

    public RubyPiglinEntity(EntityType<? extends AbstractPiglinEntity> entity, World worldIn) {
        super(entity, worldIn);
    }

}
