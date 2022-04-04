package com.soliel.rituacraft.components.impl

import com.soliel.rituacraft.components.ManaProducerComponent
import dev.onyxstudios.cca.api.v3.component.sync.AutoSyncedComponent
import net.minecraft.nbt.NbtCompound
import net.minecraft.world.chunk.Chunk

class BaseManaProducerComponent(baseValue: Int, val attachedChunk: Chunk) : ManaProducerComponent, AutoSyncedComponent {
    companion object {
        const val manaTag: String = "manaProduction"
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