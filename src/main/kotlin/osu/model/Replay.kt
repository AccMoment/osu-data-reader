package osu.model

import osu.enums.Mode
import java.util.*

/**
 * @property mode The gamemode the replay was scored in.
 * @property version If the replay is inside a `scores.db` file, the version should be redundant with it (?).
 * @property beatmapHash The MD5 hash of the beatmap played.
 * @property playerName The name of the player who scored the replay.
 * @property replayHash The replay-specific MD5 hash.
 * @property count300  Amount of 300s (fruits in ctb).
 * @property count100 Amount of 100s (drops in ctb, 150s in taiko and 200s in mania).
 * @property count50 Amount of 50s (droplets in ctb).
 * @property countGeKi Amount of gekis ("MAX scores" or "rainbow 300s" in mania).
 * @property countKaTsu Amount of katsus (200s in mania, droplet misses in ctb).
 * @property countMiss Amount of misses (fruit + drop misses in ctb).
 * @property score The numerical score achieved.
 * @property mods The mod combination with which the replay was done.
 * @property lifeGraph
 * A string representing a graph of how much life bar did the player have along the beatmap.
 *
 * It is a comma-separated list of human-readable entries in the form `<offset>|<life>`, where
 * `<offset>` is the amount of milliseconds since the start of the song and `<life>` is a
 * number between 0 and 1 representing the amount of life left.
 * @property timeStamp When was the replay scored.
// * @property replayData
// * Decompressed replay data.
// * @property rawReplayData
// * Raw replay data
 * @property onlineScoreId
 * Online score id.
 * Only has a useful value on replays embedded in a `ScoreList`.
 */

data class Replay(
    val mode: Mode,
    val version: Int,
    val beatmapHash: String?,
    val playerName: String?,
    val replayHash: String?,
    val count300: Short,
    val count100: Short,
    val count50: Short,
    val countGeKi: Short,
    val countKaTsu: Short,
    val countMiss: Short,
    val score: Int,
    val maxCombo: Short,
    val perfectCombo: Boolean,
    val mods: Int,
    val lifeGraph: String?,
    val timeStamp: Date,
//    val replayData: List<Action>,
//    val rawReplayData: List<Byte>,
    val onlineScoreId: Long
)

/**
 * @property delta The amount of milliseconds since the last action.
 * @property x
 * First bit of payload in the action.
 *
 * In standard:
 * Represents the `x` coordinate of the mouse, from `0` to `512`.
 *
 * In mania:
 * Represents the bitwise combination of buttons pressed.
 * @property y
 * Second bit of payload in the action.
 *
 * In standard:
 * Represents the `y` coordinate of the mouse, from `0` to `384`.
 * @property z
 * Third bit of payload in the action.
 *
 * In standard:
 * Represents the bitwise combination of buttons pressed.
 */
data class Action(
    val delta: Long,
    val x: Float,
    val y: Float,
    val z: Float
)