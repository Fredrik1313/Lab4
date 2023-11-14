import java.awt.*;

public class CarTransport extends Car{

    private boolean rampOpen = false;
    private Car[] carsLoaded = new Car[8];
    private int nCarsLoaded = 0;

    public CarTransport(){
        nrDoors = 2;
        color = Color.black;
        enginePower = 100;
        modelName = "CarTransport"; 
        stopEngine();
    }

    public void loadCar(Car vehicle) {
        if (rampOpen && nCarsLoaded < carsLoaded.length && !(vehicle instanceof CarTransport) &&
            Math.abs(x - vehicle.x) < 10 && Math.abs(y - vehicle.y) < 10) {
            carsLoaded[nCarsLoaded] = vehicle;
            nCarsLoaded++; 
        } 
    }
    public void unloadCar() {
        if (rampOpen && nCarsLoaded > 0) { 
            nCarsLoaded--; 
            carsLoaded[nCarsLoaded] = null;
        } 
    }
    public void openRamp() {
        if (currentSpeed == 0) {
            rampOpen = true;
        }
    }
    public void closeRamp() {
        if (currentSpeed == 0) {
            rampOpen = false;
        }
    }
    @Override
    public void move(double duration) {
        super.move(duration);

        for (int i = 0; i < nCarsLoaded; i++) {
            carsLoaded[i].x = x;
            carsLoaded[i].y = y;
        }
    }
    @Override
    public double speedFactor(){
        if (!rampOpen) {
            return enginePower;
        }   
        else {
            return 0.0;
        }
    }
}
