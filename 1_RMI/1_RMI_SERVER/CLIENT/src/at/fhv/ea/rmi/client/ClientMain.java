package at.fhv.ea.rmi.client;

import at.fhv.ea.rmi.SquareRmi;
import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ClientMain {
    public static void main(String[] args) {
        String host = (args.length < 1) ? null : args[0];
        try {
            Registry registry = LocateRegistry.getRegistry(host);
            SquareRmi stub = (SquareRmi) registry.lookup("square");


            Injector injector = Guice.createInjector(new AbstractModule() {
                @Override
                protected void configure() {
                    bind(SquareRmi.class).toInstance(stub);
                }
            });

            RmiClient rmiClient = injector.getInstance(RmiClient.class);
            new Thread(rmiClient).start();

        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
