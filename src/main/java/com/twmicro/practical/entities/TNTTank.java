package com.twmicro.practical.entities;

import com.twmicro.practical.setup.Events;
import com.twmicro.practical.types.ModSounds;
import com.twmicro.practical.types.ModEntities;
import com.twmicro.practical.types.not_deferred.ModGamerules;
import com.twmicro.practical.types.not_deferred.ModKeybindings;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierManager;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.FollowParentGoal;
import net.minecraft.entity.item.TNTEntity;
import net.minecraft.entity.passive.horse.HorseEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;


public class TNTTank extends HorseEntity {

    public TNTTank(EntityType<? extends HorseEntity> type, World worldIn) {
        super(type, worldIn);
        setHorseWatchableBoolean(4, true);
        setHorseWatchableBoolean(2, true);
    }

    public TNTTank(World worldIn) {
        super(ModEntities.TNT_TANK, worldIn);
        setHorseWatchableBoolean(4, true);
        setHorseWatchableBoolean(2, true);
    }

    @Override
    public boolean isTame() {
        return true;
    }

    @Override
    public boolean setTamedBy(PlayerEntity player) {
        return true;
    }

    @Override
    protected void playStepSound(BlockPos pos, BlockState blockIn) {
        playSound(ModSounds.TNT_TANK_IDLE, 0.15F, 1F);
    }

    @Override
    public boolean isSilent() {
        return false;
    }

    @Override
    public void tick() {
        super.tick();
        if (ModKeybindings.USE_SPECIAL_FEATURE.isPressed() && this.getPassengers().contains(Minecraft.getInstance().player)) throwTNT();
    }

    public static AttributeModifierMap.MutableAttribute func_234237_fg_() {
        return MobEntity.func_233666_p_().func_233815_a_(Attributes.field_233818_a_, 200.0D).func_233815_a_(Attributes.field_233821_d_, (double)0.2F);
    }

    @Override
    public AttributeModifierManager func_233645_dx_() {
        return new AttributeModifierManager(func_234237_fg_().func_233813_a_());
    }

    public void throwTNT()
    {
        TNTEntity tnt = new TNTEntity(EntityType.TNT, getEntityWorld());
        RayTraceResult lookingAt = Minecraft.getInstance().objectMouseOver;
        tnt.setPosition(lookingAt.getHitVec().x, lookingAt.getHitVec().y, lookingAt.getHitVec().z);
        getEntityWorld().addEntity(tnt);
        playSound(ModSounds.TNT_TANK_SHOT, 0.5F, 1);
    }

    @Override
    protected float getModifiedMaxHealth() {
        return 200F;
    }

    @Override
    protected double getModifiedMovementSpeed() {
        return 0.2;
    }

    @Override
    public double getHorseJumpStrength() {
        return 0.1;
    }

    @Override
    protected SoundEvent getDeathSound()
    {
        return ModSounds.TNT_TANK_EXPLOSION;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return null;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn) { return null; }

    @Override
    protected void playGallopSound(SoundType p_190680_1_) {
        // Pass
    }

    @Override
    protected SoundEvent getAngrySound() {
        return null;
    }

    @Override
    protected void registerGoals() {
        if(world.getGameRules().getBoolean(ModGamerules.ENABLE_TANK_RANDOM_MOVEMENT))
            super.registerGoals();
        else
            this.goalSelector.addGoal(0, new FollowParentGoal(this, 1.0D));
    }
}
