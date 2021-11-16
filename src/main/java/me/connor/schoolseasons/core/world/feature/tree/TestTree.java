package me.connor.schoolseasons.core.world.feature.tree;

import me.connor.schoolseasons.core.world.feature.biome.ModBiomeFeatures;
import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;

import javax.annotation.Nullable;
import java.util.Random;

public class TestTree extends Tree {

    //public static final TreeFeatureConfig TEST_TREE_CONFIG = (new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(BlockInit.TEST_BLOCK.getDefaultState()), new SimpleBlockStateProvider(Blocks.COAL_BLOCK.getDefaultState()), new BlobFoliagePlacer(3, 0))).baseHeight(15).heightRandA(6).foliageHeight(5).ignoreVines().setSapling((IPlantable) BlockInit.TEST_SAPLING).build();

    @Nullable
    @Override
    protected ConfiguredFeature<TreeFeatureConfig, ?> getTreeFeature(Random randomIn, boolean b) {
        return Feature.NORMAL_TREE.withConfiguration(ModBiomeFeatures.TEST_TREE_CONFIG);
    }
}
