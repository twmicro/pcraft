package com.twmicro.practical.items.spawn_eggs;

import com.twmicro.practical.entities.TNTTank;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class TNTTankItem extends Item {
    public TNTTankItem() {
        super(new Properties().group(ItemGroup.MISC));
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        TNTTank TntTank = new TNTTank(worldIn);
        TntTank.setPosition(playerIn.getPosX(), playerIn.getPosY(), playerIn.getPosZ());
        worldIn.addEntity(TntTank);
        ItemStack stack = playerIn.getHeldItem(handIn);
        stack.shrink(1);
        return ActionResult.resultSuccess(stack);
    }
}
