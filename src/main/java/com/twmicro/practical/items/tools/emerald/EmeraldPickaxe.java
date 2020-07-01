package com.twmicro.practical.items.tools.emerald;

import com.twmicro.practical.items.ingredients.RubyIngot;
import com.twmicro.practical.items.tools.Tiers;
import net.minecraft.item.*;
import net.minecraft.item.crafting.Ingredient;
import net.minecraftforge.common.ToolType;

public class EmeraldPickaxe extends PickaxeItem {
    public EmeraldPickaxe() {
        super(Tiers.EMERALD_PICKAXE.tier, 5, 0.5F, new Properties().addToolType(ToolType.PICKAXE, 5).group(ItemGroup.TOOLS));
    }
}
