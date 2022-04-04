package com.soliel.rituacraft.worldgen

import com.mojang.serialization.Codec
import com.mojang.serialization.codecs.RecordCodecBuilder
import net.minecraft.util.math.intprovider.IntProvider
import net.minecraft.world.gen.feature.FeatureConfig

data class ManaFontFeatureConfig(val providedMana: IntProvider) : FeatureConfig {
    companion object {
        val CODEC: Codec<ManaFontFeatureConfig> = RecordCodecBuilder.create {
            it.group(
                IntProvider
                    .VALUE_CODEC
                    .fieldOf("providedMana")
                    .forGetter(ManaFontFeatureConfig::providedMana)
            ).apply(it, ::ManaFontFeatureConfig)
        }
    }
}