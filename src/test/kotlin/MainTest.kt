import org.junit.jupiter.api.Test
import osu.OsuDataReader
import java.io.File

internal class MainTest {
    @Test
    fun getMainDataTest(){
        val data = OsuDataReader.getOsuData(File("D:\\osu!\\osu!.db"))
        assert(data.beatmaps.isNotEmpty())
    }

    @Test
    fun getScoresTest(){
        val scores = OsuDataReader.getScoresList(File("D:\\osu!\\scores.db"))
        assert(scores.beatmaps.isNotEmpty())
    }

    @Test
    fun getCollectionTest(){
        val collection = OsuDataReader.getOsuCollectionList(File("D:\\osu!\\collection.db"))
        assert(collection.collections.isNotEmpty())
    }
}