package com.soliel.rituacraft.blocks

import com.soliel.rituacraft.blocks.blockentites.RitualCraftingBlockEntity
import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.minecraft.block.BlockEntityProvider
import net.minecraft.block.BlockState
import net.minecraft.block.Material
import net.minecraft.block.entity.BlockEntity
import net.minecraft.util.math.BlockPos


class RitualCraftingBlock(IDENT: String, DEFAULT_NAME: String) : RituacraftBlock(IDENT, DEFAULT_NAME, FabricBlockSettings.of(
    Material.GLASS).breakInstantly()), BlockEntityProvider {

    override fun createBlockEntity(pos: BlockPos?, state: BlockState?): BlockEntity {
        return RitualCraftingBlockEntity(pos, state)
    }
}