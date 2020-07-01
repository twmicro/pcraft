package com.twmicro.practical.types;

import com.google.common.collect.ImmutableMap;
import com.twmicro.practical.items.food.GodApple;
import com.twmicro.practical.items.ingredients.NetherIngot;
import com.twmicro.practical.items.ingredients.RubyIngot;
import com.twmicro.practical.items.ingredients.RubyShard;
import com.twmicro.practical.items.spawn_eggs.TNTTankItem;
import com.twmicro.practical.utils.interfaces.IRegistryList;
import net.minecraft.item.Item;
import net.minecraftforge.registries.DeferredRegister;

import java.util.Map;

public class ModItems implements IRegistryList<Item> {
    private static final ImmutableMap.Builder<Item, String> REGISTRY_MAP = (new ImmutableMap.Builder<>());
    private static DeferredRegister<Item> DEFERRED_REGISTER = null;

    public static final Item GOD_APPLE = new GodApple();
    public static final Item NETHER_INGOT = new NetherIngot();
    public static final Item RUBY_INGOT = new RubyIngot();
    public static final Item RUBY_SHARD = new RubyShard();
    public static final Item TNT_TANK_EGG = new TNTTankItem();

    private static void add(Item item, String name)
    {
        REGISTRY_MAP.put(item, name);
    }

    static
    {
        add(GOD_APPLE, "god_apple");
        add(NETHER_INGOT, "nether_ingot");
        add(RUBY_INGOT, "ruby_ingot");
        add(RUBY_SHARD, "ruby_shard");
        add(TNT_TANK_EGG, "tnt_tank_egg");
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
