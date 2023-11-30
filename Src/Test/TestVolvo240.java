import org.junit.Test;

import java.awt.geom.Point2D;

import static org.junit.Assert.assertEquals;

public class TestVolvo240 {
    Volvo240 car = new Volvo240(new Point2D.Double(0,  0));

    @Test
    public void testGas() {
        car.gas(0.5);
        assertEquals(0.625, car.currentSpeed, 1e-6);
    }

    @Test
    public void testBrake() {
        car.gas(0.5);
        car.brake(0.5);
        assertEquals(0, car.currentSpeed, 1e-6);
    }

    @Test
    public void testGasAboveLimit() {
        car.gas(2);
        assertEquals(0, car.currentSpeed, 1e-6);
    }

    @Test
    public void testBrakeBelowLimit() {
        car.brake(2);
        assertEquals(0, car.currentSpeed, 1e-6);
    }

    @Test
    public void testNegativeGas() {
        car.gas(-1);
        assertEquals(0, car.currentSpeed, 1e-6);
    }

    @Test
    public void testNegativeBrake() {
        car.brake(-1);
        assertEquals(0, car.currentSpeed, 1e-6);
    }

    @Test
    public void testMaxSpeed() {
        for (int i = 0; i < 81; i++) {
            car.gas(1);
        }
        assertEquals(100, car.currentSpeed, 1e-6);
    }
}
