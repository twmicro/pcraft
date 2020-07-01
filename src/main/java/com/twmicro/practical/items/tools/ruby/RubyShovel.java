package com.twmicro.practical.items.tools.ruby;

import com.twmicro.practical.items.ingredients.RubyIngot;
import com.twmicro.practical.items.tools.Tiers;
import net.minecraft.item.*;
import net.minecraft.item.crafting.Ingredient;
import net.minecraftforge.common.ToolType;

public class RubyShovel extends ShovelItem {
    public RubyShovel() {
        super(Tiers.RUBY_SHOVEL.tier, 7, 0.5F, new Item.Properties().addToolType(ToolType.SHOVEL, 5).group(ItemGroup.TOOLS));
    }
}
