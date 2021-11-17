package me.connor.schoolseasons.core.world.feature.biome;

import com.google.common.collect.ImmutableList;
import me.connor.schoolseasons.core.init.BlockInit;
import me.connor.schoolseasons.core.world.feature.ModFeatures;
import me.connor.schoolseasons.core.world.feature.tree.MassiveTreeFeatureConfig;
import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraft.world.gen.placement.AtSurfaceWithExtraConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.treedecorator.AlterGroundTreeDecorator;
import net.minecraftforge.common.IPlantable;

public class ModBiomeFeatures {

    public static final TreeFeatureConfig TEST_TREE_CONFIG = (new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(BlockInit.TEST_BLOCK.getDefaultState()), new SimpleBlockStateProvider(Blocks.COAL_BLOCK.getDefaultState()), new BlobFoliagePlacer(3, 0))).baseHeight(15).heightRandA(6).foliageHeight(5).ignoreVines().setSapling((IPlantable) BlockInit.TEST_SAPLING).build();
    public static final MassiveTreeFeatureConfig MASSIVE_REDWOOD_TREE_CONFIG = (new MassiveTreeFeatureConfig.Builder(new SimpleBlockStateProvider(BlockInit.REDWOOD_LOG.getDefaultState()), new SimpleBlockStateProvider(BlockInit.REDWOOD_LEAVES.getDefaultState()))).baseHeight(15).heightInterval(17).crownHeight(4).decorators(ImmutableList.of(new AlterGroundTreeDecorator(new SimpleBlockStateProvider(BlockInit.TEST_BLOCK.getDefaultState())))).setSapling((IPlantable) BlockInit.REDWOOD_SAPLING).build();
    public static final TreeFeatureConfig REDWOOD_TREE_CONFIG = (new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(BlockInit.REDWOOD_LOG.getDefaultState()), new SimpleBlockStateProvider(BlockInit.REDWOOD_LEAVES.getDefaultState()), new BlobFoliagePlacer(2, 1))).baseHeight(6).heightRandA(5).foliageHeight(4).ignoreVines().setSapling((IPlantable) BlockInit.REDWOOD_SAPLING).build();

    public static void addTestTrees(Biome biomeIn) {
        biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.NORMAL_TREE.withConfiguration(TEST_TREE_CONFIG).withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(3, 1f,1))));
    }

    public static void addRedwoodTrees(Biome biomein) {
        biomein.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, ModFeatures.MASSIVE_REDWOOD_TREE.withConfiguration(MASSIVE_REDWOOD_TREE_CONFIG).withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(3, 1f, 1))));
        //biomein.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.NORMAL_TREE.withConfiguration(REDWOOD_TREE_CONFIG).withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(3, 1f, 1))));
    }
}
