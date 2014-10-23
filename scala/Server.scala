//SERVER
import java.net._
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent._
 
object main{
 
    def handleClient(s: Socket) : Unit = {
      val in = s.getInputStream
      val out = s.getOutputStream
      while(s.isConnected){
        val buffer = Array[Byte](4)
        in.read(buffer)
        out.write("Pong".getBytes)
      }
    }
 
    def main(args: Array[String]){
      val server = new ServerSocket(1201)
      while(true){
        val s: Socket = server.accept()
        future { handleClient(s) }
      }
    }
}
