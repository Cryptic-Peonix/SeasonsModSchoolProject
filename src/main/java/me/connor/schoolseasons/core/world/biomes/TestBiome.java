package me.connor.schoolseasons.core.world.biomes;

import me.connor.schoolseasons.core.world.feature.ModBiomeFeatures;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.carver.CanyonWorldCarver;
import net.minecraft.world.gen.feature.ProbabilityConfig;

public class TestBiome extends Biome {

    public TestBiome(Builder biomeBuilder) {
        super(biomeBuilder);
        ModBiomeFeatures.addTestTrees(this);
        DefaultBiomeFeatures.addCarvers(this);
        DefaultBiomeFeatures.addDefaultFlowers(this);
        DefaultBiomeFeatures.addExtraReedsPumpkinsCactus(this);
    }
}
