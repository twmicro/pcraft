package com.twmicro.practical.items.tools.emerald;

import com.twmicro.practical.items.ingredients.RubyIngot;
import net.minecraft.item.*;
import net.minecraft.item.crafting.Ingredient;
import net.minecraftforge.common.ToolType;

public class EmeraldPickaxe extends PickaxeItem {
    public EmeraldPickaxe() {
        super(EmeraldPickaxeTier, 5, 0.5F, new Properties().addToolType(ToolType.PICKAXE, 5).group(ItemGroup.TOOLS));
    }
    private static final IItemTier EmeraldPickaxeTier = new IItemTier()
    {

        @Override
        public int getMaxUses() {
            return 1000;
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
}
