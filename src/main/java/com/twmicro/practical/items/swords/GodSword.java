package com.twmicro.practical.items.swords;

import net.minecraft.block.material.Material;
import net.minecraft.item.*;
import net.minecraft.item.crafting.Ingredient;


public class GodSword extends SwordItem {
    private static final IItemTier GodSwordTier = new IItemTier() {
        @Override
        public int getMaxUses() {
            return 10000;
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
            return Ingredient.fromStacks(new ItemStack(Items.DIAMOND_BLOCK));
        }
    };
    public GodSword() {
        super(GodSwordTier, 100, GodSwordTier.getEfficiency(), new Properties().group(ItemGroup.COMBAT));
    }
}
