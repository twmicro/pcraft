package com.twmicro.practical.items.tools.ruby;

import com.twmicro.practical.items.ingredients.RubyIngot;
import net.minecraft.item.*;
import net.minecraft.item.crafting.Ingredient;
import net.minecraftforge.common.ToolType;

public class RubyHoe extends HoeItem {
    private static final IItemTier RubyHoeTier = new IItemTier()
    {

        @Override
        public int getMaxUses() {
            return 2500;
        }

        @Override
        public float getEfficiency() {
            return 20;
        }

        @Override
        public float getAttackDamage() {
            return 0;
        }

        @Override
        public int getHarvestLevel() {
            return 10;
        }

        @Override
        public int getEnchantability() {
            return 5;
        }

        @Override
        public Ingredient getRepairMaterial() {
            return Ingredient.fromStacks(new ItemStack(new RubyIngot()));
        }
    };
    public RubyHoe() {
        super(RubyHoeTier, 4, new Item.Properties().group(ItemGroup.TOOLS));
    }
}
