import java.io.*;
import java.io.DataInputStream;
import java.net.*;

public class Task4Client {
    @SuppressWarnings("deprecation")
    public static void main(String[] args) throws Exception {

	try {
	    Socket client=new Socket("127.0.0.1",7896);
	    DataInputStream r=new DataInputStream(client.getInputStream());
	    PrintStream w=new PrintStream(client.getOutputStream());

	    //get input from keyboard
	    DataInputStream in=new DataInputStream(System.in);
	    String text;


	    while ((text = in.readLine()) != null)
		{
		    //send number to server
		    w.println(text);
		    System.out.println("Echo Server Sent: " + r.readLine());
		}


	}catch (UnknownHostException e){
	    System.out.println("Sock:"+e.getMessage());
	}catch (EOFException e){
	    System.out.println("EOF:"+e.getMessage());
	}catch (IOException e){
	    System.out.println("IO:"+e.getMessage());
	}

    }

}
