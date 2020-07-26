package com.twmicro.practical.types;

import com.twmicro.practical.blocks.RainbowBlock;
import com.twmicro.practical.blocks.RubyBlock;
import com.twmicro.practical.blocks.RubyShardOre;
import com.twmicro.practical.blocks.VarrackBlock;
import com.twmicro.practical.utils.classes.RegistryList;
import net.minecraft.block.Block;

public class ModBlocks extends RegistryList<Block> {
    public static final Block VARRACK = new VarrackBlock();
    public static final Block RAINBOW_BLOCK = new RainbowBlock();
    public static final Block RUBY_SHARD_ORE = new RubyShardOre();
    public static final Block RUBY_BLOCK = new RubyBlock();

    public ModBlocks()
    {
        add(VARRACK, "varrack");
        add(RAINBOW_BLOCK, "rainbow_block");
        add(RUBY_SHARD_ORE, "ruby_shard_ore");
        add(RUBY_BLOCK, "ruby_block");
    }
}
