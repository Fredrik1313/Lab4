import java.awt.*;

public class CarTransport extends Truck{

    protected boolean rampOpen = false;
    private final Car[] carsLoaded = new Car[8];
    protected int nCarsLoaded = 0;
    private double distanceThreshold = 10;

    public CarTransport(){
        nrDoors = 2;
        color = Color.orange;
        enginePower = 90;
        modelName = "CarTransport";
        stopEngine();
    }

    public void loadCar(Car vehicle){
        if (rampOpen && nCarsLoaded < carsLoaded.length &&
                Math.abs(x-vehicle.x) < distanceThreshold && Math.abs(y-vehicle.y) < distanceThreshold){
            carsLoaded[nCarsLoaded] = vehicle;
            nCarsLoaded++;
        }
    }
    public void unloadCar(int nCars){
        if (rampOpen && nCarsLoaded > 0){
            for (int i = 0; i < nCars; i++) {
                nCarsLoaded--;
                carsLoaded[nCarsLoaded - 1].y -= distanceThreshold;
                carsLoaded[nCarsLoaded - 1].x += distanceThreshold * i;
                carsLoaded[nCarsLoaded - 1] = null;
            }
        }
    }
    public void openRamp(){
        if (currentSpeed == 0){
            rampOpen = true;
        }
    }
    public void closeRamp(){
        if (currentSpeed == 0){
            rampOpen = false;
        }
    }
    @Override
    public void move(){
        super.move();

        for (int i = 0; i < nCarsLoaded; i++){
            carsLoaded[i].x = x;
            carsLoaded[i].y = y;
        }
    }
    @Override
    public double speedFactor(){
        if (!rampOpen){
            return super.speedFactor();
        }
        else {
            return 0.0;
        }
    }
}
