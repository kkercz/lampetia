package data.tuple

data class Color(val red: Double, val green: Double, val blue: Double) : Tuple(red, green, blue, 0.0) {

    override fun equals(other: Any?): Boolean {
        return super.equals(other)
    }

    override fun hashCode(): Int {
        return super.hashCode()
    }
}
