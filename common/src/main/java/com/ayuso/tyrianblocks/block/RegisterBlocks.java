package com.ayuso.tyrianblocks.block;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import com.ayuso.tyrianblocks.TooltipBlockItem;
import com.ayuso.tyrianblocks.block.fan.BaseFanBlock;
import com.ayuso.tyrianblocks.block.fan.MediumFanBlock;
import com.ayuso.tyrianblocks.block.fan.RedstoneFanBlock;
import dev.architectury.registry.registries.Registrar;
import dev.architectury.registry.registries.RegistrarManager;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;

import java.util.ArrayList;

import static com.ayuso.tyrianblocks.TyrianBlocksMod.MODID;

public class RegisterBlocks
{
    public static final Supplier<RegistrarManager> MANAGER = Suppliers.memoize(() -> RegistrarManager.get(MODID));

    enum Type {
        base,
        baseFan,
        redFan,
        mediumFan
    }

    private static void addTyrianBlock(String nameID, Type type)
    {
        addTyrianBlock(nameID, type,true);
    }

    public static ArrayList<RegistrySupplier<Item>> itemSuppliers = new ArrayList<>();

    private static void addTyrianBlock(String nameID, Type type, boolean include)
    {
        Identifier blockID = Identifier.of(MODID, nameID);

        Registrar<Block> blocks = MANAGER.get().get(Registries.BLOCK);
        RegistrySupplier<Block> blockSupplier;

        switch (type) {
            default -> blockSupplier = blocks.register(blockID, () -> new BaseTyrianBlock(AbstractBlock.Settings.copy(Blocks.IRON_BLOCK)));
            case baseFan -> blockSupplier = blocks.register(blockID, () -> new BaseFanBlock(AbstractBlock.Settings.copy(Blocks.IRON_BLOCK)));
            case redFan -> blockSupplier = blocks.register(blockID, () -> new RedstoneFanBlock(AbstractBlock.Settings.copy(Blocks.IRON_BLOCK)));
            case mediumFan -> blockSupplier = blocks.register(blockID, () -> new MediumFanBlock(AbstractBlock.Settings.copy(Blocks.IRON_BLOCK)));
        }

        Registrar<Item> items = MANAGER.get().get(Registries.ITEM);
        itemSuppliers.add(items.register(blockID, () -> new TooltipBlockItem(blockSupplier.get(), new Item.Settings().arch$tab(ItemGroups.BUILDING_BLOCKS), nameID + ".tooltip")));
    }

    public static void register()
    {
        addTyrianBlock("shining", Type.base);
        addTyrianBlock("tyrian", Type.base);
        addTyrianBlock("chaotic", Type.base);
        addTyrianBlock("softplate", Type.base);
        addTyrianBlock("rust", Type.base);
        addTyrianBlock("elaborate", Type.base);
        addTyrianBlock("routes", Type.base);
        addTyrianBlock("platform", Type.base);
        addTyrianBlock("platetiles", Type.base);
        addTyrianBlock("diagonal", Type.base);
        addTyrianBlock("dent", Type.base);
        addTyrianBlock("blueplating", Type.base);
        addTyrianBlock("black", Type.base);
        addTyrianBlock("black2", Type.base);
        addTyrianBlock("opening", Type.base);
        addTyrianBlock("plate", Type.base);
    }
}
