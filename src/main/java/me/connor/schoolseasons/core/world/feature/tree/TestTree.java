package me.connor.schoolseasons.core.world.feature.tree;

import me.connor.schoolseasons.core.world.feature.biome.ModBiomeFeatures;
import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;

import javax.annotation.Nullable;
import java.util.Random;

public class TestTree extends Tree {

    @Nullable
    @Override
    protected ConfiguredFeature<TreeFeatureConfig, ?> getTreeFeature(Random randomIn, boolean b) {
        return Feature.NORMAL_TREE.withConfiguration(ModBiomeFeatures.TEST_TREE_CONFIG);
    }
}
