package kaipada.Client;

import java.util.Scanner; 
import org.zeromq.SocketType;
import org.zeromq.ZMQ;
import org.zeromq.ZContext;

public class ZClient {

    public static void main(String[] args)
    {
        try (ZContext context = new ZContext()) {
	    //  Socket to talk to server
            ZMQ.Socket socket = context.createSocket(SocketType.REQ);
            socket.connect("tcp://localhost:5555");

	    Scanner scan = new Scanner(System.in);
	    while(true){
		System.out.println("Enter number for processing: ");
		String number = scan.next();
		System.out.println("Sending "+number);
		socket.send(number.getBytes(ZMQ.CHARSET), 0); // send number string to server

		byte[] reply = socket.recv(0);
		System.out.println("Received " + new String(reply, ZMQ.CHARSET));
	    }

        }
    }
}
