package me.connor.schoolseasons.core.world.biomes;

import me.connor.schoolseasons.core.world.feature.biome.ModBiomeFeatures;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;

public class RedwoodForest extends Biome {

    public RedwoodForest(Builder biomeBuilder) {
        super(biomeBuilder);
        ModBiomeFeatures.addRedwoodLeafCarpets(this);
        ModBiomeFeatures.addRedwoodTrees(this);
        DefaultBiomeFeatures.addCarvers(this);
    }
}
