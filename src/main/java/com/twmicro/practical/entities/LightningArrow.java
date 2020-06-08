package com.twmicro.practical.entities;

import com.twmicro.practical.items.ingredients.LightningArrowItem;
import net.minecraft.enchantment.ChannelingEnchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.entity.projectile.TridentEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.network.IPacket;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.fml.network.NetworkHooks;

public class LightningArrow extends AbstractArrowEntity {
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
        LightningBoltEntity entity = new LightningBoltEntity(world, (double)living.getPosX() + 0.5D, (double)living.getPosY(), (double)living.getPosZ() + 0.5D, false);
        ((ServerWorld)getEntityWorld()).addLightningBolt(entity);
    }

    @Override
    public IPacket<?> createSpawnPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }
}
