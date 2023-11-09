import org.junit.Test;
public class testVolvo240 {
    Volvo240 car = new Volvo240();

    @Test
    public void testGas() {
        car.gas(0.5);
        assertEquals(0.625, car.currentSpeed);
    }

    @Test
    public void testBrake() {
        car.gas(0.5);
        car.brake(0.5);
        assertEquals(0, car.currentSpeed);
    }

    @Test
    public void testGasAboveLimit() {
        car.gas(2);
        assertEquals(1.25, car.currentSpeed);
    }

    @Test
    public void testBrakeBelowLimit() {
        car.brake(2);
        assertEquals(0, car.currentSpeed);
    }

    @Test
    public void testNegativeGas() {
        car.gas(-1);
        assertEquals(0, car.currentSpeed);
    }

    @Test
    public void testNegativeBrake() {
        car.gas(-1);
        assertEquals(0, car.currentSpeed);
    }

    @Test
    public void testMaxSpeed() {
        for (int i = 0; i < 81; i++) {
            car.gas(1);
        }
        assertEquals(100, car.currentSpeed);
    }
}
