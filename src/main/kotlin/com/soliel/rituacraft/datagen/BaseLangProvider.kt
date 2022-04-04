package com.soliel.rituacraft.datagen

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.JsonObject
import com.soliel.rituacraft.blocks.Blocks
import com.soliel.rituacraft.blocks.RituacraftBlock
import com.soliel.rituacraft.blocks.RitualCraftingBlock
import com.soliel.rituacraft.items.Items
import com.soliel.rituacraft.items.RituacraftItem
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator
import net.minecraft.data.DataCache
import net.minecraft.data.DataProvider
import java.nio.file.Path
import kotlin.reflect.full.memberProperties

class BaseLangProvider(val generator: FabricDataGenerator) : DataProvider {
    private val gson: Gson = GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create()

    override fun run(cache: DataCache?) {
        val outputPath: Path = generator.output
        val langFile = JsonObject()

        //Blocks
        for(prop in Blocks::class.memberProperties) {
            when(val block = prop.get(Blocks)) {
                is RitualCraftingBlock -> {
                    langFile.addProperty("block.%s.%s".format(generator.modId, block.IDENT), block.DEFAULT_NAME)
                }
                is RituacraftBlock -> {
                    langFile.addProperty("block.%s.%s".format(generator.modId, block.IDENT), block.DEFAULT_NAME)
                    langFile.addProperty("item.%s.%s".format(generator.modId, block.IDENT), block.DEFAULT_NAME)
                }
            }
        }

        //Items
        for(prop in Items::class.memberProperties) {
            when(val item = prop.get(Items)) {
                is RituacraftItem -> {
                    langFile.addProperty("item.%s.%s".format(generator.modId, item.IDENT), item.DEFAULT_NAME)
                }
            }
        }

        DataProvider.writeToPath(gson, cache, langFile, outputPath.resolve("assets/%s/lang/en_us.json".format(generator.modId)))
    }

    override fun getName(): String {
        return "Base Language Provider"
    }

}