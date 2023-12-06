import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;


public class Saab95 extends Car{
    private boolean turboOn; // If turbo is on or off
    private BufferedImage image;
    public void setTurboOn(){
        turboOn = true;
    }
    public void setTurboOff(){
        turboOn = false;}


    public Saab95(Point2D.Double position){
        super(position);
        nrDoors = 2;
        color = Color.red;
        enginePower = 125;
	    turboOn = false;
        modelName = "Saab95";
        //image = "pics/Saab95.jpg";
        stopEngine();
    }


    @Override
    public double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return enginePower * 0.01 * turbo;
    }
}
