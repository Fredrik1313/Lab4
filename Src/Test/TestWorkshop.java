import org.junit.Test;
import static org.junit.Assert.*;

public class TestWorkshop {

    @Test
    public void testLoadCar() {
        Workshop workshop = new Workshop(5);
        Saab95 Saab95 = new Saab95();

        workshop.loadCar(Saab95);
        assertTrue(workshop.getCars().contains(Saab95));
    }

    @Test
    public void testLoadCarInvalidType() {
        Volvo240 Volvo240 = new Volvo240();
        Saab95 Saab95 = new Saab95();
        Workshop<Volvo240> workshop = new Workshop<>(5);
        workshop.loadCar(Volvo240);
        workshop.loadCar(Saab95);
    }

    @Test
    public void testUnloadCarPresent() {
        Workshop workshop = new Workshop(5);
        Saab95 car = new Saab95();

        workshop.loadCar(car);
        workshop.unloadCar(car);

        assertFalse(workshop.getCars().contains(car));
    }

    @Test
    public void testUnloadCarNotPresent() {
        Workshop workshop = new Workshop(5);
        Saab95 car = new Saab95();

        assertThrows(IllegalArgumentException.class, () -> workshop.unloadCar(car));
    }
}