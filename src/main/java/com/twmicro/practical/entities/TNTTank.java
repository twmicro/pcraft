package com.twmicro.practical.entities;

import com.twmicro.practical.types.ModSounds;
import com.twmicro.practical.types.ModEntities;
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
import net.minecraft.entity.passive.horse.AbstractHorseEntity;
import net.minecraft.entity.passive.horse.HorseEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.network.IPacket;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;


public class TNTTank extends AbstractHorseEntity {

    public TNTTank(EntityType<? extends TNTTank> type, World worldIn) {
        super(ModEntities.TNT_TANK, worldIn);
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
    public boolean isHorseSaddled() {
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
    public ActionResultType func_230254_b_(PlayerEntity p_230254_1_, Hand p_230254_2_) {
        ItemStack itemstack = p_230254_1_.getHeldItem(p_230254_2_);
        if (!this.isChild()) {
            if (this.isTame() && p_230254_1_.isSecondaryUseActive()) {
                this.openGUI(p_230254_1_);
                return ActionResultType.func_233537_a_(this.world.isRemote);
            }

            if (this.isBeingRidden()) {
                return super.func_230254_b_(p_230254_1_, p_230254_2_);
            }
        }

        if (!itemstack.isEmpty()) {
            if (this.isBreedingItem(itemstack)) {
                return this.func_241395_b_(p_230254_1_, itemstack);
            }

            ActionResultType actionresulttype = itemstack.func_111282_a_(p_230254_1_, this, p_230254_2_);
            if (actionresulttype.isSuccessOrConsume()) {
                return actionresulttype;
            }

            if (!this.isTame()) {
                this.makeMad();
                return ActionResultType.func_233537_a_(this.world.isRemote);
            }

            boolean flag = !this.isChild() && !this.isHorseSaddled() && itemstack.getItem() == Items.SADDLE;
            if (this.isArmor(itemstack) || flag) {
                this.openGUI(p_230254_1_);
                return ActionResultType.func_233537_a_(this.world.isRemote);
            }
        }

        if (this.isChild()) {
            return super.func_230254_b_(p_230254_1_, p_230254_2_);
        } else {
            this.mountTo(p_230254_1_);
            return ActionResultType.func_233537_a_(this.world.isRemote);
        }
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
        try {
            AtomicBoolean enableTankRandomMovement = new AtomicBoolean(false);
            Field field = GameRules.class.getDeclaredField("rules");
            field.setAccessible(true);
            Map<GameRules.RuleKey<?>, GameRules.RuleValue<?>> rules = (Map<GameRules.RuleKey<?>, GameRules.RuleValue<?>>) field.get(world.getGameRules());
            rules.forEach((k, v) -> {
                if(k.func_234911_b_().contains("enableTankRandomMovement")){
                    enableTankRandomMovement.set(world.getGameRules().getBoolean((GameRules.RuleKey<GameRules.BooleanValue>) k));
                }
            });

            if (enableTankRandomMovement.get())
                super.registerGoals();
            else
                this.goalSelector.addGoal(0, new FollowParentGoal(this, 1.0D));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public IPacket<?> createSpawnPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }
}
