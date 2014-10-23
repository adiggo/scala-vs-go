import java.net.*;
import java.net.Socket;
import java.io.*;

public class Client{
    
    public static void main(String[] args){
        int totalPings = 1000000;
        //int concurrentConnection = 5000;
	int concurrentConnection = Integer.parseInt(args[0]);

        int pingPerConnection = totalPings/concurrentConnection;

        long t0 = System.currentTimeMillis();
        Thread [] pings = new Thread[concurrentConnection];
        for (int i = 0; i < concurrentConnection; i++){
            pings[i] = new Thread(new ServerHandler(pingPerConnection));
            pings[i].start();
        }
        
	for(int i = 0; i < concurrentConnection; i++){
		try{
			pings[i].join();
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	} 
	long t1 = System.currentTimeMillis();
	System.out.println((double)1000*(t1-t0)/totalPings);
    }

         
}
        
