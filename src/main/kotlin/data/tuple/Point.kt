package data.tuple

data class Point(val x: Double, val y: Double, val z: Double) {
    fun asTuple(): Tuple {
        return Tuple.point(x, y, z)
    }

    operator fun plus(v: Vector): Point {
        return with(asTuple() + v.asTuple()) { Point(this.x, this.y, this.z) }
    }

    operator fun minus(other: Point): Vector {
        return with(asTuple() - other.asTuple()) { Vector(this.x, this.y, this.z) }
    }

    override fun equals(other: Any?): Boolean {
        return other is Point && asTuple() == other.asTuple()
    }

    override fun hashCode(): Int {
        return asTuple().hashCode()
    }
}
