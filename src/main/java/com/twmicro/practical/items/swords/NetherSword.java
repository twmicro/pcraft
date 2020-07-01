package com.twmicro.practical.items.swords;

import com.twmicro.practical.items.ingredients.NetherIngot;
import com.twmicro.practical.items.ingredients.RubyIngot;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.crafting.Ingredient;

public class NetherSword extends SwordItem {
    private static final IItemTier NetherSwordTier = new IItemTier() {
        @Override
        public int getMaxUses() {
            return 2000;
        }

        @Override
        public float getEfficiency() {
            return 5;
        }

        @Override
        public float getAttackDamage() {
            return 30;
        }

        @Override
        public int getHarvestLevel() {
            return 1;
        }

        @Override
        public int getEnchantability() {
            return 10;
        }

        @Override
        public Ingredient getRepairMaterial() {
            return Ingredient.fromStacks(new ItemStack(new NetherIngot()));
        }
    };
    public NetherSword() {
        super(NetherSwordTier, 30, 0.5F, new Properties().group(ItemGroup.COMBAT));
    }
}
