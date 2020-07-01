package com.twmicro.practical.types;

import com.google.common.collect.ImmutableMap;
import com.twmicro.practical.blocks.RainbowBlock;
import com.twmicro.practical.blocks.RubyBlock;
import com.twmicro.practical.blocks.RubyShardOre;
import com.twmicro.practical.blocks.VarrackBlock;
import com.twmicro.practical.utils.interfaces.IRegistryList;
import net.minecraft.block.Block;
import net.minecraftforge.registries.DeferredRegister;

import java.util.Map;

public class ModBlocks implements IRegistryList<Block> {
    private static final ImmutableMap.Builder<Block, String> REGISTRY_MAP = (new ImmutableMap.Builder<>());
    private static DeferredRegister<Block> DEFERRED_REGISTER = null;

    public static final Block VARRACK = new VarrackBlock();
    public static final Block RAINBOW_BLOCK = new RainbowBlock();
    public static final Block RUBY_SHARD_ORE = new RubyShardOre();
    public static final Block RUBY_BLOCK = new RubyBlock();

    static
    {
        add(VARRACK, "varrack");
        add(RAINBOW_BLOCK, "rainbow_block");
        add(RUBY_SHARD_ORE, "ruby_shard_ore");
        add(RUBY_BLOCK, "ruby_block");
    }

    private static void add(Block block, String name)
    {
        REGISTRY_MAP.put(block, name);
    }

    @Override
    public void setDeferredRegister(DeferredRegister<?> register) {
        DEFERRED_REGISTER = (DeferredRegister<Block>) register;
    }

    @Override
    public Map<Block, String> getRegistryNames() {
        return REGISTRY_MAP.build();
    }

    @Override
    public void register() {
        Map<Block, String> MAP = getRegistryNames();
        MAP.forEach((block, name) -> DEFERRED_REGISTER.register(name, () -> block));
    }
}
