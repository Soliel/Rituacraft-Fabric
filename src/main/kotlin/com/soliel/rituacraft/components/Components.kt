package com.soliel.rituacraft.components

import com.soliel.rituacraft.RituacraftIdentifier
import com.soliel.rituacraft.components.impl.BaseManaProducerComponent
import dev.onyxstudios.cca.api.v3.chunk.ChunkComponentFactoryRegistry
import dev.onyxstudios.cca.api.v3.chunk.ChunkComponentInitializer
import dev.onyxstudios.cca.api.v3.component.ComponentKey
import dev.onyxstudios.cca.api.v3.component.ComponentRegistryV3

object Components : ChunkComponentInitializer {
    val MANA_PRODUCER: ComponentKey<ManaProducerComponent> = ComponentRegistryV3.INSTANCE.getOrCreate(RituacraftIdentifier("manaproducer"), ManaProducerComponent::class.java)

    override fun registerChunkComponentFactories(registry: ChunkComponentFactoryRegistry) {
        registry.register(MANA_PRODUCER) { BaseManaProducerComponent(0, it) }
    }
}