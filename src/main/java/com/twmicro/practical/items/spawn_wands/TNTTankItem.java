package com.twmicro.practical.items.spawn_wands;

import com.twmicro.practical.entities.TNTTankEntity;
import com.twmicro.practical.setup.ModRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class TNTTankItem extends Item {
    public TNTTankItem() {
        super(new Properties().group(ItemGroup.MISC));
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        TNTTankEntity TntTank = new TNTTankEntity(ModRegistry.TNT_TANK_ENTITY.get(), worldIn);
        TntTank.setPosition(playerIn.getPosX(), playerIn.getPosY(), playerIn.getPosZ());
        worldIn.addEntity(TntTank);
        ItemStack stack = playerIn.getHeldItem(handIn);
        stack.shrink(1);
        return ActionResult.resultSuccess(stack);
    }
}
