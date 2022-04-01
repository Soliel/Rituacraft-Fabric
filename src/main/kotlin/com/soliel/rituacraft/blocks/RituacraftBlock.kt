package com.soliel.rituacraft.blocks

import com.soliel.rituacraft.Rituacraft
import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.minecraft.block.Block
import net.minecraft.item.BlockItem

@Suppress("UNUSED")
class RituacraftBlock(val IDENT: String, val DEFAULT_NAME: String, settings: FabricBlockSettings) :  Block(settings) {
    val item: BlockItem = BlockItem(this, FabricItemSettings().maxCount(64).group(Rituacraft.creativeTab))
}