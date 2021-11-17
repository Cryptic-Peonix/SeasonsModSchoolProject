package me.connor.schoolseasons.core.world.feature.tree;

import me.connor.schoolseasons.core.blocks.trees.MassiveTree;
import me.connor.schoolseasons.core.world.feature.ModFeatures;
import me.connor.schoolseasons.core.world.feature.biome.ModBiomeFeatures;
import net.minecraft.block.trees.BigTree;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.HugeTreeFeatureConfig;
import net.minecraft.world.gen.feature.TreeFeatureConfig;

import javax.annotation.Nullable;
import java.util.Random;

//WIP
public class RedwoodTree extends MassiveTree {

    @Nullable
    @Override
    protected ConfiguredFeature<TreeFeatureConfig, ?> getTreeFeature(Random randomIn, boolean p_225546_2_) {
        //return Feature.NORMAL_TREE.withConfiguration(ModBiomeFeatures.REDWOOD_TREE_CONFIG);
        return null;
    }

    @Nullable
    @Override
    protected ConfiguredFeature<MassiveTreeFeatureConfig, ?> getMassiveTreeFeature(Random rand) {
        return ModFeatures.MASSIVE_REDWOOD_TREE.withConfiguration(ModBiomeFeatures.MASSIVE_REDWOOD_TREE_CONFIG);
    }


}
