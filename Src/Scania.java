import java.awt.*;

public class Scania extends Truck{
    protected double trailerAngle; // The angle of the loading platform
    public Scania(){
        nrDoors = 2;
        color = Color.black;
        enginePower = 90;
        modelName = "Scania";
        stopEngine();
    }
    public void lowerLoadingPlatform(double angle){
        if (currentSpeed == 0) {
            trailerAngle = limitTo(trailerAngle - angle, 0, 70);
        }
    }
    public void raiseLoadingPlatform(double angle){
        if (currentSpeed == 0) {
            trailerAngle = limitTo(trailerAngle + angle, 0, 70);
        }
    }
    public double speedFactor(){
        if (trailerAngle == 0){
            return 0.01 * enginePower;
        }
        else{
            return 0.0;
        }
    }
}
