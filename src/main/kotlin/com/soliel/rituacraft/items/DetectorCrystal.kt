package com.soliel.rituacraft.items

import com.soliel.rituacraft.Rituacraft
import com.soliel.rituacraft.components.Components
import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.minecraft.client.item.ModelPredicateProviderRegistry
import net.minecraft.client.world.ClientWorld
import net.minecraft.entity.LivingEntity
import net.minecraft.item.ItemStack
import net.minecraft.util.Identifier

class DetectorCrystal : RituacraftItem("detector_crystal", "Detector Crystal", FabricItemSettings().maxCount(64).group(Rituacraft.creativeTab)) {
    companion object {
        fun isInManaFont(itemStack: ItemStack, clientWorld: ClientWorld?, livingEntity: LivingEntity?, seed: Int) : Float {
            if(livingEntity == null || clientWorld == null) return 0.0F

            val chunk = clientWorld.getChunk(livingEntity.blockPos) ?: return 0.0F
            return if(Components.MANA_PRODUCER.get(chunk).production()  > 0) 1.0F else 0.0F
        }
    }

    fun registerModelPredicateProvider() {
        ModelPredicateProviderRegistry.register(Items.DetectorCrystal, Identifier("powered"), DetectorCrystal::isInManaFont)
    }
}