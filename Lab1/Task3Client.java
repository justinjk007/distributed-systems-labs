import java.io.*; 
import java.io.DataInputStream; 
import java.net.*;

public class Task3Client {
    @SuppressWarnings("deprecation")
    public static void main(String[] args) throws Exception {
		
	try {

	    Socket client=new Socket("127.0.0.1",7896); 
	    DataInputStream r=new DataInputStream(client.getInputStream()); 
	    PrintStream w=new PrintStream(client.getOutputStream()); 
	       
	    //get input from keyboard
	    DataInputStream in=new DataInputStream(System.in); 

	    while(true){
		//send number to server
		System.out.println("Enter text to decypher");
		String text = in.readLine();
		w.println(text);
		
		System.out.println("Enter number to shift by");
		String number = in.readLine();
		w.write(Integer.parseInt(number));
		
		//read answer from server and print it
		String answer = r.readLine();
		System.out.println(answer);
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
