import org.junit.jupiter.api.Test
import osu.OsuDataReader
import java.io.File

internal class MainTest {
    @Test
    fun test(){
        val scores = OsuDataReader.getScoresList(File("D:\\osu!\\scores.db"))
    }
}