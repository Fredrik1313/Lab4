import org.junit.Test;

public class testCar {
    Car car = new Car();

    @Test
    public void testStartEngine() {
        car.startEngine();
        assertEquals(0.1, car.currentSpeed);
    }

    @Test
    public void testStopEngine() {
        car.stopEngine();
        assertEquals(0, car.currentSpeed);
    }

    @Test
    public void testTurnLeft() {
        car.turnLeft(45);
        assertEquals(-45, car.direction);
        car.turnLeft(-45);
        assertEquals(0, car.direction);
    }

    @Test
    public void testTurnRight() {
        car.turnRight(45);
        assertEquals(45, car.direction);
        car.turnRight(-45);
        assertEquals(0, car.direction);
    }

    @Test
    public void testMove() {
        car.startEngine();
        car.turnRight(45);
        car.move(10);
        assertEquals(0.70711, car.x, 1E-4);
        assertEquals(0.70711, car.y, 1E-4);
    }

    @Test
    public void testMoveNegativeTime() {
        car.startEngine();
        car.move(-10);
        assertEquals(0, car.x);
        assertEquals(0, car.y);
    }
}