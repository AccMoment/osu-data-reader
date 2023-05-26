package osu.model

import osu.enums.Permission
import java.util.*

/**
 * @property version
 * The `osu!.db` version number.
 *
 * This is a decimal number in the form `YYYYMMDD` (eg. `20150203`).
 * @property folderCount
 * The amount of folders within the "Songs" directory.
 *
 * Probably for quick checking of changes within the directory.
 * @property unbanDate
 * Whether the account is locked/banned, and when will be it be unbanned.
 * @property playerName
 * Self-explanatory.
 * @property beatmaps
 * All stored beatmaps and the information stored about them.
 *
 * The main bulk of information.
 * @property userPermissions
 * User permissions (0 = None, 1 = Normal, 2 = Moderator, 4 = Supporter,8 = Friend, 16 = peppy, 32 = World Cup staff)
 */
data class OsuData(
    val version: Int,
    val folderCount: Int,
    val unbanDate: Date,
    val playerName: String?,
    val beatmaps: List<Beatmap>,
    val userPermissions: Permission
) {

}