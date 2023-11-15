import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestCar {
    Car car = new Volvo240();

    @Test
    public void testStartEngine() {
        car.startEngine();
        assertEquals(0.1, car.currentSpeed, 1e-6);
    }

    @Test
    public void testStopEngine() {
        car.stopEngine();
        assertEquals(0, car.currentSpeed, 1e-6);
    }

    @Test
    public void testTurnLeft() {
        car.turnLeft();
        assertEquals(5, car.direction, 1e-6);
        car.turnLeft();
        assertEquals(10, car.direction, 1e-6);
    }

    @Test
    public void testTurnRight() {
        car.turnRight();
        assertEquals(-5, car.direction, 1e-6);
        car.turnRight();
        assertEquals(-10, car.direction, 1e-6);
    }

    @Test
    public void testMove() {
        car.startEngine();
        car.turnRight();
        car.gas(0.5);
        car.move();
        assertEquals(0.722241, car.x, 1E-4);
        assertEquals(-0.063188, car.y, 1E-4);
    }
}