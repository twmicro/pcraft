package com.twmicro.practical.items.tools.emerald;

import com.twmicro.practical.items.ingredients.RubyIngot;
import net.minecraft.item.*;
import net.minecraft.item.crafting.Ingredient;
import net.minecraftforge.common.ToolType;

public class EmeraldAxe extends AxeItem {
    public EmeraldAxe() {
        super(EmeraldAxeTier, 9, 0.5F, new Properties().addToolType(ToolType.AXE, 5).group(ItemGroup.TOOLS));
    }

    private static final IItemTier EmeraldAxeTier = new IItemTier()
    {

        @Override
        public int getMaxUses() {
            return 750;
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
