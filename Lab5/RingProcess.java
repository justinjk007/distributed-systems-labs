import java.io.*;
import java.util.Scanner;
 
public class RingProcess {
    public static void main(String args[])throws IOException
    {
	int n;
	int id[] = new int[100]; // Can only support 99 processes maximum :sad:
	int initiator = 0;
	System.out.println("Enter the number of processes: ");
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        
        for(int i=1;i<=n;i++)
	    {
		System.out.println("For process "+i+" ...");
		System.out.println("Process id (1, 2, 3, .., n): ");
		id[i] = in.nextInt();
	    }
         
        System.out.println("Which process will initiate election? ");
        initiator = in.nextInt();
	
	// TO DO Task: Implement your logic to perform the ring algorithm. 

	int to = initiator+1;
	int from = initiator;
	while (true) {
	    System.out.println("Comparing process "+to+" to "+from);
	    if(id[from] > id[to]) {
		to++;
	    }
	    else if(id[from] < id[to]) {
		from = to;
		to++;
	    }
	    else{
		System.out.println("Leader is "+from);
		break;
	    }

	    // Rotate the id back to 1
	    if(to > n)
		to = 1;
	}
    }
}
