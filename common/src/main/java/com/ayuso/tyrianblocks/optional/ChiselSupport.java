package com.ayuso.tyrianblocks.optional;

import com.periut.chisel.block.ChiselGroupLookup;
import net.minecraft.util.Identifier;

public class ChiselSupport {
    public static void addTyrianBlockToChisel(Identifier blockID)
    {
        try {
            ChiselGroupLookup.addItemToGroup("tyrian", blockID);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
