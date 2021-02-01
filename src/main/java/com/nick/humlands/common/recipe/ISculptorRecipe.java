package com.nick.humlands.common.recipe;

import javax.annotation.Nonnull;

import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.items.wrapper.RecipeWrapper;

public interface ISculptorRecipe extends IRecipe<RecipeWrapper> {

	IRecipeType<SculptorRecipe> SCULPTOR = register("sculptor");
	
	@Nonnull
	@Override
	default IRecipeType<?> getType() {
		return SCULPTOR;
	}
	
	@Override
	default boolean canFit(int width, int height) {
		return false;
	}
	
	Ingredient getInput();
	
	 static <T extends IRecipe<?>> IRecipeType<T> register(final String key) {
	      return Registry.register(Registry.RECIPE_TYPE, new ResourceLocation(key), new IRecipeType<T>() {
	         public String toString() {
	            return key;
	         }
	      });
	   }
}
