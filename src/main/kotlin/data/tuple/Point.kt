package data.tuple

data class Point(override val x: Double, override val y: Double, override val z: Double) : Tuple(x, y, z, 1.0) {

    override fun equals(other: Any?): Boolean {
        return super.equals(other)
    }

    override fun hashCode(): Int {
        return super.hashCode()
    }
}
