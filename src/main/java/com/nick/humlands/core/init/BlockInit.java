package com.nick.humlands.core.init;

import com.nick.humlands.Humlands;
import com.nick.humlands.common.block.CustomDoor;
import com.nick.humlands.common.block.CustomFence;
import com.nick.humlands.common.block.CustomFenceGate;
import com.nick.humlands.common.block.CustomGrass;
import com.nick.humlands.common.block.CustomPressurePlate;
import com.nick.humlands.common.block.CustomSlab;
import com.nick.humlands.common.block.CustomStairs;
import com.nick.humlands.common.block.CustomTrapDoor;
import com.nick.humlands.common.block.CustomWoodButton;
import com.nick.humlands.common.block.FluxCrystalBlockOne;
import com.nick.humlands.common.block.FluxCrystalBlockThree;
import com.nick.humlands.common.block.FluxCrystalBlockTwo;
import com.nick.humlands.common.block.OreClump;
import com.nick.humlands.common.block.Sculptor;
import com.nick.humlands.common.block.Sifter;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.AbstractBlock.Properties;
import net.minecraft.block.Block;
import net.minecraft.block.LeavesBlock;
import net.minecraft.block.PressurePlateBlock.Sensitivity;
import net.minecraft.block.RotatedPillarBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.util.Direction;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockInit {

	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS,
			Humlands.MOD_ID);

	public static final RegistryObject<Block> RUBBER_WOOD_LOG = BLOCKS
			.register("rubber_wood_log",
					() -> createLogBlock(MaterialColor.WOOD, MaterialColor.WOOD));
	
	public static final RegistryObject<Block> RUBBER_WOOD_PLANKS = BLOCKS
			.register("rubber_wood_planks", 
					() -> new Block(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.BROWN)
					.hardnessAndResistance(2f, 3f)
					.harvestTool(ToolType.AXE)
					.harvestLevel(2)
					.sound(SoundType.WOOD)));


	public static final RegistryObject<Block> STRIPPED_RUBBER_WOOD_LOG = BLOCKS.register("stripped_rubber_wood_log",
			() -> createLogBlock(MaterialColor.WOOD, MaterialColor.WOOD));
					

	public static final RegistryObject<Block> RUBBER_STREAMING_RUBBER_WOOD_LOG = BLOCKS.register("rubber_streaming_rubber_wood_log",
			() -> createLogBlock(MaterialColor.WOOD, MaterialColor.WOOD));

	public static final RegistryObject<Block> RUBBER_LEAVES = BLOCKS.register("rubber_leaves",
			() -> createLeavesBlock());
	
	public static final RegistryObject<Block> RUBBER_WOOD_STAIRS = BLOCKS.register("rubber_wood_stairs",
			() -> new CustomStairs(RUBBER_WOOD_PLANKS.get().getDefaultState(),
					Block.Properties.create(Material.WOOD).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD)));

	public static final RegistryObject<Block> RUBBER_WOOD_BUTTON = BLOCKS.register("rubber_wood_button",
			() -> new CustomWoodButton(
					Block.Properties.create(Material.WOOD).hardnessAndResistance(3.0F, 3.0F).sound(SoundType.WOOD)));

	public static final RegistryObject<Block> RUBBER_WOOD_SLAB = BLOCKS.register("rubber_wood_slab",
			() -> new CustomSlab(
					Block.Properties.create(Material.WOOD).hardnessAndResistance(3.0F, 3.0F).sound(SoundType.WOOD)));

	public static final RegistryObject<Block> RUBBER_WOOD_FENCE_GATE = BLOCKS.register("rubber_wood_fence_gate",
			() -> new CustomFenceGate(
					Block.Properties.create(Material.WOOD).hardnessAndResistance(3.0F, 3.0F).sound(SoundType.WOOD)));

	public static final RegistryObject<Block> RUBBER_WOOD_FENCE = BLOCKS.register("rubber_wood_fence",
			() -> new CustomFence(
					Block.Properties.create(Material.WOOD).hardnessAndResistance(3.0F, 3.0F).sound(SoundType.WOOD)));

	public static final RegistryObject<Block> RUBBER_WOOD_PRESSURE_PLATE = BLOCKS.register("rubber_wood_pressure_plate",
			() -> new CustomPressurePlate(Sensitivity.EVERYTHING,
					Block.Properties.create(Material.WOOD).hardnessAndResistance(3.0F, 3.0F).sound(SoundType.WOOD)));

	public static final RegistryObject<Block> RUBBER_WOOD_TRAPDOOR = BLOCKS.register("rubber_wood_trapdoor",
			() -> new CustomTrapDoor(Block.Properties.create(Material.WOOD).hardnessAndResistance(3.0F, 3.0F)
					.sound(SoundType.WOOD).notSolid()));

	public static final RegistryObject<Block> RUBBER_WOOD_DOOR = BLOCKS.register("rubber_wood_door",
			() -> new CustomDoor(Block.Properties.create(Material.WOOD).hardnessAndResistance(3.0F, 3.0F)
					.sound(SoundType.WOOD).notSolid()));

	public static final RegistryObject<Block> RUBBER_WOOD_FOREST_GRASS = BLOCKS.register("rubber_wood_forest_grass",
			() -> new CustomGrass(Block.Properties.create(Material.ORGANIC).hardnessAndResistance(2.0F, 2.0F)
					.sound(SoundType.PLANT)));

	public static final RegistryObject<Block> RUBBER_WOOD_FOREST_DIRT = BLOCKS.register("rubber_wood_forest_dirt",
			() -> new Block(Block.Properties.create(Material.EARTH).hardnessAndResistance(2.0F, 2.0F)
					.sound(SoundType.GROUND)));
	
	public static final RegistryObject<Block> IRON_ORE_CLUMP = BLOCKS.register("iron_ore_clump",
			() -> new OreClump(Properties.create(Material.ROCK, MaterialColor.STONE)));

	public static final RegistryObject<Block> COAL_ORE_CLUMP = BLOCKS.register("coal_ore_clump",
			() -> new OreClump(Properties.create(Material.ROCK, MaterialColor.STONE)));

	public static final RegistryObject<Block> GOLD_ORE_CLUMP = BLOCKS.register("gold_ore_clump",
			() -> new OreClump(Properties.create(Material.ROCK, MaterialColor.STONE)));

	public static final RegistryObject<Block> LAPIS_ORE_CLUMP = BLOCKS.register("lapis_ore_clump",
			() -> new OreClump(Properties.create(Material.ROCK, MaterialColor.STONE)));

	public static final RegistryObject<Block> REDSTONE_ORE_CLUMP = BLOCKS.register("redstone_ore_clump",
			() -> new OreClump(Properties.create(Material.ROCK, MaterialColor.STONE)));
	
	public static final RegistryObject<Block> COPPER_ORE = BLOCKS.register("copper_ore",
			() -> new Block(Properties.create(Material.ROCK, MaterialColor.STONE)));
	
	public static final RegistryObject<Block> FLUX_CRYSTAL_BLOCK_THREE = BLOCKS.register("flux_crystal_block_three",
			() -> new FluxCrystalBlockThree(Properties.create(Material.GLASS, MaterialColor.STONE).harvestLevel(10000000).hardnessAndResistance(10000.0f, 10000.0f)));
	
	public static final RegistryObject<Block> FLUX_CRYSTAL_BLOCK_TWO = BLOCKS.register("flux_crystal_block_two",
			() -> new FluxCrystalBlockTwo(Properties.create(Material.GLASS, MaterialColor.STONE).harvestLevel(10000000).hardnessAndResistance(10000.0f, 10000.0f)));
	
	public static final RegistryObject<Block> FLUX_CRYSTAL_BLOCK_ONE = BLOCKS.register("flux_crystal_block_one",
			() -> new FluxCrystalBlockOne(Properties.create(Material.GLASS, MaterialColor.STONE).harvestLevel(10000000).hardnessAndResistance(10000.0f, 10000.0f)));
	
	public static final RegistryObject<Block> SIFTER = BLOCKS.register("sifter",
			() -> new Sifter(Properties.create(Material.IRON, MaterialColor.IRON).harvestLevel(1).hardnessAndResistance(3.0f, 3.0f)));
	
	public static final RegistryObject<Block> SCULPTOR = BLOCKS.register("sculptor",
			() -> new Sculptor(Properties.create(Material.IRON, MaterialColor.IRON).harvestLevel(1).hardnessAndResistance(3.0f, 3.0f)));
	
	 private static LeavesBlock createLeavesBlock() {
	      return new LeavesBlock(AbstractBlock.Properties.create(Material.LEAVES).hardnessAndResistance(0.2f).tickRandomly().sound(SoundType.PLANT).notSolid());
	   }
	
	private static RotatedPillarBlock createLogBlock(MaterialColor topColor, MaterialColor barkColor) {
	      return new RotatedPillarBlock(AbstractBlock.Properties.create(Material.WOOD, (state) -> {
	         return state.get(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? topColor : barkColor;
	      }).hardnessAndResistance(2.0f).sound(SoundType.WOOD));
	   }

}