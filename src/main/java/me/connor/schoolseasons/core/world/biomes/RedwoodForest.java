package me.connor.schoolseasons.core.world.biomes;

import me.connor.schoolseasons.core.world.feature.biome.ModBiomeFeatures;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;

public class RedwoodForest extends Biome {

    public RedwoodForest(Builder biomeBuilder) {
        super(biomeBuilder);
        ModBiomeFeatures.addRedwoodLeafCarpets(this);
        ModBiomeFeatures.addRedwoodTrees(this);
        ModBiomeFeatures.addMilkmaidFlowers(this);
        DefaultBiomeFeatures.addCarvers(this);
        DefaultBiomeFeatures.addSprings(this);
        this.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(EntityType.FOX, 8, 2, 4));
    }
}
