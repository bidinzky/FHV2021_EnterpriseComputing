package at.fhv.ea.rmi.server;

import at.fhv.ea.rmi.SquareRmi;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class RmiServer implements SquareRmi {
    @Override
    public int square(int num) throws RemoteException {
        return num*num;
    }

    public static void register() {
        try {
            RmiServer obj = new RmiServer();
            SquareRmi stub = (SquareRmi) UnicastRemoteObject.exportObject(obj, 0);

            // Bind the remote object's stub in the registry
            Registry registry = LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
            registry.bind("square", stub);

            System.err.println("Server ready");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
