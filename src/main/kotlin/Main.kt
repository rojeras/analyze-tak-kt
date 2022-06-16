import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.coroutines.*
import kotlinx.serialization.*
import kotlinx.serialization.json.*

@Serializable
data class Contract(
    val id: Int,
    val name: String,
    val serviceDomainId: Int,
    val namespace: String,
    val major: Int,
    val synonym: String = "None",
)

val url: String = "https://integrationer.tjansteplattform.se/tpdb/tpdbapi.php/api/v1/contracts"

suspend fun main() {
    runBlocking {

        val connectionPointList = ConnectionPoint.load()

        for (cp in connectionPointList) {
            val id = cp.id
            println("$id ${cp.platform}-${cp.environment}")
        }

        // client.close()
    }
}
