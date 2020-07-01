package com.twmicro.practical.items.tools.emerald;

import com.twmicro.practical.items.ingredients.RubyIngot;
import com.twmicro.practical.items.tools.Tiers;
import net.minecraft.item.*;
import net.minecraft.item.crafting.Ingredient;

public class EmeraldHoe extends HoeItem {
    public EmeraldHoe() {
        super(Tiers.EMERALD_HOE.tier, 4, 0.1F, new Item.Properties().group(ItemGroup.TOOLS));
    }
}
