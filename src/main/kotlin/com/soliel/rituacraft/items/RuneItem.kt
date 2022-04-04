package com.soliel.rituacraft.items

import com.soliel.rituacraft.Rituacraft
import com.soliel.rituacraft.blocks.Blocks
import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.minecraft.block.SideShapeType
import net.minecraft.item.ItemUsageContext
import net.minecraft.util.ActionResult

class RuneItem(IDENT: String, DEFAULT_NAME: String) : RituacraftItem(IDENT, DEFAULT_NAME, FabricItemSettings().maxCount(64).group(Rituacraft.creativeTab)) {

    @Override
    override fun useOnBlock(context: ItemUsageContext?): ActionResult {
        if(context == null) {
            return ActionResult.FAIL
        }

        val world = context.world

        //If ritualCrafting -> Add Rune to ritual & Decrement stack
        //Else start ritualCrafting -> add rune & decrement stack

        val targetBlockState = world.getBlockState(context.blockPos)
        val ritualBlockPos = context.blockPos.offset(context.side)
        val preRitualBlockState = world.getBlockState(ritualBlockPos)

        if(!preRitualBlockState.isAir) {
            return ActionResult.FAIL
        }

        if(!targetBlockState.isSideSolid(world, context.blockPos, context.side, SideShapeType.FULL)) {
            return ActionResult.FAIL
        }

        world.setBlockState(ritualBlockPos, Blocks.RITUAL_CRAFT.defaultState)


        return ActionResult.CONSUME
    }

}