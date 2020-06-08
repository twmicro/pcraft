package com.twmicro.practical.items.swords;

import com.twmicro.practical.items.ingredients.RubyIngot;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.crafting.Ingredient;

public class RubySword extends SwordItem {
    private static final IItemTier RubySwordTier = new IItemTier() {
        @Override
        public int getMaxUses() {
            return 2500;
        }

        @Override
        public float getEfficiency() {
            return 5;
        }

        @Override
        public float getAttackDamage() {
            return 0;
        }

        @Override
        public int getHarvestLevel() {
            return 1;
        }

        @Override
        public int getEnchantability() {
            return 320;
        }

        @Override
        public Ingredient getRepairMaterial() {
            return Ingredient.fromStacks(new ItemStack(new RubyIngot()));
        }
    };
    public RubySword() {
        super(RubySwordTier, 20, 1, new Properties().group(ItemGroup.COMBAT));
    }
}
