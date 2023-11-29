import java.awt.*;
import java.awt.geom.Point2D;
import java.util.ArrayList;

// This is our model of the MVC
public class Model {
    private ArrayList<AnimatedVehicle> vehicles;

    public Model(){
        vehicles = new ArrayList<AnimatedVehicle>();
        vehicles.add(new AnimatedVehicle(new Saab95(), "pics/Saab95.jpg", new Point(0, 0)));
        vehicles.add(new AnimatedVehicle(new Volvo240(), "pics/Volvo240.jpg", new Point(0, 100)));
        vehicles.add(new AnimatedVehicle(new Scania(), "pics/Scania.jpg", new Point(0, 200)));
    }

    public ArrayList<AnimatedVehicle> getVehicles(){
        return vehicles;
    }

    public void gasAll(double amount){
        for (AnimatedVehicle vehicle : vehicles){
            vehicle.getVehicle().gas(amount);
        }
    }

    public void brakeAll(double amount){
        for (AnimatedVehicle vehicle : vehicles){
            vehicle.getVehicle().brake(amount);
        }
    }
    // Calls the stop method for all vehicle
    void stopAll() {;
        for (AnimatedVehicle vehicle : vehicles){
            vehicle.getVehicle().stopEngine();
        }
    }
    // Calls the start method for all vehicle
    void startAll() {;
        for (AnimatedVehicle vehicle : vehicles){
            vehicle.getVehicle().startEngine();
        }
    }
    // Calls the turbo off method for all vehicle
    void turboOffAll() {;
        for (AnimatedVehicle vehicle : vehicles){
            MotorVehicle realVehicle = vehicle.getVehicle();
            if (realVehicle instanceof Saab95){
                ((Saab95)realVehicle).setTurboOff();
            }
        }
    }
    // Calls the turbo on method for all vehicle
    void turboOnAll() {;
        for (AnimatedVehicle vehicle : vehicles){
            MotorVehicle realVehicle = vehicle.getVehicle();
            if (realVehicle instanceof Saab95){
                ((Saab95)realVehicle).setTurboOn();
            }
        }
    }

    // Calls the lift bed method for all vehicle
    void liftBedAll() {;
        for (AnimatedVehicle vehicle : vehicles){
            MotorVehicle realVehicle = vehicle.getVehicle();
            if (realVehicle instanceof Scania){
                ((Scania)realVehicle).raiseLoadingPlatform(5);
            }
        }
    }

    // Calls the lower bed method for all vehicle
    void lowerBedAll() {;
        for (AnimatedVehicle vehicle : vehicles){
            MotorVehicle realVehicle = vehicle.getVehicle();
            if (realVehicle instanceof Scania){
                ((Scania)realVehicle).lowerLoadingPlatform(5);
            }
        }
    }


    public void moveAll(){
        for (AnimatedVehicle vehicle : vehicles) {
            vehicle.getVehicle().move();
            Point2D pos = vehicle.getVehicle().getPosition();
            int x = (int) Math.round(pos.getX());
            int y = (int) Math.round(pos.getY());
            vehicle.moveit(x, y);
        }

    }
}