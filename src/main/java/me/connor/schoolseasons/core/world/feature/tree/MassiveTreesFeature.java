package me.connor.schoolseasons.core.world.feature.tree;

import com.mojang.datafixers.Dynamic;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.gen.IWorldGenerationBaseReader;
import net.minecraft.world.gen.IWorldGenerationReader;
import net.minecraft.world.gen.feature.AbstractTreeFeature;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.feature.HugeTreeFeatureConfig;
import net.minecraftforge.common.IPlantable;

import java.util.Random;
import java.util.Set;
import java.util.function.Function;

/**
 * Trying to make a 3x3 tree...
 * @param <T>
 */
public abstract class MassiveTreesFeature<T extends BaseTreeFeatureConfig> extends AbstractTreeFeature<T> {

    public MassiveTreesFeature(Function<Dynamic<?>, ? extends T> p_i225797_1_) {
        super(p_i225797_1_);
    }

    //This determines the height i think?
    protected int func_227256_a_(Random rand, MassiveTreeFeatureConfig config) {
        int i = rand.nextInt(3) + config.baseHeight;
        if (config.heightInterval > 1) {
            i += rand.nextInt(config.heightInterval);
        }

        return i;
    }

    /**
     * Determines whether there is space for a tree to grow at a certain pos
     * @param worldIn The world
     * @param leavesPos The position of the leaves
     * @param height The height of the tree
     * @return True if it can grow, false if it cant
     */
    private boolean isSpaceAt(IWorldGenerationBaseReader worldIn, BlockPos leavesPos, int height) {
        boolean canGrow = true;
        if (leavesPos.getY() >= 1 && leavesPos.getY() + height + 1 <= worldIn.getMaxHeight()) {
            for (int i = 0; i <= 1 + height; i++) {
                int j = 2;
                if (i == 0) {j=1;}else if (i >= 1 + height - 2){j=2;}
                for (int k = -j; k <= j && canGrow; k++) {
                    for(int l = -j; l <= j && canGrow; l++) {
                        if (leavesPos.getY() + i < 0 || leavesPos.getY() + i >= worldIn.getMaxHeight() || canBeReplacedByLogs(worldIn, leavesPos.add(k, i, l))) {
                            canGrow = false;
                        }
                    }
                }
            }
            return canGrow;
        } else {
            return false;
        }
    }

    //Change to dirt if the soil is valid to grow
    private boolean validSoil(IWorldGenerationReader worldIn, BlockPos pos, IPlantable sapling) {
        BlockPos blockPos = pos.down();
        if (isSoil(worldIn, blockPos, sapling) && pos.getY() >= 2) {
            setDirtAt(worldIn, blockPos, pos);
            setDirtAt(worldIn, blockPos.east(), pos);
            setDirtAt(worldIn, blockPos.west(), pos);
            setDirtAt(worldIn, blockPos.south(), pos);
            setDirtAt(worldIn, blockPos.north(), pos);
            setDirtAt(worldIn, blockPos.east().south(), pos);
            setDirtAt(worldIn, blockPos.west().south(), pos);
            setDirtAt(worldIn, blockPos.east().north(), pos);
            setDirtAt(worldIn, blockPos.west().north(), pos);
            return true;
        } else {
            return false;
        }
    }

    protected boolean hasRoom(IWorldGenerationReader world, BlockPos pos, int height, BaseTreeFeatureConfig config) {
        return this.isSpaceAt(world, pos, height) && this.validSoil(world, pos, config.getSapling());
    }

    protected void func_227255_a_(IWorldGenerationReader reader, Random rand, BlockPos pos, int integer, Set<BlockPos> blockSet, MutableBoundingBox boundBox, BaseTreeFeatureConfig config) {
        int i = integer * integer;

        for (int j = -integer; j < integer + 1; j++) {
            for(int k = -integer; k <= integer + 1; k++) {
                int l = Math.min(Math.abs(j), Math.abs(j-1));
                int i1 = Math.min(Math.abs(k), Math.abs(k-1));
                if (l + i1 < 7 && l * l + i1 * i1 <= i) {
                    this.func_227219_b_(reader, rand, pos.add(j, 0, k), blockSet, boundBox, config);
                }
            }
        }
    }

    protected void func_227257_b_(IWorldGenerationReader p_227257_1_, Random p_227257_2_, BlockPos p_227257_3_, int p_227257_4_, Set<BlockPos> p_227257_5_, MutableBoundingBox p_227257_6_, BaseTreeFeatureConfig p_227257_7_) {
        int i = p_227257_4_ * p_227257_4_;

        for(int j = -p_227257_4_; j <= p_227257_4_; ++j) {
            for(int k = -p_227257_4_; k <= p_227257_4_; ++k) {
                if (j * j + k * k <= i) {
                    this.func_227219_b_(p_227257_1_, p_227257_2_, p_227257_3_.add(j, 0, k), p_227257_5_, p_227257_6_, p_227257_7_);
                }
            }
        }

    }

    protected void func_227254_a_(IWorldGenerationReader p_227254_1_, Random p_227254_2_, BlockPos p_227254_3_, int p_227254_4_, Set<BlockPos> p_227254_5_, MutableBoundingBox p_227254_6_, MassiveTreeFeatureConfig p_227254_7_) {
        BlockPos.Mutable blockpos$mutable = new BlockPos.Mutable();

        for(int i = 0; i < p_227254_4_; ++i) {
            blockpos$mutable.setPos(p_227254_3_).move(0, i, 0);
            if (canBeReplacedByLogs(p_227254_1_, blockpos$mutable)) {
                this.func_227216_a_(p_227254_1_, p_227254_2_, blockpos$mutable, p_227254_5_, p_227254_6_, p_227254_7_);
            }

            if (i < p_227254_4_ - 1) {
                blockpos$mutable.setPos(p_227254_3_).move(1, i, 0);
                if (canBeReplacedByLogs(p_227254_1_, blockpos$mutable)) {
                    this.func_227216_a_(p_227254_1_, p_227254_2_, blockpos$mutable, p_227254_5_, p_227254_6_, p_227254_7_);
                }

                blockpos$mutable.setPos(p_227254_3_).move(1, i, 1);
                if (canBeReplacedByLogs(p_227254_1_, blockpos$mutable)) {
                    this.func_227216_a_(p_227254_1_, p_227254_2_, blockpos$mutable, p_227254_5_, p_227254_6_, p_227254_7_);
                }

                blockpos$mutable.setPos(p_227254_3_).move(0, i, 1);
                if (canBeReplacedByLogs(p_227254_1_, blockpos$mutable)) {
                    this.func_227216_a_(p_227254_1_, p_227254_2_, blockpos$mutable, p_227254_5_, p_227254_6_, p_227254_7_);
                }
            }
        }

    }
}
