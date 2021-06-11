package data

import data.tuple.Color

class Canvas(val width: Int, val height: Int) {

    private val pixels: Array<Array<Color>> = Array(width) { Array(height) { Color(0.0, 0.0, 0.0) } }

    operator fun get(w: Int, h: Int): Color = pixels[w][h]
    operator fun set(w: Int, h: Int, pixel: Color): Canvas = with(this) { pixels[w][h] = pixel; return this }

}