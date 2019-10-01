package justin.kaipada.Server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

@SuppressWarnings("serial")
public class RemoteImp extends UnicastRemoteObject implements RemoteInterface
{
	public RemoteImp() throws RemoteException
	{
		super();
	}
	
	public int fibonacci (int number)
	{
		if (number < 2) 
			return number;
		return fibonacci(number-1) + fibonacci(number-2);
	}
}
