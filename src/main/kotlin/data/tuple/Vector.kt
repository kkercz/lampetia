package data.tuple

data class Vector(val x: Double, val y: Double, val z: Double) {

    companion object {
        operator fun Double.times(vector: Vector): Vector {
            return vector * this
        }
    }

    fun asTuple(): Tuple {
        return Tuple.vector(x, y, z)
    }

    operator fun plus(v: Vector): Vector {
        return with(asTuple() + v.asTuple()) { Vector(this.x, this.y, this.z) }
    }

    operator fun plus(p: Point): Point {
        return with(asTuple() + p.asTuple()) { Point(this.x, this.y, this.z) }
    }

    operator fun minus(v: Vector): Vector {
        return with(asTuple() - v.asTuple()) { Vector(this.x, this.y, this.z) }
    }

    operator fun times(scalar: Double): Vector {
        return with(asTuple() * scalar) { Vector(this.x, this.y, this.z) }
    }

    operator fun div(scalar: Double): Vector {
        return with(asTuple() / scalar) { Vector(this.x, this.y, this.z) }
    }

    operator fun unaryMinus(): Vector {
        return with(-asTuple()) { Vector(this.x, this.y, this.z) }
    }

    override fun equals(other: Any?): Boolean {
        return other is Vector && asTuple() == other.asTuple()
    }

    override fun hashCode(): Int {
        return asTuple().hashCode()
    }
}
