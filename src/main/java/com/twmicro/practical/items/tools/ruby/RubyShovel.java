package com.twmicro.practical.items.tools.ruby;

import com.twmicro.practical.items.ingredients.RubyIngot;
import net.minecraft.item.*;
import net.minecraft.item.crafting.Ingredient;
import net.minecraftforge.common.ToolType;

public class RubyShovel extends ShovelItem {
    private static final IItemTier RubyShovelTier = new IItemTier()
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
    public RubyShovel() {
        super(RubyShovelTier, 7, 0.5F, new Item.Properties().addToolType(ToolType.SHOVEL, 5).group(ItemGroup.TOOLS));
    }
}
