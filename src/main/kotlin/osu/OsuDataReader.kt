package osu

import osu.enums.*
import osu.model.Beatmap
import osu.model.OsuCollectionList
import osu.model.OsuMainData
import osu.model.TimingPoint
import java.io.BufferedInputStream
import java.io.File
import java.util.*

object OsuDataReader {


    fun getOsuData(filePath: String): OsuMainData = getOsuData(file = File(filePath))


    fun getOsuData(file: File): OsuMainData {
        if (file.name != "osu!.db") throw Exception("路径错误,请检查osu!.db文件的路径是否正确!")
        val fileStream = BufferedInputStream(file.inputStream())
        val version = fileStream.readInt()
        val folderCount = fileStream.readInt()
        fileStream.readBoolean() //read accountUnlocked
        val unlockDate = Date(fileStream.readLong())
        val playerName = fileStream.readString()
        val beatmaps = getBeatmaps(stream = fileStream)
        val permission = parsePermission(fileStream.readInt())
        fileStream.close()
        return OsuMainData(version, folderCount, unlockDate, playerName, beatmaps, permission)
    }


    fun getOsuCollectionList(filePath: String): OsuCollectionList = getOsuCollectionList(file = File(filePath))

    fun getOsuCollectionList(file: File): OsuCollectionList {
        if (file.name != "collection.db") throw Exception("路径错误,请检查collection.db文件的路径是否正确!")
        val osuData = getOsuData(file.parent + "\\osu!.db")
        val stream = BufferedInputStream(file.inputStream())
        val version = stream.readInt()
        val collections = stream.readCollections(osuData)
        stream.close()
        return OsuCollectionList(version, collections)
    }

    private fun getBeatmaps(stream: BufferedInputStream): List<Beatmap> {
        val mapCount = stream.readInt()
        val list = mutableListOf<Beatmap>()
        repeat(mapCount) {
            val artistAscii: String? = stream.readString()
            val artistUnicode: String? = stream.readString()
            val titleAscii: String? = stream.readString()
            val titleUnicode: String? = stream.readString()
            val creator: String? = stream.readString()
            val difficultyName: String? = stream.readString()
            val audio: String? = stream.readString()
            val hash: String? = stream.readString()
            val fileName: String? = stream.readString()
            val status: RankedStatus = parseRandedStatus(stream.readUByte())
            val hitCircleCount: Short = stream.readShort()
            val sliderCount: Short = stream.readShort()
            val spinnerCount: Short = stream.readShort()
            val lastModified: Date = Date(stream.readLong())
            val approachRate: Float = stream.readFloat()
            val circleSize: Float = stream.readFloat()
            val hpDrain: Float = stream.readFloat()
            val overallDifficulty: Float = stream.readFloat()
            val sliderVelocity: Double = stream.readDouble()
            val stdRatings: List<Double> = stream.readStarRatings()
            val taikoRatings: List<Double> = stream.readStarRatings()
            val ctbRatings: List<Double> = stream.readStarRatings()
            val maniaRatings: List<Double> = stream.readStarRatings()
            val drainTime: Int = stream.readInt()
            val totalTime: Int = stream.readInt()
            val previewTime: Int = stream.readInt()
            val timingPoints: List<TimingPoint> = stream.readTimingPoints()
            val beatmapId: Int = stream.readInt()
            val beatmapSetId: Int = stream.readInt()
            val threadId: Int = stream.readInt()
            val stdGrade: Grade = parseGrade(stream.readUByte())
            val taikoGrade: Grade = parseGrade(stream.readUByte())
            val ctbGrade: Grade = parseGrade(stream.readUByte())
            val maniaGrade: Grade = parseGrade(stream.readUByte())
            val localBeatMapOffset: Short = stream.readShort()
            val stackLeniency: Float = stream.readFloat()
            val mode: Mode = parseMode(stream.readUByte())
            val songSource: String? = stream.readString()
            val tags: String? = stream.readString()
            val onlineOffset: Short = stream.readShort()
            val titleFont: String? = stream.readString()
            val unPlayed: Boolean = stream.readBoolean()
            val lastPlayed: Date = Date(stream.readLong())
            val isOsz2: Boolean = stream.readBoolean()
            val folderName: String? = stream.readString()
            val lastOnlineCheck: Date = Date(stream.readLong())
            val isIgnoreSounds: Boolean = stream.readBoolean()
            val isIgnoreSkin: Boolean = stream.readBoolean()
            val isDisableStoryBoard: Boolean = stream.readBoolean()
            val isDisableVideo: Boolean = stream.readBoolean()
            val isVisualOverride: Boolean = stream.readBoolean()
            val mysteriousLastModified: Int = stream.readInt()
            val maniaScrollSpeed: Int = stream.readUByte().toInt()

            val beatmap = Beatmap(
                artistAscii,
                artistUnicode,
                titleAscii,
                titleUnicode,
                creator,
                difficultyName,
                audio,
                hash,
                fileName,
                status,
                hitCircleCount,
                sliderCount,
                spinnerCount,
                lastModified,
                approachRate,
                circleSize,
                hpDrain,
                overallDifficulty,
                sliderVelocity,
                stdRatings,
                taikoRatings,
                ctbRatings,
                maniaRatings,
                drainTime,
                totalTime,
                previewTime,
                timingPoints,
                beatmapId,
                beatmapSetId,
                threadId,
                stdGrade,
                taikoGrade,
                ctbGrade,
                maniaGrade,
                localBeatMapOffset,
                stackLeniency,
                mode,
                songSource,
                tags,
                onlineOffset,
                titleFont,
                unPlayed,
                lastPlayed,
                isOsz2,
                folderName,
                lastOnlineCheck,
                isIgnoreSounds,
                isIgnoreSkin,
                isDisableStoryBoard,
                isDisableVideo,
                isVisualOverride,
                mysteriousLastModified,
                maniaScrollSpeed
            )
            list.add(beatmap)
        }
        return list
    }

}