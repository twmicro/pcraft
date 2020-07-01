package com.twmicro.practical.items.tools.nether;

import com.twmicro.practical.items.tools.Tiers;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraftforge.common.ToolType;

public class NetherPickaxe extends PickaxeItem {
    public NetherPickaxe() {
        super(Tiers.NETHER_PICKAXE.tier, 25, 0.5F, new Properties().addToolType(ToolType.PICKAXE, 5).group(ItemGroup.TOOLS));
    }

    @Override
    public ActionResultType itemInteractionForEntity(ItemStack stack, PlayerEntity playerIn, LivingEntity target, Hand hand) {
        if(hand == Hand.OFF_HAND) playerIn.addPotionEffect(new EffectInstance(Effects.HASTE, 250, 3));
        return super.itemInteractionForEntity(stack, playerIn, target, hand);
    }
}
