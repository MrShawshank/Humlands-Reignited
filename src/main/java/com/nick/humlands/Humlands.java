package com.nick.humlands;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.nick.humlands.client.gui.SculptorScreen;
import com.nick.humlands.client.render.entity.EntityBinderInit;
import com.nick.humlands.core.init.BlockInit;
import com.nick.humlands.core.init.ContainerTypesInit;
import com.nick.humlands.core.init.EntityTypesInit;
import com.nick.humlands.core.init.ItemInit;
import com.nick.humlands.core.init.RecipeSerializerInit;
import com.nick.humlands.core.init.TileEntityTypesInit;

import net.minecraft.client.gui.ScreenManager;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Humlands.MOD_ID)
public class Humlands {
	public static final Logger LOGGER = LogManager.getLogger();
	public static final String MOD_ID = "humlands";
	public static final ItemGroup HUMLANDS_TAB = new HumlandsTab("humlands_tab");

	public Humlands() {
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		bus.addListener(this::setup);
		bus.addListener(this::clientSetup);

		ItemInit.ITEMS.register(bus);
		BlockInit.BLOCKS.register(bus);
		EntityTypesInit.ENTITY_TYPES.register(bus);
		TileEntityTypesInit.TILE_ENTITY_TYPES.register(bus);
		ContainerTypesInit.CONTAINER_TYPES.register(bus);
		RecipeSerializerInit.RECIPE_SERIALIZERS.register(bus);

		MinecraftForge.EVENT_BUS.register(this);
	}

	private void setup(final FMLCommonSetupEvent event) {

		event.enqueueWork(() -> {
			RenderTypeLookup.setRenderLayer(BlockInit.RUBBER_WOOD_TRAPDOOR.get(), RenderType.getCutout());
			RenderTypeLookup.setRenderLayer(BlockInit.RUBBER_WOOD_DOOR.get(), RenderType.getCutout());
			EntityTypesInit.entityAttributesRegister();
		});
	}
	
	public void clientSetup(FMLClientSetupEvent event) {
		
			EntityBinderInit.bindAllEntities();
			ScreenManager.registerFactory(ContainerTypesInit.SCULPTOR.get(), SculptorScreen::new);
		
	}
	
	public static class HumlandsTab extends ItemGroup {

		public HumlandsTab(String label) {
			super(label);
		}

		@Override
		public ItemStack createIcon() {
			return ItemInit.FLUX_CRYSTAL.get().getDefaultInstance();
		}
	}
	
	

}
