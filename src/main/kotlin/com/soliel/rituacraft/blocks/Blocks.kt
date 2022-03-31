package com.soliel.rituacraft.blocks

import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.minecraft.block.Block
import net.minecraft.block.Material

object Blocks {
    val EXAMPLE_BLOCK: Block = Block(FabricBlockSettings.of(Material.METAL).strength(4.0f))
}