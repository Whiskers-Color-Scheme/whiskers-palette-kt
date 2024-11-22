package com.lighttigerxiv.whiskers_palette_kt

import com.google.gson.Gson

/**
 * An object containing all colors of a Whiskers Palette
 */
data class Palette(
    val banana: Color,
    val blueberry: Color,
    val cherry: Color,
    val grape: Color,
    val kiwi: Color,
    val tangerine: Color,
    val neutral: Color,
    val neutralTwo: Color,
    val neutralThree: Color,
    val neutralFour: Color,
    val neutralFive: Color,
    val neutralSix: Color,
    val neutralSeven: Color,
    val neutralEight: Color,
    val text: Color,
    val textTwo: Color,
    val textThree: Color,
    val textFour: Color
){
    /**
     * Returns a list of colors of the palette
     */
    fun colors(): List<Color>{
        return listOf(
            banana,
            blueberry,
            cherry,
            grape,
            kiwi,
            tangerine,
            neutral,
            neutralTwo,
            neutralThree,
            neutralFour,
            neutralFive,
            neutralSix,
            neutralSeven,
            neutralEight,
            text,
            textTwo,
            textThree,
            textFour
        )
    }
}


/**
 * An object containing both Whiskers palettes
 */
data class WhiskersPalette(
    val panther: Palette,
    val tiger: Palette
)


/**
 * Get a Whiskers palette by sending the according JSON string
 */
private fun getPalette(json: String): Palette{

    val colors = Gson().fromJson(json, Array<Color>::class.java).toList()

    return Palette(
        banana = colors[0],
        blueberry = colors[1],
        cherry = colors[2],
        grape = colors[3],
        kiwi = colors[4],
        tangerine = colors[5],
        neutral = colors[6],
        neutralTwo = colors[7],
        neutralThree = colors[8],
        neutralFour = colors[9],
        neutralFive = colors[10],
        neutralSix = colors[11],
        neutralSeven = colors[12],
        neutralEight = colors[13],
        text = colors[14],
        textTwo = colors[15],
        textThree = colors[16],
        textFour = colors[17]
    )
}


/**
 * Returns an object containing the Panther and Tiger palettes
 */
fun getWhiskersPalette(): WhiskersPalette{
    return WhiskersPalette(
        panther = getPantherPalette(),
        tiger = getTigerPalette()
    )
}


/**
 * Returns an object containing the Panther palette
 */
fun getPantherPalette(): Palette {
   return getPalette(PANTHER_JSON)
}


/**
 * Returns an object containing the Tiger palette
 */
fun getTigerPalette(): Palette{
    return getPalette(TIGER_JSON)
}
