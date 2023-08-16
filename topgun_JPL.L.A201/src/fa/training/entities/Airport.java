package fa.training.entities;

import java.util.ArrayList;
import java.util.List;

public class Airport {
    private String id;
    private String name;
    private int runwaySize;
    private int maxFixedWingParkingPlace;
    private List<String> fixedWingAirplaneIds = new ArrayList<>();
    private int maxRotatedWingParkingPlace;
    private List<String> helicopterIds;
    
   

    public Airport(String id, String name, int runwaySize, int maxFixedWingParkingPlace, int maxRotatedWingParkingPlace) {
        this.id = id;
        this.name = name;
        this.runwaySize = runwaySize;
        this.maxFixedWingParkingPlace = maxFixedWingParkingPlace;
//        this.fixedWingAirplaneIds = new ArrayList<>();
        this.maxRotatedWingParkingPlace = maxRotatedWingParkingPlace;
        this.helicopterIds = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getRunwaySize() {
        return runwaySize;
    }

    public int getMaxFixedWingParkingPlace() {
        return maxFixedWingParkingPlace;
    }

    public List<String> getFixedWingAirplaneIds() {
        return fixedWingAirplaneIds;
    }

    public int getMaxRotatedWingParkingPlace() {
        return maxRotatedWingParkingPlace;
    }

    public List<String> getHelicopterIds() {
        return helicopterIds;
    }

    public void addFixedWingAirplane(String airplaneId) {
        if (fixedWingAirplaneIds.size() < maxFixedWingParkingPlace) {
            fixedWingAirplaneIds.add(airplaneId);
        } else {
            throw new RuntimeException("No more parking place for fixed wing airplane");
        }
    }

    public void addHelicopter(String helicopterId) {
        if (helicopterIds.size() < maxRotatedWingParkingPlace) {
            helicopterIds.add(helicopterId);
        } else {
            throw new RuntimeException("No more parking place for helicopter");
        }
    }
}
