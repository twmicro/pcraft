package com.twmicro.practical.types;

import com.google.common.collect.ImmutableMap;
import com.twmicro.practical.items.swords.*;
import com.twmicro.practical.utils.interfaces.IRegistryList;
import net.minecraft.item.Item;
import net.minecraftforge.registries.DeferredRegister;

import java.util.Map;

public class ModSwords implements IRegistryList<Item> {
    private static final ImmutableMap.Builder<Item, String> REGISTRY_MAP = (new ImmutableMap.Builder<>());
    private static DeferredRegister<Item> DEFERRED_REGISTER = null;

    public static final Item GOD_SWORD = new GodSword();
    public static final Item EMERALD_SWORD = new EmeraldSword();
    public static final Item RUBY_SWORD = new RubySword();
    public static final Item HERO_SWORD = new HeroSword();
    public static final Item POISON_SWORD = new PoisonSword();
    public static final Item ANGER_SWORD = new AngerSword();
    public static final Item NETHER_SWORD = new NetherSword();

    private static void add(Item item, String name)
    {
        REGISTRY_MAP.put(item, name);
    }

    static
    {
        add(GOD_SWORD, "god_sword");
        add(EMERALD_SWORD, "emerald_sword");
        add(RUBY_SWORD, "ruby_sword");
        add(HERO_SWORD, "hero_sword");
        add(POISON_SWORD, "poison_sword");
        add(ANGER_SWORD, "sword_of_anger");
        add(NETHER_SWORD, "nether_sword");
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
