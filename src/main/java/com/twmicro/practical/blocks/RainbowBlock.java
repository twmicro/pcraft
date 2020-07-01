package com.twmicro.practical.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class RainbowBlock extends Block {

    public RainbowBlock() {
        super(BlockItemBase.genProperties(Material.IRON, 100F, 6000F, SoundType.METAL, 0.1F, 1));
    }
}
