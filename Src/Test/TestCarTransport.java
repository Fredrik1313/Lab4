import org.junit.Test;
import static org.junit.Assert.*;


public class TestCarTransport {
    CarTransport Truck = new CarTransport();
    Saab95 saab = new Saab95();
    Volvo240 volvo = new Volvo240();

    @Test
    public void testGasWithOpenRamp(){
        Truck.openRamp();
        Truck.gas(0.5);
        assertEquals(0, Truck.currentSpeed, 1e-6);
    }

    @Test
    public void testOpenRampWhileMoving(){
        Truck.gas(0.5);
        Truck.openRamp();
        assertFalse(Truck.rampOpen);
    }

    @Test
    public void testLoadCar(){
        Truck.openRamp();
        Truck.loadCar(saab);
        Truck.loadCar(volvo);
        assertEquals(2, Truck.getNumberCarsLoaded());
    }

    @Test
    public void testLoadCarWithClosedRamp(){
        Truck.closeRamp();
        Truck.loadCar(volvo);
        assertEquals(0, Truck.getNumberCarsLoaded());
    }

    @Test
    public void testUnloadCar(){
        Truck.openRamp();
        Truck.loadCar(saab);
        Truck.unloadCars(1);
        assertEquals(0, Truck.getNumberCarsLoaded());
    }

    @Test
    public void testLoadLimit(){
        Truck.openRamp();
        for (int i = 0; i < 20; i++){
            Truck.loadCar(saab);
        }
        assertEquals(8, Truck.getNumberCarsLoaded());
    }

    @Test
    public void testUnloadCarPosition(){
        Truck.openRamp();
        Truck.loadCar(saab);
        Truck.loadCar(volvo);
        Truck.unloadCars(2);

        assertNotEquals(saab.x, volvo.x);
        assertEquals(saab.y, volvo.y, 1e-6);
    }
}