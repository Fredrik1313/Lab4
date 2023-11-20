import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestScania {
    Scania Truck = new Scania();

    @Test
    public void testRaisingPlatformAboveLimit(){
        Truck.raiseLoadingPlatform(80);
        assertEquals(70, Truck.trailerAngle, 1e-6);
    }

    @Test
    public void testLoweringPlatformBelowLimit(){
        Truck.lowerLoadingPlatform(50);
        assertEquals(0, Truck.trailerAngle, 1e-6);
    }

    @Test
    public void testRaisingPlatform(){
        Truck.raiseLoadingPlatform(50);
        assertEquals(50, Truck.trailerAngle, 1e-6);
    }

    @Test
    public void testGasWithTrailerAngle(){
        Truck.raiseLoadingPlatform(10);
        Truck.gas(0.5);
        assertEquals(0, Truck.currentSpeed, 1e-6);
    }


    @Test
    public void testTrailerAngleWhileMoving(){
        Truck.gas(0.5);
        Truck.raiseLoadingPlatform(50);
        assertEquals(0, Truck.trailerAngle, 1e-6);
    }

    @Test
    public void testMaxSpeed() {
        for (int i = 0; i < 101; i++) {
            Truck.gas(1);
        }
        assertEquals(90, Truck.currentSpeed, 1e-6);
    }
}