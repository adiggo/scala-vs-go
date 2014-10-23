import java.net.*;
import java.net.Socket;
import java.io.*;

public class ClientHandler implements Runnable{
    
    private Socket socket;    

    public ClientHandler(Socket s){
        this.socket = s;
    }


    public void run(){
	//while(socket.isConnected())
	//{
		try{
		    DataInputStream in = new DataInputStream(socket.getInputStream());
		    //System.out.println("Received" + in.toString());
		    if (in.toString().equals("Ping")){
		        DataOutputStream dos = new DataOutputStream(
		                                socket.getOutputStream());
		        dos.writeUTF("Pong");
		     }
		}catch(IOException | NullPointerException e){
		        e.printStackTrace();
		}
	   //}
    }
}
        
        

                




    


        






