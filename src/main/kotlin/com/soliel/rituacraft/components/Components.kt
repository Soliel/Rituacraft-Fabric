package com.soliel.rituacraft.components

import com.soliel.rituacraft.RituacraftIdentifier
import com.soliel.rituacraft.components.impl.BaseManaProducerComponent
import dev.onyxstudios.cca.api.v3.chunk.ChunkComponentFactoryRegistry
import dev.onyxstudios.cca.api.v3.chunk.ChunkComponentInitializer
import dev.onyxstudios.cca.api.v3.component.ComponentKey
import dev.onyxstudios.cca.api.v3.component.ComponentRegistryV3
import net.minecraft.world.StructureWorldAccess
import net.minecraft.world.chunk.Chunk
import net.minecraft.world.chunk.WorldChunk

object Components : ChunkComponentInitializer {
    val MANA_PRODUCER: ComponentKey<ManaProducerComponent> = ComponentRegistryV3.INSTANCE.getOrCreate(RituacraftIdentifier("manaproducer"), ManaProducerComponent::class.java)

    private fun zeroMana(chunk: Chunk) : BaseManaProducerComponent {
        return BaseManaProducerComponent(0, chunk)
    }

    private fun fontMana(chunk: Chunk) : BaseManaProducerComponent {
        return BaseManaProducerComponent(32, chunk)
    }

    private fun setupChunkMana(chunk: Chunk) : BaseManaProducerComponent {
        if(chunk !is WorldChunk) return zeroMana(chunk)
        val world = chunk.world

        if(world !is StructureWorldAccess) return zeroMana(chunk)
        val seed = world.seed

        return if(BaseManaProducerComponent.getManaFontRandom(chunk.pos.x, chunk.pos.z, seed, 1293489719823479L).nextInt(100) == 1) {
            fontMana(chunk)
        } else {
            zeroMana(chunk)
        }
    }

    override fun registerChunkComponentFactories(registry: ChunkComponentFactoryRegistry) {
        registry.register(MANA_PRODUCER, this::setupChunkMana)
    }
}