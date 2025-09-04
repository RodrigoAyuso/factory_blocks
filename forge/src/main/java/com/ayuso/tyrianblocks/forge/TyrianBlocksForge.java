package com.ayuso.tyrianblocks.forge;

import com.ayuso.tyrianblocks.TyrianBlocksMod;
import dev.architectury.platform.forge.EventBuses;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(TyrianBlocksMod.MODID)
public class TyrianBlocksForge {
    public TyrianBlocksForge() {
        // Submit our event bus to let architectury register our content on the right time
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        EventBuses.registerModEventBus(TyrianBlocksMod.MODID, FMLJavaModLoadingContext.get().getModEventBus());
        TyrianBlocksMod.init();
        modEventBus.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        TyrianBlocksMod.post(ModList.get().isLoaded("chisel"));
    }
}
