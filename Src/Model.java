import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Point2D;
import java.util.ArrayList;

// This is our model of the MVC
public class Model {
    private ArrayList<AnimatedVehicle> vehicles;
    private MotorVehicleFactory motorVehicleFactory;
    private ArrayList<RedrawObserver> RedrawObservers;

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with a listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    public Model(){
        vehicles = new ArrayList<AnimatedVehicle>();
        motorVehicleFactory  = new MotorVehicleFactory();
        RedrawObservers = new ArrayList<RedrawObserver>();
        vehicles.add(new AnimatedVehicle(new Saab95  (new Point2D.Double(0,  0))));
        vehicles.add(new AnimatedVehicle(new Volvo240(new Point2D.Double(0,65))));
        vehicles.add(new AnimatedVehicle(new Scania  (new Point2D.Double(0,130))));
    }

    public void startTimer(){
        // Start the timer
        timer.start();
    }

    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            moveAll();
            for (RedrawObserver observer: RedrawObservers){
                observer.redraw();
            }
        }
    }

    public void addRedrawObserver(RedrawObserver observer){
        RedrawObservers.add(observer);
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
    public void stopAll() {
        for (AnimatedVehicle vehicle : vehicles){
            vehicle.getVehicle().stopEngine();
        }
    }
    // Calls the start method for all vehicle
    public void startAll() {
        for (AnimatedVehicle vehicle : vehicles){
            vehicle.getVehicle().startEngine();
        }
    }
    public void addCar() {
        if (vehicles.size() < 10){
            Point2D.Double position = new Point2D.Double(0, vehicles.size()*65);
            if (vehicles.add(new AnimatedVehicle(motorVehicleFactory.createRandomMotorVehicle(position))));
        }
    }
    public void removeCar() {
        if (!vehicles.isEmpty()){
            vehicles.remove(vehicles.size()-1);
        }
    }

    // Calls the turbo off method for all vehicle
    public void turboOffAll() {
        for (AnimatedVehicle vehicle : vehicles){
            MotorVehicle realVehicle = vehicle.getVehicle();
            if (realVehicle instanceof Saab95){
                ((Saab95)realVehicle).setTurboOff();
            }
        }
    }
    // Calls the turbo on method for all vehicle
    public void turboOnAll() {
        for (AnimatedVehicle vehicle : vehicles){
            MotorVehicle realVehicle = vehicle.getVehicle();
            if (realVehicle instanceof Saab95){
                ((Saab95)realVehicle).setTurboOn();
            }
        }
    }

    // Calls the lift bed method for all Scania vehicles
    public void liftBedAll() {
        for (AnimatedVehicle vehicle : vehicles){
            MotorVehicle realVehicle = vehicle.getVehicle();
            if (realVehicle instanceof Scania){
                ((Scania)realVehicle).raiseBed(10);
            }
        }
    }

    // Calls the lower bed method for all Scania vehicles
    public void lowerBedAll() {
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