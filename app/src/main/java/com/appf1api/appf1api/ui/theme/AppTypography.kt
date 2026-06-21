package com.appf1api.appf1api.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.appf1api.appf1api.R


val Titillium = FontFamily(

    Font(
        R.font.titillium_regular,
        FontWeight.Normal
    ),

    Font(
        R.font.titillium_semibold,
        FontWeight.SemiBold
    ),

    Font(
        R.font.titillium_bold,
        FontWeight.Bold
    )
)

val AppTypography = Typography(
    headlineLarge = TextStyle(
        fontFamily = Titillium,
        fontWeight = FontWeight.Bold,
        fontSize = 32.sp
    ),

    headlineMedium = TextStyle(
        fontFamily = Titillium,
        fontWeight = FontWeight.SemiBold,
        fontSize = 28.sp
    ),

    titleLarge = TextStyle(
        fontFamily = Titillium,
        fontWeight = FontWeight.SemiBold,
        fontSize = 22.sp
    ),

    bodyLarge = TextStyle(
        fontFamily = Titillium,
        fontSize = 16.sp
    )
)