package com.twmicro.practical.items.tools.emerald;

import com.twmicro.practical.items.ingredients.RubyIngot;
import net.minecraft.item.*;
import net.minecraft.item.crafting.Ingredient;
import net.minecraftforge.common.ToolType;

public class EmeraldShovel extends ShovelItem {
    private static final IItemTier EmeraldShovelTier = new IItemTier()
    {
        @Override
        public int getMaxUses() {
            return 750;
        }

        @Override
        public float getEfficiency() {
            return 4;
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
    public EmeraldShovel() {
        super(EmeraldShovelTier, 2, 0.5F, new Item.Properties().addToolType(ToolType.SHOVEL, 4).group(ItemGroup.TOOLS));
    }

}
