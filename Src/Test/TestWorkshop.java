import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestWorkshop {

    @Test
    public void testLoadCarValidType() {
        Class<? extends Car>[] acceptedCars = new Class[]{Saab95.class, Volvo240.class};
        Workshop workshop = new Workshop(5, acceptedCars);
        Saab95 car = new Saab95();

        workshop.loadCar(car);
        assertTrue(workshop.getCars().contains(car));
    }

    @Test
    public void testLoadCarInvalidType() {
        Class<? extends Car>[] acceptedCars = new Class[]{Saab95.class, Volvo240.class};
        Workshop workshop = new Workshop(5, acceptedCars);
        Scania truck = new Scania();

        assertThrows(IllegalArgumentException.class, () -> workshop.loadCar(truck));
    }

    @Test
    public void testUnloadCarPresent() {
        Class<? extends Car>[] acceptedCars = new Class[]{Saab95.class, Volvo240.class};
        Workshop workshop = new Workshop(5, acceptedCars);
        Saab95 car = new Saab95();

        workshop.loadCar(car);
        workshop.unloadCar(car);

        assertFalse(workshop.getCars().contains(car));
    }

    @Test
    public void testUnloadCarNotPresent() {
        Class<? extends Car>[] acceptedCars = new Class[]{Saab95.class, Volvo240.class};
        Workshop workshop = new Workshop(5, acceptedCars);
        Saab95 car = new Saab95();

        assertThrows(IllegalArgumentException.class, () -> workshop.unloadCar(car));
    }
}
