package osu.enums

enum class Permission(val code: Int) {
    None(0),
    Normal(1),
    Moderator(2),
    Supporter(4),
    Friend(8),
    Peppy(16),
    WorldCupStaff(32)
}

fun parsePermission(byte: Int): Permission = when (byte) {
    0 -> Permission.None
    1 -> Permission.Normal
    2 -> Permission.Moderator
    4 -> Permission.Supporter
    8 -> Permission.Friend
    16 -> Permission.Peppy
    else -> Permission.WorldCupStaff
}