package util

import kotlin.math.abs

object Math {

    private const val EPSILON = 1e-10

    /**
     * Compares for equality up to a certain very small precision, allowing to ignore rounding errors.
     */
    fun Double.equalsSafely(other: Double): Boolean {
        return abs(this - other) < EPSILON
    }
}