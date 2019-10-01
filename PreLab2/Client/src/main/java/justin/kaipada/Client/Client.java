package justin.kaipada.Client;

import java.rmi.Naming;

public class Client
{
	public static void main(String[] argv) 
	{
		try {
			String name = "//10.150.7.194/Server";
			RemoteInterface test = (RemoteInterface) Naming.lookup(name);
			System.out.println(test.fibonacci(Integer.parseInt(argv[0])));
		} catch (Exception e)
		{
			System.err.println(e.getMessage());
		}
	}
}
