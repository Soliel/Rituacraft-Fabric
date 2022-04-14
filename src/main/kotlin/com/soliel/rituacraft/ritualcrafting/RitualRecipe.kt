package com.soliel.rituacraft.ritualcrafting

import com.google.gson.JsonElement
import com.google.gson.JsonObject
import com.google.gson.JsonParseException
import com.soliel.rituacraft.RituacraftIdentifier
import com.soliel.rituacraft.rituals.AbstractRitual
import net.minecraft.inventory.CraftingInventory
import net.minecraft.recipe.Ingredient
import net.minecraft.recipe.RecipeSerializer
import net.minecraft.recipe.RecipeType
import net.minecraft.util.Identifier
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World

class RitualRecipe : RituacraftRecipe<CraftingInventory> {
    companion object {
        private fun readIngredients(obj: JsonElement): List<IngredientCount> {
            if(!obj.isJsonArray) {
                throw JsonParseException("Ritual ingredients must be an array")
            }

            return obj.asJsonArray.asIterable().map {
                if(!it.isJsonObject) {
                    throw JsonParseException("ingredients entry must be an object")
                }
                val jObj = it.asJsonObject
                if(!jObj.has("ingredient") || !jObj.has("amount")) {
                    throw JsonParseException("ingredients entry must contain the keys \"ingredient\" and \"amount\"")
                }

                return@map IngredientCount(Ingredient.fromJson(jObj["ingredient"]), jObj["amount"].asInt)
            }
        }

        fun fromJSON(element: JsonElement) : RitualRecipe {
            if(!element.isJsonObject)
                throw JsonParseException("Ritual Recipe must be an object!")
            val jObj = element.asJsonObject
            if(!jObj.has("ingredients") || !jObj.has("result"))
                throw JsonParseException("")
            val ingredients = readIngredients(element.asJsonObject["ingredients"])
            val resultId = Identifier(jObj["result"].asString)

        }
    }

    override val id: Identifier
        get() = RituacraftIdentifier("ritual_recipies")
    override val serializer: RecipeSerializer<*>
        get() = TODO("Not yet implemented")
    override val type: RecipeType<*>
        get() = TODO("Not yet implemented")
    override val output: AbstractRitual
        get() = TODO("Not yet implemented")

    override fun matches(inventory: CraftingInventory, world: World): Boolean {
        TODO("Not yet implemented")
    }

    override fun craft(inventory: CraftingInventory, world: World, pos: BlockPos): AbstractRitual {
        TODO("Not yet implemented")
    }


}