package me.connor.schoolseasons.core.world.feature.tree;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.mojang.datafixers.Dynamic;
import com.mojang.datafixers.types.DynamicOps;
import me.connor.schoolseasons.core.init.BlockInit;
import net.minecraft.world.gen.blockstateprovider.BlockStateProvider;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.treedecorator.TreeDecorator;
import net.minecraftforge.common.IPlantable;

import java.util.List;

public class MassiveTreeFeatureConfig extends BaseTreeFeatureConfig {
    public final int heightInterval;
    public final int crownHeight;

    protected MassiveTreeFeatureConfig(BlockStateProvider trunkProviderIn, BlockStateProvider leavesProviderIn, List<TreeDecorator> decoratorsIn, int baseHeightIn, int heightIntervalIn, int crownHeightIn) {
        super(trunkProviderIn, leavesProviderIn, decoratorsIn, baseHeightIn);
        this.heightInterval = heightIntervalIn;
        this.crownHeight = crownHeightIn;
    }

    public <T> Dynamic<T> serialize(DynamicOps<T> ops) {
        Dynamic<T> dynamic = new Dynamic<>(ops, ops.createMap(ImmutableMap.of(ops.createString("height_interval"), ops.createInt(this.heightInterval), ops.createString("crown_height"), ops.createInt(this.crownHeight))));
        return dynamic.merge(super.serialize(ops));
    }

    @Override
    protected MassiveTreeFeatureConfig setSapling(IPlantable value) {
        super.setSapling(value);
        return this;
    }

    public static <T> MassiveTreeFeatureConfig treeSetup(Dynamic<T> dynamic) {
        BaseTreeFeatureConfig btf = BaseTreeFeatureConfig.deserialize(dynamic);
        return new MassiveTreeFeatureConfig(btf.trunkProvider, btf.leavesProvider, btf.decorators, btf.baseHeight, dynamic.get("height_interval").asInt(0), dynamic.get("crown_height").asInt(0));
    }

    public static <T> MassiveTreeFeatureConfig deserializeRedwood(Dynamic<T> data) {
        return treeSetup(data).setSapling((IPlantable) BlockInit.REDWOOD_SAPLING);
    }

    public static class Builder extends BaseTreeFeatureConfig.Builder {
        private List<TreeDecorator> decorators = ImmutableList.of();
        private int baseHeight;
        private int heightInterval;
        private int crownHeight;


        public Builder(BlockStateProvider trunkProviderIn, BlockStateProvider leavesProviderIn) {
            super(trunkProviderIn, leavesProviderIn);
        }

        public MassiveTreeFeatureConfig.Builder decorators(List<TreeDecorator> list) {
            this.decorators = list;
            return this;
        }

        public MassiveTreeFeatureConfig.Builder baseHeight(int baseHeightIn) {
            this.baseHeight = baseHeightIn;
            return this;
        }

        public MassiveTreeFeatureConfig.Builder heightInterval(int heightIntervalIn) {
            this.heightInterval = heightIntervalIn;
            return this;
        }

        public MassiveTreeFeatureConfig.Builder crownHeight(int crownHeightIn) {
            this.crownHeight = crownHeightIn;
            return this;
        }

        @Override
        public MassiveTreeFeatureConfig.Builder setSapling(IPlantable value) {
            super.setSapling(value);
            return this;
        }

        public MassiveTreeFeatureConfig build() {
            return new MassiveTreeFeatureConfig(this.trunkProvider, this.leavesProvider, this.decorators, this.baseHeight, this.heightInterval, this.crownHeight).setSapling(this.sapling);
        }
    }
}
