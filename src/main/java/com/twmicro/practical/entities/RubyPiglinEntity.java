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
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import javax.annotation.Nullable;
import java.lang.reflect.Field;

public class RubyPiglinEntity extends PiglinEntity {

    public RubyPiglinEntity(World worldIn) {
        super(ModEntities.RUBY_PIGLIN, worldIn);
        tryToChange(getClass(), "field_234405_b_", ImmutableList.of(SensorType.NEAREST_LIVING_ENTITIES, SensorType.NEAREST_PLAYERS, SensorType.field_234129_b_, SensorType.HURT_BY, SensorType.INTERACTABLE_DOORS, ModSensors.RUBY_PIGLIN_MOBS_SENSOR), null);
    }

    public RubyPiglinEntity(EntityType<? extends MonsterEntity> entity, World worldIn) {
        super(entity, worldIn);
        tryToChange(getClass(), "field_234405_b_", ImmutableList.of(SensorType.NEAREST_LIVING_ENTITIES, SensorType.NEAREST_PLAYERS, SensorType.field_234129_b_, SensorType.HURT_BY, SensorType.INTERACTABLE_DOORS, ModSensors.RUBY_PIGLIN_MOBS_SENSOR), null);
    }

    @Override
    public ILivingEntityData onInitialSpawn(IWorld worldIn, DifficultyInstance difficultyIn, SpawnReason reason, @Nullable ILivingEntityData spawnDataIn, @Nullable CompoundNBT dataTag) {
        if (reason != SpawnReason.STRUCTURE) {
            if (worldIn.getRandom().nextFloat() < 0.2F) {
                this.setChild(true);
            } else if (this.func_234421_eJ_()) {
                this.setItemStackToSlot(EquipmentSlotType.MAINHAND, this.func_234432_eW_());
            }
        }

        RubyPiglinTasks.func_234466_a_(this);
        this.setEquipmentBasedOnDifficulty(difficultyIn);
        this.setEnchantmentBasedOnDifficulty(difficultyIn);
        return super.onInitialSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
    }
    private ItemStack func_234432_eW_() {
        return (double)this.rand.nextFloat() < 0.5D ? new ItemStack(Items.CROSSBOW) : new ItemStack(ModSwords.RUBY_SWORD);
    }
    static boolean tryToChange(Class<?> executor, String fieldName, Object value, @Nullable Object instance)
    {
        try
        {
            Field field = executor.getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(instance, value);
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }
    @Override
    protected void setEquipmentBasedOnDifficulty(DifficultyInstance difficulty) {
        if (this.func_234421_eJ_()) {
            this.func_234419_d_(EquipmentSlotType.HEAD, new ItemStack(ModArmor.RUBY_HELMET));
            this.func_234419_d_(EquipmentSlotType.CHEST, new ItemStack(ModArmor.RUBY_CHESTPLATE));
            this.func_234419_d_(EquipmentSlotType.LEGS, new ItemStack(ModArmor.RUBY_LEGGINGS));
            this.func_234419_d_(EquipmentSlotType.FEET, new ItemStack(ModArmor.RUBY_BOOTS));
        }

    }


    @Override
    public void func_234439_n_(ItemStack p_234439_1_) {
        if (p_234439_1_.getItem() == RubyPiglinTasks.field_234444_a_) {
            this.setItemStackToSlot(EquipmentSlotType.OFFHAND, p_234439_1_);
            this.func_233663_d_(EquipmentSlotType.OFFHAND);
        } else {
            this.func_233657_b_(EquipmentSlotType.OFFHAND, p_234439_1_);
        }

    }
    private void func_234419_d_(EquipmentSlotType p_234419_1_, ItemStack p_234419_2_) {
        if (this.world.rand.nextFloat() < 0.1F) {
            this.setItemStackToSlot(p_234419_1_, p_234419_2_);
        }
    }

    @Override
    public boolean func_234437_l_(ItemStack p_234437_1_) {
        return super.func_234437_l_(p_234437_1_);
    }

    @Override
    public ActionResultType func_230254_b_(PlayerEntity p_230254_1_, Hand p_230254_2_) {
        if (!this.world.isRemote) {
            ActionResultType type = RubyPiglinTasks.func_234471_a_(this, p_230254_1_, p_230254_2_);
            if(type == ActionResultType.CONSUME) entityDropItem(getHeldItemOffhand());
            return type ;
        } else {
            boolean flag = RubyPiglinTasks.func_234489_b_(this, p_230254_1_.getHeldItem(p_230254_2_)) && this.func_234424_eM_() != PiglinEntity.Action.ADMIRING_ITEM;
            if(flag) entityDropItem(getHeldItemOffhand());
            return flag ? ActionResultType.SUCCESS : ActionResultType.PASS;
        }
    }

    @Override
    protected boolean func_234440_o_(ItemStack p_234440_1_) {
        return super.func_234440_o_(p_234440_1_);
    }

    @Override
    public ItemStack func_234436_k_(ItemStack p_234436_1_) {
        return super.func_234436_k_(p_234436_1_);
    }

    @Override
    public AttributeModifierManager func_233645_dx_() {
        double speed = isChild() ? 0.4D : 0.2D;
        return new AttributeModifierManager(func_234237_fg_().func_233815_a_(Attributes.field_233821_d_, speed).func_233813_a_());
    }

    public static AttributeModifierMap.MutableAttribute func_234237_fg_() {
        return MobEntity.func_233666_p_().func_233815_a_(Attributes.field_233818_a_, 50.0D).func_233815_a_(Attributes.field_233823_f_, 0.2);
    }
    public Brain<PiglinEntity> getBrain() {
        return (Brain<PiglinEntity>)super.getBrain();
    }

    @Override
    public void func_241417_a_(SoundEvent p_241417_1_) {
        super.func_241417_a_(p_241417_1_);
    }

    @Override
    public void func_234438_m_(ItemStack p_234438_1_) {
        super.func_234438_m_(p_234438_1_);
    }

    @Override
    protected Brain<?> createBrain(Dynamic<?> dynamicIn) {
        return RubyPiglinTasks.func_234469_a_(this, this.func_230289_cH_().func_233748_a_(dynamicIn));
    }

    @Override
    protected void updateAITasks() {
        this.world.getProfiler().startSection("piglinBrain");
        this.getBrain().tick((ServerWorld)this.world, this);
        this.world.getProfiler().endSection();
        RubyPiglinTasks.func_234486_b_(this);
        Field field;
        try {
            field = PiglinEntity.class.getDeclaredField("field_234413_bz_");
            field.setAccessible(true);
            if (this.func_234423_eL_()) {

                field.set(this, field.getInt(this) + 1);
            } else {
                field.set(this, 0);
            }

            if (field.getInt(this) > 300) {
                this.func_241417_a_(SoundEvents.field_232799_la_);
                this.func_234416_a_((ServerWorld)this.world);
            }
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
    private void func_234416_a_(ServerWorld p_234416_1_) {
        RubyPiglinTasks.func_234496_c_(this);
        try {
            Field field = PiglinEntity.class.getDeclaredField("field_234406_bA_");
            field.setAccessible(true);
            ((Inventory)field.get(this)).func_233543_f_().forEach(this::entityDropItem);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
        ZombifiedPiglinEntity zombifiedpiglinentity = this.func_233656_b_(EntityType.field_233592_ba_);
        zombifiedpiglinentity.addPotionEffect(new EffectInstance(Effects.NAUSEA, 200, 0));
    }
    @Override
    public PiglinEntity.Action func_234424_eM_() {


        if (RubyPiglinTasks.func_234480_a_(this.getHeldItemOffhand().getItem())) {
            return PiglinEntity.Action.ADMIRING_ITEM;
        }
        else return super.func_234424_eM_();
    }
    @Override
    public boolean attackEntityFrom(DamageSource source, float amount) {
        boolean flag = super.attackEntityFrom(source, amount);
        if (this.world.isRemote) {
            return false;
        } else {
            if (flag && source.getTrueSource() instanceof LivingEntity) {
                RubyPiglinTasks.func_234468_a_(this, (LivingEntity)source.getTrueSource());
            }

            return flag;
        }
    }
    @Override
    protected boolean shouldExchangeEquipment(ItemStack candidate, ItemStack existing) {
        if (EnchantmentHelper.hasBindingCurse(existing)) {
            return false;
        } else {
            boolean flag = RubyPiglinTasks.func_234480_a_(candidate.getItem()) || candidate.getItem() == Items.CROSSBOW;
            boolean flag1 = RubyPiglinTasks.func_234480_a_(existing.getItem()) || existing.getItem() == Items.CROSSBOW;
            if (flag && !flag1) {
                return true;
            } else if (!flag && flag1) {
                return false;
            } else {
                return this.func_234421_eJ_() && candidate.getItem() != Items.CROSSBOW && existing.getItem() == Items.CROSSBOW ? false : super.shouldExchangeEquipment(candidate, existing);
            }
        }
    }

    @Override
    public boolean func_234422_eK_() {
        return super.func_234422_eK_();
    }

    @Override
    protected void updateEquipmentIfNeeded(ItemEntity itemEntity) {
        this.func_233630_a_(itemEntity);
        RubyPiglinTasks.func_234470_a_(this, itemEntity);
    }
    @Override
    protected SoundEvent getAmbientSound() {
        return this.world.isRemote ? null : RubyPiglinTasks.func_241429_d_(this).orElse((SoundEvent)null);
    }
}
