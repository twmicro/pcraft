package com.twmicro.practical.types;

import com.google.common.collect.ImmutableMap;
import com.twmicro.practical.items.ingredients.HookArrowItem;
import com.twmicro.practical.items.ingredients.LightningArrowItem;
import com.twmicro.practical.items.ingredients.TNTArrowItem;
import com.twmicro.practical.items.ingredients.TeleportingArrowItem;
import com.twmicro.practical.utils.interfaces.IRegistryList;
import net.minecraft.item.Item;
import net.minecraftforge.registries.DeferredRegister;

import java.util.Map;

public class ModArrowItems implements IRegistryList<Item> {
    private static final ImmutableMap.Builder<Item, String> REGISTRY_MAP = (new ImmutableMap.Builder<>());
    private static DeferredRegister<Item> DEFERRED_REGISTER = null;

    public static final HookArrowItem HOOK_ARROW = new HookArrowItem();
    public static final TeleportingArrowItem TELEPORTING_ARROW = new TeleportingArrowItem();
    public static final LightningArrowItem LIGHTNING_ARROW = new LightningArrowItem();
    public static final TNTArrowItem TNT_ARROW = new TNTArrowItem();

    private static void add(Item item, String name)
    {
        REGISTRY_MAP.put(item, name);
    }

    static
    {
        add(HOOK_ARROW,"hook_arrow");
        add(TELEPORTING_ARROW, "teleporting_arrow");
        add(LIGHTNING_ARROW,"lightning_arrow");
        add(TNT_ARROW,"tnt_arrow");
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
