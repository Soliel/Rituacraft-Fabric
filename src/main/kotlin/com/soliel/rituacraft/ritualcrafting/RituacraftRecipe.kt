package com.soliel.rituacraft.ritualcrafting

import com.soliel.rituacraft.rituals.AbstractRitual
import net.minecraft.inventory.Inventory
import net.minecraft.item.ItemStack
import net.minecraft.recipe.Ingredient
import net.minecraft.recipe.RecipeSerializer
import net.minecraft.recipe.RecipeType
import net.minecraft.util.Identifier
import net.minecraft.util.collection.DefaultedList
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World

//This is a functional copy of Recipe<T> specifically for returning Rituals.
//Rituals have no ItemStack attached, so Recipe<T> isn't a good fit.
interface RituacraftRecipe<I : Inventory> {
    val id : Identifier
    val serializer : RecipeSerializer<*>
    val type: RecipeType<*>
    val output: AbstractRitual

    val ingredients: DefaultedList<Ingredient>
        get() = DefaultedList.of()

    fun matches(inventory: I, world: World) : Boolean
    fun craft(inventory: I, world: World, pos: BlockPos) : AbstractRitual

    fun getRemainder(inventory: I) : DefaultedList<ItemStack> {
        val defaultedList = DefaultedList.ofSize(inventory.size(), ItemStack.EMPTY)
        for (i in defaultedList.indices) {
            val item = inventory.getStack(i).item
            if (item.hasRecipeRemainder()) {
                defaultedList[i] = ItemStack(item.recipeRemainder)
            }
        }

        return defaultedList
    }

    fun isEmpty() : Boolean {
        val defaultedList = this.ingredients
        return defaultedList.isEmpty() || defaultedList.stream().anyMatch {
            it.matchingStacks.isEmpty()
        }
    }
}