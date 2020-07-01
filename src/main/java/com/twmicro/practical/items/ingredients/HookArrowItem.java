package com.twmicro.practical.items.ingredients;

import com.twmicro.practical.entities.HookArrow;
import com.twmicro.practical.types.ModEntities;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.item.ArrowItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class HookArrowItem extends ArrowItem{
    public HookArrowItem() {
        super(new Properties().group(ItemGroup.COMBAT));
    }

    @Override
    public AbstractArrowEntity createArrow(World worldIn, ItemStack stack, LivingEntity shooter) {
        return new HookArrow(ModEntities.HOOK_ARROW, worldIn, shooter);
    }
    @Override
    public boolean isInfinite(ItemStack stack, ItemStack bow, net.minecraft.entity.player.PlayerEntity player) {
        int enchant = net.minecraft.enchantment.EnchantmentHelper.getEnchantmentLevel(net.minecraft.enchantment.Enchantments.INFINITY, bow);
        return enchant > 0;
    }

}
