package osu.model

/**
 * @property bpm The bpm of the timing point.
 * @property offset The amount of milliseconds from the start of the song this timing point is located on.
 * @property inherit
 * Whether the timing point inherits or not.
 *
 * Basically, inherited timing points are absolute, and define a new bpm independent of any previous bpms.
 * On the other hand, timing points that do not inherit have a negative bpm representing a percentage of the
 * bpm of the previous timing point.
 *
 * See the osu wiki on the `.osu` format for more details.
 */
data class TimingPoint(
    val bpm:Double,
    val offset:Double,
    val inherit:Boolean
)