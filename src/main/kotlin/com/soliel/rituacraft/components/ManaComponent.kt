package com.soliel.rituacraft.components

import dev.onyxstudios.cca.api.v3.component.ComponentV3

interface ManaProducerComponent : ComponentV3 {
    fun production() : Int
    fun setProduction(newVal: Int)
}