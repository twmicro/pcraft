package com.twmicro.practical.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

public class BlockItemBase extends BlockItem {

    public BlockItemBase(Block block) {
        super(block, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
    }
    public static Block.Properties genProperties(Material material, float hardness, float resistance, SoundType sound, float slipperiness, int lightValue)
    {
        return Block.Properties.create(material).hardnessAndResistance(hardness, resistance).sound(sound).slipperiness(slipperiness);
    }
}
