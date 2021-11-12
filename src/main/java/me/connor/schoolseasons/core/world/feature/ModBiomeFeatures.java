package me.connor.schoolseasons.core.world.feature;

import me.connor.schoolseasons.core.init.BlockInit;
import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraft.world.gen.placement.AtSurfaceWithExtraConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.common.IPlantable;

public class ModBiomeFeatures {

    public static final TreeFeatureConfig TEST_TREE_CONFIG = (new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(BlockInit.TEST_BLOCK.getDefaultState()), new SimpleBlockStateProvider(Blocks.COAL_BLOCK.getDefaultState()), new BlobFoliagePlacer(3, 0))).baseHeight(15).heightRandA(6).foliageHeight(5).ignoreVines().setSapling((IPlantable) BlockInit.TEST_BLOCK.getDefaultState()).build();


    public static void addTestTrees(Biome biomeIn) {
        biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.NORMAL_TREE.withConfiguration(TEST_TREE_CONFIG).withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(3, 1f,1))));
    }
}
