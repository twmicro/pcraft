package com.twmicro.practical.items.tools.emerald;

import com.twmicro.practical.items.ingredients.RubyIngot;
import com.twmicro.practical.items.tools.Tiers;
import net.minecraft.item.*;
import net.minecraft.item.crafting.Ingredient;
import net.minecraftforge.common.ToolType;

public class EmeraldAxe extends AxeItem {
    public EmeraldAxe() {
        super(Tiers.EMERALD_AXE.tier, 9, 0.5F, new Properties().addToolType(ToolType.AXE, 5).group(ItemGroup.TOOLS));
    }
}
