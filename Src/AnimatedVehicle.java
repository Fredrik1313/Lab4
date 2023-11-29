import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class AnimatedVehicle {
    private MotorVehicle vehicle;
    private BufferedImage image;
    private Point position;

    public AnimatedVehicle(MotorVehicle vehicle, String imgFileName, Point position){
        this.vehicle = vehicle;
        this.position = position;

        try {
            image = ImageIO.read(DrawPanel.class.getResourceAsStream(imgFileName));

        } catch (IOException ex){
            ex.printStackTrace();
        }
    }

    public MotorVehicle getVehicle() {
        return vehicle;
    }

    public Point getPosition() {
        return position;
    }

    public void moveit(int x, int y){
        position.x = x;
        position.y = y;
    }

    public void draw(Graphics g){
        g.drawImage(image, position.x, position.y, null);
    }
}
