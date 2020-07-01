package com.twmicro.practical.entities;

import com.twmicro.practical.items.ingredients.LightningArrowItem;
import com.twmicro.practical.types.ModEntities;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.network.IPacket;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

public class LightningArrow extends AbstractArrowEntity {
    public LightningArrow(World worldIn) {
        super(ModEntities.LIGHTNING_ARROW, worldIn);
    }

    public LightningArrow(EntityType<? extends AbstractArrowEntity> type, World worldIn) {
        super(type, worldIn);
    }

    protected LightningArrow(EntityType<? extends AbstractArrowEntity> type, double x, double y, double z, World worldIn) {
        super(type, x, y, z, worldIn);
    }

    public LightningArrow(EntityType<? extends AbstractArrowEntity> type, LivingEntity shooter, World worldIn) {
        super(type, shooter, worldIn);
    }

    @Override
    protected ItemStack getArrowStack() {
        return new ItemStack(new LightningArrowItem());
    }

    @Override
    protected void arrowHit(LivingEntity living) {
        super.arrowHit(living);
        LightningBoltEntity entity = new LightningBoltEntity(EntityType.LIGHTNING_BOLT, world);
        entity.setPosition(living.getPosX() + 0.5D, living.getPosY(), living.getPosZ() + 0.5D);
        world.addEntity(entity);
    }

    @Override
    public IPacket<?> createSpawnPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }
}
