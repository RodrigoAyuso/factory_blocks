package com.ayuso.tyrianblocks.fabric;

import com.ayuso.tyrianblocks.TyrianBlocksMod;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;

public class TyrianBlocksFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        TyrianBlocksMod.init();
        TyrianBlocksMod.post(FabricLoader.getInstance().isModLoaded("chisel"));
    }
}
