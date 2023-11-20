import java.util.ArrayList;
import java.util.List;

public class Workshop {

    private Class<? extends Car>[] acceptedCars;
    private List<Car> cars;
    private int carCapacity;

    public Workshop(int carCapacity, Class<? extends Car>[] acceptedCars) {
        this.cars = new ArrayList<>();
        this.carCapacity = carCapacity;
        this.acceptedCars = acceptedCars;
    }

    public List<Car> getCars() {
        return new ArrayList<>(cars);
    }

    private boolean carTypeValid(Car car) {
        for (Class<? extends Car> validCar : acceptedCars) {
            if (validCar.isInstance(car)) {
                return true;
            }
        }
        return false;
    }

    public void loadCar(Car car) {
        if (!carTypeValid(car)) {
            throw new IllegalArgumentException("This type of car cannot be loaded into this workshop");
        }
        if (cars.size() < carCapacity) {
            cars.add(car);
        }
    }

    public void unloadCar(Car car) {
        if (cars.contains(car)) {
            cars.remove(car);
        }
        else {
            throw new IllegalArgumentException("This car is not present in the workshop");
        }
    }
}
