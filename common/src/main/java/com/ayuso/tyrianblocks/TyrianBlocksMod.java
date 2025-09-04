package com.ayuso.tyrianblocks;

import com.ayuso.tyrianblocks.block.RegisterBlocks;
import com.ayuso.tyrianblocks.optional.ChiselSupport;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.item.Item;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TyrianBlocksMod
{
	public static final String MODID = "tyrian_blocks";
	public static final Logger LOGGER = LoggerFactory.getLogger(MODID);

	public static void init()
	{
		RegisterBlocks.register();
	}

	public static void post(boolean chisel) {
		if (chisel) {
			for (RegistrySupplier<Item> supplier : RegisterBlocks.itemSuppliers) {
				ChiselSupport.addTyrianBlockToChisel(supplier.get().arch$registryName());
			}
		}
	}
}
