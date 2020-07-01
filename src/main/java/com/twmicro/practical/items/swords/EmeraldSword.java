package com.twmicro.practical.items.swords;

import net.minecraft.item.*;
import net.minecraft.item.crafting.Ingredient;

public class EmeraldSword extends SwordItem {
    private static final IItemTier EmeraldSwordTier = new IItemTier() {
        @Override
        public int getMaxUses() {
            return 1500;
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
            return Ingredient.fromStacks(new ItemStack(Items.EMERALD));
        }
    };
    public EmeraldSword() {
        super(EmeraldSwordTier, 10, EmeraldSwordTier.getEfficiency(), new Item.Properties().group(ItemGroup.COMBAT));
    }
}
