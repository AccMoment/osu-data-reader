package osu

import osu.model.Beatmap
import osu.model.OsuCollection
import osu.model.OsuMainData
import osu.model.TimingPoint
import java.io.BufferedInputStream


internal fun BufferedInputStream.readInt(): Int {
    val bytes = ByteArray(Int.SIZE_BYTES)
    read(bytes)
    return bytes.toInt()
}

internal fun BufferedInputStream.readBoolean(): Boolean {
    val byte = ByteArray(Byte.SIZE_BYTES)
    read(byte)
    return byte[0].toUByte().toInt() != 0
}

internal fun BufferedInputStream.readShort(): Short {
    val bytes = ByteArray(Short.SIZE_BYTES)
    read(bytes)
    var result = 0
    for (i in bytes.size - 1 downTo 0) {
        result = result shl 8
        result = result or bytes[i].toUByte().toInt()
    }
    return result.toShort()
}

internal fun BufferedInputStream.readLong(): Long {
    val bytes = ByteArray(Long.SIZE_BYTES)
    read(bytes)
    return bytes.toLong()
}

internal fun BufferedInputStream.readUByte(): UByte {
    val bytes = ByteArray(Byte.SIZE_BYTES)
    read(bytes)
    return bytes[0].toUByte()
}

internal fun BufferedInputStream.readString(): String? =
    when (readUByte()) {
        (0x0b).toUByte() -> {
            var strlen = 0
            var offset = 0
            while (true) {
                val t = readUByte().toInt()
                strlen = strlen or (t and 127 shl offset)
                if ((t and (1 shl 7)) == 0) break
                offset += 7
            }
            val bytes = ByteArray(strlen)
            read(bytes)
            bytes.decodeToString()
        }

        else -> null
    }

internal fun BufferedInputStream.readDouble(): Double {
    val bytes = ByteArray(Double.SIZE_BYTES)
    read(bytes)
    return bytes.toDouble()
}

internal fun BufferedInputStream.readFloat(): Float {
    val bytes = ByteArray(Float.SIZE_BYTES)
    read(bytes)
    return bytes.toFloat()
}


internal fun BufferedInputStream.readStarRatings(): List<Double> {
    val count = readInt()
    val list = mutableListOf<Double>()
    repeat(count) {
        readUByte()
        val modSet = readInt()
        readUByte()
        val starRating = readDouble()
        list.add(starRating)
    }
    return list
}

internal fun BufferedInputStream.readTimingPoints(): List<TimingPoint> {
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

internal fun BufferedInputStream.readCollections(osuData:OsuMainData):List<OsuCollection>{
    val collectionCount = readInt()
    val collections = mutableListOf<OsuCollection>()
    repeat(collectionCount) {
        val name = readString()
        val size = readInt()
        val beatmaps = mutableListOf<Beatmap>()
        repeat(size) {
            val hash = readString()
            osuData.beatmaps.find { beatmap -> beatmap.hash == hash }?.let { beatmap ->
                beatmaps.add(beatmap)
            }
        }
        val collection = OsuCollection(name = name, beatmaps = beatmaps)
        collections.add(collection)
    }
    return collections
}

fun ByteArray.toLong(): Long {
    var result = 0L
    for (i in Long.SIZE_BYTES - 1 downTo 0) {
        result = result shl 8
        result = result or this[i].toUByte().toLong()
    }
    return result
}

fun ByteArray.toInt(): Int {
    var result = 0
    for (i in Int.SIZE_BYTES - 1 downTo 0) {
        result = result shl 8
        result = result or this[i].toUByte().toInt()
    }
    return result
}


fun ByteArray.toDouble(): Double = Double.fromBits(this.toLong())


fun ByteArray.toFloat(): Float = Float.fromBits(this.toInt())