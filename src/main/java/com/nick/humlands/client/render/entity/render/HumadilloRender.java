package com.nick.humlands.client.render.entity.render;

import com.nick.humlands.Humlands;
import com.nick.humlands.client.render.entity.model.HumadilloModel;
import com.nick.humlands.common.entity.Humadillo;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class HumadilloRender extends MobRenderer<Humadillo, HumadilloModel<Humadillo>> {
	protected static final ResourceLocation HUMADILLO_TEXTURE = new ResourceLocation(Humlands.MOD_ID,
			"textures/entities/humadillo.png");

	public HumadilloRender(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new HumadilloModel<Humadillo>(), 0.7f);
	}

	@Override
	public ResourceLocation getEntityTexture(Humadillo entity) {

		return HUMADILLO_TEXTURE;
	}
}