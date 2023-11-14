import java.awt.*;

public class Scania extends Car{

    private double trailerAngle = 0.0;

    public Scania(){
        nrDoors = 2;
        color = Color.black;
        enginePower = 100;
        modelName = "Scania"; 
        stopEngine();
    }

    public void setTrailerAngle(double degAngle) {
        if (currentSpeed == 0 && degAngle >= 0 && degAngle <= 70) {
            trailerAngle = degAngle;
        }
    }

    @Override
    public double speedFactor(){
        if (trailerAngle == 0) {
            return enginePower;
        }   
        else {
            return 0.0;
        }
    }
}
