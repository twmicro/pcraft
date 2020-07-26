package com.twmicro.practical.types;

import com.twmicro.practical.items.ingredients.HookArrowItem;
import com.twmicro.practical.items.ingredients.LightningArrowItem;
import com.twmicro.practical.items.ingredients.TNTArrowItem;
import com.twmicro.practical.items.ingredients.TeleportingArrowItem;
import com.twmicro.practical.utils.classes.RegistryList;
import net.minecraft.item.Item;

public class ModArrowItems extends RegistryList<Item> {
    public static final HookArrowItem HOOK_ARROW = new HookArrowItem();
    public static final TeleportingArrowItem TELEPORTING_ARROW = new TeleportingArrowItem();
    public static final LightningArrowItem LIGHTNING_ARROW = new LightningArrowItem();
    public static final TNTArrowItem TNT_ARROW = new TNTArrowItem();

    public ModArrowItems()
    {
        add(HOOK_ARROW,"hook_arrow");
        add(TELEPORTING_ARROW, "teleporting_arrow");
        add(LIGHTNING_ARROW,"lightning_arrow");
        add(TNT_ARROW,"tnt_arrow");
    }
}
