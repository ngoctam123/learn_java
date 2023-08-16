package fa.training.entities;

public class FixedWing extends Airplane {
    public FixedWing(String id, String model, String planeType, int cruiseSpeed, int emptyWeight, int maxTakeoffWeight, int minNeededRunwaySize, String flyMethod) {
        super(id, model, planeType, cruiseSpeed, emptyWeight, maxTakeoffWeight, minNeededRunwaySize, flyMethod);
    }
}
