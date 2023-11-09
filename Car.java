import java.awt.*;

abstract class Car implements Movable{
    // Variables
    protected int nrDoors; // Number of doors on the car
    protected double enginePower; // Engine power of the car
    protected double currentSpeed; // The current speed of the car
    protected Color color; // Color of the car
    protected String modelName; // The car model name
    public boolean turboOn; // If turbo is on or off
    abstract double speedFactor(); //

    protected double x = 0.0;
    protected double y = 0.0;
    protected double direction = 0.0;

    // Methods
    public int getNrDoors(){
        return nrDoors;
    }
    public double getEnginePower() {
        return enginePower;
    }
    public double getCurrentSpeed() {
        return currentSpeed;
    }
    public Color getColor(){
        return color;
    }
    public void setColor(Color clr){color = clr;}
    public void startEngine(){
        currentSpeed = 0.1;
    }
    public void setTurboOn(){
        turboOn = true;
    }
    public void setTurboOff(){
        turboOn = false;
    }
    // Help method
    private double limitTo(double value, double min, double max) {
        return Math.max(Math.min(value, max), min);
    }
    protected void incrementSpeed(double amount) {
        currentSpeed = limitTo((currentSpeed + speedFactor() * amount),0.0, enginePower);
    }
    protected void decrementSpeed(double amount) {
        currentSpeed = limitTo((currentSpeed - speedFactor() * amount),0.0, enginePower);
    }
    public void gas(double amount){
        if ((amount >= 0) && (amount <= 1)) {
            incrementSpeed(amount);
        }
    }
    public void brake(double amount){
        if ((amount >= 0) && (amount <= 1)) {
            decrementSpeed(amount);
        }
    }
    public void stopEngine(){
        currentSpeed = 0;
    }
    public void  move(double duration){
        double distance = currentSpeed*Math.max(duration, 0);
        double radianDirection = Math.toRadians(direction);
        x += Math.sin(radianDirection) * distance;
        y += Math.cos(radianDirection) * distance;
    }
    public void turnLeft(double angleDeg){
        direction += angleDeg;
    }
    public void turnRight(double angleDeg){
        direction -= angleDeg;
    }
}
