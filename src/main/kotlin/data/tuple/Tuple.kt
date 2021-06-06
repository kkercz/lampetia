package data.tuple

import util.Math.equalsIgnoreRoundingErrors
import util.Math.hashCodeIgnoreRoundingErrors

open class Tuple protected constructor(open val x: Double, open val y: Double, open val z: Double, val w: Double) {

    companion object {
        fun point(x: Double, y: Double, z: Double): Point {
            return Point(x, y, z)
        }

        fun vector(x: Double, y: Double, z: Double): Vector {
            return Vector(x, y, z)
        }

        fun tuple(x: Double, y: Double, z: Double, w: Double): Tuple {
            return when (w) {
                0.0 -> Vector(x, y, z)
                1.0 -> Point(x, y, z)
                else -> Tuple(x, y, z, w)
            }
        }

        operator fun Double.times(vector: Tuple): Tuple {
            return vector * this
        }
    }

    operator fun plus(other: Tuple): Tuple {
        return tuple(x + other.x, y + other.y, z + other.z, w + other.w)
    }

    operator fun minus(other: Tuple): Tuple {
        return tuple(x - other.x, y - other.y, z - other.z, w - other.w)
    }

    open operator fun times(scalar: Double): Tuple {
        return tuple(x * scalar, y * scalar, z * scalar, w * scalar)
    }

    open operator fun div(scalar: Double): Tuple {
        return tuple(x / scalar, y / scalar, z / scalar, w / scalar)
    }

    open operator fun unaryMinus(): Tuple {
        return tuple(-x, -y, -z, -w)
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

    override fun toString(): String {
        return "($x, $y, $z, $w)"
    }
}