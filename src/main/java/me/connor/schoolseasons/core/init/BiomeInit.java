package me.connor.schoolseasons.core.init;


import me.connor.schoolseasons.Reference;
import me.connor.schoolseasons.core.world.biomes.TestBiome;
import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.biome.provider.BiomeProvider;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BiomeInit {

    public static final DeferredRegister<Biome> BIOMES = new DeferredRegister<>(ForgeRegistries.BIOMES, Reference.MOD_ID);

    public static final RegistryObject<Biome> TEST_BIOME = BIOMES.register("test_biome", () -> new TestBiome(new Biome.
            Builder().waterColor(65328).waterFogColor(65366).precipitation(Biome.RainType.SNOW).temperature(0.5F).
            surfaceBuilder(SurfaceBuilder.DEFAULT, new SurfaceBuilderConfig(Blocks.GRANITE.getDefaultState(),
                    Blocks.DIRT.getDefaultState(), Blocks.ANDESITE.getDefaultState())).category(Biome.Category.FOREST)
            .scale(0.1F).downfall(0.7F).depth(0.1F)));



    public static void registerBiomes() {
        registerBiome(TEST_BIOME.get(), 5, BiomeDictionary.Type.OVERWORLD, BiomeDictionary.Type.FOREST);
    }

    private static void registerBiome(Biome biome, int weight, BiomeDictionary.Type... types) {
        BiomeDictionary.addTypes(biome, types);
        BiomeManager.addBiome(BiomeManager.BiomeType.COOL, new BiomeManager.BiomeEntry(biome, weight));
        BiomeManager.addSpawnBiome(biome);
        BiomeProvider.BIOMES_TO_SPAWN_IN.add(biome);
    }

}
