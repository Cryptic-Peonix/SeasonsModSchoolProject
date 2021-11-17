package me.connor.schoolseasons.core.world.biomes;

import me.connor.schoolseasons.core.world.feature.biome.ModBiomeFeatures;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;

public class TestBiome extends Biome {

    public TestBiome(Builder biomeBuilder) {
        super(biomeBuilder);
        ModBiomeFeatures.addRedwoodTrees(this);
        DefaultBiomeFeatures.addCarvers(this);
        DefaultBiomeFeatures.addDefaultFlowers(this);
        DefaultBiomeFeatures.addExtraReedsPumpkinsCactus(this);
    }
}
