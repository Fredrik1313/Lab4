import java.awt.*;
import java.awt.geom.Point2D;
import java.util.ArrayList;

// This is our model of the MVC
public class Model {
    private ArrayList<AnimatedVehicle> vehicles;

    public Model(){
        vehicles = new ArrayList<AnimatedVehicle>();
        vehicles.add(new AnimatedVehicle(new Saab95  (new Point2D.Double(0,  0)), "pics/Saab95.jpg"));
        vehicles.add(new AnimatedVehicle(new Volvo240(new Point2D.Double(0,100)), "pics/Volvo240.jpg"));
        vehicles.add(new AnimatedVehicle(new Scania  (new Point2D.Double(0,200)), "pics/Scania.jpg"));
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

    // Calls the lift bed method for all Scania vehicles
    void liftBedAll() {;
        for (AnimatedVehicle vehicle : vehicles){
            MotorVehicle realVehicle = vehicle.getVehicle();
            if (realVehicle instanceof Scania){
                ((Scania)realVehicle).raiseBed(10);
            }
        }
    }

    // Calls the lower bed method for all Scania vehicles
    void lowerBedAll() {;
        for (AnimatedVehicle vehicle : vehicles){
            MotorVehicle realVehicle = vehicle.getVehicle();
            if (realVehicle instanceof Scania){
                ((Scania)realVehicle).lowerBed(10);
            }
        }
    }

    // Calls the move method for all vehicles
    public void moveAll(){
        for (AnimatedVehicle vehicle : vehicles) {
            vehicle.getVehicle().move();
        }

    }
}