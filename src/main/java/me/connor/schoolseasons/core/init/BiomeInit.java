package me.connor.schoolseasons.core.init;


import me.connor.schoolseasons.Reference;
import me.connor.schoolseasons.core.world.biomes.TestBiome;
import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BiomeInit {

    public static final DeferredRegister<Biome> BIOMES = new DeferredRegister<>(ForgeRegistries.BIOMES, Reference.MOD_ID);

    public static final RegistryObject<Biome> TEST_BIOME = BIOMES.register("test_biome", () -> new TestBiome(new Biome.Builder().waterColor(65328).waterFogColor(65366).precipitation(Biome.RainType.SNOW).temperature(0.5F).surfaceBuilder(SurfaceBuilder.DEFAULT, new SurfaceBuilderConfig(Blocks.GRASS_BLOCK.getDefaultState(), Blocks.DIRT.getDefaultState(), Blocks.DIRT.getDefaultState())).category(Biome.Category.FOREST).scale(0.5F).downfall(0.7F).depth(0.1F).parent(null)));

    public static void registerBiomes() {
        registerBiome(TEST_BIOME.get(), BiomeDictionary.Type.OVERWORLD, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.HOT);
    }

    private static void registerBiome(Biome biome, BiomeDictionary.Type... types) {
        BiomeManager.addBiome(BiomeManager.BiomeType.WARM, new BiomeManager.BiomeEntry(biome, 20));
        BiomeDictionary.addTypes(biome, types);
    }

}