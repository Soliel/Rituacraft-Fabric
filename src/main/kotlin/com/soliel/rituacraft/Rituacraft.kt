package com.soliel.rituacraft
import com.soliel.rituacraft.items.Items
import net.devtech.arrp.api.RuntimeResourcePack
import net.fabricmc.api.ModInitializer
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder
import net.minecraft.item.ItemGroup
import net.minecraft.item.ItemStack

@Suppress("UNUSED")
object Rituacraft: ModInitializer {
    const val MOD_ID = "rituacraft"
    val creativeTab: ItemGroup = creativeItemGroup()
    val resourcePack: RuntimeResourcePack = RuntimeResourcePack.create(RituacraftIdentifier("resources"))

    private fun creativeItemGroup() : ItemGroup {
        return FabricItemGroupBuilder.build(
            RituacraftIdentifier("general")
        ) { ItemStack(Items.DetectorCrystal) }
    }

    override fun onInitialize() {
        //Blocks.registerBlocks()
        Items.registerItems()

        //BlockEntities.initializeBlockEntities()
        println("Rituacraft initialization complete.")
    }
}