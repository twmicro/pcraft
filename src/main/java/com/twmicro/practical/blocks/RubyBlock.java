package com.twmicro.practical.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class RubyBlock extends Block {
    public RubyBlock() {
        super(BlockItemBase.genProperties(Material.IRON, 50F, 6000F, SoundType.METAL, 1.5F, 1));
    }
}
