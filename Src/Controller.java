/*
 * This class represents the Controller part in the MVC pattern.
 * It is responsibilities is to listen to the View and responds in an appropriate manner by
 * modifying the model state and the updating the view.
 */
public class Controller {
    // The model of the MVC pattern
    Model model;

    public Controller(Model model) {
        // Store a reference to the MVC model
        this.model = model;
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
    void stopAll() {
        model.stopAll();
    }
    // Calls the start method for all vehicle
    void startAll() {
        model.startAll();
    }
    // Calls the turbo off method for all vehicle
    void turboOffAll() {
        model.turboOffAll();
    }
    // Calls the turbo on method for all vehicle
    void turboOnAll() {
        model.turboOnAll();
    }
    void liftBedAll() {
        model.liftBedAll();
    }
    void lowerBedAll() {
        model.lowerBedAll();
    }

}
