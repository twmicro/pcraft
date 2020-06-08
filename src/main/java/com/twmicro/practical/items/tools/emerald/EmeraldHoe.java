package com.twmicro.practical.items.tools.emerald;

import com.twmicro.practical.items.ingredients.RubyIngot;
import net.minecraft.item.*;
import net.minecraft.item.crafting.Ingredient;

public class EmeraldHoe extends HoeItem {
    private static final IItemTier EmeraldHoeTier = new IItemTier()
    {

        @Override
        public int getMaxUses() {
            return 5000;
        }

        @Override
        public float getEfficiency() {
            return 10;
        }

        @Override
        public float getAttackDamage() {
            return 0;
        }

        @Override
        public int getHarvestLevel() {
            return 3;
        }

        @Override
        public int getEnchantability() {
            return 100;
        }

        @Override
        public Ingredient getRepairMaterial() {
            return Ingredient.fromStacks(new ItemStack(Items.EMERALD));
        }
    };
    public EmeraldHoe() {
        super(EmeraldHoeTier, 4, new Item.Properties().group(ItemGroup.TOOLS));
    }
}
