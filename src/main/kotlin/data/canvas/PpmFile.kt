package data.canvas

import data.tuple.Color
import ext.scaleTo255
import java.io.File

class PpmFile(private val rows: List<Array<Color>>, private val w: Int, private val h: Int) {

    companion object {
        fun fromCanvas(c: Canvas) = PpmFile(
            (0 until c.height).map { h -> c.getRow(c.height - h - 1).copyOf() },
            c.width, c.height
        )
    }

    fun writeOut(filename: String = "output.ppm") {
        File(filename).printWriter().use { out ->
            out.println("P3")
            out.println("$w $h")
            out.println("255")
            rows
                .map { it.joinToString(" ") { c -> "${c.red.scaleTo255()} ${c.green.scaleTo255()} ${c.blue.scaleTo255()}" } }
                .forEach(out::println)
            out.println()
        }
    }

}