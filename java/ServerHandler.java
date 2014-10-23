import java.net.*;
import java.net.Socket;
import java.io.*;

public class ServerHandler implements Runnable{
	private int timesToPing;

	public ServerHandler(int timesToPing){
		this.timesToPing = timesToPing;
	}

	public void run(){
		try{
			Socket socket = new Socket("localhost",1201);
			for(int i = 0; i <= timesToPing; i++){
				DataOutputStream out = new DataOutputStream(socket.getOutputStream());
				out.writeUTF("Ping");
				DataInputStream in = new DataInputStream(socket.getInputStream());
				if(in.toString().equals("Pong")){
					//System.out.println("Pong Received.");
				}
				//in.close();
				//out.close();
			}
			socket.close();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}
