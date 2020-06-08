package com.twmicro.practical.items.ingredients;

import com.twmicro.practical.entities.HookArrowEntity;
import com.twmicro.practical.setup.ModRegistry;
import net.minecraft.block.DispenserBlock;
import net.minecraft.client.Minecraft;
import net.minecraft.dispenser.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.IProjectile;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.item.ArrowItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SpectralArrowItem;
import net.minecraft.network.IPacket;
import net.minecraft.util.Direction;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

public class HookArrowItem extends ArrowItem{
    public HookArrowItem() {
        super(new Properties().group(ItemGroup.COMBAT));
    }

    @Override
    public AbstractArrowEntity createArrow(World worldIn, ItemStack stack, LivingEntity shooter) {
        return new HookArrowEntity(ModRegistry.HOOK_ARROW_ENTITY.get(), worldIn, shooter);
    }
    @Override
    public boolean isInfinite(ItemStack stack, ItemStack bow, net.minecraft.entity.player.PlayerEntity player) {
        int enchant = net.minecraft.enchantment.EnchantmentHelper.getEnchantmentLevel(net.minecraft.enchantment.Enchantments.INFINITY, bow);
        return enchant <= 0 ? false : this instanceof ArrowItem;
    }

}
