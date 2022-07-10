import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Ship {
private int id;
    private int loadLevel;
    private int shipSize;
    private String shipType;

    public Ship(int shipSize, String shipType) {
        this.shipSize = shipSize;
        this.shipType = shipType;
    }

    public Ship() {

    }

    public Ship(int id) {
        this.id = id;
    }


    public int getLoadLevel() {
        return loadLevel;
    }

    public int getShipSize() {
        shipSizes[] ships = shipSizes.values();
        int shipSizesidx = shipSizes.values().length;
        int generatedSize = new Random().nextInt(shipSizesidx);
        if (generatedSize == 1) {
            shipSize = 50;
        } else if (generatedSize == 2) {
            shipSize = 100;
        } else {
            shipSize = 150;
        }
        return shipSize;
    }

    public String getShipType() {
        int types = shiptypes.values().length;
        int shipsIndex = new Random().nextInt(shiptypes.values().length);
        if (shipsIndex == 0) {
            shipType = String.valueOf(shiptypes.TANKER);
        } else if (shipsIndex == 1) {
            shipType = String.valueOf(shiptypes.CRUISE);

        } else {
            shipType = String.valueOf(shiptypes.CONTAINERS);
        }
        return shipType;
    }

    @Override
    public String toString() {
        return "Ship{" +
                "shipSize=" + shipSize +
                ", shipType='" + shipType + '\'' +
                '}';
    }

  // @Override
  // public void run() {
  //     ShipGenerator shipGenerator = new ShipGenerator();
  //     shipGenerator.run();
  // }
}

class ShipGenerator implements Runnable {
    ArrayBlockingQueue<Ship> generatedShips = new ArrayBlockingQueue<>(5);
    private int id;
    public ShipGenerator(){}

    public ArrayBlockingQueue<Ship> getGeneratedShips() {
        return generatedShips;
    }

    public void shipGenerator() throws InterruptedException {
        ShipGenerator shipGenerator = new ShipGenerator();
        shipGenerator.run();
        ExecutorService executorService = Executors.newFixedThreadPool(5);


        for (int i = 0; i < 4; i++)
            executorService.submit(new ShipGenerator(i));
            executorService.shutdown();
    }

    public ShipGenerator(int id) {
        this.id = id;
    }


    @Override
    public void run() {


        try {
                            Ship ship = new Ship();
                            ship.getShipSize();
                            ship.getShipType();
                            generatedShips.put(ship);
                            System.out.println("Ship is created " + ship);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }





    }
