import org.junit.Test;
public class testSaab95 {
    Saab95 car = new Saab95();
    @Test
    public void testGasWithTurbo() {
        car.setTurboOn();
        car.gas(0.5);
        assertEquals(0.8125, car.currentSpeed);
    }

    @Test
    public void testGasWithoutTurbo() {
        car.gas(0.5);
        assertEquals(0.625, car.currentSpeed);
    }

    @Test
    public void testBrakeWithTurbo() {
        car.setTurboOn();
        car.gas(0.5);
        car.brake(0.5);
        assertEquals(0, car.currentSpeed);
    }

    @Test
    public void testBrakeWithoutTurbo() {
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
        for (int i = 0; i < 101; i++) {
            car.gas(1);
        }
        assertEquals(125, car.currentSpeed);
    }
}
