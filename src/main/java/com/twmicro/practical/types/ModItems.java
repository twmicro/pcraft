package com.twmicro.practical.types;

import com.twmicro.practical.items.food.GodApple;
import com.twmicro.practical.items.ingredients.NetherIngot;
import com.twmicro.practical.items.ingredients.RubyIngot;
import com.twmicro.practical.items.ingredients.RubyShard;
import com.twmicro.practical.items.spawn_eggs.TNTTankEgg;
import com.twmicro.practical.utils.classes.RegistryList;
import net.minecraft.item.Item;

public class ModItems extends RegistryList<Item> {
    public static final Item GOD_APPLE = new GodApple();
    public static final Item NETHER_INGOT = new NetherIngot();
    public static final Item RUBY_INGOT = new RubyIngot();
    public static final Item RUBY_SHARD = new RubyShard();
    public static final Item TNT_TANK_EGG = new TNTTankEgg();

    public ModItems()
    {
        add(GOD_APPLE, "god_apple");
        add(NETHER_INGOT, "nether_ingot");
        add(RUBY_INGOT, "ruby_ingot");
        add(RUBY_SHARD, "ruby_shard");
        add(TNT_TANK_EGG, "tnt_tank_egg");
    }
}
