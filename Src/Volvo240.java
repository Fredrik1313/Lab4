import java.awt.*;

public class Volvo240 extends Car{
    private final static double trimFactor = 1.25;
    public Volvo240(){
        nrDoors = 4;
        color = Color.black;
        enginePower = 100;
        modelName = "Volvo240";
        this.x = 0;
        this.y = 100;
        stopEngine();
    }
    @Override
    public double speedFactor(){
        return enginePower * 0.01 * trimFactor;
    }
}
