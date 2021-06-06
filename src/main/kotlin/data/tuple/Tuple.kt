package data.tuple

import util.Math.equalsIgnoreRoundingErrors
import util.Math.hashCodeIgnoreRoundingErrors

data class Tuple(val x: Double, val y: Double, val z: Double, val w: Double) {

    companion object {
        fun point(x: Double, y: Double, z: Double): Tuple {
            return Tuple(x, y, z, 1.0)
        }

        fun vector(x: Double, y: Double, z: Double): Tuple {
            return Tuple(x, y, z, 0.0)
        }

        operator fun Double.times(vector: Tuple): Tuple {
            return vector * this
        }
    }

    operator fun plus(other: Tuple): Tuple {
        return Tuple(x + other.x, y + other.y, z + other.z, w + other.w)
    }

    operator fun minus(other: Tuple): Tuple {
        return Tuple(x - other.x, y - other.y, z - other.z, w - other.w)
    }

    operator fun times(scalar: Double): Tuple {
        return Tuple(x * scalar, y * scalar, z * scalar, w * scalar)
    }

    operator fun div(scalar: Double): Tuple {
        return Tuple(x / scalar, y / scalar, z / scalar, w / scalar)
    }

    operator fun unaryMinus(): Tuple {
        return Tuple(-x, -y, -z, -w)
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