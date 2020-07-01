package com.twmicro.practical.items.ingredients;

import com.twmicro.practical.types.ModEntities;
import com.twmicro.practical.entities.TeleportingArrow;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.item.ArrowItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class TeleportingArrowItem extends ArrowItem {
    public TeleportingArrowItem() {
        super(new Item.Properties().group(ItemGroup.COMBAT));
    }
    @Override
    public AbstractArrowEntity createArrow(World worldIn, ItemStack stack, LivingEntity shooter) {
        return new TeleportingArrow(ModEntities.TELEPORTING_ARROW, shooter, worldIn);
    }
    @Override
    public boolean isInfinite(ItemStack stack, ItemStack bow, net.minecraft.entity.player.PlayerEntity player) {
        int enchant = net.minecraft.enchantment.EnchantmentHelper.getEnchantmentLevel(net.minecraft.enchantment.Enchantments.INFINITY, bow);
        return enchant > 0;
    }
}
