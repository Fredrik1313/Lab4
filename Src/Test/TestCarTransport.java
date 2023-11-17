import org.junit.Test;
import static org.junit.Assert.assertEquals;
public class TestCarTransport {
    CarTransport Truck = new CarTransport();
    @Test
    public void testGas(){
        Truck.gas(0.5);
        assertEquals(0.45, Truck.currentSpeed, 1e-6);
    }

    @Test
    public void testBrake(){
        Truck.brake(0.5);
        assertEquals(0, Truck.currentSpeed, 1e-6);
    }
}
