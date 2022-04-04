package com.soliel.rituacraft.worldgen

import com.soliel.rituacraft.RituacraftIdentifier
import net.fabricmc.fabric.api.biome.v1.BiomeModifications
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors
import net.minecraft.util.math.intprovider.ConstantIntProvider
import net.minecraft.util.registry.BuiltinRegistries
import net.minecraft.util.registry.Registry
import net.minecraft.util.registry.RegistryEntry
import net.minecraft.util.registry.RegistryKey
import net.minecraft.world.gen.GenerationStep
import net.minecraft.world.gen.feature.ConfiguredFeature
import net.minecraft.world.gen.feature.Feature
import net.minecraft.world.gen.feature.PlacedFeature
import net.minecraft.world.gen.placementmodifier.RarityFilterPlacementModifier

object Features {
    val MANA_FONT: Feature<ManaFontFeatureConfig> = ManaFontFeature(ManaFontFeatureConfig.CODEC)
    val CONFIGURED_MANA_FONT: ConfiguredFeature<*, *> = ConfiguredFeature(MANA_FONT, ManaFontFeatureConfig(ConstantIntProvider.create(32)))
    val PLACED_MANA_FONT: PlacedFeature = PlacedFeature(RegistryEntry.of(CONFIGURED_MANA_FONT),
        listOf(
           RarityFilterPlacementModifier.of(20)
        )
    )

    fun initializeFeatures() {
        Registry.register(Registry.FEATURE, RituacraftIdentifier("mana_font"), MANA_FONT)
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, RituacraftIdentifier("mana_font"), CONFIGURED_MANA_FONT)
        Registry.register(BuiltinRegistries.PLACED_FEATURE, RituacraftIdentifier("mana_font"), PLACED_MANA_FONT)

        BiomeModifications.addFeature(
            BiomeSelectors.all(),
            GenerationStep.Feature.RAW_GENERATION,
            RegistryKey.of(Registry.PLACED_FEATURE_KEY, RituacraftIdentifier("mana_font")))
    }
}