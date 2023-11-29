/*
 * This class represents the Controller part in the MVC pattern.
 * It's responsibilities is to listen to the View and responds in a appropriate manner by
 * modifying the model state and the updating the view.
 */

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Point2D;

public class Controller {
    // The model of the MVC pattern
    Model model;
    View view;

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with a listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    public Controller(Model model) {
        // Store a reference to the MVC model
        this.model = model;
    }

    public void setView(View view){
        // Store a reference to the MVC view
        this.view = view;
    }
    public void startTimer(){
        // Start the timer
        timer.start();
    }

    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            model.moveAll();
            view.reDraw();
        }
    }

    // Calls the gas method for all vehicle
    void gasAll(double amount) {
        model.gasAll(amount);
    }

    // Calls the brake method for all vehicle
    void brakeAll(double amount) {
        model.brakeAll(amount);
    }
    // Calls the stop method for all vehicle
    void stopAll() {;
        model.stopAll();
    }
    // Calls the start method for all vehicle
    void startAll() {;
        model.startAll();
    }
    // Calls the turbo off method for all vehicle
    void turboOffAll() {;
        model.turboOffAll();
    }
    // Calls the turbo on method for all vehicle
    void turboOnAll() {;
        model.turboOnAll();
    }
    void liftBedAll() {;
        model.liftBedAll();
    }
    void lowerBedAll() {;
        model.lowerBedAll();
    }

}
