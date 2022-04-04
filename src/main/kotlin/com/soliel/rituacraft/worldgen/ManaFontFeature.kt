package com.soliel.rituacraft.worldgen

import com.mojang.serialization.Codec
import com.soliel.rituacraft.components.Components
import net.minecraft.world.gen.feature.Feature
import net.minecraft.world.gen.feature.util.FeatureContext

class ManaFontFeature(codec: Codec<ManaFontFeatureConfig>) : Feature<ManaFontFeatureConfig>(codec) {
    override fun generate(context: FeatureContext<ManaFontFeatureConfig>?): Boolean {
        if(context == null) {
            return false
        }

        val config = context.config

        val currentChunk = context.world.getChunk(context.origin)
        val manaComponent = Components.MANA_PRODUCER.maybeGet(currentChunk)

        if (manaComponent.isPresent) {
            manaComponent.get().setProduction(config.providedMana.get(context.random))
            return true
        }


        return false
    }

}