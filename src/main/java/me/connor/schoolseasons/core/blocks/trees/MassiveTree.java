package me.connor.schoolseasons.core.blocks.trees;

import me.connor.schoolseasons.core.world.feature.tree.MassiveTreeFeatureConfig;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.trees.Tree;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.ConfiguredFeature;

import javax.annotation.Nullable;
import java.util.Random;

public abstract class MassiveTree extends Tree {

    @Nullable
    protected abstract ConfiguredFeature<MassiveTreeFeatureConfig, ?> getMassiveTreeFeature(Random rand);

    public boolean place(IWorld worldIn, ChunkGenerator<?> chunkGenerator, BlockPos blockPos, BlockState state, Random rand) {
        for( int i = 0; i >= -1; i--) {
            for(int j = 0; j >= -1; j--) {
                if (canMassiveTreeSpawnAt(state, worldIn, blockPos, i, j)) {
                    return this.growMassiveTree(worldIn, chunkGenerator, blockPos, state, rand, i, j);
                }
            }
        }

        return super.place(worldIn, chunkGenerator, blockPos, state, rand);
    }

    public boolean growMassiveTree(IWorld worldIn, ChunkGenerator<?> chunkGenerator, BlockPos blockPos, BlockState state, Random rand, int i, int j) {
        ConfiguredFeature<MassiveTreeFeatureConfig, ?> configuredFeature = this.getMassiveTreeFeature(rand);
        if (configuredFeature == null) {
            return false;
        } else {
            BlockState blockState = Blocks.AIR.getDefaultState();
            worldIn.setBlockState(blockPos.add(i, 0, j), blockState, 4);
            worldIn.setBlockState(blockPos.add(i + 1, 0, j), blockState, 4);
            worldIn.setBlockState(blockPos.add(i - 1, 0, j), blockState, 4);
            worldIn.setBlockState(blockPos.add(i,0,j+1), blockState, 4);
            worldIn.setBlockState(blockPos.add(i,0,j-1), blockState, 4);
            worldIn.setBlockState(blockPos.add(i+1,0,j+1), blockState, 4);
            worldIn.setBlockState(blockPos.add(i-1,0,j+1),blockState, 4);
            worldIn.setBlockState(blockPos.add(i+1,0,j-1), blockState, 4);
            worldIn.setBlockState(blockPos.add(i-1, 0, j-1),blockState, 4);
            if (configuredFeature.place(worldIn, chunkGenerator, rand, blockPos.add(i, 0, j))) {
                return true;
            } else {
                worldIn.setBlockState(blockPos.add(i, 0, j), state, 4);
                worldIn.setBlockState(blockPos.add(i + 1, 0, j), state, 4);
                worldIn.setBlockState(blockPos.add(i -1, 0, j), state, 4);
                worldIn.setBlockState(blockPos.add(i,0,j+1), state, 4);
                worldIn.setBlockState(blockPos.add(i,0,j-1), state, 4);
                worldIn.setBlockState(blockPos.add(i+1,0,j+1), state, 4);
                worldIn.setBlockState(blockPos.add(i-1,0,j+1),state, 4);
                worldIn.setBlockState(blockPos.add(i+1,0,j-1), state, 4);
                worldIn.setBlockState(blockPos.add(i-1, 0, j-1),state, 4);
                return false;
            }
        }
    }

    public static boolean canMassiveTreeSpawnAt(BlockState blockUnder, IBlockReader worldIn, BlockPos pos, int xOffset, int zOffset) {
        Block block = blockUnder.getBlock();
        return block == worldIn.getBlockState(pos.add(xOffset, 0, zOffset)).getBlock() && block == worldIn.getBlockState(pos.add(xOffset + 1, 0, zOffset)).getBlock()
                && block == worldIn.getBlockState(pos.add(xOffset - 1, 0, zOffset)).getBlock() && block == worldIn.getBlockState(pos.add(xOffset, 0, zOffset + 1)).getBlock()
                && block == worldIn.getBlockState(pos.add(xOffset, 0, zOffset - 1)).getBlock() && block == worldIn.getBlockState(pos.add(xOffset + 1, 0, zOffset + 1)).getBlock()
                && block == worldIn.getBlockState(pos.add(xOffset - 1, 0, zOffset + 1)).getBlock() && block == worldIn.getBlockState(pos.add(xOffset + 1, 0, zOffset - 1)).getBlock()
                && block == worldIn.getBlockState(pos.add(xOffset - 1, 0, zOffset - 1)).getBlock();
    }
}
