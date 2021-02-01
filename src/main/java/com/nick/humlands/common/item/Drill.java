package com.nick.humlands.common.item;

import com.nick.humlands.core.init.BlockInit;
import com.nick.humlands.core.init.ItemInit;

import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TranslationTextComponent;

public class Drill extends Item {

	public Drill(Properties properties) {
		super(properties);
	}

	@Override
	public ActionResultType onItemUse(ItemUseContext context) 
	{
		//getDamage starts at 0!
		if (context.getItem().getDamage() < 10 && context.getWorld().getBlockState(context.getPos()).getBlock() == BlockInit.FLUX_CRYSTAL_BLOCK_THREE.get())
		{
		
			for (ItemStack stack : context.getPlayer().inventory.mainInventory) 
			{
				if (stack.isEmpty())
            {
					context.getPlayer().addItemStackToInventory(new ItemStack(ItemInit.FLUX_CRYSTAL.get()));

					context.getItem().damageItem(1, context.getPlayer(), (onBroken) -> 
					{
						onBroken.sendBreakAnimation(context.getPlayer().getActiveHand());

					});
					BlockPos pos = context.getPos();
					context.getWorld().setBlockState(pos, BlockInit.FLUX_CRYSTAL_BLOCK_TWO.get().getDefaultState());
					return ActionResultType.SUCCESS;
			}
		}
	}
		
		if (context.getItem().getDamage() < 10 && context.getWorld().getBlockState(context.getPos()).getBlock() == BlockInit.FLUX_CRYSTAL_BLOCK_TWO.get())
		{
		
			for (ItemStack stack : context.getPlayer().inventory.mainInventory) 
			{
				if (stack.isEmpty())
            {
					context.getPlayer().addItemStackToInventory(new ItemStack(ItemInit.FLUX_CRYSTAL.get()));

					context.getItem().damageItem(1, context.getPlayer(), (onBroken) -> 
					{
						onBroken.sendBreakAnimation(context.getPlayer().getActiveHand());

					});
					BlockPos pos = context.getPos();
					context.getWorld().setBlockState(pos, BlockInit.FLUX_CRYSTAL_BLOCK_ONE.get().getDefaultState());
					return ActionResultType.SUCCESS;
			}
		}
	}
		if (context.getItem().getDamage() < 10 && context.getWorld().getBlockState(context.getPos()).getBlock() == BlockInit.FLUX_CRYSTAL_BLOCK_ONE.get())
		{
		
			for (ItemStack stack : context.getPlayer().inventory.mainInventory) 
			{
				if (stack.isEmpty())
            {
					context.getPlayer().addItemStackToInventory(new ItemStack(ItemInit.FLUX_CRYSTAL.get()));

					context.getItem().damageItem(1, context.getPlayer(), (onBroken) -> 
					{
						onBroken.sendBreakAnimation(context.getPlayer().getActiveHand());

					});
					BlockPos pos = context.getPos();
					context.getWorld().setBlockState(pos, Blocks.AIR.getDefaultState());
					return ActionResultType.SUCCESS;
			}
		}
	}
		if(context.getItem().getDamage() == 10 && context.getWorld().isRemote)
		{
			context.getPlayer().sendMessage(new TranslationTextComponent("message.discharged_tool"), ATTACK_DAMAGE_MODIFIER);
			return ActionResultType.SUCCESS;
		}
		
		return ActionResultType.FAIL;
		
	
		
		
}
	
	
}
