package kaipada.Server;

import org.zeromq.SocketType;
import org.zeromq.ZMQ;
import org.zeromq.ZContext;

public class ZServer {
    public static void main(String[] args) throws Exception
    {
	try (ZContext context = new ZContext()) {
	    //  Socket to talk to clients
	    ZMQ.Socket socket = context.createSocket(SocketType.REP);
	    socket.bind("tcp://*:5555");
	    while (!Thread.currentThread().isInterrupted()) {
		byte[] reply = socket.recv(0);
		System.out.println("Received " + ": [" + new String(reply, ZMQ.CHARSET) + "]");
		String response = "Hello from the server!";
		socket.send(response.getBytes(ZMQ.CHARSET), 0);
	    }
	}
    }
}
