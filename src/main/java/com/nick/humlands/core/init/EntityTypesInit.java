package com.nick.humlands.core.init;

import com.nick.humlands.Humlands;
import com.nick.humlands.common.entity.Centipede;
import com.nick.humlands.common.entity.Humadillo;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class EntityTypesInit {
public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES,
		Humlands.MOD_ID);

public static final RegistryObject<EntityType<Humadillo>> HUMADILLO = ENTITY_TYPES.register("humadillo",
		() -> EntityType.Builder.<Humadillo>create(Humadillo::new, EntityClassification.CREATURE).size(0.9f, 0.5f)
				.build(new ResourceLocation(Humlands.MOD_ID, "humadillo").toString()));

public static final RegistryObject<EntityType<Centipede>> CENTIPEDE = ENTITY_TYPES.register("centipede",
		() -> EntityType.Builder.<Centipede>create(Centipede::new, EntityClassification.MONSTER).size(3.0f, 0.5f)
				.build(new ResourceLocation(Humlands.MOD_ID, "centipede").toString()));

       public static void entityAttributesRegister()
       {
    	   GlobalEntityTypeAttributes.put(HUMADILLO.get(), Humadillo.registerAttributes().create());
    	   GlobalEntityTypeAttributes.put(CENTIPEDE.get(), Centipede.registerAttributes().create());
       }
}