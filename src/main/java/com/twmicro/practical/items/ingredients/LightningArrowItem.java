package com.twmicro.practical.items.ingredients;

import com.twmicro.practical.entities.LightningArrow;
import com.twmicro.practical.types.ModEntities;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.item.ArrowItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class LightningArrowItem extends ArrowItem {
    public LightningArrowItem() {
        super(new Properties().group(ItemGroup.COMBAT));
    }
    @Override
    public AbstractArrowEntity createArrow(World worldIn, ItemStack stack, LivingEntity shooter) {
        return new LightningArrow(ModEntities.LIGHTNING_ARROW, shooter, worldIn);
    }
    @Override
    public boolean isInfinite(ItemStack stack, ItemStack bow, net.minecraft.entity.player.PlayerEntity player) {
        int enchant = net.minecraft.enchantment.EnchantmentHelper.getEnchantmentLevel(net.minecraft.enchantment.Enchantments.INFINITY, bow);
        return enchant > 0;
    }
}
