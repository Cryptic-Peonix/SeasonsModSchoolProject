package me.connor.schoolseasons.core.world.feature.biome;

import me.connor.schoolseasons.core.init.BlockInit;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.blockplacer.SimpleBlockPlacer;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.BlockClusterFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraft.world.gen.foliageplacer.SpruceFoliagePlacer;
import net.minecraft.world.gen.placement.AtSurfaceWithExtraConfig;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.FrequencyConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.common.IPlantable;

public class ModBiomeFeatures {

    public static final BlockState LEAF_CARPET = BlockInit.REDWOOD_LEAF_CARPET.getDefaultState();
    public static final BlockState MILKMAID = BlockInit.MILKMAID.getDefaultState();
    public static final BlockState LOAMY_DIRT = BlockInit.LOAMY_DIRT.getDefaultState();

    public static final TreeFeatureConfig TEST_TREE_CONFIG = (new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(BlockInit.TEST_BLOCK.getDefaultState()), new SimpleBlockStateProvider(Blocks.COAL_BLOCK.getDefaultState()), new BlobFoliagePlacer(3, 0))).baseHeight(15).heightRandA(6).foliageHeight(5).ignoreVines().setSapling((IPlantable) BlockInit.TEST_SAPLING).build();
    //public static final MassiveTreeFeatureConfig MASSIVE_REDWOOD_TREE_CONFIG = (new MassiveTreeFeatureConfig.Builder(new SimpleBlockStateProvider(BlockInit.REDWOOD_LOG.getDefaultState()), new SimpleBlockStateProvider(BlockInit.REDWOOD_LEAVES.getDefaultState()))).baseHeight(15).heightInterval(17).crownHeight(4).decorators(ImmutableList.of(new AlterGroundTreeDecorator(new SimpleBlockStateProvider(BlockInit.TEST_BLOCK.getDefaultState())))).setSapling((IPlantable) BlockInit.REDWOOD_SAPLING).build();
    public static final TreeFeatureConfig REDWOOD_TREE_CONFIG = (new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(BlockInit.REDWOOD_LOG.getDefaultState()), new SimpleBlockStateProvider(BlockInit.REDWOOD_LEAVES.getDefaultState()), new SpruceFoliagePlacer(2, 1))).baseHeight(20).heightRandA(15).trunkHeight(12).trunkHeightRandom(1).trunkTopOffsetRandom(2).ignoreVines().setSapling((net.minecraftforge.common.IPlantable)BlockInit.REDWOOD_SAPLING).build();
    public static final BlockClusterFeatureConfig LEAF_CARPET_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(LEAF_CARPET), new SimpleBlockPlacer())).tries(64).build();
    public static final BlockClusterFeatureConfig MILKMAID_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(MILKMAID), new SimpleBlockPlacer())).tries(64).build();

    public static void addTestTrees(Biome biomeIn) {
        biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.NORMAL_TREE.withConfiguration(TEST_TREE_CONFIG).withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(3, 1f,1))));
    }

    public static void addRedwoodTrees(Biome biomein) {
        //biomein.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, ModFeatures.MASSIVE_REDWOOD_TREE.withConfiguration(MASSIVE_REDWOOD_TREE_CONFIG));
        biomein.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.NORMAL_TREE.withConfiguration(REDWOOD_TREE_CONFIG).withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(3, 1f, 1))));
    }

    public static void addRedwoodLeafCarpets(Biome biomein) {
        biomein.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(LEAF_CARPET_CONFIG).withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(4, 1f, 2))));
    }

    public static void addMilkmaidFlowers(Biome biomein) {
        biomein.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.FLOWER.withConfiguration(MILKMAID_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_32.configure(new FrequencyConfig(3))));
    }

    public static void addLoamyDirtPatches(Biome biomein) {
        biomein.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, LOAMY_DIRT, 33)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(10,0,0,256))));
    }
}
