package com.soliel.rituacraft.ritualcrafting

import com.soliel.rituacraft.rituals.AbstractRitual
import net.minecraft.inventory.CraftingInventory
import net.minecraft.recipe.RecipeSerializer
import net.minecraft.recipe.RecipeType
import net.minecraft.util.Identifier
import net.minecraft.world.World

class BaseRitualRecipe : RitualRecipe<CraftingInventory> {
    override val id: Identifier
        get() = TODO("Not yet implemented")
    override val serializer: RecipeSerializer<*>
        get() = TODO("Not yet implemented")
    override val type: RecipeType<*>
        get() = TODO("Not yet implemented")
    override val output: AbstractRitual
        get() = TODO("Not yet implemented")

    override fun matches(inventory: CraftingInventory, world: World): Boolean {
        TODO("Not yet implemented")
    }

    override fun craft(inventory: CraftingInventory): AbstractRitual {
        TODO("Not yet implemented")
    }
}