package com.twmicro.practical.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.OreBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class RubyShardOre extends OreBlock {
    public RubyShardOre() {
        super(BlockItemBase.genProperties(Material.IRON, 5, 6000, SoundType.STONE, 0.6F, 0).func_235861_h_());
    }
}
