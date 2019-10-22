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
		String myString = new String(reply, ZMQ.CHARSET);
		int foo = Integer.parseInt(myString);
		String response = getPrimeNumbers(foo);
		socket.send(response.getBytes(ZMQ.CHARSET), 0);
	    }
	}
    }

    public static String getPrimeNumbers(int big_boy)
    {
	// Send back all the prime numbers up to the given number
	String  primeNumbers = "";

	for (int i = 1; i <= big_boy; i++)         
	    { 		  	  
		int counter=0; 	  
		for(int num =i; num>=1; num--)
		    {
			if(i%num==0)
			    {
				counter = counter + 1;
			    }
		    }
		if (counter ==2)
		    {
			//Appended the Prime number to the String
			primeNumbers = primeNumbers + i + " ";
		    }	
	    }	
	return primeNumbers;
    }
}
