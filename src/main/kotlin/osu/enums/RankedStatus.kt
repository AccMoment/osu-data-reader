package osu.enums

enum class RankedStatus(val code:UByte) {
    Unknown((0x00).toUByte()),
    Unsubmitted((0x01).toUByte()),
    /// Any of the three.
    PendingWipGraveyard((0x02).toUByte()),
    Ranked((0x04).toUByte()),
    Approved((0x05).toUByte()),
    Qualified((0x06).toUByte()),
    Loved((0x07).toUByte())


}

fun parseRandedStatus(byte: UByte): RankedStatus = RankedStatus.values().find { it.code == byte }!!