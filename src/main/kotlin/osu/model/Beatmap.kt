package osu.model

import osu.enums.Grade
import osu.enums.Mode
import osu.enums.RankedStatus
import java.util.Date

/**
 * @property artistAscii The name of the artist without special characters.
 * @property artistUnicode The unrestrained artist name.
 * @property titleAscii The song title without special characters.
 * @property titleUnicode The unrestrained song title.
 * @property creator The name of the beatmap mapper.
 * @property difficultyName The name of this specific difficulty.
 * @property audio The filename of the song file.
 * @property hash The MD5 hash of the beatmap.
 * @property fileName The filename of the `.osu` file corresponding to this specific difficulty.
 * @property drainTime Drain time in seconds.
 * @property totalTime Total beatmap time in milliseconds.
 * @property previewTime
 * When should the song start playing when previewed, in milliseconds since the start of the song.
 * @property songSource Where did the song come from, if anywhere.
 * @property tags Song tags, separated by whitespace.
 * @property lastPlayed Whether the beatmap has been played, and if it has, when was it last played.
 * @property isOsz2 Whether the beatmap was in `osz2` format.
 * @property folderName The folder name of the beatmapset within the "Songs" folder.
 * @property mysteriousLastModified
 * Perhaps an early attempt at "last modified", but scrapped once peppy noticed it only had 32 bits.
 */

data class Beatmap(
    val artistAscii :String?,
    val artistUnicode:String?,
    val titleAscii:String?,
    val titleUnicode:String?,
    val creator:String?,
    val difficultyName:String?,
    val audio:String?,
    val hash:String?,
    val fileName:String?,
    val status:RankedStatus,
    val hitCircleCount:Short,
    val sliderCount:Short,
    val spinnerCount:Short,
    val lastModified:Date,
    val approachRate:Float,
    val circleSize:Float,
    val hpDrain:Float,
    val overallDifficulty:Float,
    val sliderVelocity:Double,
    val stdRatings:List<Double>,
    val taikoRatings:List<Double>,
    val ctbRatings:List<Double>,
    val maniaRatings:List<Double>,
    val drainTime:Int,
    val totalTime:Int,
    val previewTime:Int,
    val timingPoints:List<TimingPoint>,
    val beatmapId:Int,
    val beatmapSetId:Int,
    val threadId:Int,
    val stdGrade:Grade,
    val taikoGrade:Grade,
    val ctbGrade:Grade,
    val maniaGrade: Grade,
    val localBeatMapOffset:Short,
    val stackLeniency:Float,
    val mode: Mode,
    val songSource:String?,
    val tags:String?,
    val onlineOffset:Short,
    val titleFont:String?,
    val unPlayed: Boolean,
    val lastPlayed:Date,
    val isOsz2:Boolean,
    val folderName:String?,
    val lastOnlineCheck:Date,
    val isIgnoreSounds:Boolean,
    val isIgnoreSkin:Boolean,
    val isDisableStoryBoard:Boolean,
    val isDisableVideo:Boolean,
    val isVisualOverride:Boolean,
//    val mysteriousShort:Short?,
    val mysteriousLastModified:Int,
    val maniaScrollSpeed:Int
)


