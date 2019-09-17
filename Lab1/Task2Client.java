import java.util.Scanner;  // Import the Scanner class
import java.io.*;
import java.io.DataInputStream;
import java.net.*;

class Task2Client {
    public static void main(String arg[])throws Exception {
	try {
	    Socket client=new Socket("127.0.0.1",7896);
	    DataInputStream r=new DataInputStream(client.getInputStream());
	    PrintStream w=new PrintStream(client.getOutputStream());
	    DataInputStream in=new DataInputStream(System.in);
	    System.out.println("Connection established with server");
	    Scanner scanner_obj = new Scanner(in);  // Create a Scanner object

	    System.out.print("Enter string to decipher: ");
	    String text = scanner_obj.nextLine();
	    byte[] byte_array = text.getBytes();
	    w.write(byte_array,0,byte_array.length);

	    System.out.print("Enter shift number: ");
	    int number = scanner_obj.nextInt();  // Read user input
	    w.write(number);

	    byte[] ans_array = new byte[100];
	    r.read(ans_array);
	    String ans_text = new String(ans_array);
	    System.out.println("Shifted String received: "+ans_text);

	}catch (UnknownHostException e){
	    System.out.println("Sock:"+e.getMessage());
	}catch (EOFException e){
	    System.out.println("EOF:"+e.getMessage());
	}catch (IOException e){
	    System.out.println("IO:"+e.getMessage());
	}
    }
}
