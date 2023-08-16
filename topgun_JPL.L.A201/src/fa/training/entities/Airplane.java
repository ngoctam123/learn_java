package fa.training.entities;


public abstract class Airplane {
    private String id;
    private String model;
    private String planeType;
    private int cruiseSpeed;
    private int emptyWeight;
    private int maxTakeoffWeight;
    private int minNeededRunwaySize;
    private String flyMethod;

    public Airplane(String id, String model, String planeType, int cruiseSpeed, int emptyWeight, int maxTakeoffWeight, int minNeededRunwaySize, String flyMethod) {
        this.id = id;
        this.model = model;
        this.planeType = planeType;
        this.cruiseSpeed = cruiseSpeed;
        this.emptyWeight = emptyWeight;
        this.maxTakeoffWeight = maxTakeoffWeight;
        this.minNeededRunwaySize = minNeededRunwaySize;
        this.flyMethod = flyMethod;
    }

    public String getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public String getPlaneType() {
        return planeType;
    }

    public int getCruiseSpeed() {
        return cruiseSpeed;
    }

    public int getEmptyWeight() {
        return emptyWeight;
    }

    public int getMaxTakeoffWeight() {
        return maxTakeoffWeight;
    }

    public int getMinNeededRunwaySize() {
        return minNeededRunwaySize;
    }

    public String getFlyMethod() {
        return flyMethod;
    }
}

