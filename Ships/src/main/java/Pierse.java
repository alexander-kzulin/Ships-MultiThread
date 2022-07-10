import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Pierse implements Runnable{
    private int pierseId;
    private String pierseName;
    public Pierse(int pierseId, String pierseName) {
        this.pierseId = pierseId;
        this.pierseName = pierseName;

    }




    public Pierse() {

    }


    @Override
    public void run() {

        ShipGenerator shipGenerator = new ShipGenerator();
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for(Ship ship : shipGenerator.getGeneratedShips() ){
            try {
                shipGenerator.getGeneratedShips().put(new Ship());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            executorService.submit(new Pierse());
            System.out.println("Ship going to pierse");
            executorService.shutdown();
        }
    }

    }

