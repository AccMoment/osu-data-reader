package osu

import osu.enums.*
import osu.model.*
import java.io.BufferedInputStream
import java.io.File
import java.util.*


object OsuDataReader {

    /**
     * Get data from osu!.db file
     */
    fun getOsuData(filePath: String): OsuData = getOsuData(file = File(filePath))

    /**
     * Get data from osu!.db file
     */
    fun getOsuData(file: File): OsuData {
        if (file.name != "osu!.db") throw Exception("路径错误,请检查osu!.db文件的路径是否正确!")
        val stream = BufferedInputStream(file.inputStream())
        val version = stream.readInt()
        val folderCount = stream.readInt()
        stream.readBoolean() //read accountUnlocked
        val unlockDate = stream.readDate()
        val playerName = stream.readString()
        val beatmaps = getBeatmaps(stream = stream)
        val permission = parsePermission(stream.readInt())
        stream.close()
        return OsuData(version, folderCount, unlockDate, playerName, beatmaps, permission)
    }

    /**
     * Get data from collection.db file
     */
    fun getCollectionList(filePath: String): OsuCollectionList = getCollectionList(file = File(filePath))

    /**
     * Get data from collection.db file
     */
    fun getCollectionList(file: File): OsuCollectionList {
        if (file.name != "collection.db") throw Exception("路径错误,请检查collection.db文件的路径是否正确!")
        val stream = BufferedInputStream(file.inputStream())
        val version = stream.readInt()
        val collections = stream.readCollections()
        stream.close()
        return OsuCollectionList(version, collections)
    }

    fun getScoresList(filePath: String): ScoreList = getScoresList(file = File(filePath))

    /**
     * get data from scores.db file
     */
    fun getScoresList(file: File): ScoreList {
        if (file.name != "scores.db") throw Exception("路径错误,请检查scores.db文件的路径是否正确!")
        val stream = BufferedInputStream(file.inputStream())
        val version = stream.readInt()
        val beatmapScoreList = stream.readBeatmapScoresList()
        return ScoreList(version, beatmapScoreList)
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
            val lastModified = stream.readDate()
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
            val lastPlayed = stream.readDate()
            val isOsz2: Boolean = stream.readBoolean()
            val folderName: String? = stream.readString()
            val lastOnlineCheck = stream.readDate()
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


private fun BufferedInputStream.readStarRatings(): List<Double> {
    val count = readInt()
    val list = mutableListOf<Double>()
    repeat(count) {
        readUByte()
        readInt() // read ModSet
        readUByte()
        val starRating = readDouble()
        list.add(starRating)
    }
    return list
}

private fun BufferedInputStream.readTimingPoints(): List<TimingPoint> {
    val count = readInt()
    val list = mutableListOf<TimingPoint>()
    repeat(count) {
        val bpm = readDouble()
        val offset = readDouble()
        val inherit = readBoolean()
        val timingPoint = TimingPoint(bpm, offset, inherit)
        list.add(timingPoint)
    }
    return list
}

private fun BufferedInputStream.readCollections(): List<OsuCollection> {
    val collectionCount = readInt()
    val collections = mutableListOf<OsuCollection>()
    repeat(collectionCount) {
        val name = readString()
        val size = readInt()
        val beatmapHashes = mutableListOf<String>()
        repeat(size) {
            val hash = readString()
            beatmapHashes.add(hash!!)
        }
        val collection = OsuCollection(name = name, beatmapHashes = beatmapHashes)
        collections.add(collection)
    }
    return collections
}

private fun BufferedInputStream.readBeatmapScoresList(): List<BeatmapScores> {
    val count = readInt()
    val list = mutableListOf<BeatmapScores>()
    repeat(count) {
        val hash = readString()
        val replayList = readReplayList()
        val scores = BeatmapScores(hash, replayList)
        list.add(scores)
    }
    return list
}

private fun BufferedInputStream.readReplayList(): List<Replay> {
    val count = readInt()
    val list = mutableListOf<Replay>()
    repeat(count) {
        val mode = parseMode(readUByte())
        val version = readInt()
        val beatmapHash = readString()
        val playerName = readString()
        val replayHash = readString()
        val count300 = readShort()
        val count100 = readShort()
        val count50 = readShort()
        val countGeKi = readShort()
        val countKaTsu = readShort()
        val countMiss = readShort()
        val score = readInt()
        val maxCombo = readShort()
        val perfectCombo = readBoolean()
        val mods = readInt()
        val lifeGraph = readString()
        val timeStamp = readDate()
        readInt() // don't know what is this
        val onlineScoreId = readLong()
        val replay = Replay(
            mode,
            version,
            beatmapHash,
            playerName,
            replayHash,
            count300,
            count100,
            count50,
            countGeKi,
            countKaTsu,
            countMiss,
            score,
            maxCombo,
            perfectCombo,
            mods,
            lifeGraph,
            timeStamp,
            onlineScoreId
        )

        list.add(replay)
    }
    return list

}