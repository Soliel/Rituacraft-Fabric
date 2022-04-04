package com.soliel.rituacraft.blocks

import com.soliel.rituacraft.RituacraftIdentifier
import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.minecraft.block.Material
import net.minecraft.util.registry.Registry
import kotlin.reflect.full.memberProperties

@Suppress("UNUSED")
object Blocks {
    val EXAMPLE_BLOCK: RituacraftBlock = RituacraftBlock("example_block", "Example Block", FabricBlockSettings.of(Material.METAL).strength(4.0f))
    val RITUAL_CRAFT: RitualCraftingBlock = RitualCraftingBlock("ritual_crafter", "Ritual In Progress")

    fun registerBlocks() {
        for(property  in Blocks :: class.memberProperties) {
            when(val block = property.get(Blocks)) {
                is RitualCraftingBlock -> {
                    Registry.register(Registry.BLOCK, RituacraftIdentifier(block.IDENT), block)
                }
                is RituacraftBlock -> {
                    Registry.register(Registry.BLOCK, RituacraftIdentifier(block.IDENT), block)
                    Registry.register(Registry.ITEM, RituacraftIdentifier(block.IDENT), block.item)
                }
            }
        }
    }
}