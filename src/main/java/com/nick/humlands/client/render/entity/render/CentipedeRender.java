package com.nick.humlands.client.render.entity.render;

import com.nick.humlands.Humlands;
import com.nick.humlands.client.render.entity.model.CentipedeModel;
import com.nick.humlands.common.entity.Centipede;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class CentipedeRender extends MobRenderer<Centipede, CentipedeModel<Centipede>> {
	protected static final ResourceLocation CENTIPEDE_TEXTURE = new ResourceLocation(Humlands.MOD_ID,
			"textures/entities/centipede.png");

	public CentipedeRender(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new CentipedeModel<Centipede>(), 1.0f);
	}

	@Override
	public ResourceLocation getEntityTexture(Centipede entity) {

		return CENTIPEDE_TEXTURE;
	}
}