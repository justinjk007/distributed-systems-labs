import java.io.*;
import java.io.DataInputStream;
import java.net.*;

public class Task4Server {
    @SuppressWarnings("deprecation")
    public static void main(String[] args) throws Exception {

	int portNumber = 7896;
	Task4Server es = new Task4Server();
	es.run(portNumber);
    }

    public void run(int portNumber) {
	try {
	    ServerSocket serverSocket = new ServerSocket(portNumber);
	    int limit = 0;
	    while(limit < 2) {
		Socket client = serverSocket.accept();
		Connection cc = new Connection(client);
		limit++;
	    }
	    System.out.println("Busy...: ");
	} catch(Exception e) {
	    System.out.println("Busy...: ");
	}
    }
}

class Connection extends Thread {
    Socket client;
    PrintWriter out;
    BufferedReader in;

    public Connection(Socket s) { // constructor
       client = s;

       try {
           out = new PrintWriter(client.getOutputStream(), true);
           in = new BufferedReader(
                new InputStreamReader(client.getInputStream()));
       } catch (IOException e) {
           try {
             client.close();
           } catch (IOException ex) {
             System.out.println("Error while getting socket streams.."+ex);
           }
           return;
       }
        this.start(); // Thread starts here...this start() will call run()
    }

    public void run() {
      try {

         String inputLine;
         while ((inputLine = in.readLine()) != null) {
                System.out.println("Received from: "+ client.getRemoteSocketAddress() + " Input: "+inputLine);
                out.println(inputLine);
         }

         client.close();
       } catch (IOException e) {
           System.out.println("Exception caught...");
           System.out.println(e.getMessage());
       }
    }
}
