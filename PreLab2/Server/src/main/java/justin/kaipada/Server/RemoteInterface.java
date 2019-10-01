package justin.kaipada.Server;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RemoteInterface extends Remote
{
	int fibonacci (int number) throws RemoteException;
}
