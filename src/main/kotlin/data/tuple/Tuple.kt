package data.tuple

import ext.equalsIgnoreRoundingErrors
import ext.hashCodeIgnoreRoundingErrors

open class Tuple protected constructor(open val x: Double, open val y: Double, open val z: Double, val w: Double) {

    companion object {
        fun tuple(x: Double, y: Double, z: Double, w: Double): Tuple {
            return when (w) {
                0.0 -> Vector(x, y, z)
                1.0 -> Point(x, y, z)
                else -> Tuple(x, y, z, w)
            }
        }
    }

    override fun equals(other: Any?): Boolean {
        return other is Tuple &&
                x.equalsIgnoreRoundingErrors(other.x) &&
                y.equalsIgnoreRoundingErrors(other.y) &&
                z.equalsIgnoreRoundingErrors(other.z) &&
                w.equalsIgnoreRoundingErrors(other.w)
    }

    override fun hashCode(): Int {
        var result = x.hashCodeIgnoreRoundingErrors()
        result = 31 * result + y.hashCodeIgnoreRoundingErrors()
        result = 31 * result + z.hashCodeIgnoreRoundingErrors()
        result = 31 * result + w.hashCodeIgnoreRoundingErrors()
        return result
    }
}