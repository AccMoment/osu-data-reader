package osu.model

import osu.enums.Grade
import osu.enums.Mode
import osu.enums.RankedStatus
import java.util.Date


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


