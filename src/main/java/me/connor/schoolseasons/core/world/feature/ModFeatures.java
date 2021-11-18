package me.connor.schoolseasons.core.world.feature;

import me.connor.schoolseasons.Reference;
import me.connor.schoolseasons.core.world.feature.tree.MassiveRedwoodFeature;
import me.connor.schoolseasons.core.world.feature.tree.MassiveTreeFeatureConfig;
import me.connor.schoolseasons.core.world.feature.tree.MassiveTreesFeature;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.gen.feature.*;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.ArrayList;
import java.util.List;

@Mod.EventBusSubscriber(modid = Reference.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModFeatures {

    public static final List<Feature<?>> FEATURE_LIST = new ArrayList<>();

    //Feature
    public static final Feature<MassiveTreeFeatureConfig> MASSIVE_REDWOOD_TREE = register(new MassiveRedwoodFeature(MassiveTreeFeatureConfig::deserializeRedwood), "massive_redwood_tree");

    public static final Feature<TreeFeatureConfig> TEST_TREE = register(new TreeFeature(TreeFeatureConfig::func_227338_a_), "test_feature");

    @SubscribeEvent
    public static void registerFeatures(RegistryEvent.Register<Feature<?>> event) {
        IForgeRegistry<Feature<?>> registry = event.getRegistry();
        FEATURE_LIST.forEach(registry::register);
        FEATURE_LIST.clear();
    }

    private static <C extends IFeatureConfig, F extends Feature<C>> F register(F value, String key) {
        value.setRegistryName(key);
        FEATURE_LIST.add(value);
        return value;
    }
}
