package com.twmicro.practical.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class VarrackBlock extends Block {

    public VarrackBlock() {
        super(BlockItemBase.genProperties(Material.IRON, 10, 6000F, SoundType.GLASS, 1F, 1));
    }
}
