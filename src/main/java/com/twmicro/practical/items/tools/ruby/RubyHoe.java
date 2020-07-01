package com.twmicro.practical.items.tools.ruby;

import com.twmicro.practical.items.ingredients.RubyIngot;
import com.twmicro.practical.items.tools.Tiers;
import net.minecraft.item.*;
import net.minecraft.item.crafting.Ingredient;
import net.minecraftforge.common.ToolType;

public class RubyHoe extends HoeItem {
    public RubyHoe() {
        super(Tiers.RUBY_HOE.tier, 4,0.1F, new Item.Properties().group(ItemGroup.TOOLS));
    }
}
