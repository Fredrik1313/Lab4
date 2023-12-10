import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.util.Stack;

public class CarTransport extends Truck {

    protected boolean rampOpen = false;
    private Stack<Car> carsLoaded = new Stack<>();
    protected final int MAXLOAD = 8;
    private final double MAXDISTANCE = 10;
    private final double CARSPACING = 6.0;
    private static BufferedImage image = null;
    private static final String IMGFILENAME = "pics/Scania.jpg";

    public CarTransport(Point2D.Double position){
        super(position);
        nrDoors = 2;
        color = Color.orange;
        enginePower = 90;
        modelName = "CarTransport";
        if (image == null){
            image = readImage(IMGFILENAME);
        }
        stopEngine();
    }

    public void loadCar(Car car) {
        if (rampOpen && (carsLoaded.size() < MAXLOAD) &&
                (Math.abs(x - car.x) < MAXDISTANCE) && (Math.abs(y - car.y) < MAXDISTANCE)) {
            carsLoaded.push(car);
        }
    }

    public void unloadCars(int nCars) {
        if (rampOpen) {
            double radianDirection = Math.toRadians(direction);
            double dx = Math.cos(radianDirection) * CARSPACING;
            double dy = Math.sin(radianDirection) * CARSPACING;
            for (int i = nCars; (i > 0) && !carsLoaded.empty(); i--) {
                Car car = carsLoaded.pop();
                car.x -= dx * i;
                car.y -= dy * i;
            }
        }
    }

    public int getNumberCarsLoaded() {
        return carsLoaded.size();
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
    public void move() {
        super.move();
        for (Car car : carsLoaded) {
            car.x = x;
            car.y = y;
        }
    }

    @Override
    public double speedFactor() {
        if (!rampOpen) {
            return 0.01 * enginePower;
        } else {
            return 0.0;
        }
    }

    public BufferedImage getImage(){
        return image;
    }
}
