package com.twmicro.practical.entities.renderers;

import com.twmicro.practical.PracticalMod;
import com.twmicro.practical.entities.RubyPiglinEntity;
import com.twmicro.practical.entities.models.RubyPiglinModel;
import net.minecraft.client.renderer.entity.BipedRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.PiglinRenderer;
import net.minecraft.client.renderer.entity.layers.BipedArmorLayer;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.entity.model.PiglinModel;
import net.minecraft.entity.Entity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.monster.piglin.AbstractPiglinEntity;
import net.minecraft.entity.monster.piglin.PiglinEntity;
import net.minecraft.util.ResourceLocation;

public class RubyPiglinRenderer extends BipedRenderer<MobEntity, RubyPiglinModel<MobEntity>> {
    private static final ResourceLocation field_239393_a_ = new ResourceLocation(PracticalMod.MODID + ":textures/entities/ruby_piglin.png");
    private static final ResourceLocation field_239394_g_ = new ResourceLocation("textures/entity/piglin/zombified_piglin.png");

    public RubyPiglinRenderer(EntityRendererManager p_i232472_1_, boolean p_i232472_2_) {
        super(p_i232472_1_, func_239395_a_(p_i232472_2_), 0.5F, 1.0019531F, 1.0F, 1.0019531F);
        this.addLayer(new BipedArmorLayer<>(this, new BipedModel(0.5F), new BipedModel(1.02F)));
    }

    private static RubyPiglinModel<MobEntity> func_239395_a_(boolean p_239395_0_) {
        RubyPiglinModel<MobEntity> piglinmodel = new RubyPiglinModel<>(0.0F, 64, 64);
        if (p_239395_0_) {
            piglinmodel.field_239116_b_.showModel = false;
        }
        return piglinmodel;
    }

    /**
     * Returns the location of an entity's texture.
     */
    public ResourceLocation getEntityTexture(MobEntity entity) {
        return entity instanceof RubyPiglinEntity ? field_239393_a_ : field_239394_g_;
    }

    protected boolean func_230495_a_(MobEntity p_230495_1_) {
        return p_230495_1_ instanceof AbstractPiglinEntity && ((AbstractPiglinEntity)p_230495_1_).func_242336_eL();
    }
}
