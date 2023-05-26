package osu.model


data class ScoreList(
    val version:Int,
    val beatmaps:List<BeatmapScores>
)

/**
 * @property beatmapHash
 * The beatmap hash.
 *
 * Should be redundant with the individual replay hashes.
 * @property scores
 * All the scored replays for this beatmap.
 */
data class BeatmapScores(
    val beatmapHash: String?,
    val scores:List<Replay>
)