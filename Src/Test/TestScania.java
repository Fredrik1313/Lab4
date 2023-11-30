import org.junit.Test;

import java.awt.geom.Point2D;

import static org.junit.Assert.assertEquals;

public class TestScania {
    Scania Truck = new Scania(new Point2D.Double(0,  0));

    @Test
    public void testRaisingPlatformAboveLimit(){
        Truck.raiseBed(80);
        assertEquals(70, Truck.bedAngle, 1e-6);
    }

    @Test
    public void testLoweringPlatformBelowLimit(){
        Truck.lowerBed(50);
        assertEquals(0, Truck.bedAngle, 1e-6);
    }

    @Test
    public void testRaisingPlatform(){
        Truck.raiseBed(50);
        assertEquals(50, Truck.bedAngle, 1e-6);
    }

    @Test
    public void testGasWithTrailerAngle(){
        Truck.raiseBed(10);
        Truck.gas(0.5);
        assertEquals(0, Truck.currentSpeed, 1e-6);
    }


    @Test
    public void testTrailerAngleWhileMoving(){
        Truck.gas(0.5);
        Truck.raiseBed(50);
        assertEquals(0, Truck.bedAngle, 1e-6);
    }

    @Test
    public void testMaxSpeed() {
        for (int i = 0; i < 101; i++) {
            Truck.gas(1);
        }
        assertEquals(90, Truck.currentSpeed, 1e-6);
    }
}