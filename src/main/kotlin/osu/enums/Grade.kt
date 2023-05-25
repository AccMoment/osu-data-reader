package osu.enums

enum class Grade {
    SSPlus,
    SPlus,
    SS,
    S,
    A,
    B,
    C,
    D,
    UnPlayed
}
fun parseGrade(byte: UByte): Grade = when (byte) {
    (0x00).toUByte() -> Grade.SSPlus
    (0x01).toUByte() -> Grade.SPlus
    (0x02).toUByte() -> Grade.SS
    (0x03).toUByte() -> Grade.S
    (0x04).toUByte() -> Grade.A
    (0x05).toUByte() -> Grade.B
    (0x06).toUByte() -> Grade.C
    (0x07).toUByte() -> Grade.D
    else -> Grade.UnPlayed
}
