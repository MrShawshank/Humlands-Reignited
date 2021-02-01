package com.nick.humlands.core.init;

import net.minecraft.item.Food;

public class FoodInit {
	
	public static final Food INSECT_BAR = new Food.Builder().saturation(0.5f).hunger(10).setAlwaysEdible().build();

}
