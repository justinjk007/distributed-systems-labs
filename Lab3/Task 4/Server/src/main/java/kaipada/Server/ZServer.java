package kaipada.Server;

import java.util.Random;
import org.zeromq.SocketType;
import org.zeromq.ZMQ;
import org.zeromq.ZContext;

public class ZServer
{
    public static void main(String[] args) throws Exception
    {
        //  Prepare our context and publisher
        try (ZContext context = new ZContext()) {
            ZMQ.Socket publisher = context.createSocket(SocketType.PUB);
            publisher.bind("tcp://*:5556");
            publisher.bind("ipc://population");

            //  Initialize random number generator
            Random srandom = new Random(System.currentTimeMillis());
            while (!Thread.currentThread().isInterrupted()) {

		// This is generating population values for a lot of
		// zip codes and then client just pick up what it
		// needs

		int zipcode, population;
                zipcode = 1000 + srandom.nextInt(1000);
                population = srandom.nextInt(215654) - 15 + 1;

                //  Send message to all subscribers
                String update = String.format("%04d %d", zipcode, population);
                System.out.println(update);
                publisher.send(update, 0);
	    }
        }
    }
}
