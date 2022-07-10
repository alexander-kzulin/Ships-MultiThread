import javax.swing.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws InterruptedException{
ShipGenerator shipGenerator = new ShipGenerator();
shipGenerator.shipGenerator();
Tunnel tunnel = new Tunnel();
tunnel.addShip(shipGenerator);
Pierse pierse = new Pierse();
pierse.run();

    }
}
