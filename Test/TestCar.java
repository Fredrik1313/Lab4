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
        car.turnLeft(45);
        assertEquals(45, car.direction, 1e-6);
        car.turnLeft(-45);
        assertEquals(0, car.direction, 1e-6);
    }

    @Test
    public void testTurnRight() {
        car.turnRight(45);
        assertEquals(-45, car.direction, 1e-6);
        car.turnRight(-45);
        assertEquals(0, car.direction, 1e-6);
    }

    @Test
    public void testMove() {
        car.startEngine();
        car.turnRight(45);
        car.move(10);
        assertEquals(0.70711, car.x, 1E-4);
        assertEquals(-0.70711, car.y, 1E-4);
    }

    @Test
    public void testMoveNegativeTime() {
        car.startEngine();
        car.move(-10);
        assertEquals(0, car.x, 1e-6);
        assertEquals(0, car.y, 1e-6);
    }
}