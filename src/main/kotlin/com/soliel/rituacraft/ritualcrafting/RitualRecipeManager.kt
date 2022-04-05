package com.soliel.rituacraft.ritualcrafting

import com.google.gson.GsonBuilder
import com.google.gson.JsonElement
import net.minecraft.resource.JsonDataLoader
import net.minecraft.resource.ResourceManager
import net.minecraft.util.Identifier
import net.minecraft.util.profiler.Profiler

class RitualRecipeManager : JsonDataLoader(GSON, "ritual_recipes") {
    companion object {
        val GSON = GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create()
    }

    override fun apply(prepared: MutableMap<Identifier, JsonElement>?, manager: ResourceManager?, profiler: Profiler?) {
        TODO("Not yet implemented")
    }
}