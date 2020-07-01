package com.twmicro.practical.items.tools.ruby;

import com.twmicro.practical.items.ingredients.RubyIngot;
import com.twmicro.practical.items.tools.Tiers;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.crafting.Ingredient;
import net.minecraftforge.common.ToolType;

public class RubyPickaxe extends PickaxeItem {

    public RubyPickaxe() {
        super(Tiers.RUBY_PICKAXE.tier, 12, 0.5F, new Properties().addToolType(ToolType.PICKAXE, 5).group(ItemGroup.TOOLS));
    }
}
