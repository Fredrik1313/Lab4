import java.util.ArrayList;
import java.util.List;

public class Workshop<C extends Car> {

    private List<C> cars;
    private int carCapacity;

    public Workshop(int carCapacity) {
        this.cars = new ArrayList<>();
        this.carCapacity = carCapacity;
    }

    public List<C> getCars() {
        return new ArrayList<>(cars);
    }

    public void loadCar(C car) {
        if (cars.size() < carCapacity) {
            cars.add(car);
        } else {
            throw new IllegalStateException("Workshop is at full capacity, cannot load more cars");
        }
    }

    public void unloadCar(C car) {
        if (cars.contains(car)) {
            cars.remove(car);
        } else {
            throw new IllegalArgumentException("This car is not present in the workshop");
        }
    }
}
