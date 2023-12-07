import java.awt.*;
import java.awt.geom.Point2D;

public class Volvo240 extends Car{
    private final static double trimFactor = 1.25;
    private String imgFileName;
    public Volvo240(Point2D.Double position){
        super(position);
        nrDoors = 4;
        color = Color.black;
        enginePower = 100;
        modelName = "Volvo240";
        imgFileName = "pics/Volvo240.jpg";
        stopEngine();
    }

    @Override
    public double speedFactor(){
        return enginePower * 0.01 * trimFactor;
    }
}
