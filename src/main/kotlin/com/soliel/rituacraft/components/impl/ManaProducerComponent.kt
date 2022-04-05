package com.soliel.rituacraft.components.impl

import com.soliel.rituacraft.components.ManaProducerComponent
import dev.onyxstudios.cca.api.v3.component.sync.AutoSyncedComponent
import net.minecraft.nbt.NbtCompound
import net.minecraft.world.chunk.Chunk
import kotlin.random.Random

class BaseManaProducerComponent(baseValue: Int, val attachedChunk: Chunk) : ManaProducerComponent, AutoSyncedComponent {
    companion object {
        const val manaTag: String = "manaProduction"

        fun getManaFontRandom(chunkX: Int, chunkZ: Int, worldSeed: Long, scrambler: Long) : Random {
            //We're using the same seed algo as slime chunks, but with a different scrambler
            return Random(worldSeed + (chunkX * chunkX * 4987142).toLong() + (chunkX * 5947611).toLong() + (chunkZ * chunkZ).toLong() * 4392871L + (chunkZ * 389711).toLong() xor scrambler)
        }
    }

    var currentProduction: Int = baseValue

    override fun production(): Int {
        return currentProduction
    }

    override fun setProduction(newVal: Int) {
        currentProduction = newVal
        attachedChunk.setNeedsSaving(true)
    }

    override fun readFromNbt(tag: NbtCompound) {
        currentProduction = tag.getInt(manaTag)
    }

    override fun writeToNbt(tag: NbtCompound) {
        tag.putInt(manaTag, currentProduction)
    }
}