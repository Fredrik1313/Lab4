import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class Saab95 extends Car{
    private boolean turboOn; // If turbo is on or off
    private static BufferedImage image = null;
    private static final String IMGFILENAME = "pics/Saab95.jpg";
    public void setTurboOn(){
        turboOn = true;
    }
    public void setTurboOff(){
        turboOn = false;
    }

    public Saab95(Point2D.Double position){
        super(position);
        nrDoors = 2;
        color = Color.red;
        enginePower = 125;
	    turboOn = false;
        modelName = "Saab95";
        stopEngine();
        if (image == null){
            image = readImage(IMGFILENAME);
        }


    }
    @Override
    public double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return enginePower * 0.01 * turbo;
    }


    public BufferedImage getImage(){
        return image;
    }
}