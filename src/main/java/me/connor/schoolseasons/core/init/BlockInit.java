package me.connor.schoolseasons.core.init;

import me.connor.schoolseasons.Reference;
import me.connor.schoolseasons.core.blocks.*;
import me.connor.schoolseasons.core.world.feature.tree.RedwoodTree;
import me.connor.schoolseasons.core.world.feature.tree.TestTree;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.potion.Effects;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.ArrayList;
import java.util.List;

@Mod.EventBusSubscriber(modid = Reference.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class BlockInit {

    //create block list
    private static final List<Block> BLOCKS = new ArrayList<>();

    // Create List for BlockItems
    private static final List<Item> ITEMS = new ArrayList<>();

    // Blocks
    public static final Block TEST_BLOCK = register( "test_block",
            new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(5f, 6f)
                    .harvestTool(ToolType.PICKAXE).harvestLevel(0).sound(SoundType.STONE)),
            ItemGroup.BUILDING_BLOCKS, 1);

    public static final Block TEST_SAPLING = register("test_sapling", new ModSaplingBlock(TestTree::new, Block.Properties.from(Blocks.ACACIA_SAPLING)), ItemGroup.DECORATIONS, 64);

    public static final Block REDWOOD_LOG = register("redwood_log", new LogBlock(MaterialColor.RED_TERRACOTTA, Block.Properties.from(Blocks.OAK_LOG)), ItemGroup.BUILDING_BLOCKS, 64);

    public static final Block REDWOOD_WOOD = register("redwood_wood", new RotatedPillarBlock(Block.Properties.from(Blocks.OAK_WOOD)), ItemGroup.BUILDING_BLOCKS, 64);

    public static final Block REDWOOD_LEAVES = register("redwood_leaves", new LeavesBlock(Block.Properties.from(Blocks.OAK_LEAVES)), ItemGroup.DECORATIONS, 64);

    public static final Block REDWOOD_SAPLING  = register("redwood_sapling", new ModSaplingBlock(RedwoodTree::new, Block.Properties.from(Blocks.OAK_SAPLING)), ItemGroup.DECORATIONS, 64);

    public static final Block REDWOOD_PLANKS = register("redwood_planks", new Block(Block.Properties.from(Blocks.OAK_PLANKS)), ItemGroup.BUILDING_BLOCKS, 64);

    public static final Block REDWOOD_LEAF_CARPET = register("redwood_leaf_carpet", new LeafCarpetBlock(Block.Properties.create(Material.LEAVES, MaterialColor.GRASS).hardnessAndResistance(0.1f).sound(SoundType.PLANT)), ItemGroup.DECORATIONS, 64);

    public static final Block LOAMY_GRASS_BLOCK = register("loamy_grass_block", new LoamyGrassBlock(Block.Properties.from(Blocks.GRASS_BLOCK)), ItemGroup.BUILDING_BLOCKS, 64);

    public static  final Block LOAMY_DIRT = register("loamy_dirt", new ModDirtBlock(Block.Properties.from(Blocks.DIRT)), ItemGroup.BUILDING_BLOCKS, 64);

    public static final Block MILKMAID = register("milkmaid", new FlowerBlock(Effects.GLOWING, 10, Block.Properties.from(Blocks.AZURE_BLUET)), ItemGroup.DECORATIONS, 64);

    public static final Block REDWOOD_STAIRS = register("redwood_stairs", new StairsBlock(REDWOOD_PLANKS::getDefaultState, Block.Properties.from(Blocks.OAK_STAIRS)), ItemGroup.BUILDING_BLOCKS, 64);

    public static final Block REDWOOD_SLAB = register("redwood_slab", new SlabBlock(Block.Properties.from(Blocks.OAK_SLAB)), ItemGroup.BUILDING_BLOCKS, 64);

    public static final Block REDWOOD_WALL = register("redwood_wall", new WallBlock(Block.Properties.from(REDWOOD_PLANKS)), ItemGroup.BUILDING_BLOCKS, 64);

    public static final Block REDWOOD_DOOR = register("redwood_door", new ModDoorBlock(Block.Properties.from(Blocks.OAK_DOOR)), ItemGroup.DECORATIONS, 64);

    public static final Block REDWOOD_BUTTON = register("redwood_button", new ModWoodenButton(Block.Properties.from(Blocks.OAK_BUTTON)), ItemGroup.REDSTONE, 64);

    public static final Block REDWOOD_PRESSURE_PLATE = register("redwood_pressure_plate", new ModPressurePlate(PressurePlateBlock.Sensitivity.EVERYTHING, Block.Properties.from(Blocks.OAK_PRESSURE_PLATE)), ItemGroup.REDSTONE, 64);

    public static final Block REDWOOD_GATE = register("redwood_fence_gate", new FenceGateBlock(Block.Properties.from(Blocks.OAK_FENCE_GATE)), ItemGroup.BUILDING_BLOCKS, 64);

    public static final Block DEEG = register("deeg", new Block(Block.Properties.from(Blocks.OAK_LEAVES)), ItemGroup.DECORATIONS, 1);

    public static final Block TEST = register("test", new Block(Block.Properties.from(Blocks.GLASS)), ItemGroup.DECORATIONS, 16);

    // Create Constructor and add blocks/block items to their lists
    private static Block register(String name, Block block, ItemGroup group, int itemMaxStackSize) {
        ResourceLocation key = new ResourceLocation(Reference.MOD_ID, name);
        block.setRegistryName(key);
        BLOCKS.add(block);
        BlockItem item = new BlockItem(block, new Item.Properties().maxStackSize(itemMaxStackSize).group(group));
        item.setRegistryName(key);
        ITEMS.add(item);
        return block;
    }

    // Register Blocks to Registry
    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        IForgeRegistry<Block> registry = event.getRegistry();
        BLOCKS.forEach(registry::register);
        BLOCKS.clear();
    }

    // Register Block Items to Registry
    @SubscribeEvent
    public static void registerBlockItems(RegistryEvent.Register<Item> event) {
        IForgeRegistry<Item> registry = event.getRegistry();
        ITEMS.forEach(registry::register);
        ITEMS.clear();
    }
}
