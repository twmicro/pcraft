package com.twmicro.practical.utils.interfaces;

import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;

public interface IProxy {
    World getClientWorld();
    ClientPlayerEntity getPlayerEntity();
}
