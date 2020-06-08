package com.twmicro.practical.entities.renderers;

import com.twmicro.practical.PracticalMod;
import com.twmicro.practical.entities.TNTTankEntity;
import com.twmicro.practical.entities.models.TNTTankModel;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class TNTTankRenderer extends MobRenderer<TNTTankEntity, TNTTankModel> {

    private static final ResourceLocation TEXTURE = new ResourceLocation(PracticalMod.MODID, "textures/entities/tnt_tank_model.png");

    public TNTTankRenderer(EntityRendererManager manager) {
        super(manager, new TNTTankModel(), 0.5f);
    }

    @Nullable
    @Override
    public ResourceLocation getEntityTexture(TNTTankEntity entity) {
        return TEXTURE;
    }
}