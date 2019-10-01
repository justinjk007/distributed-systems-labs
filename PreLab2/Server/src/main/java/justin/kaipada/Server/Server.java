package justin.kaipada.Server;

import java.rmi.Naming;

public class Server
{
	public static void main(String[] argv)
	{
		// Dont have a security policy so no point in having it in.
		//if (System.getSecurityManager() == null) 
		//{
		//	System.setSecurityManager(new SecurityManager());
		//}
		try
		{
			RemoteInterface test = new RemoteImp();
			Naming.rebind("//127.0.0.1/Server", test);
		} catch (Exception e)
		{
			System.err.println(e.getMessage());
		}
	}
}
