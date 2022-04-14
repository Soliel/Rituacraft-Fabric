package com.soliel.rituacraft.ritualcrafting

import com.google.gson.GsonBuilder

class RitualRecipeManager {
    companion object {
        val GSON = GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create()
    }

    fun readAndRegisterRecipe()
}