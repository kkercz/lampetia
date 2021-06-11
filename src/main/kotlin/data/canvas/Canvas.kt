package data.canvas

import data.tuple.Color

class Canvas(val width: Int, val height: Int) {

    private val pixels: Array<Array<Color>> = Array(height) { Array(width) { Color(0.0, 0.0, 0.0) } }

    operator fun get(w: Int, h: Int): Color = pixels[h][w]
    operator fun set(w: Int, h: Int, pixel: Color): Canvas = with(this) { pixels[h][w] = pixel; return this }

    fun getRow(h: Int): Array<Color> = pixels[h]
}