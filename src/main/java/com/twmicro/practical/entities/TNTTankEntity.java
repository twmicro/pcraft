package com.twmicro.practical.entities;

import com.twmicro.practical.PracticalMod;
import com.twmicro.practical.proxy.ClientProxy;
import com.twmicro.practical.proxy.ModSubscriber;
import com.twmicro.practical.setup.ModRegistry;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.FollowParentGoal;
import net.minecraft.entity.item.BoatEntity;
import net.minecraft.entity.item.TNTEntity;
import net.minecraft.entity.passive.horse.AbstractHorseEntity;
import net.minecraft.entity.passive.horse.HorseEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class TNTTankEntity extends HorseEntity {

    public TNTTankEntity(EntityType<? extends HorseEntity> type, World worldIn) {
        super(type, worldIn);
        setHorseTamed(true);
        setHorseSaddled(true);
    }

    @Override
    public boolean isTame() {
        setHorseTamed(true);
        return true;
    }

    @Override
    public boolean setTamedBy(PlayerEntity player) {
        return true;
    }

    @Override
    protected void playStepSound(BlockPos pos, BlockState blockIn) {
        playSound(ModRegistry.TNT_TANK_IDLE.get(), 0.15F, 1F);
    }
    @Override
    public boolean isSilent() { return false; }
    @Override
    public void tick() {
        super.tick();
        setHorseTamed(true);
        setHorseSaddled(true);
        if (ModSubscriber.USE_SPECIAL_FEATURE.isKeyDown() && this.getPassengers().contains(Minecraft.getInstance().player)) throwTNT(PracticalMod.proxy.getPlayerEntity());
    }

    public void throwTNT(PlayerEntity shooter)
    {
        BlockPos blockpos = new BlockPos(getPosX(), getPosY(), getPosZ());
        TNTEntity tnt = new TNTEntity(EntityType.TNT, getEntityWorld());
        RayTraceResult lookingAt = Minecraft.getInstance().objectMouseOver;
        tnt.setPosition(lookingAt.getHitVec().x, lookingAt.getHitVec().y, lookingAt.getHitVec().z);
        getEntityWorld().addEntity(tnt);
        playSound(ModRegistry.TNT_TANK_SHOT.get(), 0.5F, 1);
    }


    @Override
    protected void registerAttributes() {
        super.registerAttributes();
        this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(100F);
        this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.2F);
    }
    @Override
    protected SoundEvent getDeathSound()
    {
        return ModRegistry.TNT_TANK_EXPLOSION.get();
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
        if(world.getGameRules().getBoolean(ModSubscriber.ENABLE_TANK_RANDOM_MOVEMENT))
            super.registerGoals();
        else
            this.goalSelector.addGoal(0, new FollowParentGoal(this, 1.0D));
    }
}
