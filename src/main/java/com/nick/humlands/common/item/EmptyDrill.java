package com.nick.humlands.common.item;

import com.nick.humlands.core.init.ItemInit;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EmptyDrill extends Item{

	public EmptyDrill(Properties properties) {
		super(properties);
		
	}
	
	@Override
	public void onCreated(ItemStack stack, World worldIn, PlayerEntity playerIn) {
		
		playerIn.addItemStackToInventory(new ItemStack(ItemInit.UNCHARGED_BATTERY.get()));
	}

}
