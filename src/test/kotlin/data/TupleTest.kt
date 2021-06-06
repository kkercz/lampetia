package data

import data.tuple.*
import data.tuple.Tuple.Companion.tuple
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.*
import org.junit.jupiter.api.Test

object TupleTest {

    @Test
    fun addingPointToVector() {
        val p1 = Point(0.5, 1.0, 1.5)
        val v1 = Vector(0.5, 1.0, 1.5)
        val sum = Point(1.0, 2.0, 3.0)
        assertThat(p1 + v1, equalTo(sum))
        assertThat(v1 + p1, equalTo(sum))
    }

    @Test
    fun subtractingTwoPoints() {
        val p1 = Point(1.5, 3.0, 4.5)
        val p2 = Point(0.5, 1.0, 1.5)
        val diff = Vector(1.0, 2.0, 3.0)
        assertThat(p1 - p2, equalTo(diff))
        assertThat(p2 - p1, equalTo(-diff))
    }

    @Test
    fun negation() {
        val v = Vector(1.5, 3.0, 4.5)
        val negation = Vector(-1.5, -3.0, -4.5)
        assertThat(-v, equalTo(negation))
    }

    @Test
    fun multiplyingVectors() {
        val v = Vector(1.5, 3.0, 4.5)
        val tripled = Vector(4.5, 9.0, 13.5)
        assertThat(v * 3.0, equalTo(tripled))
        assertThat(3.0 * v, equalTo(tripled))
    }

    @Test
    fun dividingVectors() {
        val v = Vector(4.5, 9.0, 13.5)
        val divided = Vector(1.5, 3.0, 4.5)
        assertThat(v / 3.0, equalTo(divided))
    }

    @Test
    fun equalityIgnoresRoundingErrors() {
        val t1 = tuple(0.5, 1.0, 1.5, 2.0)
        val t2 = tuple(0.5000000000004, 1.000000000003, 1.5000000000002, 2.000000000005)
        assertThat(t1, equalTo(t2))
        assertThat(t1.hashCode(), equalTo(t2.hashCode()))
        assertThat(Point(t1.x, t1.y, t1.z), equalTo(Point(t2.x, t2.y, t2.z)))
        assertThat(Vector(t1.x, t1.y, t1.z), equalTo(Vector(t2.x, t2.y, t2.z)))
    }

    @Test
    fun properTypeIsAssignedToTuples() {
        assertThat(tuple(0.5, 1.0, 1.5, 1.0), isA(Point::class.java))
        assertThat(tuple(0.5, 1.0, 1.5, 0.0), isA(Vector::class.java))
        assertThat(tuple(0.5, 1.0, 1.5, 3.0), not(allOf(isA(Point::class.java), isA(Vector::class.java))))
    }

}