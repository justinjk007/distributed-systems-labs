import java.io.*;
import java.io.DataInputStream; 
import java.net.*; 

public class Task2Server {
    @SuppressWarnings("deprecation")
    public static void main(String[] args) throws Exception {
		
	ServerSocket server;
	DataInputStream in;
	PrintStream w;
	DataInputStream r;
	
	try {
	    server=new ServerSocket(7896);  
	    Socket client=server.accept(); 
	    r=new DataInputStream(client.getInputStream()); 
	    w=new PrintStream(client.getOutputStream()); 
	    //in=new DataInputStream(System.in); 
	
	    String text = r.readLine();
	    System.out.println(text);
	    int number = r.read();
	    System.out.println(number);
	
	    StringBuffer result= new StringBuffer();
       
	    for (int i=0; i<text.length(); i++) 
		{ 
		    if (Character.isUpperCase(text.charAt(i))) 
			{ 
			    char ch = (char)(((int)text.charAt(i) + number - 65) % 26 + 65); 
			    result.append(ch); 
			} 
		    else
			{ 
			    char ch = (char)(((int)text.charAt(i) + number - 97) % 26 + 97); 
			    result.append(ch); 
			} 
		} 
	
	    w.println(result);
	
	} catch(IOException e)  {
	    System.out.println("Connection:"+e.getMessage());
	}

    }

}
