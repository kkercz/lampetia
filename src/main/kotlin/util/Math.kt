package util

import kotlin.math.abs
import kotlin.math.floor

object Math {

    private const val EPSILON = 1e-10

    /**
     * Compares for equality up to a certain very small precision, allowing to ignore rounding errors.
     */
    fun Double.equalsIgnoreRoundingErrors(other: Double): Boolean = abs(this - other) < EPSILON

    /**
     * Returns a hashcode, ensuring two numbers that would be equal if not for rounding errors will have the same hashcode.
     */
    fun Double.hashCodeIgnoreRoundingErrors(): Int = floor(this * 100000).hashCode()
}