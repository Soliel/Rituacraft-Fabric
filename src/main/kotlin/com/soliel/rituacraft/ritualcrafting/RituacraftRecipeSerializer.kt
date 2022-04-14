package com.soliel.rituacraft.ritualcrafting

import com.google.gson.JsonObject
import net.minecraft.network.PacketByteBuf
import net.minecraft.util.Identifier

interface RituacraftRecipeSerializer<T: RituacraftRecipe<*>> {
    fun read(Id: Identifier, json: JsonObject) : T
    fun read(Id: Identifier, packet: PacketByteBuf) : T
    fun write(packet: PacketByteBuf, recipe: T)
}