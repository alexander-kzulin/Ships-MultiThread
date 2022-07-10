import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Pierse implements Runnable{
    private ArrayBlockingQueue<Ship> generatedShips;
    private int pierseId;
    private String pierseName;
    public Pierse(int pierseId, String pierseName) {
        this.pierseId = pierseId;
        this.pierseName = pierseName;

    }

    @Override
    public void run() {

        ShipGenerator shipGenerator  = new ShipGenerator();
generatedShips.co
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        System.out.println();
    }
}
