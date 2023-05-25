package osu.model


data class ScoreList(
    val version:Int,
    val beatmaps:List<BeatmapScores>
)

/**
 * @property beatmap
 * The beatmap hash.
 *
 * Should be redundant with the individual replay hashes.
 * @property scores
 * All the scored replays for this beatmap.
 */
data class BeatmapScores(
    val beatmap: Beatmap,
    val scores:List<Replay>
)