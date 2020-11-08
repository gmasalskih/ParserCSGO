import com.google.gson.GsonBuilder
import java.io.File
import java.util.*

fun main() {
    val parserCSGO = ParserCSGO(pathToFile = "./src/main/resources/", fileName = "txt.txt")
    parserCSGO.parsToMap()
}