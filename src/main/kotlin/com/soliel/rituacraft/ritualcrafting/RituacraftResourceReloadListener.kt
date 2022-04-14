package com.soliel.rituacraft.ritualcrafting

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.JsonElement
import com.soliel.rituacraft.Rituacraft
import com.soliel.rituacraft.RituacraftIdentifier
import net.fabricmc.fabric.api.resource.SimpleResourceReloadListener
import net.minecraft.resource.ResourceManager
import net.minecraft.util.Identifier
import net.minecraft.util.JsonHelper
import net.minecraft.util.profiler.Profiler
import java.io.BufferedReader
import java.io.InputStreamReader
import java.nio.charset.StandardCharsets
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor

class RituacraftResourceReloadListener : SimpleResourceReloadListener<RitualRecipeManager> {
    override fun getFabricId(): Identifier {
        return RituacraftIdentifier("ritual_resources")
    }

    override fun load(
        manager: ResourceManager?,
        profiler: Profiler?,
        executor: Executor?
    ): CompletableFuture<RitualRecipeManager> {
        val future = CompletableFuture<RitualRecipeManager>()

        executor?.execute {
            if (manager == null) {
                return@execute
            }

            for(id in manager.findResources("rituacraft/ritual_recipes") { it.endsWith(".json") }) {
                try{
                    val stream = manager.getResource(id).inputStream
                    val gson = GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create()
                    try {
                        val reader = BufferedReader(InputStreamReader(stream, StandardCharsets.UTF_8))
                        val jsonElement = JsonHelper.deserialize(gson, reader, JsonElement::class.java)
                    } catch(e: Exception) {
                        Rituacraft.LOGGER.error("Error creating input stream for resource $id: $e")
                        stream.close()
                    }

                    future.complete()
                } catch(e: Exception) {
                    Rituacraft.LOGGER.error("Error occurred while loading resource json $id: $e")

                }
            }
        }

        return future
    }

    override fun apply(
        data: RitualRecipeManager?,
        manager: ResourceManager?,
        profiler: Profiler?,
        executor: Executor?
    ): CompletableFuture<Void> {
        TODO("Not yet implemented")
    }
}