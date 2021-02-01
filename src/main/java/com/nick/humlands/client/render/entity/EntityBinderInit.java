package com.nick.humlands.client.render.entity;

import com.nick.humlands.client.render.entity.render.HumadilloRender;
import com.nick.humlands.client.render.entity.render.CentipedeRender;
import com.nick.humlands.core.init.EntityTypesInit;

import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class EntityBinderInit {
	public static void bindAllEntities() {
		RenderingRegistry.registerEntityRenderingHandler(EntityTypesInit.HUMADILLO.get(), HumadilloRender::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityTypesInit.CENTIPEDE.get(), CentipedeRender::new);
	}
}
