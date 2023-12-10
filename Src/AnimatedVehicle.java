import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class AnimatedVehicle {
    private MotorVehicle vehicle;

    public AnimatedVehicle(MotorVehicle vehicle){
        this.vehicle = vehicle;

    }

    public MotorVehicle getVehicle() {
        return vehicle;
    }


    public void draw(DrawPanel panel, Graphics g){
        BufferedImage image = vehicle.getImage();
        Point2D.Double position = vehicle.getPosition();
        int x = (int)position.x, y = (int)position.y;
        if((x<0) || (x+image.getWidth() >= panel.getWidth())){
            vehicle.currentSpeed = -vehicle.currentSpeed;
            vehicle.setGoingBack();
        }
        g.drawImage(image, (int)position.x, (int)position.y, null);
    }
}
