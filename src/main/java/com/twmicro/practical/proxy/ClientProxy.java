package com.twmicro.practical.proxy;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.world.World;

public class ClientProxy implements IProxy {
    @Override
    public World getClientWorld() {
        return Minecraft.getInstance().world;
    }

    @Override
    public ClientPlayerEntity getPlayerEntity() {
        return Minecraft.getInstance().player;
    }

}

