import java.io.*;
import java.io.DataInputStream;
import java.net.*;

class Task2Server {
    public static void main(String[] arg)throws Exception {
	ServerSocket server;
	DataInputStream in;
	PrintStream w;
	DataInputStream r;
	try {
	    server=new ServerSocket(7896);
	    Socket client=server.accept();
	    r=new DataInputStream(client.getInputStream());
	    w=new PrintStream(client.getOutputStream());
	    in=new DataInputStream(System.in);
	    System.out.println("Connection established");

	    byte[] byte_array = new byte[100];
	    r.read(byte_array);
	    String text = new String(byte_array);
	    System.out.println("String received: "+text);

	    int number = r.read();
	    System.out.println("Shift number received: "+number);

	    String ans = process(text,number);
	    byte[] ans_array = ans.getBytes();
	    w.write(ans_array,0,ans_array.length);
	} catch(IOException e)  {
	    System.out.println("Connection failed:"+e.getMessage());
	}
    }


    public static String process(String text, int s) {
	    string result = ""; 
	    // traverse text 
	    for (int i=0;i<text.length();i++) 
		{ 
		    // apply transformation to each character 
		    // Encrypt Uppercase letters 
		    if (isupper(text[i])) 
			result += char(int(text[i]+s-65)%26 +65); 
  
		    // Encrypt Lowercase letters 
		    else
			result += char(int(text[i]+s-97)%26 +97); 
		} 
  
	    // Return the resulting string 
	    return result; 
    }
}
