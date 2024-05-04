package com.lighttigerxiv.whiskers_palette_kt

/**
 * A object used for each Whiskers Color that contains the name, hex, rgb and hsl of a color
 */
data class Color(
    val name: String,
    val hex: String,
    val rgb: Rgb,
    val hsl: Hsl
){
    /**
     * Get color as a Long to use with jetpack compose
     */
    fun asLong(): Long{
        return java.lang.Long.decode(hex.replace("#", "#ff"))
    }
}

/**
 * An object containing the rgb colors
 */
data class Rgb(
    val r: String,
    val g: String,
    val b: String,
    val rgb: String
)

/**
 * An object containing the hsl colors
 */
data class Hsl(
    val h: String,
    val s: String,
    val l: String,
    val hsl: String
)

/**
 * A Whiskers palette color
 */
enum class WhiskersColor {
    PantherBanana,
    PantherBlueberry,
    PantherCherry,
    PantherGrape,
    PantherKiwi,
    PantherTangerine,
    PantherNeutral,
    PantherNeutralTwo,
    PantherNeutralThree,
    PantherNeutralFor,
    PantherNeutralFive,
    PantherNeutralSix,
    PantherNeutralSeven,
    PantherNeutralEight,
    PantherText,
    PantherTextTwo,
    PantherTextThree,
    PantherTextFor,
    TigerBanana,
    TigerBlueberry,
    TigerCherry,
    TigerGrape,
    TigerKiwi,
    TigerTangerine,
    TigerNeutral,
    TigerNeutralTwo,
    TigerNeutralThree,
    TigerNeutralFor,
    TigerNeutralFive,
    TigerNeutralSix,
    TigerNeutralSeven,
    TigerNeutralEight,
    TigerText,
    TigerTextTwo,
    TigerTextThree,
    TigerTextFor
}

fun getColor(color: WhiskersColor): Color{
    return when(color){
        WhiskersColor.PantherBanana -> getPantherPalette().banana
        WhiskersColor.PantherBlueberry -> getPantherPalette().blueberry
        WhiskersColor.PantherCherry -> getPantherPalette().cherry
        WhiskersColor.PantherGrape -> getPantherPalette().grape
        WhiskersColor.PantherKiwi -> getPantherPalette().kiwi
        WhiskersColor.PantherTangerine -> getPantherPalette().tangerine
        WhiskersColor.PantherNeutral -> getPantherPalette().neutral
        WhiskersColor.PantherNeutralTwo -> getPantherPalette().neutralTwo
        WhiskersColor.PantherNeutralThree -> getPantherPalette().neutralThree
        WhiskersColor.PantherNeutralFor -> getPantherPalette().neutralFor
        WhiskersColor.PantherNeutralFive -> getPantherPalette().neutralFive
        WhiskersColor.PantherNeutralSix -> getPantherPalette().neutralSix
        WhiskersColor.PantherNeutralSeven -> getPantherPalette().neutralSeven
        WhiskersColor.PantherNeutralEight -> getPantherPalette().neutralEight
        WhiskersColor.PantherText -> getPantherPalette().text
        WhiskersColor.PantherTextTwo -> getPantherPalette().textTwo
        WhiskersColor.PantherTextThree -> getPantherPalette().textThree
        WhiskersColor.PantherTextFor -> getPantherPalette().textFor
        WhiskersColor.TigerBanana -> getTigerPalette().banana
        WhiskersColor.TigerBlueberry -> getTigerPalette().blueberry
        WhiskersColor.TigerCherry -> getTigerPalette().cherry
        WhiskersColor.TigerGrape -> getTigerPalette().grape
        WhiskersColor.TigerKiwi -> getTigerPalette().kiwi
        WhiskersColor.TigerTangerine -> getTigerPalette().tangerine
        WhiskersColor.TigerNeutral -> getTigerPalette().neutral
        WhiskersColor.TigerNeutralTwo -> getTigerPalette().neutralTwo
        WhiskersColor.TigerNeutralThree -> getTigerPalette().neutralThree
        WhiskersColor.TigerNeutralFor -> getTigerPalette().neutralFor
        WhiskersColor.TigerNeutralFive -> getTigerPalette().neutralFive
        WhiskersColor.TigerNeutralSix -> getTigerPalette().neutralSix
        WhiskersColor.TigerNeutralSeven -> getTigerPalette().neutralSeven
        WhiskersColor.TigerNeutralEight -> getTigerPalette().neutralEight
        WhiskersColor.TigerText -> getTigerPalette().text
        WhiskersColor.TigerTextTwo -> getTigerPalette().textTwo
        WhiskersColor.TigerTextThree -> getTigerPalette().textThree
        WhiskersColor.TigerTextFor -> getTigerPalette().textFor
    }
}