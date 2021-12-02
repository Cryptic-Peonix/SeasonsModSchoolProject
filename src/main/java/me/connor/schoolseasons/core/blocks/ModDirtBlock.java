package me.connor.schoolseasons.core.blocks;

import me.connor.schoolseasons.core.init.BlockInit;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;

public class ModDirtBlock extends Block {

    public ModDirtBlock(Properties properties) {
        super(properties);
    }

    @Override
    public void onPlantGrow(BlockState state, IWorld world, BlockPos pos, BlockPos source) {
        world.setBlockState(pos, BlockInit.LOAMY_DIRT.getDefaultState(), 2);
    }
}
