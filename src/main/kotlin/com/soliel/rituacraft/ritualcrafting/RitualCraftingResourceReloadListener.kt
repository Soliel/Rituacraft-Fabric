package com.soliel.rituacraft.ritualcrafting

import net.fabricmc.fabric.api.resource.SimpleResourceReloadListener
import net.minecraft.resource.ResourceManager
import net.minecraft.util.Identifier
import net.minecraft.util.profiler.Profiler
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor

class RitualCraftingResourceReloadListener : SimpleResourceReloadListener<RitualRecipeManager> {
    override fun getFabricId(): Identifier {
        TODO("Not yet implemented")
    }

    override fun load(
        manager: ResourceManager?,
        profiler: Profiler?,
        executor: Executor?
    ): CompletableFuture<RitualRecipeManager> {
        TODO("Not yet implemented")
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