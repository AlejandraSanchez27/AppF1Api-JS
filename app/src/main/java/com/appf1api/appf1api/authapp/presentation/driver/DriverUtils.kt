package com.appf1api.appf1api.authapp.presentation.driver

import com.appf1api.appf1api.R

fun getDriverImage(driverId: String): Int {

    return when(driverId){
        "hamilton" -> R.drawable.hamilton
        "verstappen" -> R.drawable.verstappen
        "piastri" -> R.drawable.piastri
        "antonelli" -> R.drawable.antonelli
        "gasly" -> R.drawable.gasly
        "hadjar" -> R.drawable.hadjar
        "russell" -> R.drawable.russell
        "lawson" -> R.drawable.lawson
        "norris" -> R.drawable.norris
        "leclerc" -> R.drawable.leclerc
        else -> R.drawable.lol

    }

}