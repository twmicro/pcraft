package com.twmicro.practical.entities;

import com.twmicro.practical.items.ingredients.HookArrowItem;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.EnderPearlEntity;
import net.minecraft.entity.monster.EndermiteEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.network.IPacket;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.tileentity.EndGatewayTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.network.NetworkHooks;

import javax.annotation.Nullable;

public class TeleportingArrow extends AbstractArrowEntity {

    private boolean used = false;
    public TeleportingArrow(EntityType<? extends AbstractArrowEntity> type, World worldIn) {
        super(type, worldIn);
    }

    public TeleportingArrow(EntityType<? extends AbstractArrowEntity> type, double x, double y, double z, World worldIn) {
        super(type, x, y, z, worldIn);
    }

    public TeleportingArrow(EntityType<? extends AbstractArrowEntity> type, LivingEntity shooter, World worldIn) {
        super(type, shooter, worldIn);
    }

    @Override
    protected ItemStack getArrowStack() {
        return new ItemStack(new HookArrowItem());
    }

    @Override
    protected void onHit(RayTraceResult raytraceResultIn) {
        super.onHit(raytraceResultIn);
        onImpact(raytraceResultIn);
    }

    protected void onImpact(RayTraceResult result) {
        LivingEntity livingentity = (LivingEntity) this.getShooter();
        if (result.getType() == RayTraceResult.Type.ENTITY) {
            Entity entity = ((EntityRayTraceResult)result).getEntity();
            if (entity == this.getShooter()) {
                return;
            }

            entity.attackEntityFrom(DamageSource.causeThrownDamage(this, livingentity), 0.0F);
        }

        if (result.getType() == RayTraceResult.Type.BLOCK) {
            BlockPos blockpos = ((BlockRayTraceResult)result).getPos();
            TileEntity tileentity = this.world.getTileEntity(blockpos);
            if (tileentity instanceof EndGatewayTileEntity) {
                EndGatewayTileEntity endgatewaytileentity = (EndGatewayTileEntity)tileentity;
                if (livingentity != null) {
                    if (livingentity instanceof ServerPlayerEntity) {
                        CriteriaTriggers.ENTER_BLOCK.trigger((ServerPlayerEntity)livingentity, this.world.getBlockState(blockpos));
                    }

                    endgatewaytileentity.teleportEntity(livingentity);
                    this.remove();
                    return;
                }

                endgatewaytileentity.teleportEntity(this);
                return;
            }
        }

        for(int i = 0; i < 32; ++i) {
            this.world.addParticle(ParticleTypes.PORTAL, this.getPosX(), this.getPosY() + this.rand.nextDouble() * 2.0D, this.getPosZ(), this.rand.nextGaussian(), 0.0D, this.rand.nextGaussian());
        }

        if (!this.world.isRemote) {
            if (livingentity instanceof ServerPlayerEntity) {
                ServerPlayerEntity serverplayerentity = (ServerPlayerEntity)livingentity;
                if (serverplayerentity.connection.getNetworkManager().isChannelOpen() && serverplayerentity.world == this.world && !serverplayerentity.isSleeping()) {
                    net.minecraftforge.event.entity.living.EnderTeleportEvent event = new net.minecraftforge.event.entity.living.EnderTeleportEvent(serverplayerentity, this.getPosX(), this.getPosY(), this.getPosZ(), 5.0F);
                    if (!net.minecraftforge.common.MinecraftForge.EVENT_BUS.post(event)) { // Don't indent to lower patch size
                        if (this.rand.nextFloat() < 0.05F && this.world.getGameRules().getBoolean(GameRules.DO_MOB_SPAWNING)) {
                            EndermiteEntity endermiteentity = EntityType.ENDERMITE.create(this.world);
                            endermiteentity.setSpawnedByPlayer(true);
                            endermiteentity.setLocationAndAngles(livingentity.getPosX(), livingentity.getPosY(), livingentity.getPosZ(), livingentity.rotationYaw, livingentity.rotationPitch);
                            this.world.addEntity(endermiteentity);
                        }

                        if (livingentity.isPassenger()) {
                            livingentity.stopRiding();
                        }

                        livingentity.setPositionAndUpdate(event.getTargetX(), event.getTargetY(), event.getTargetZ());
                        livingentity.fallDistance = 0.0F;
                        livingentity.attackEntityFrom(DamageSource.FALL, event.getAttackDamage());
                    } //Forge: End
                }
            } else if (livingentity != null) {
                livingentity.setPositionAndUpdate(this.getPosX(), this.getPosY(), this.getPosZ());
                livingentity.fallDistance = 0.0F;
            }

            this.remove();
        }

    }

    /**
     * Called to update the entity's position/logic.
     */
    public void tick() {
        LivingEntity livingentity = (LivingEntity) this.getShooter();
        if (livingentity != null && livingentity instanceof PlayerEntity && !livingentity.isAlive()) {
            this.remove();
        } else {
            super.tick();
        }

    }

    @Nullable
    public Entity changeDimension(DimensionType destination, net.minecraftforge.common.util.ITeleporter teleporter) {
        if (this.getShooter().dimension != destination) {
            shootingEntity = null;
        }

        return super.changeDimension(destination, teleporter);
    }
    @Override
    public IPacket<?> createSpawnPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }
}
