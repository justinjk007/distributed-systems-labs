import java.io.*;
import java.io.DataInputStream;
import java.net.*;

class TCPServer {
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
	    int number = r.read();
	    System.out.println("Number received: "+number);
	    int ans = process(number);
	    System.out.println("Processed number: "+ans);
	    w.write(ans);
	} catch(IOException e)  {
	    System.out.println("Connection failed:"+e.getMessage());
	}
    }


    public static int process(int num) {
	int ans = 0;
	for (int i = 0; i < num; i++)
	    ans+=i;
	return ans/num;		// Average of the summation
    }

}
