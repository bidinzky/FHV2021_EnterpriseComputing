package at.fhv.ea.rmi;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface SquareRmi extends Remote {
    public int square(int num) throws RemoteException;
}