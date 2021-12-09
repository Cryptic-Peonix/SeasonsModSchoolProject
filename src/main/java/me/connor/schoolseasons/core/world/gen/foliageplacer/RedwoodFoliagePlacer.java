package me.connor.schoolseasons.core.world.gen.foliageplacer;

import com.mojang.datafixers.Dynamic;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.IWorldGenerationReader;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliageplacer.FoliagePlacer;

import java.util.Random;
import java.util.Set;

public class RedwoodFoliagePlacer extends FoliagePlacer {

    public RedwoodFoliagePlacer(int p_i225848_1_, int p_i225848_2_) {
        super(p_i225848_1_, p_i225848_2_, ModFoliagePlacerType.REDWOOD);
    }

    public <T> RedwoodFoliagePlacer(Dynamic<T> dynamic) {
        this(dynamic.get("radius").asInt(0), dynamic.get("radius_random").asInt(0));
    }

    @Override
    public void func_225571_a_(IWorldGenerationReader reader, Random r, TreeFeatureConfig treeFeatureConfig, int p_225571_4_, int p_225571_5_, int p_225571_6_, BlockPos pos, Set<BlockPos> blockPosSet) {

    }

    @Override
    public int func_225573_a_(Random p_225573_1_, int p_225573_2_, int p_225573_3_, TreeFeatureConfig p_225573_4_) {
        return 0;
    }

    @Override
    protected boolean func_225572_a_(Random p_225572_1_, int p_225572_2_, int p_225572_3_, int p_225572_4_, int p_225572_5_, int p_225572_6_) {
        return false;
    }

    @Override
    public int func_225570_a_(int p_225570_1_, int p_225570_2_, int p_225570_3_, int p_225570_4_) {
        return 0;
    }
}
