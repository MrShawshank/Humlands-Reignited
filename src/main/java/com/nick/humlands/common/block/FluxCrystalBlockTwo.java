package com.nick.humlands.common.block;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;

public class FluxCrystalBlockTwo extends CustomBlock
{
	protected static final Map<Direction, VoxelShape> SHAPES = new HashMap<Direction, VoxelShape>();
	public static final VoxelShape SHAPE = Stream.of(
			Block.makeCuboidShape(5, 0, 5, 11, 9, 11),
			Block.makeCuboidShape(6, 9, 6, 10, 14, 10),
			Block.makeCuboidShape(5, 0, 2, 8, 4, 5),
			Block.makeCuboidShape(7, 14, 7, 9, 19, 10),
			Block.makeCuboidShape(5, 4, 2, 7, 7, 4),
			Block.makeCuboidShape(11, 0, 7, 13, 4, 9),
			Block.makeCuboidShape(5, 9, 5, 9, 10, 6),
			Block.makeCuboidShape(8, 5, 11, 9, 8, 13),
			Block.makeCuboidShape(7, 0, 11, 10, 5, 13),
			Block.makeCuboidShape(6, 0, 11, 7, 2, 12),
			Block.makeCuboidShape(8, 0, 3, 10, 2, 5)
			).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();
	
	public FluxCrystalBlockTwo(Properties properties) {
		super(properties);
		runCalculation(SHAPE);
	}
	
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		return SHAPES.get(state.get(HORIZONTAL_FACING));
	}
	
	protected void runCalculation(VoxelShape allShapes) {
		for (Direction direction : Direction.values()) {
			calculateShapes(direction, allShapes);
		}
	}
	
	protected static void calculateShapes(Direction to, VoxelShape allShapes) {
		VoxelShape[] buffer = new VoxelShape[] { allShapes, VoxelShapes.empty() };

		int times = (to.getHorizontalIndex() - Direction.NORTH.getHorizontalIndex() + 4) % 4;
		for (int i = 0; i < times; i++) {
			buffer[0].forEachBox((minX, minY, minZ, maxX, maxY, maxZ) -> buffer[1] = VoxelShapes.or(buffer[1],
					VoxelShapes.create(1 - maxZ, minY, minX, 1 - minZ, maxY, maxX)));
			buffer[0] = buffer[1];
			buffer[1] = VoxelShapes.empty();
		}

		SHAPES.put(to, buffer[0]);
	}
		
}