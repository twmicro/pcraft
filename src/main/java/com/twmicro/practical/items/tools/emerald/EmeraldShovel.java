package com.twmicro.practical.items.tools.emerald;

import com.twmicro.practical.items.ingredients.RubyIngot;
import com.twmicro.practical.items.tools.Tiers;
import net.minecraft.item.*;
import net.minecraft.item.crafting.Ingredient;
import net.minecraftforge.common.ToolType;

public class EmeraldShovel extends ShovelItem {
    public EmeraldShovel() {
        super(Tiers.EMERALD_SHOVEL.tier, 2, 0.5F, new Item.Properties().addToolType(ToolType.SHOVEL, 4).group(ItemGroup.TOOLS));
    }

}
