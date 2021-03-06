package me.connor.schoolseasons.core.blocks;

import me.connor.schoolseasons.core.init.BlockInit;
import net.minecraft.block.BlockState;
import net.minecraft.block.IGrowable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.DecoratedFeatureConfig;
import net.minecraft.world.gen.feature.FlowersFeature;
import net.minecraft.world.server.ServerWorld;

import java.util.List;
import java.util.Random;

public class LoamyGrassBlock extends SpreadableLoamyGrassBlock implements IGrowable {
    public LoamyGrassBlock(Properties builder) {
        super(builder);
    }

    @Override
    public boolean canGrow(IBlockReader worldIn, BlockPos pos, BlockState state, boolean isClient) {
        return worldIn.getBlockState(pos.up()).isAir();
    }

    @Override
    public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, BlockState state) {
        return false;
    }

    @Override
    public void onPlantGrow(BlockState state, IWorld world, BlockPos pos, BlockPos source) {
        world.setBlockState(pos, BlockInit.LOAMY_DIRT.getDefaultState(),2);
    }

    @Override
    public void grow(ServerWorld worldIn, Random rand, BlockPos pos, BlockState state) {
        BlockPos blockpos = pos.up();
        BlockState blockstate = BlockInit.LOAMY_GRASS_BLOCK.getDefaultState();

        for (int i = 0; i < 128; ++i) {
            BlockPos blockpos1 = blockpos;
            int j = 0;

            while (true) {
                if (j >= i / 16) {
                    BlockState blockstate2 = worldIn.getBlockState(blockpos1);
                    if (blockstate2.getBlock() == blockstate.getBlock() && rand.nextInt(10) == 0) {
                        ((IGrowable) blockstate.getBlock()).grow(worldIn, rand, blockpos1, blockstate2);
                    }

                    if (!blockstate2.isAir()) {
                        break;
                    }

                    BlockState blockstate1;
                    if (rand.nextInt(8) == 0) {
                        List<ConfiguredFeature<?, ?>> list = worldIn.getBiome(blockpos1).getFlowers();
                        if (list.isEmpty()) {
                            break;
                        }

                        ConfiguredFeature<?, ?> configuredfeature = ((DecoratedFeatureConfig) (list
                                .get(0)).config).feature;
                        blockstate1 = ((FlowersFeature) configuredfeature.feature).getFlowerToPlace(rand, blockpos1,
                                configuredfeature.config);
                    } else {
                        blockstate1 = blockstate;
                    }

                    if (blockstate1.isValidPosition(worldIn, blockpos1)) {
                        worldIn.setBlockState(blockpos1, blockstate1, 3);
                    }
                    break;
                }

                blockpos1 = blockpos1.add(rand.nextInt(3) - 1, (rand.nextInt(3) - 1) * rand.nextInt(3) / 2,
                        rand.nextInt(3) - 1);
                if (worldIn.getBlockState(blockpos1.down()).getBlock() != this
                        || worldIn.getBlockState(blockpos1).isCollisionShapeOpaque(worldIn, blockpos1)) {
                    break;
                }

                ++j;
            }
        }
    }
}
