package com.example.facebookpam2.ui.theme


import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

import com.example.facebookpam2.R

// Set of Material typography styles to start with
val fbFont= FontFamily(
    listOf(
        Font(R.font.fbold)
    )
)
val Typography = Typography(
    h6=TextStyle(
        fontFamily = fbFont,

        fontWeight = FontWeight.SemiBold,
        fontSize = 22.sp,
        color = BrandBlue
    ),
    body1 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    )
)