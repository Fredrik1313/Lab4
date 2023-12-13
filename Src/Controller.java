
public class Controller implements ControllerObserver {
    // The model of the MVC pattern
    Model model;

    public Controller(Model model, View view) {
        // Store a reference to the MVC model
        this.model = model;
        view.addControllerObserver(this);
    }
    // Calls the gas method for all vehicle
    public void gasAll(double amount) {
        model.gasAll(amount);
    }

    // Calls the brake method for all vehicle
    public void brakeAll(double amount) {
        model.brakeAll(amount);
    }
    // Calls the stop method for all vehicle
    public void stopAll() {
        model.stopAll();
    }
    // Calls the start method for all vehicle
    public void startAll() {
        model.startAll();
    }
    // Calls the add car method for all vehicle
    public void addCar(){
        model.addCar();
    }
    public void removeCar(){
        model.removeCar();
    }
    // Calls the turbo off method for all vehicle
    public void turboOffAll() {
        model.turboOffAll();
    }
    // Calls the turbo on method for all vehicle
    public void turboOnAll() {
        model.turboOnAll();
    }
    public void liftBedAll() {
        model.liftBedAll();
    }
    public void lowerBedAll() {
        model.lowerBedAll();
    }

}
