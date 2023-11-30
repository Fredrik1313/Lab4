import java.awt.*;
import java.awt.geom.Point2D;

abstract class Car extends MotorVehicle{
    // Variables
    protected int nrDoors; // Number of doors on the car
    public Car(Point2D.Double position){
        super(position);
    }
    // Methods
    public int getNrDoors(){
        return nrDoors;
    }
}