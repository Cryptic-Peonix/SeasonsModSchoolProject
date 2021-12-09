package me.connor.schoolseasons.core.init;

import net.minecraft.block.Blocks;
import net.minecraft.block.FireBlock;

public class FireInit {

    public static void init() {
        FireBlock fb = (FireBlock) Blocks.FIRE;
        fb.setFireInfo(BlockInit.REDWOOD_LOG, 5, 20);
        fb.setFireInfo(BlockInit.REDWOOD_PLANKS, 5, 20);
        fb.setFireInfo(BlockInit.REDWOOD_SLAB,5, 20);
        fb.setFireInfo(BlockInit.REDWOOD_GATE, 5, 20);
        fb.setFireInfo(BlockInit.REDWOOD_WALL, 5, 20);
        fb.setFireInfo(BlockInit.REDWOOD_STAIRS, 5, 20);
        fb.setFireInfo(BlockInit.REDWOOD_WOOD, 5, 20);
        fb.setFireInfo(BlockInit.REDWOOD_DOOR, 5, 20);
        fb.setFireInfo(BlockInit.REDWOOD_LEAVES, 30, 60);
        fb.setFireInfo(BlockInit.REDWOOD_LEAF_CARPET, 35, 70);
        fb.setFireInfo(BlockInit.MILKMAID, 60, 100);
    }
}
