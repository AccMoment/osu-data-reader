package osu.enums

import com.sun.org.apache.xpath.internal.operations.Mod

enum class Mode {
    Standard,
    Taiko,
    CatchTheBeat,
    Mania,
}

fun parseMode(byte: UByte): Mode = when (byte) {
    (0x00).toUByte() -> Mode.Standard
    (0x01).toUByte() -> Mode.Taiko
    (0x02).toUByte() -> Mode.CatchTheBeat
    else ->Mode.Mania
}
