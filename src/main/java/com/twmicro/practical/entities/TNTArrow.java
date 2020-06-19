package com.twmicro.practical.entities;

import com.twmicro.practical.items.ingredients.LightningArrowItem;
import com.twmicro.practical.items.ingredients.TNTArrowItem;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.item.TNTEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.network.IPacket;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.fml.network.NetworkHooks;

public class TNTArrow extends AbstractArrowEntity {
    public TNTArrow(EntityType<? extends AbstractArrowEntity> type, World worldIn) {
        super(type, worldIn);
    }

    protected TNTArrow(EntityType<? extends AbstractArrowEntity> type, double x, double y, double z, World worldIn) {
        super(type, x, y, z, worldIn);
    }

    public TNTArrow(EntityType<? extends AbstractArrowEntity> type, LivingEntity shooter, World worldIn) {
        super(type, shooter, worldIn);
    }

    @Override
    protected ItemStack getArrowStack() {
        return new ItemStack(new TNTArrowItem());
    }

    @Override
    protected void arrowHit(LivingEntity living) {
        super.arrowHit(living);
        TNTEntity tnt = new TNTEntity(EntityType.TNT, world);
        tnt.setPosition(living.getPosX(), living.getPosY(), living.getPosZ());
        world.addEntity(tnt);
    }

    @Override
    public IPacket<?> createSpawnPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }
}
