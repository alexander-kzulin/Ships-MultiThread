import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Tunnel {
    private ArrayBlockingQueue<Ship> ships;
    private int capacity;
    private String name;

   // public Tunnel() {
   //     ArrayBlockingQueue<Ship> ships = new ArrayBlockingQueue<>(5);
   // }

    public int getCapacity() {
        return capacity;
    }

    public String getName() {
        return name;
    }
    public void addShip(ShipGenerator shipGenerator) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        try {
            while ( capacity < shipGenerator.getGeneratedShips().remainingCapacity()) {
                ships.add(new Ship(getCapacity(),getName()));
                System.out.println("Ship going to tunnel" );
                capacity++;
                executorService.submit(shipGenerator);
                executorService.shutdown();
            }
        } catch (Exception e) {
            System.out.println("Tunnel is full. wait");
            Thread.sleep(5000);
        }
        shipGenerator.run();


    }
}
