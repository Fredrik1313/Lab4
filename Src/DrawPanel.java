import java.awt.*;
import javax.swing.*;

// This panel represent the animated part of the view with the car images.
public class DrawPanel extends JPanel{
    private Model model;

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y, Model model) {
        this.model = model;
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
    }

    // This method is called each time the panel updates/refreshes/repaints itself
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (model != null) {
            for (AnimatedVehicle vehicle : model.getVehicles()) {
                vehicle.draw(g);
            }
        }
    }
}
