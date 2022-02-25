package me.connor.schoolseasons.core.init;

import me.connor.schoolseasons.Reference;
import me.connor.schoolseasons.core.init.itemtier.ModItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.SwordItem;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.ArrayList;
import java.util.List;

/**
 * Init class for all the mods items.
 *
 * @author Skyla Clark.
 */
@Mod.EventBusSubscriber(modid = Reference.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ItemInit {

    private static final List<Item> ITEMS = new ArrayList<>();

    // Items
    public static final Item FLINT_PICKAXE = register("flint_pickaxe", new PickaxeItem(ModItemTier.FLINT, 1, -2.8F, new Item.Properties().group(ItemGroup.TOOLS).maxStackSize(1)));

    // Registry stuff
    private static Item register(String name, Item item) {
        ResourceLocation key = new ResourceLocation(Reference.MOD_ID, name);
        item.setRegistryName(key);
        ITEMS.add(item);
        return item;
    }

    @SubscribeEvent
    public static void reigisterItems(RegistryEvent.Register<Item> e) {
        IForgeRegistry<Item> reg = e.getRegistry();
        ITEMS.forEach(reg::register);
        ITEMS.clear();
    }

}
