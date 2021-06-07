package data.tuple

import data.tuple.Tuple.Companion.tuple
import kotlin.math.pow
import kotlin.math.sqrt

// Operations on Tuples
operator fun Tuple.plus(t: Tuple): Tuple = tuple(x + t.x, y + t.y, z + t.z, w + t.w)
operator fun Tuple.minus(t: Tuple): Tuple = tuple(x - t.x, y - t.y, z - t.z, w - t.w)
operator fun Tuple.times(scalar: Double): Tuple = tuple(x * scalar, y * scalar, z * scalar, w * scalar)
operator fun Double.times(t: Tuple): Tuple = t * this
operator fun Tuple.div(scalar: Double): Tuple = tuple(x / scalar, y / scalar, z / scalar, w / scalar)
operator fun Tuple.unaryMinus(): Tuple = tuple(-x, -y, -z, -w)

fun Tuple.magnitude(): Double = sqrt(x.pow(2) + y.pow(2) + z.pow(2) + w.pow(2))
fun Tuple.normalized(): Tuple = magnitude().let { tuple(x / it, y / it, z / it, w / it) }
infix fun Tuple.o(t: Tuple): Double = x * t.x + y * t.y + z * t.z + w * t.w

// Operations on Points
operator fun Point.plus(v: Vector): Point = (this as Tuple + v as Tuple) as Point
operator fun Point.minus(v: Point): Vector = (this as Tuple - v as Tuple) as Vector

// Operations on Vectors
operator fun Vector.plus(v: Vector): Vector = (this as Tuple + v as Tuple) as Vector
operator fun Vector.plus(p: Point): Point = (this as Tuple + p as Tuple) as Point
operator fun Vector.minus(v: Vector): Vector = (this as Tuple - v as Tuple) as Vector
operator fun Vector.times(scalar: Double): Vector = (this as Tuple * scalar) as Vector
operator fun Double.times(t: Vector): Vector = (t as Tuple * this) as Vector
operator fun Vector.div(scalar: Double): Vector = (this as Tuple / scalar) as Vector
operator fun Vector.unaryMinus(): Vector = -(this as Tuple) as Vector

fun Vector.normalized(): Vector = (this as Tuple).normalized() as Vector
infix fun Vector.o(v: Vector): Double = this as Tuple o v
infix fun Vector.x(b: Vector): Vector = Vector(y * b.z - z * b.y, z * b.x - x * b.z, x * b.y - y * b.x)