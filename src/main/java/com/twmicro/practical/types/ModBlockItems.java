package com.twmicro.practical.types;

import com.twmicro.practical.blocks.BlockItemBase;
import com.twmicro.practical.utils.classes.RegistryList;
import net.minecraft.item.Item;

public class ModBlockItems extends RegistryList<Item> {
    public static final Item RUBY_BLOCK = new BlockItemBase(ModBlocks.RUBY_BLOCK);
    public static final Item VARRACK = new BlockItemBase(ModBlocks.VARRACK);
    public static final Item RUBY_SHARD_ORE = new BlockItemBase(ModBlocks.RUBY_SHARD_ORE);
    public static final Item RAINBOW_BLOCK = new BlockItemBase(ModBlocks.RAINBOW_BLOCK);

    public ModBlockItems()
    {
        add(VARRACK, "varrack");
        add(RAINBOW_BLOCK, "rainbow_block");
        add(RUBY_SHARD_ORE, "ruby_shard_ore");
        add(RUBY_BLOCK, "ruby_block");
    }
}
