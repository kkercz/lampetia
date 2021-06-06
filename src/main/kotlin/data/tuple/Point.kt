package data.tuple

data class Point(override val x: Double, override val y: Double, override val z: Double) : Tuple(x, y, z, 1.0) {

    operator fun plus(v: Vector): Point {
        return super.plus(v) as Point
    }

    operator fun minus(p: Point): Vector {
        return super.minus(p) as Vector
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
