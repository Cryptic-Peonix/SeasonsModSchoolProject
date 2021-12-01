package me.connor.schoolseasons.client;

import me.connor.schoolseasons.Reference;
import me.connor.schoolseasons.core.init.BlockInit;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = Reference.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientEventbusSubscriber {

    @SubscribeEvent
    public static void clientSetup(FMLClientSetupEvent e) {
        RenderTypeLookup.setRenderLayer(BlockInit.REDWOOD_LEAVES, RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BlockInit.REDWOOD_SAPLING, RenderType.getCutout());
    }
}
