package com.nick.humlands.core.init;

import com.nick.humlands.Humlands;
import com.nick.humlands.common.recipe.SculptorRecipeSerializer;

import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class RecipeSerializerInit 
{
	

	public static final DeferredRegister<IRecipeSerializer<?>> RECIPE_SERIALIZERS = DeferredRegister.create(
			ForgeRegistries.RECIPE_SERIALIZERS, Humlands.MOD_ID);

	public static final RegistryObject<IRecipeSerializer<?>> SCULPTOR_SERIALIZER = RECIPE_SERIALIZERS.register("sculptor",
			() -> new SculptorRecipeSerializer());
	
	private static class RecipeType<T extends IRecipe<?>> implements IRecipeType<T> {
		@Override
		public String toString() {
			return Registry.RECIPE_TYPE.getKey(this).toString();
		}
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static <T extends IRecipeType> T registerTypes(ResourceLocation recipeTypeId) {
		return (T) Registry.register(Registry.RECIPE_TYPE, recipeTypeId, new RecipeType<>());
	}
	

}
