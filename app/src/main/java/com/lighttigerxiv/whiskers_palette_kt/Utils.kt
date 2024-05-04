package com.lighttigerxiv.whiskers_palette_kt

import androidx.compose.ui.graphics.Color


fun getComposeColor(color: com.lighttigerxiv.whiskers_palette_kt.Color): Color{
    return Color(color.asLong())
}