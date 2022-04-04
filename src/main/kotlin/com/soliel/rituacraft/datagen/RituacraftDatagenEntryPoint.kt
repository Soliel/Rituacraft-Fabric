package com.soliel.rituacraft.datagen

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator

@Suppress("UNUSED")
class RituacraftDatagenEntryPoint : DataGeneratorEntrypoint {
    override fun onInitializeDataGenerator(fabricDataGenerator: FabricDataGenerator?) {
        fabricDataGenerator?.addProvider { BaseLangProvider(it) }
    }
}