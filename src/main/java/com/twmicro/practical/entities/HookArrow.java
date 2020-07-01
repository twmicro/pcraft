package com.twmicro.practical.entities;

import com.twmicro.practical.items.ingredients.HookArrowItem;
import com.twmicro.practical.types.ModEntities;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.network.IPacket;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

public class HookArrow extends AbstractArrowEntity{

    public HookArrow(World worldIn) {
        super(ModEntities.HOOK_ARROW, worldIn);
    }

    public HookArrow(EntityType<? extends AbstractArrowEntity> type, World worldIn) {
        super(type, worldIn);
    }

    public HookArrow(EntityType<? extends AbstractArrowEntity> type, World world, double x, double y, double z) {
        super(type, x, y, z, world);
    }

    public HookArrow(EntityType<? extends AbstractArrowEntity> type, World worldIn, LivingEntity shooter) {
        super(type, shooter, worldIn);
    }



    protected ItemStack getArrowStack() {
        return new ItemStack(new HookArrowItem());
    }

    @Override
    protected void arrowHit(LivingEntity living) {
        super.arrowHit(living);
        living.setPosition(func_234616_v_().getPosX(), func_234616_v_().getPosY(), func_234616_v_().getPosZ());
    }

    @Override
    public IPacket<?> createSpawnPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }
}
