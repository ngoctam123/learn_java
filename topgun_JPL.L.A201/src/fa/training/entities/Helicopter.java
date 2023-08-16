package fa.training.entities;

public class Helicopter extends Airplane {
    private int range;

    public Helicopter(String id, String model, String planeType, int cruiseSpeed, int emptyWeight, int maxTakeoffWeight, int range, String flyMethod) {
        super(id, model, planeType, cruiseSpeed, emptyWeight, maxTakeoffWeight, 0, flyMethod);
        this.range = range;
    }

    public int getRange() {
        return range;
    }
}
