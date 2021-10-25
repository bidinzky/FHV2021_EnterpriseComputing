package at.fhv.ea.rmi.client;

import at.fhv.ea.rmi.SquareRmi;
import com.google.inject.Inject;

import java.util.Scanner;

public class RmiClient implements Runnable {
    @Inject
    private SquareRmi squareRmi;

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.print("> ");
            String nl = scanner.nextLine();
            try {
                int number = Integer.parseInt(nl);
                int square = squareRmi.square(number);
                System.out.println(square);
            }catch (Exception e) {
                System.out.println("INVALID INTEGER");
            }
        }
    }
}
