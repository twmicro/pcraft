package com.twmicro.practical.items.tools.ruby;

import com.twmicro.practical.items.ingredients.RubyIngot;
import net.minecraft.item.AxeItem;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraftforge.common.ToolType;

public class RubyAxe extends AxeItem {
    public RubyAxe() {
        super(RubyAxeTier, 25, 0.5F, new Properties().addToolType(ToolType.AXE, 5).group(ItemGroup.TOOLS));
    }

    private static final IItemTier RubyAxeTier = new IItemTier()
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
            return 100;
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

}
