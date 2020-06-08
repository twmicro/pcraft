package com.twmicro.practical.entities;

import com.twmicro.practical.items.ingredients.HookArrowItem;
import com.twmicro.practical.setup.ModRegistry;
import it.unimi.dsi.fastutil.longs.Long2ObjectMap;
import net.minecraft.client.Minecraft;
import net.minecraft.client.MinecraftGame;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.dispenser.IPosition;
import net.minecraft.dispenser.ProjectileDispenseBehavior;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.server.ChunkManager;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.network.NetworkHooks;

import javax.annotation.Nullable;
import java.lang.reflect.Field;
import java.util.List;
import java.util.UUID;

public class HookArrowEntity extends AbstractArrowEntity{

    public HookArrowEntity(EntityType<? extends AbstractArrowEntity> type, World worldIn) {
        super(type, worldIn);
    }

    public HookArrowEntity(EntityType<? extends AbstractArrowEntity> type, World world, double x, double y, double z) {
        super(type, x, y, z, world);
    }

    public HookArrowEntity(EntityType<? extends AbstractArrowEntity> type, World worldIn, LivingEntity shooter) {
        super(type, shooter, worldIn);
    }



    protected ItemStack getArrowStack() {
        return new ItemStack(new HookArrowItem());
    }
    @Override
    protected void arrowHit(LivingEntity living) {
        super.arrowHit(living);
        living.setPosition(getShooter().getPosX(), getShooter().getPosY(), getShooter().getPosZ());
    }
    @Override
    public IPacket<?> createSpawnPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }
}
