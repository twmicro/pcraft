package com.twmicro.practical.types;

import com.twmicro.practical.items.swords.*;
import com.twmicro.practical.utils.classes.RegistryList;
import net.minecraft.item.Item;

public class ModSwords extends RegistryList<Item> {
    public static final Item GOD_SWORD = new GodSword();
    public static final Item EMERALD_SWORD = new EmeraldSword();
    public static final Item RUBY_SWORD = new RubySword();
    public static final Item HERO_SWORD = new HeroSword();
    public static final Item POISON_SWORD = new PoisonSword();
    public static final Item ANGER_SWORD = new AngerSword();
    public static final Item NETHER_SWORD = new NetherSword();


    public ModSwords()
    {
        add(GOD_SWORD, "god_sword");
        add(EMERALD_SWORD, "emerald_sword");
        add(RUBY_SWORD, "ruby_sword");
        add(HERO_SWORD, "hero_sword");
        add(POISON_SWORD, "poison_sword");
        add(ANGER_SWORD, "sword_of_anger");
        add(NETHER_SWORD, "nether_sword");
    }
}
