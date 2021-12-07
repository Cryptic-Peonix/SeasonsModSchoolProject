package me.connor.schoolseasons.common;

import me.connor.schoolseasons.Reference;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.Tag;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.Tags;

public class ModTags extends Tags {

    public static class Blocks {
        public static final Tag<Block> LOGS_REDWOOD = tag("redwood_logs");
        public static final Tag<Block> FUNNY = tag("funny");

        private static Tag<Block> tag(String name) {
            return new BlockTags.Wrapper(new ResourceLocation(Reference.MOD_ID, name));
        }
    }

    public static class Items {
        public static final Tag<Item> LOGS_REDWOOD = tag("redwood_logs");
        public static final Tag<Item> FUNNY = tag("funny");

        private static Tag<Item> tag (String name) {
            return new ItemTags.Wrapper(new ResourceLocation(Reference.MOD_ID, name));
        }
    }
}
