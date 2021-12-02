package me.connor.schoolseasons.core.blocks;

import java.util.Random;
import java.util.function.Supplier;

import me.connor.schoolseasons.core.init.BlockInit;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.BushBlock;
import net.minecraft.block.IGrowable;
import net.minecraft.block.trees.Tree;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer.Builder;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.event.ForgeEventFactory;

public class ModSaplingBlock extends BushBlock implements IGrowable {

    public static final IntegerProperty STAGE = BlockStateProperties.STAGE_0_1;
    protected static final VoxelShape SHAPE = Block.makeCuboidShape(2.0D, 0.0D, 2.0D, 14.0D, 12.0D, 14.0D);
    private final Supplier<Tree> tree;

    public ModSaplingBlock(Supplier<Tree> treeIn, Properties properties) {
        super(properties);
        this.tree =treeIn;
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return SHAPE;
    }

    @SuppressWarnings("deprecation")
    public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
        super.tick(state, worldIn, pos, rand);
        if(!worldIn.isAreaLoaded(pos, 1)) {
            return;
        }
        if(worldIn.getLight(pos.up()) >= 9 && rand.nextInt(7) == 0) {
            this.grow(worldIn, rand, pos, state);
        }
    }

    public void func_226942_a_(ServerWorld worldIn, BlockPos pos, BlockState state, Random rand) {
        if(state.get(STAGE) == 0) {
            worldIn.setBlockState(pos, state.cycle(STAGE), 4);
        } else {
            if (!ForgeEventFactory.saplingGrowTree(worldIn, rand, pos))
                return;
            this.tree.get().place(worldIn, worldIn.getChunkProvider().getChunkGenerator(), pos, state,
                    rand);
        }
    }

    @Override
    public boolean canGrow(IBlockReader worldIn, BlockPos pos, BlockState state, boolean isClient) {
        return true;
    }

    @Override
    public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, BlockState state) {
        return (double) worldIn.rand.nextFloat() < 0.45D;
    }

    @Override
    public void grow(ServerWorld worldIn, Random rand, BlockPos pos, BlockState state) {
        this.func_226942_a_(worldIn, pos, state, rand);
    }

    @Override
    protected void fillStateContainer(Builder<Block, BlockState> builder) {
        builder.add(STAGE);
    }


    @Override
    public boolean isValidGround(BlockState state, IBlockReader worldIn, BlockPos pos) {
        Block block = state.getBlock();
        return block == Blocks.DIRT
                || block == Blocks.GRASS_BLOCK || block == Blocks.COARSE_DIRT || block == Blocks.PODZOL
                || block == Blocks.MYCELIUM || block == Blocks.GRANITE || block == BlockInit.LOAMY_GRASS_BLOCK
                || block == BlockInit.LOAMY_DIRT;
    }

}
