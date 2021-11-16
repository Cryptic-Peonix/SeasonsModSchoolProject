package me.connor.schoolseasons.core.world.feature.tree;

import me.connor.schoolseasons.core.blocks.trees.MassiveTree;
import me.connor.schoolseasons.core.world.feature.ModFeatures;
import me.connor.schoolseasons.core.world.feature.biome.ModBiomeFeatures;
import net.minecraft.block.trees.BigTree;
import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.feature.*;

import javax.annotation.Nullable;
import java.util.Random;

//WIP
public class RedwoodTree extends MassiveTree {

    @Nullable
    @Override
    protected ConfiguredFeature<TreeFeatureConfig, ?> getTreeFeature(Random randomIn, boolean p_225546_2_) {
        return Feature.NORMAL_TREE.withConfiguration(ModBiomeFeatures.REDWOOD_TREE_CONFIG);
    }

    @Nullable
    @Override
    protected ConfiguredFeature<HugeTreeFeatureConfig, ?> getHugeTreeFeature(Random p_225547_1_) {
        return ModFeatures.MASSIVE_REDWOOD_TREE.withConfiguration(ModBiomeFeatures.MASSIVE_REDWOOD_TREE_CONFIG);
    } //TODO: FIX ME, make the massive tree class
}
