package me.connor.schoolseasons.core.world.gen.foliageplacer;

import com.mojang.datafixers.Dynamic;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.foliageplacer.FoliagePlacer;
import net.minecraft.world.gen.foliageplacer.FoliagePlacerType;

import java.util.function.Function;

public class ModFoliagePlacerType {
    public static final FoliagePlacerType<RedwoodFoliagePlacer> REDWOOD = register("redwood_foliage_placer", RedwoodFoliagePlacer::new);

    protected static <P extends FoliagePlacer> FoliagePlacerType<P> register(String s, Function<Dynamic<?>, P> function) {
        return Registry.register(Registry.FOLIAGE_PLACER_TYPE, s, new FoliagePlacerType<>(function));
    }

}
