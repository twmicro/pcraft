package com.twmicro.practical.proxy;

import com.twmicro.practical.proxy.IProxy;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.world.World;

public class ServerProxy implements IProxy {

    @Override
    public World getClientWorld() {
        throw new IllegalStateException("Only run this on the client!");
    }
    @Override
    public ClientPlayerEntity getPlayerEntity() {
        throw new IllegalStateException("Only run this on the client!");
    }
}
