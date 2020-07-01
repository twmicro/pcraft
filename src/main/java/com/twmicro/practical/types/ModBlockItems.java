package com.twmicro.practical.types;

import com.google.common.collect.ImmutableMap;
import com.twmicro.practical.blocks.BlockItemBase;
import com.twmicro.practical.utils.interfaces.IRegistryList;
import net.minecraft.item.Item;
import net.minecraftforge.registries.DeferredRegister;

import java.util.Map;

public class ModBlockItems implements IRegistryList<Item> {
    private static final ImmutableMap.Builder<Item, String> REGISTRY_MAP = (new ImmutableMap.Builder<>());
    private static DeferredRegister<Item> DEFERRED_REGISTER = null;

    public static final Item RUBY_BLOCK = new BlockItemBase(ModBlocks.RUBY_BLOCK);
    public static final Item VARRACK = new BlockItemBase(ModBlocks.VARRACK);
    public static final Item RUBY_SHARD_ORE = new BlockItemBase(ModBlocks.RUBY_SHARD_ORE);
    public static final Item RAINBOW_BLOCK = new BlockItemBase(ModBlocks.RAINBOW_BLOCK);

    private static void add(Item item, String name)
    {
        REGISTRY_MAP.put(item, name);
    }

    static
    {
        add(VARRACK, "varrack");
        add(RAINBOW_BLOCK, "rainbow_block");
        add(RUBY_SHARD_ORE, "ruby_shard_ore");
        add(RUBY_BLOCK, "ruby_block");
    }

    @Override
    public void setDeferredRegister(DeferredRegister<?> register) {
        DEFERRED_REGISTER = (DeferredRegister<Item>) register;
    }

    @Override
    public Map<Item, String> getRegistryNames() {
        return REGISTRY_MAP.build();
    }

    @Override
    public void register() {
        Map<Item, String> MAP = getRegistryNames();
        MAP.forEach((item, name) -> DEFERRED_REGISTER.register(name, () -> item));
    }
}
