package osu.enums

enum class Grade(val code:UByte) {
    SSPlus((0x00).toUByte()),
    SPlus((0x01).toUByte()),
    SS((0x02).toUByte()),
    S((0x03).toUByte()),
    A((0x04).toUByte()),
    B((0x05).toUByte()),
    C((0x06).toUByte()),
    D((0x07).toUByte()),
    UnPlayed((0x09).toUByte())
}

fun parseGrade(byte: UByte): Grade = Grade.values().find { it.code == byte }!!
