package com.nick.humlands.core.init;

import com.nick.humlands.Humlands;
import com.nick.humlands.common.item.Drill;
import com.nick.humlands.common.item.EmptyDrill;
import com.nick.humlands.common.item.EmptyRubberExtractor;
import com.nick.humlands.common.item.FluxCrystal;
import com.nick.humlands.common.item.RubberExtractor;

import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemInit 
{

	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS,
			Humlands.MOD_ID);

	public static final RegistryObject<Item> CORRUPTED_CRYSTAL = ITEMS.register("corrupted_crystal",
			() -> new Item(new Item.Properties().group(Humlands.HUMLANDS_TAB)));
	
	public static final RegistryObject<Item> FLUX_CRYSTAL = ITEMS.register("flux_crystal",
			() -> new FluxCrystal(new Item.Properties().group(Humlands.HUMLANDS_TAB)));
	
	public static final RegistryObject<Item> PURE_FLUX_CRYSTAL = ITEMS.register("pure_flux_crystal",
			() -> new FluxCrystal(new Item.Properties().group(Humlands.HUMLANDS_TAB)));

	public static final RegistryObject<Item> COPPER = ITEMS.register("copper",
			() -> new Item(new Item.Properties().group(Humlands.HUMLANDS_TAB)));
	
	public static final RegistryObject<Item> COPPER_WIRE = ITEMS.register("copper_wire",
			() -> new Item(new Item.Properties().group(Humlands.HUMLANDS_TAB)));
	
	public static final RegistryObject<Item> CARBON_TUBE = ITEMS.register("carbon_tube",
			() -> new Item(new Item.Properties().group(Humlands.HUMLANDS_TAB)));

	public static final RegistryObject<Item> CARBON_SHEET = ITEMS.register("carbon_sheet",
			() -> new Item(new Item.Properties().group(Humlands.HUMLANDS_TAB)));
	
	public static final RegistryObject<Item> IRON_PLATE = ITEMS.register("iron_plate",
			() -> new Item(new Item.Properties().group(Humlands.HUMLANDS_TAB)));
	
	public static final RegistryObject<Item> IRON_MESH = ITEMS.register("iron_mesh",
			() -> new Item(new Item.Properties().group(Humlands.HUMLANDS_TAB)));
	
	public static final RegistryObject<Item> MECHANICAL_ARM = ITEMS.register("mechanical_arm",
			() -> new Item(new Item.Properties().group(Humlands.HUMLANDS_TAB)));

	public static final RegistryObject<Item> POWERED_SIFTER_BODY = ITEMS.register("powered_sifter_body",
			() -> new Item(new Item.Properties().group(Humlands.HUMLANDS_TAB)));
	
	public static final RegistryObject<Item> FILTER = ITEMS.register("filter",
			() -> new Item(new Item.Properties().group(Humlands.HUMLANDS_TAB)));
	
	public static final RegistryObject<Item> UNPOWERED_SIFTER_BODY = ITEMS.register("unpowered_sifter_body",
			() -> new Item(new Item.Properties().group(Humlands.HUMLANDS_TAB)));
	
	public static final RegistryObject<Item> BATTERY = ITEMS.register("battery",
			() -> new Item(new Item.Properties().group(Humlands.HUMLANDS_TAB)));
	
	public static final RegistryObject<Item> UNCHARGED_BATTERY = ITEMS.register("uncharged_battery",
			() -> new Item(new Item.Properties().group(Humlands.HUMLANDS_TAB)));

	public static final RegistryObject<Item> RUBBER = ITEMS.register("rubber",
			() -> new Item(new Item.Properties().group(Humlands.HUMLANDS_TAB)));
	
	public static final RegistryObject<Item> STEEL_CHUNK = ITEMS.register("steel_chunk",
			() -> new Item(new Item.Properties().group(Humlands.HUMLANDS_TAB)));
	
	public static final RegistryObject<Item> STEEL_PLATE = ITEMS.register("steel_plate",
			() -> new Item(new Item.Properties().group(Humlands.HUMLANDS_TAB)));
	
	public static final RegistryObject<Item> BLADE = ITEMS.register("blade",
			() -> new Item(new Item.Properties().group(Humlands.HUMLANDS_TAB)));
	
	public static final RegistryObject<Item> DIAMOND_DUST = ITEMS.register("diamond_dust",
			() -> new Item(new Item.Properties().group(Humlands.HUMLANDS_TAB)));
	
	public static final RegistryObject<Item> DRILL_TIP = ITEMS.register("drill_tip",
			() -> new Item(new Item.Properties().group(Humlands.HUMLANDS_TAB)));

	public static final RegistryObject<Item> TOOL_BODY = ITEMS.register("tool_body",
			() -> new Item(new Item.Properties().group(Humlands.HUMLANDS_TAB)));

	
	// Block Items
	
	public static final RegistryObject<BlockItem> RUBBER_WOOD_LOG = ITEMS.register("rubber_wood_log",
			() -> new BlockItem(BlockInit.RUBBER_WOOD_LOG.get(),
					new Item.Properties().group(Humlands.HUMLANDS_TAB)));
	
	public static final RegistryObject<BlockItem> STRIPPED_RUBBER_WOOD_LOG = ITEMS.register("stripped_rubber_wood_log",
			() -> new BlockItem(BlockInit.STRIPPED_RUBBER_WOOD_LOG.get(),
					new Item.Properties().group(Humlands.HUMLANDS_TAB)));
	
	public static final RegistryObject<BlockItem> RUBBER_STREAMING_RUBBER_WOOD_LOG = ITEMS.register("rubber_streaming_rubber_wood_log",
			() -> new BlockItem(BlockInit.RUBBER_STREAMING_RUBBER_WOOD_LOG.get(),
					new Item.Properties().group(Humlands.HUMLANDS_TAB)));
	
	public static final RegistryObject<BlockItem> RUBBER_WOOD_PLANKS = ITEMS.register("rubber_wood_planks",
			() -> new BlockItem(BlockInit.RUBBER_WOOD_PLANKS.get(),
					new Item.Properties().group(Humlands.HUMLANDS_TAB)));
	
	public static final RegistryObject<BlockItem> RUBBER_LEAVES = ITEMS.register("rubber_leaves",
			() -> new BlockItem(BlockInit.RUBBER_LEAVES.get(),
					new Item.Properties().group(Humlands.HUMLANDS_TAB)));
	
	public static final RegistryObject<BlockItem> RUBBER_WOOD_BUTTON = ITEMS.register("rubber_wood_button",
			() -> new BlockItem(BlockInit.RUBBER_WOOD_BUTTON.get(),
					new Item.Properties().group(Humlands.HUMLANDS_TAB)));
	
	public static final RegistryObject<BlockItem> RUBBER_WOOD_DOOR = ITEMS.register("rubber_wood_door",
			() -> new BlockItem(BlockInit.RUBBER_WOOD_DOOR.get(),
					new Item.Properties().group(Humlands.HUMLANDS_TAB)));
	
	public static final RegistryObject<BlockItem> RUBBER_WOOD_FENCE = ITEMS.register("rubber_wood_fence",
			() -> new BlockItem(BlockInit.RUBBER_WOOD_FENCE.get(),
					new Item.Properties().group(Humlands.HUMLANDS_TAB)));
	
	public static final RegistryObject<BlockItem> RUBBER_WOOD_FENCE_GATE = ITEMS.register("rubber_wood_fence_gate",
			() -> new BlockItem(BlockInit.RUBBER_WOOD_FENCE_GATE.get(),
					new Item.Properties().group(Humlands.HUMLANDS_TAB)));
	
	public static final RegistryObject<BlockItem> RUBBER_WOOD_FOREST_DIRT = ITEMS.register("rubber_wood_forest_dirt",
			() -> new BlockItem(BlockInit.RUBBER_WOOD_FOREST_DIRT.get(),
					new Item.Properties().group(Humlands.HUMLANDS_TAB)));
	
	public static final RegistryObject<BlockItem> RUBBER_WOOD_FOREST_GRASS = ITEMS.register("rubber_wood_forest_grass",
			() -> new BlockItem(BlockInit.RUBBER_WOOD_FOREST_GRASS.get(),
					new Item.Properties().group(Humlands.HUMLANDS_TAB)));
	
	public static final RegistryObject<BlockItem> RUBBER_WOOD_PRESSURE_PLATE = ITEMS.register("rubber_wood_pressure_plate",
			() -> new BlockItem(BlockInit.RUBBER_WOOD_PRESSURE_PLATE.get(),
					new Item.Properties().group(Humlands.HUMLANDS_TAB)));
	
	public static final RegistryObject<BlockItem> RUBBER_WOOD_SLAB = ITEMS.register("rubber_wood_slab",
			() -> new BlockItem(BlockInit.RUBBER_WOOD_SLAB.get(),
					new Item.Properties().group(Humlands.HUMLANDS_TAB)));
	
	public static final RegistryObject<BlockItem> RUBBER_WOOD_STAIRS = ITEMS.register("rubber_wood_stairs",
			() -> new BlockItem(BlockInit.RUBBER_WOOD_STAIRS.get(),
					new Item.Properties().group(Humlands.HUMLANDS_TAB)));
	
	public static final RegistryObject<BlockItem> RUBBER_WOOD_TRAPDOOR = ITEMS.register("rubber_wood_trapdoor",
			() -> new BlockItem(BlockInit.RUBBER_WOOD_TRAPDOOR.get(),
					new Item.Properties().group(Humlands.HUMLANDS_TAB)));
	
	public static final RegistryObject<BlockItem> COPPER_ORE = ITEMS.register("copper_ore",
			() -> new BlockItem(BlockInit.COPPER_ORE.get(),
					new Item.Properties().group(Humlands.HUMLANDS_TAB)));
	
	public static final RegistryObject<BlockItem> COAL_ORE_CLUMP = ITEMS.register("coal_ore_clump",
			() -> new BlockItem(BlockInit.COAL_ORE_CLUMP.get(),
					new Item.Properties().group(Humlands.HUMLANDS_TAB)));
	
	public static final RegistryObject<BlockItem> GOLD_ORE_CLUMP = ITEMS.register("gold_ore_clump",
			() -> new BlockItem(BlockInit.GOLD_ORE_CLUMP.get(),
					new Item.Properties().group(Humlands.HUMLANDS_TAB)));
	
	public static final RegistryObject<BlockItem> IRON_ORE_CLUMP = ITEMS.register("iron_ore_clump",
			() -> new BlockItem(BlockInit.IRON_ORE_CLUMP.get(),
					new Item.Properties().group(Humlands.HUMLANDS_TAB)));
	
	public static final RegistryObject<BlockItem> LAPIS_ORE_CLUMP = ITEMS.register("lapis_ore_clump",
			() -> new BlockItem(BlockInit.LAPIS_ORE_CLUMP.get(),
					new Item.Properties().group(Humlands.HUMLANDS_TAB)));
	

	public static final RegistryObject<BlockItem> REDSTONE_ORE_CLUMP = ITEMS.register("redstone_ore_clump",
			() -> new BlockItem(BlockInit.REDSTONE_ORE_CLUMP.get(),
					new Item.Properties().group(Humlands.HUMLANDS_TAB)));
	
	public static final RegistryObject<BlockItem> FLUX_CRYSTAL_BLOCK_THREE = ITEMS.register("flux_crystal_block_three",
			() -> new BlockItem(BlockInit.FLUX_CRYSTAL_BLOCK_THREE.get(),
					new Item.Properties().group(Humlands.HUMLANDS_TAB)));
	
	public static final RegistryObject<BlockItem> FLUX_CRYSTAL_BLOCK_TWO = ITEMS.register("flux_crystal_block_two",
			() -> new BlockItem(BlockInit.FLUX_CRYSTAL_BLOCK_TWO.get(),
					new Item.Properties().group(Humlands.HUMLANDS_TAB)));
	
	public static final RegistryObject<BlockItem> FLUX_CRYSTAL_BLOCK_ONE = ITEMS.register("flux_crystal_block_one",
			() -> new BlockItem(BlockInit.FLUX_CRYSTAL_BLOCK_ONE.get(),
					new Item.Properties().group(Humlands.HUMLANDS_TAB)));
	
	public static final RegistryObject<BlockItem> SIFTER = ITEMS.register("sifter",
			() -> new BlockItem(BlockInit.SIFTER.get(),
					new Item.Properties().group(Humlands.HUMLANDS_TAB)));
	
	public static final RegistryObject<BlockItem> SCULPTOR = ITEMS.register("sculptor",
			() -> new BlockItem(BlockInit.SCULPTOR.get(),
					new Item.Properties().group(Humlands.HUMLANDS_TAB)));

	
	//Foods
	
	public static final RegistryObject<Item> INSECT_BAR = ITEMS.register("insect_bar",
			() -> new Item(new Item.Properties().group(Humlands.HUMLANDS_TAB).food(FoodInit.INSECT_BAR)));
	
	
	//Tools
	
	public static final RegistryObject<Item> RUBBER_EXTRACTOR = ITEMS.register("rubber_extractor",
			() -> new RubberExtractor(
					new Item.Properties().group(Humlands.HUMLANDS_TAB).maxStackSize(1).maxDamage(6)));
	
	public static final RegistryObject<Item> UNCHARGED_RUBBER_EXTRACTOR = ITEMS.register("uncharged_rubber_extractor",
			() -> new Item(
					new Item.Properties().group(Humlands.HUMLANDS_TAB).maxStackSize(1)));
	
	public static final RegistryObject<Item> EMPTY_RUBBER_EXTRACTOR = ITEMS.register("empty_rubber_extractor",
			() -> new EmptyRubberExtractor(
					new Item.Properties().group(Humlands.HUMLANDS_TAB).maxStackSize(1)));
	
	public static final RegistryObject<Item> DRILL = ITEMS.register("drill",
			() -> new Drill(
					new Item.Properties().group(Humlands.HUMLANDS_TAB).maxStackSize(1).maxDamage(11)));
	
	public static final RegistryObject<Item> UNCHARGED_DRILL = ITEMS.register("uncharged_drill",
			() -> new Item(
					new Item.Properties().group(Humlands.HUMLANDS_TAB).maxStackSize(1)));
	
	public static final RegistryObject<Item> EMPTY_DRILL = ITEMS.register("empty_drill",
			() -> new EmptyDrill(
					new Item.Properties().group(Humlands.HUMLANDS_TAB).maxStackSize(1)));
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}