package com.nick.humlands.common.item;

import com.nick.humlands.core.init.BlockInit;
import com.nick.humlands.core.init.ItemInit;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TranslationTextComponent;

public class RubberExtractor extends Item {

	public RubberExtractor(Properties properties) {
		super(properties);
	}

	@Override
	public ActionResultType onItemUse(ItemUseContext context) 
	{
		//getDamage starts at 0!
		if (context.getItem().getDamage() < 5 && context.getWorld().getBlockState(context.getPos()).getBlock() == BlockInit.RUBBER_STREAMING_RUBBER_WOOD_LOG.get())
		{
		
			for (ItemStack stack : context.getPlayer().inventory.mainInventory) 
			{
				if (stack.isEmpty())
            {
					context.getPlayer().addItemStackToInventory(new ItemStack(ItemInit.RUBBER.get()));

					context.getItem().damageItem(1, context.getPlayer(), (onBroken) -> 
					{
						onBroken.sendBreakAnimation(context.getPlayer().getActiveHand());

					});
					BlockPos pos = context.getPos();
					context.getWorld().setBlockState(pos, BlockInit.RUBBER_WOOD_LOG.get().getDefaultState());
					return ActionResultType.SUCCESS;
			}
		}
	}
		
		//You cannot shrink in the client!
		if(context.getItem().getDamage() == 5 && !context.getWorld().isRemote)
		{
			context.getItem().shrink(1);
			context.getPlayer().addItemStackToInventory(new ItemStack(ItemInit.UNCHARGED_RUBBER_EXTRACTOR.get()));
			return ActionResultType.PASS;
		}
		
		if(context.getItem().getDamage() == 5 && context.getWorld().isRemote)
		{
			context.getPlayer().sendMessage(new TranslationTextComponent("message.uncharged_tool"), ATTACK_DAMAGE_MODIFIER);
			return ActionResultType.PASS;
		}
		
		return ActionResultType.FAIL;
}
	
	
}
