package data.tuple

data class Vector(override val x: Double, override val y: Double, override val z: Double) : Tuple(x, y, z, 0.0) {

    companion object {
        operator fun Double.times(vector: Vector): Vector {
            return vector.times(this)
        }
    }

    operator fun plus(v: Vector): Vector {
        return super.plus(v) as Vector
    }

    operator fun plus(p: Point): Point {
        return super.plus(p) as Point
    }

    operator fun minus(v: Vector): Vector {
        return super.minus(v) as Vector
    }

    override operator fun times(scalar: Double): Vector {
        return super.times(scalar) as Vector
    }

    override operator fun div(scalar: Double): Vector {
        return super.div(scalar) as Vector
    }

    override operator fun unaryMinus(): Vector {
        return super.unaryMinus() as Vector
    }

    override fun toString(): String {
        return super.toString()
    }

    override fun equals(other: Any?): Boolean {
        return super.equals(other)
    }

    override fun hashCode(): Int {
        return super.hashCode()
    }
}
