package data

import util.Math.equalsSafely

@Suppress("EqualsOrHashCode")
data class Tuple(val x: Double, val y: Double, val z: Double, val w: Double) {

    companion object {

        fun point(x: Double, y: Double, z: Double): Tuple {
            return Tuple(x, y, z, 1.0)
        }

        fun vector(x: Double, y: Double, z: Double): Tuple {
            return Tuple(x, y, z, 0.0)
        }

        operator fun Double.times(vector: Tuple): Tuple {
            return Tuple(this * vector.x, this * vector.y, this * vector.z, this * vector.w)
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

    fun getType(): Type {
        return if (w == 1.0) Type.Point else (if (w == 0.0) Type.Vector else Type.Undefined)
    }

    override fun equals(other: Any?): Boolean {
        return other is Tuple &&
                x.equalsSafely(other.x) && y.equalsSafely(other.y) && z.equalsSafely(other.z) && w.equalsSafely(other.w)
    }
}

enum class Type {
    Point, Vector, Undefined
}