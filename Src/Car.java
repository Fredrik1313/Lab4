import java.awt.*;

abstract class Car extends MotorVehicle{
    public Car(){
        this.x = x;
        this.y = y;
    }
    // Variables
    protected int nrDoors; // Number of doors on the car
    // Methods
    public int getNrDoors(){
        return nrDoors;
    }
}