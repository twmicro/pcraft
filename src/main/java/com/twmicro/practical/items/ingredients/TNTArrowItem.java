package com.twmicro.practical.items.ingredients;

import com.twmicro.practical.entities.TNTArrow;
import com.twmicro.practical.entities.TeleportingArrow;
import com.twmicro.practical.setup.ModRegistry;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.item.ArrowItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class TNTArrowItem extends ArrowItem {
    public TNTArrowItem() {
        super(new Properties().group(ItemGroup.COMBAT));
    }
    @Override
    public AbstractArrowEntity createArrow(World worldIn, ItemStack stack, LivingEntity shooter) {
        return new TNTArrow(ModRegistry.TNT_ARROW_ENTITY.get(), shooter, worldIn);
    }
    @Override
    public boolean isInfinite(ItemStack stack, ItemStack bow, net.minecraft.entity.player.PlayerEntity player) {
        int enchant = net.minecraft.enchantment.EnchantmentHelper.getEnchantmentLevel(net.minecraft.enchantment.Enchantments.INFINITY, bow);
        return enchant <= 0 ? false : this instanceof ArrowItem;
    }
}
