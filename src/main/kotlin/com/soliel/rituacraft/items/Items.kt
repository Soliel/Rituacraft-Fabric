package com.soliel.rituacraft.items

import com.soliel.rituacraft.Rituacraft
import com.soliel.rituacraft.RituacraftIdentifier
import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.minecraft.item.Item
import net.minecraft.util.registry.Registry
import kotlin.reflect.full.memberProperties

object Items {
    val EXAMPLE_ITEM : RituacraftItem = RituacraftItem("example_item", "Example Item", FabricItemSettings().maxCount(64).group(Rituacraft.creativeTab))
    val DetectorCrystal: DetectorCrystal = DetectorCrystal()

    fun registerItems() {
        for(property in Items :: class.memberProperties) {
            when(val item = property.get(Items)) {
                is RituacraftItem -> {
                    Registry.register(Registry.ITEM, RituacraftIdentifier(item.IDENT), item as Item)
                }
            }
        }

        DetectorCrystal.registerModelPredicateProvider()
    }
}