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
        assertEquals(90, car.direction, 1e-6);
        car.turnLeft();
        assertEquals(180, car.direction, 1e-6);
    }

    @Test
    public void testTurnRight() {
        car.turnRight();
        assertEquals(-90, car.direction, 1e-6);
        car.turnRight();
        assertEquals(-180, car.direction, 1e-6);
    }

    @Test
    public void testMove() {
        car.startEngine();
        car.turnRight();
        car.gas(0.5);
        car.move();
        assertEquals(0.00000000, car.x, 1e-6);
        assertEquals(-0.725    , car.y, 1e-6);
    }
}