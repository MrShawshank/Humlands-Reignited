package com.nick.humlands.core.init;

import com.nick.humlands.Humlands;
import com.nick.humlands.common.container.SculptorContainer;

import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ContainerTypesInit {
	
	public static final DeferredRegister<ContainerType<?>> CONTAINER_TYPES = DeferredRegister.create(
			ForgeRegistries.CONTAINERS, Humlands.MOD_ID);
	
	public static final RegistryObject<ContainerType<SculptorContainer>> SCULPTOR = CONTAINER_TYPES
			.register("sculptor", () -> IForgeContainerType.create(SculptorContainer::new));

}
