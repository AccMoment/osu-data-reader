package osu.enums

enum class RankedStatus {
    Unknown,
    Unsubmitted,

    /// Any of the three.
    PendingWipGraveyard,
    Ranked,
    Approved,
    Qualified,
    Loved;


}

fun parseRandedStatus(byte: UByte): RankedStatus = when (byte) {
    (0x00).toUByte() -> RankedStatus.Unknown
    (0x01).toUByte() -> RankedStatus.Unsubmitted
    (0x02).toUByte() -> RankedStatus.PendingWipGraveyard
    (0x04).toUByte() -> RankedStatus.Ranked
    (0x05).toUByte() -> RankedStatus.Approved
    (0x06).toUByte() -> RankedStatus.Qualified
    (0x07).toUByte() -> RankedStatus.Loved
    else -> RankedStatus.PendingWipGraveyard
}