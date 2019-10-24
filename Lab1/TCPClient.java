import java.util.Scanner;  // For reading user input
import java.io.*;
import java.io.DataInputStream;
import java.net.*;

class TCPClient {
    public static void main(String arg[])throws Exception {
	try {
	    Socket client=new Socket("127.0.0.1",7896);
	    DataInputStream r=new DataInputStream(client.getInputStream());
	    PrintStream w=new PrintStream(client.getOutputStream());
	    DataInputStream in=new DataInputStream(System.in);
	    System.out.println("Connection established with server");
	    Scanner scanner_obj = new Scanner(in);  // Create a Scanner object
	    System.out.println("Enter a number:");
	    int number = scanner_obj.nextInt();  // Read user input
	    // System.out.println("Number is: " + number);  // Output user input
	    w.write(number);
	    int ans = r.read();
	    System.out.println("Answer received: "+ans);
	}catch (UnknownHostException e){
	    System.out.println("Sock:"+e.getMessage());
	}catch (EOFException e){
	    System.out.println("EOF:"+e.getMessage());
	}catch (IOException e){
	    System.out.println("IO:"+e.getMessage());
	}
    }
}
