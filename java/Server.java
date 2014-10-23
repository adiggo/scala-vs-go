import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
public class Server{
   private static ServerSocket serverSocket;
   private static int count = 0;
   public static void main(String[] args){
	try{
        	serverSocket = new ServerSocket(1201);
		//System.out.println("Server Socket Established.");
        }catch(IOException e){
		e.printStackTrace();
	}
        while(true){
            try{
                Socket socket = serverSocket.accept();
                ClientHandler handler = new ClientHandler(socket);
                handler.run();
		//count++;
		//System.out.println("New Connection Established: " + count);
             }catch (IOException ioe) {
                System.out.println("IOException on socket listen: " + ioe);
                ioe.printStackTrace();
            }
        }
   }
}

    




