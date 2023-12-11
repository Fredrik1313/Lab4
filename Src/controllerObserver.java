public interface controllerObserver {
    void gasAll(double amount);
    void brakeAll(double amount);
    void stopAll();
    void startAll();
    void turboOffAll();
    void turboOnAll();
    void liftBedAll();
    void lowerBedAll();
    void addCar();
    void removeCar();
}
