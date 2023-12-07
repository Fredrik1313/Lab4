import java.awt.*;
import java.awt.geom.Point2D;

abstract class MotorVehicle implements Movable {
    // Variables
    protected double enginePower; // Engine power of the car
    protected double currentSpeed; // The current speed of the car
    protected Color color; // Color of the car
    protected String modelName; // The car model name
    abstract double speedFactor(); //
    protected double x; // The car's x-coordinate
    protected double y; // The car's y-coordinate
    protected double direction = 0.0; // The car's driving direction
    public boolean goingBack = false;
    private final static double TURNANGLE = 90.0; // Angle step size

    // Methods
    public double getEnginePower() {
        return enginePower;
    }
    public double getCurrentSpeed() {
        return currentSpeed;
    }
    public Color getColor(){
        return color;
    }
    public Point2D.Double getPosition(){
        return new Point2D.Double(x,y);
    }
    public void setColor(Color clr){color = clr;}
    public void startEngine(){
        if (!goingBack){
            currentSpeed = 0.1;
        } else{
            currentSpeed = -0.1;
        }
    }
    public void setGoingBack(){
        goingBack = !goingBack;
    }
    // Help method
    protected double limitTo(double value, double min, double max) {
        return Math.max(Math.min(value, max), min);
    }
    protected void incrementSpeed(double amount) {
        currentSpeed = limitTo((currentSpeed + speedFactor() * amount),0.0, enginePower);
    }
    protected void negativeIncrementSpeed(double amount) {
        currentSpeed = limitTo((currentSpeed + speedFactor() * amount),-enginePower, 0);
    }

    public MotorVehicle(Point2D.Double position){
        x = position.x;
        y = position.y;
    }
    protected void decrementSpeed(double amount) {
        currentSpeed = limitTo((currentSpeed - speedFactor() * amount),0.0, enginePower);
    }
    protected void negativeDecrementSpeed(double amount) {
        currentSpeed = limitTo((currentSpeed - speedFactor() * amount),-enginePower, 0);
    }

    public void gas(double amount){
        if ((amount >= 0) && (amount <= 1)) {
            if (!goingBack) {
                incrementSpeed(amount);
            } else {
                negativeIncrementSpeed(-amount);
            }
        }
    }
    public void brake(double amount){
        if ((amount >= 0) && (amount <= 1)) {
            if (!goingBack){
                decrementSpeed(amount);
            } else {
                negativeDecrementSpeed(-amount);
            }

        }
    }
    public void stopEngine(){
        currentSpeed = 0;
    }
    public void  move(){
        double distance = currentSpeed;
        double radianDirection = Math.toRadians(direction);
        x += Math.cos(radianDirection) * distance;
        y += Math.sin(radianDirection) * distance;
    }
    public void turnLeft(){
        direction += TURNANGLE;
    }
    public void turnRight(){
        direction -= TURNANGLE;
    }
}
