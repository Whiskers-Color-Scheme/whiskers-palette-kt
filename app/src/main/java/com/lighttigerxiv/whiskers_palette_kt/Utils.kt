package com.lighttigerxiv.whiskers_palette_kt

import androidx.compose.ui.graphics.Color
import com.lighttigerxiv.whiskers_palette_kt.Color as WhColor

fun getComposedColor(color: WhColor): Color{
    return Color(color.asLong())
}