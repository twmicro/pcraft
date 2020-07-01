package com.twmicro.practical.types.not_deferred;

import com.google.common.collect.ImmutableSet;
import com.twmicro.practical.types.ModArmor;
import com.twmicro.practical.types.ModItems;
import com.twmicro.practical.types.ModToolItems;
import com.twmicro.practical.utils.classes.SimpleTrade;
import com.twmicro.practical.utils.interfaces.INotDeferredList;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.merchant.villager.VillagerProfession;
import net.minecraft.entity.merchant.villager.VillagerTrades;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.registries.DeferredRegister;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

public class ModTrades implements INotDeferredList<SimpleTrade> {
    ArrayList<SimpleTrade> TRADES = new ArrayList<>();
    VillagerTradesEvent EVENT;

    Set<Item> EMERALD_TOOLS = ImmutableSet.of(ModToolItems.EMERALD_AXE, ModToolItems.EMERALD_HOE, ModToolItems.EMERALD_PICKAXE, ModToolItems.EMERALD_SHOVEL, ModToolItems.EMERALD_UNIVERSAL);
    Set<Item> EMERALD_ARMOR = ImmutableSet.of(ModArmor.EMERALD_HELMET, ModArmor.EMERALD_CHESTPLATE, ModArmor.EMERALD_LEGGINGS, ModArmor.EMERALD_BOOTS);
    Set<Item> FOOD = ImmutableSet.of(ModItems.GOD_APPLE);

    private void add(Set<Item> stacks, int xp, int level, int min, int max, int maxTrades, TradeEnchantmentType type)
    {
        for(Item item : stacks)
        {
            ItemStack stack = new ItemStack(item);
            if(type == TradeEnchantmentType.EMERALD_TOOL)
                stack.addEnchantment(Enchantments.EFFICIENCY,1);
            else if(type == TradeEnchantmentType.EMERALD_ARMOR)
                stack.addEnchantment(Enchantments.PROTECTION,1);
            if(type != TradeEnchantmentType.NO) stack.addEnchantment(Enchantments.UNBREAKING,3);
            TRADES.add(new SimpleTrade(EVENT, stack, maxTrades, min, max, level, xp));
        }
    }

    public void addEvent(VillagerTradesEvent event)
    {
        EVENT = event;
    }

    @Override
    public void register() {
        if(EVENT.getType() == VillagerProfession.ARMORER) add(EMERALD_ARMOR, 5, 2, 12, 16, 5, TradeEnchantmentType.EMERALD_ARMOR);
        else if(EVENT.getType() == VillagerProfession.TOOLSMITH) add(EMERALD_TOOLS, 5, 2, 12, 16, 5, TradeEnchantmentType.EMERALD_TOOL);
        else if(EVENT.getType() == VillagerProfession.FARMER) add(FOOD, 5, 2, 64, 64, 5, TradeEnchantmentType.NO);
    }

    public enum TradeEnchantmentType
    {
        EMERALD_TOOL,
        EMERALD_ARMOR,
        NO
    }
}
