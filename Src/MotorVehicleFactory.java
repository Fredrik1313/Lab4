import java.awt.geom.Point2D;
import java.util.Random;

public class MotorVehicleFactory {
    public enum MotorVehicleType{
        Saab95, Volvo240, Scania, CarTransport;

        private static final Random PRNG = new Random();

        public static MotorVehicleType randomMotorVehicleType(){
            MotorVehicleType[] types = values();
            return types[PRNG.nextInt(types.length)];
        }
    }

    public MotorVehicle create(MotorVehicleType type, Point2D.Double position){
        switch (type){
            case Saab95: return new Saab95(position);
            case Volvo240: return new Volvo240(position);
            case Scania: return new Scania(position);
            case CarTransport: return new CarTransport(position);
        }
        return null;
    }
    public MotorVehicle createRandomMotorVehicle(Point2D.Double position){
     return create(MotorVehicleType.randomMotorVehicleType(), position);
    }
}
