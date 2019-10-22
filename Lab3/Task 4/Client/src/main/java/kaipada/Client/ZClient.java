package kaipada.Client;

import java.util.StringTokenizer;
import java.util.Scanner; 
import org.zeromq.SocketType;
import org.zeromq.ZMQ;
import org.zeromq.ZContext;

public class ZClient {
    public static void main(String[] args)
    {
        try (ZContext context = new ZContext()) {
            //  Socket to talk to server
            ZMQ.Socket subscriber = context.createSocket(SocketType.SUB);
            subscriber.connect("tcp://localhost:5556");

            //  Subscribe to zipcode, default is NYC, 10001
	    Scanner scan = new Scanner(System.in);
	    int population = 0;
	    System.out.println("Print the zip code of the city:");
	    String number = scan.nextLine();
            subscriber.subscribe(number.getBytes(ZMQ.CHARSET));

            //  Process 100 updates
            int update_nbr;
            long total_temp = 0;
            for (update_nbr = 0; update_nbr < 100; update_nbr++) {
                //  Use trim to remove the tailing '0' character
                String string = subscriber.recvStr(0).trim();
                StringTokenizer sscanf = new StringTokenizer(string, " ");
                int zipcode = Integer.valueOf(sscanf.nextToken());
                population = Integer.valueOf(sscanf.nextToken());
            }

            System.out.println(String.format("Population for zipcode '%s' was %d.",number,population));
        }
    }
}
