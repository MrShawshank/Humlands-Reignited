package com.nick.humlands.core.init;

import com.nick.humlands.Humlands;
import com.nick.humlands.common.tileentity.SculptorTileEntity;

import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class TileEntityTypesInit {

	public static final DeferredRegister<TileEntityType<?>> TILE_ENTITY_TYPES = DeferredRegister.create(
			ForgeRegistries.TILE_ENTITIES, Humlands.MOD_ID);
	
	public static final RegistryObject<TileEntityType<SculptorTileEntity>> SCULPTOR = TILE_ENTITY_TYPES
			.register("sculptor", () -> TileEntityType.Builder
					.create(SculptorTileEntity::new, BlockInit.SCULPTOR.get()).build(null));
					

}
