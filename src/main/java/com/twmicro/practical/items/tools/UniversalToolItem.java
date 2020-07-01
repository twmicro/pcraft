package com.twmicro.practical.items.tools;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.RotatedPillarBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.*;

import static java.util.stream.Collectors.toList;

public class UniversalToolItem extends ToolItem {
    private static Set<Block> EFFECTIVE_ON = null;
    private static final Map<Block, BlockState> HOE_LOOKUP = Maps.newHashMap(ImmutableMap.of(Blocks.GRASS_BLOCK, Blocks.FARMLAND.getDefaultState(), Blocks.GRASS_PATH, Blocks.FARMLAND.getDefaultState(), Blocks.DIRT, Blocks.FARMLAND.getDefaultState(), Blocks.COARSE_DIRT, Blocks.DIRT.getDefaultState()));
    private static final Map<Block, Block> BLOCK_STRIPPING_MAP = (new ImmutableMap.Builder<Block, Block>()).put(Blocks.OAK_WOOD, Blocks.STRIPPED_OAK_WOOD).put(Blocks.OAK_LOG, Blocks.STRIPPED_OAK_LOG).put(Blocks.DARK_OAK_WOOD, Blocks.STRIPPED_DARK_OAK_WOOD).put(Blocks.DARK_OAK_LOG, Blocks.STRIPPED_DARK_OAK_LOG).put(Blocks.ACACIA_WOOD, Blocks.STRIPPED_ACACIA_WOOD).put(Blocks.ACACIA_LOG, Blocks.STRIPPED_ACACIA_LOG).put(Blocks.BIRCH_WOOD, Blocks.STRIPPED_BIRCH_WOOD).put(Blocks.BIRCH_LOG, Blocks.STRIPPED_BIRCH_LOG).put(Blocks.JUNGLE_WOOD, Blocks.STRIPPED_JUNGLE_WOOD).put(Blocks.JUNGLE_LOG, Blocks.STRIPPED_JUNGLE_LOG).put(Blocks.SPRUCE_WOOD, Blocks.STRIPPED_SPRUCE_WOOD).put(Blocks.SPRUCE_LOG, Blocks.STRIPPED_SPRUCE_LOG).put(Blocks.field_235368_mh_, Blocks.field_235369_mi_).put(Blocks.field_235370_mj_, Blocks.field_235371_mk_).put(Blocks.field_235377_mq_, Blocks.field_235378_mr_).put(Blocks.field_235379_ms_, Blocks.field_235380_mt_).build();
    static {
        EFFECTIVE_ON = getAllBlocks();
    }

    public UniversalToolItem(IItemTier tier, float attackDamageIn) {
        super(attackDamageIn, 0.1F, tier, EFFECTIVE_ON, new Properties().group(ItemGroup.TOOLS));
    }

    private static Set<Block> getAllBlocks() {
        List<Block> result = Arrays.asList();
        List<Field> blockFields = getStatics(Blocks.class);
        for (Field field : blockFields) {
            try {
                Object fieldObj = field.get(null);
                if (fieldObj instanceof Block) result.add(((Block)fieldObj));
            }
            catch(IllegalAccessException | UnsupportedOperationException ignored)
            {

            }
        }
        return ImmutableSet.copyOf(result);
    }

    @Override
    public float getDestroySpeed(ItemStack stack, BlockState state) {
        return efficiency;
    }

    @Override
    public boolean canHarvestBlock(BlockState blockIn) {
        return true;
    }

    @Override
    public ActionResultType onItemUse(ItemUseContext context) {
        World world = context.getWorld();
        BlockPos blockpos = context.getPos();
        BlockState blockstate = world.getBlockState(blockpos);
        Block block = BLOCK_STRIPPING_MAP.get(blockstate.getBlock());
        if (block != null) {
            PlayerEntity playerentity = context.getPlayer();
            world.playSound(playerentity, blockpos, SoundEvents.ITEM_AXE_STRIP, SoundCategory.BLOCKS, 1.0F, 1.0F);
            if (!world.isRemote) {
                world.setBlockState(blockpos, block.getDefaultState().with(RotatedPillarBlock.AXIS, blockstate.get(RotatedPillarBlock.AXIS)), 11);
                if (playerentity != null) {
                    context.getItem().damageItem(1, playerentity, (p_220040_1_) -> {
                        p_220040_1_.sendBreakAnimation(context.getHand());
                    });
                }
            }

            return ActionResultType.SUCCESS;
        } else {
            if (context.getFace() != Direction.DOWN && world.isAirBlock(blockpos.up()))
            {
                blockstate = HOE_LOOKUP.get(blockstate.getBlock());
                if (blockstate != null) {
                    PlayerEntity playerentity = context.getPlayer();
                    world.playSound(playerentity, blockpos, SoundEvents.ITEM_HOE_TILL, SoundCategory.BLOCKS, 1.0F, 1.0F);
                    if (!world.isRemote) {
                        world.setBlockState(blockpos, blockstate, 11);
                        if (playerentity != null) {
                            context.getItem().damageItem(1, playerentity, (p_220043_1_) -> {
                                p_220043_1_.sendBreakAnimation(context.getHand());
                            });
                        }
                    }

                    return ActionResultType.SUCCESS;
                }
            }
            return ActionResultType.PASS;
        }
    }
    private static List<Field> getStatics(Class<?> clazz) {
        List<Field> result;

        result = Arrays.stream(clazz.getDeclaredFields())
                // filter out the non-static fields
                .filter(f -> Modifier.isStatic(f.getModifiers()))
                .filter(f -> Modifier.isPublic(f.getModifiers()))
                // collect to list
                .collect(toList());

        return result;
    }
}
