package com.twmicro.practical.items.tools.ruby;

import com.twmicro.practical.items.ingredients.RubyIngot;
import com.twmicro.practical.items.tools.Tiers;
import net.minecraft.item.AxeItem;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraftforge.common.ToolType;

public class RubyAxe extends AxeItem {
    public RubyAxe() {
        super(Tiers.RUBY_AXE.tier, 25, 0.5F, new Properties().addToolType(ToolType.AXE, 5).group(ItemGroup.TOOLS));
    }
}
