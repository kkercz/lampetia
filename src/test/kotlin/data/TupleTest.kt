package data

import data.Tuple.Companion.point
import data.Tuple.Companion.times
import data.Tuple.Companion.vector
import org.hamcrest.MatcherAssert
import org.hamcrest.Matchers.equalTo
import org.junit.jupiter.api.Test

object TupleTest {
    @Test
    fun addingPointToVector() {
        val p1 = point(0.5, 1.0, 1.5)
        val v1 = vector(0.5, 1.0, 1.5)
        val sum = point(1.0, 2.0, 3.0)
        MatcherAssert.assertThat(p1 + v1, equalTo(sum))
    }

    @Test
    fun subtractingTwoPoints() {
        val p1 = point(1.5, 3.0, 4.5)
        val p2 = point(0.5, 1.0, 1.5)
        val diff = vector(1.0, 2.0, 3.0)
        MatcherAssert.assertThat(p1 - p2, equalTo(diff))
    }

    @Test
    fun negation() {
        val v = vector(1.5, 3.0, 4.5)
        val negation = vector(-1.5, -3.0, -4.5)
        MatcherAssert.assertThat(-v, equalTo(negation))
    }

    @Test
    fun multiplyingVectors() {
        val v = vector(1.5, 3.0, 4.5)
        val tripled = vector(4.5, 9.0, 13.5)
        MatcherAssert.assertThat(v * 3.0, equalTo(tripled))
        MatcherAssert.assertThat(3.0 * v, equalTo(tripled))
    }

    @Test
    fun dividingVectors() {
        val v = vector(4.5, 9.0, 13.5)
        val divided = vector(1.5, 3.0, 4.5)
        MatcherAssert.assertThat(v / 3.0, equalTo(divided))
    }

    @Test
    fun typeIntrospection() {
        val p = point(0.5, 1.0, 1.5)
        val v = vector(0.5, 1.0, 1.5)
        val t = Tuple(0.5, 1.0, 1.5, 3.0)
        MatcherAssert.assertThat(p.getType(), equalTo(Type.Point))
        MatcherAssert.assertThat(v.getType(), equalTo(Type.Vector))
        MatcherAssert.assertThat(t.getType(), equalTo(Type.Undefined))
    }

    @Test
    fun floatyEquality() {
        val t1 = Tuple(0.5, 1.0, 1.5, 2.0)
        val t2 = Tuple(0.5000000000004, 1.000000000003, 1.5000000000002, 2.000000000005)
        MatcherAssert.assertThat(t1, equalTo(t2))
    }

}