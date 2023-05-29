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

fun parsePermission(byte: Int): Permission = Permission.values().find { it.code==byte }!!