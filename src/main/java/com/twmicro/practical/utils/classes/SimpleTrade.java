package com.twmicro.practical.utils.classes;

import net.minecraft.entity.merchant.villager.VillagerProfession;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.village.VillagerTradesEvent;

public class SimpleTrade {
    public SimpleTrade(VillagerTradesEvent event, ItemStack toSell, int maxTrades, int minPrice, int maxPrice, int level, int xp)
    {
        event.getTrades().get(level).add(new RandomTradeBuilder(maxTrades, xp, 1F).setEmeraldPrice(minPrice, maxPrice).setForSale(random -> toSell).build());
    }
}
