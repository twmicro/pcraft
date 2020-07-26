package com.twmicro.practical.types;

import com.twmicro.practical.items.tools.emerald.*;
import com.twmicro.practical.items.tools.nether.NetherAxe;
import com.twmicro.practical.items.tools.nether.NetherPickaxe;
import com.twmicro.practical.items.tools.nether.NetherShovel;
import com.twmicro.practical.items.tools.nether.NetherUniversal;
import com.twmicro.practical.items.tools.ruby.*;
import com.twmicro.practical.utils.classes.RegistryList;
import net.minecraft.item.Item;

public class ModToolItems extends RegistryList<Item> {
    public static final Item EMERALD_HOE = new EmeraldHoe();
    public static final Item EMERALD_AXE = new EmeraldAxe();
    public static final Item EMERALD_PICKAXE = new EmeraldPickaxe();
    public static final Item EMERALD_SHOVEL = new EmeraldShovel();
    public static final Item EMERALD_UNIVERSAL = new UniversalEmeraldTool();
    public static final Item RUBY_HOE = new RubyHoe();
    public static final Item RUBY_AXE = new RubyAxe();
    public static final Item RUBY_PICKAXE = new RubyPickaxe();
    public static final Item RUBY_SHOVEL = new RubyShovel();
    public static final Item RUBY_UNIVERSAL = new UniversalRubyTool();
    public static final Item NETHER_HOE = new RubyHoe();
    public static final Item NETHER_AXE = new NetherAxe();
    public static final Item NETHER_PICKAXE = new NetherPickaxe();
    public static final Item NETHER_SHOVEL = new NetherShovel();
    public static final Item NETHER_UNIVERSAL = new NetherUniversal();

    public ModToolItems()
    {
        add(EMERALD_HOE, "emerald_hoe");
        add(EMERALD_AXE, "emerald_axe");
        add(EMERALD_PICKAXE, "emerald_pickaxe");
        add(EMERALD_SHOVEL, "emerald_shovel");
        add(EMERALD_UNIVERSAL, "universal_emerald_tool");
        add(RUBY_HOE, "ruby_hoe");
        add(RUBY_AXE, "ruby_axe");
        add(RUBY_PICKAXE, "ruby_pickaxe");
        add(RUBY_SHOVEL, "ruby_shovel");
        add(RUBY_UNIVERSAL, "universal_ruby_tool");
        add(NETHER_HOE, "nether_hoe");
        add(NETHER_AXE, "nether_axe");
        add(NETHER_PICKAXE, "nether_pickaxe");
        add(NETHER_SHOVEL, "nether_shovel");
        add(NETHER_UNIVERSAL, "universal_nether_tool");
    }
}
