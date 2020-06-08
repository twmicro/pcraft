package com.twmicro.practical.items.tools.ruby;

import com.twmicro.practical.items.ingredients.RubyIngot;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.crafting.Ingredient;
import net.minecraftforge.common.ToolType;

public class RubyPickaxe extends PickaxeItem {

    public RubyPickaxe() {
        super(RubyPickaxeTier, 12, 0.5F, new Properties().addToolType(ToolType.PICKAXE, 5).group(ItemGroup.TOOLS));
    }
    private static final IItemTier RubyPickaxeTier = new IItemTier()
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
}
