package com.ayuso.tyrianblocks.block;

import net.minecraft.block.Block;
import net.minecraft.state.property.BooleanProperty;

import static com.ayuso.tyrianblocks.TyrianSound.TYRIAN_BLOCKS;

public class BaseTyrianBlock extends Block
{
    public static final BooleanProperty ON = BooleanProperty.of("on");
    public BaseTyrianBlock(Settings settings)
    {
        super(settings.strength(2.0f).sounds(TYRIAN_BLOCKS));
    }
}
