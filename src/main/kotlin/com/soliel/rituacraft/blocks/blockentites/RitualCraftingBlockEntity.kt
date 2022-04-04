package com.soliel.rituacraft.blocks.blockentites

import net.minecraft.block.BlockState
import net.minecraft.block.entity.BlockEntity
import net.minecraft.nbt.NbtCompound
import net.minecraft.util.math.BlockPos

class RitualCraftingBlockEntity(pos: BlockPos?, state: BlockState?) :
    BlockEntity(BlockEntities.RITUAL_CRAFTING_ENTITY, pos, state) {

    override fun writeNbt(nbt: NbtCompound?) {

        super.writeNbt(nbt)
    }
}