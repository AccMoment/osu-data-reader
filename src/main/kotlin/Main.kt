import osu.OsuDataReader
import kotlin.system.measureTimeMillis
import kotlin.time.ExperimentalTime
import kotlin.time.measureTime


@OptIn(ExperimentalTime::class)
fun main(args: Array<String>) {


      val data = OsuDataReader.getOsuCollectionList("D:\\osu!\\collection.db")

    println()

}