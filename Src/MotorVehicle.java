import java.awt.*;

abstract class MotorVehicle implements Movable {
    // Variables
    protected double enginePower; // Engine power of the car
    protected double currentSpeed; // The current speed of the car
    protected Color color; // Color of the car
    protected String modelName; // The car model name
    abstract double speedFactor(); //
    protected double x = 0.0; // The car's x-coordinate
    protected double y = 0.0; // The car's y-coordinate
    protected double direction = 0.0; // The car's driving direction
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
    public void setColor(Color clr){color = clr;}
    public void startEngine(){
        currentSpeed = 0.1;
    }
    // Help method
    protected double limitTo(double value, double min, double max) {
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
