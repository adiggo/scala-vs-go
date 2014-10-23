//CLIENT
import scala.concurrent._
import scala.concurrent.duration._
import scala.concurrent.ExecutionContext.Implicits.global
import java.net._
 
object main{
 
    def ping(timesToPing: Int) : Unit = {
        val socket = new Socket("localhost", 1201)
        val out = socket.getOutputStream
        val in = socket.getInputStream
        for (i <- 0 until timesToPing) {
            out.write("Ping".getBytes)
            val buffer = Array[Byte](4)
            in.read(buffer)
        }
        socket.close
    }
 
    def main(args: Array[String]){
        var totalPings = 1000000
        var concurrentConnections = 100
        var pingsPerConnection : Int = totalPings/concurrentConnections
        var actualTotalPings : Int = pingsPerConnection*concurrentConnections
 
        val t0 = (System.currentTimeMillis()).toDouble
        var futures = (0 until concurrentConnections).map{_ => 
            future(ping(pingsPerConnection))
        }
 
        Await.result(Future.sequence(futures), 1 minutes)
        val t1 = (System.currentTimeMillis()).toDouble
        println(1000*(t1-t0)/actualTotalPings)
    }
}
