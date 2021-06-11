package data

import data.canvas.Canvas
import data.tuple.Color
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo
import org.junit.jupiter.api.Test

object CanvasTest {

    private val BLACK = Color(0.0, 0.0, 0.0)
    private val RED = Color(1.0, 0.0, 0.0)

    @Test
    fun creatingCanvas() {
        val c = Canvas(10, 20)
        for (w in 0..9) {
            for (h in 0..19) {
                assertThat(c[w, h], equalTo(BLACK))
            }
        }
    }

    @Test
    fun writingPixelsToCanvas() {
        val c = Canvas(10, 20)
        c[2, 3] = RED
        assertThat(c[2, 3], equalTo(RED))
    }
}