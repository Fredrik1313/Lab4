import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Point2D;

// Bootstrap of the project, contains the main method
public class App {
    // Declare the three parts of the MVC paradign
    Model model;
    View view;
    Controller controller;


    public static void main(String []args) {
        App app = new App();
    }
    public App(){
        // Create the MVC Model
        model = new Model();
        // Create the MVC Controller
        controller = new Controller(model);
        // Create the MVC View
        view = new View("CarSim 1.0", model, controller);

        // Start the animation
        controller.startTimer();
    }
}