package com.appf1api.appf1api.authapp.presentation.race

import com.appf1api.appf1api.R


fun getCircuitImage(circuit: String): Int {
    return when(circuit){
        "Red Bull Ring" ->
            R.drawable.redbullring
        else ->
            R.drawable.lol

    }
}