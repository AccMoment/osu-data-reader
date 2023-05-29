package osu.enums

enum class Mode {
    Standard,
    Taiko,
    CatchTheBeat,
    Mania,
}

fun parseMode(byte: UByte): Mode = Mode.values().find { it.ordinal==byte.toInt() }!!
