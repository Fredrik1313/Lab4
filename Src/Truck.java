import java.awt.geom.Point2D;

abstract class Truck extends MotorVehicle {
    // Variables
    protected int nrDoors; // Number of doors on the car

    public Truck(Point2D.Double position){
        super(position);
    }

    // Methods
    public int getNrDoors(){
        return nrDoors;
    }
}
