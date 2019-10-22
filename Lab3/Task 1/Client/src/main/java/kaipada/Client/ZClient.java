package kaipada.Client;

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

	    String request = "Hello from the Client!";
	    socket.send(request.getBytes(ZMQ.CHARSET), 0);
	    byte[] reply = socket.recv(0);
	    System.out.println("Received " + new String(reply, ZMQ.CHARSET));
        }
    }
}
