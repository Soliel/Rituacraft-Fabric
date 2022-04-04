package com.soliel.rituacraft.blocks.blockentites

import com.soliel.rituacraft.RituacraftIdentifier
import com.soliel.rituacraft.blocks.Blocks
import net.fabricmc.fabric.api.`object`.builder.v1.block.entity.FabricBlockEntityTypeBuilder
import net.minecraft.block.entity.BlockEntityType
import net.minecraft.util.registry.Registry

object BlockEntities {
    lateinit var RITUAL_CRAFTING_ENTITY: BlockEntityType<RitualCraftingBlockEntity>

    fun initializeBlockEntities() {
        RITUAL_CRAFTING_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, RituacraftIdentifier("ritual_crafting_block_entity"),
            FabricBlockEntityTypeBuilder.create(::RitualCraftingBlockEntity, Blocks.RITUAL_CRAFT).build())
    }
}