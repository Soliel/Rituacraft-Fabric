package com.soliel.rituacraft.ritualcrafting

import com.google.gson.JsonObject
import net.minecraft.network.PacketByteBuf
import net.minecraft.util.Identifier

class RitualRecipeSerializer : RituacraftRecipeSerializer<RitualRecipe> {
    override fun read(Id: Identifier, json: JsonObject): RitualRecipe {

    }

    override fun read(Id: Identifier, packet: PacketByteBuf): RitualRecipe {
        TODO("Not yet implemented")
    }

    override fun write(packet: PacketByteBuf, recipe: RitualRecipe) {
        TODO("Not yet implemented")
    }

}