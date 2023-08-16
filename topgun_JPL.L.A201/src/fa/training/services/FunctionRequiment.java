package fa.training.services;

public class FunctionRequiment {

	class Airport {
	    // existing code

//	    public void addFixedWingAirplane(FixedWing airplane) {
//	        if (canParkFixedWingAirplane(airplane)) {
//	            fixedWingAirplaneIds.add(airplane.getId());
//	        } else {
//	            throw new RuntimeException("Cannot park fixed wing airplane in this airport");
//	        }
//	    }
//
//	    public void removeHelicopter(String helicopterId) {
//	        if (helicopterIds.contains(helicopterId)) {
//	            helicopterIds.remove(helicopterId);
//	        } else {
//	            throw new RuntimeException("Helicopter not found in this airport");
//	        }
//	    }
//
//	    public void addHelicopter(Helicopter helicopter) {
//	        if (helicopterIds.size() < maxRotatedWingParkingPlace) {
//	            helicopterIds.add(helicopter.getId());
//	        } else {
//	            throw new RuntimeException("No more parking place for helicopter");
//	        }
//	    }
//
//	    public void removeHelicopters(List<String> helicopterIdsToRemove) {
//	        helicopterIds.removeAll(helicopterIdsToRemove);
//	    }
//
//	    public void changeFixedWingAirplaneTypeAndMinNeededRunwaySize(String airplaneId, String newType, int newMinNeededRunwaySize) {
//	        for (String id : fixedWingAirplaneIds) {
//	            if (id.equals(airplaneId)) {
//	                FixedWing airplane = (FixedWing) getAirplaneById(airplaneId);
//	                airplane.setPlaneType(newType);
//	                airplane.setMinNeededRunwaySize(newMinNeededRunwaySize);
//	                return;
//	            }
//	        }
//	        throw new RuntimeException("Fixed wing airplane not found in this airport");
//	    }
//
//	    private Airplane getAirplaneById(String airplaneId) {
//	        for (String id : fixedWingAirplaneIds) {
//	            if (id.equals(airplaneId)) {
//	                return getFixedWingAirplaneById(airplaneId);
//	            }
//	        }
//	        for (String id : helicopterIds) {
//	            if (id.equals(airplaneId)) {
//	                return getHelicopterById(airplaneId);
//	            }
//	        }
//	        throw new RuntimeException("Airplane not found in this airport");
//	    }
//
//	    private FixedWing getFixedWingAirplaneById(String airplaneId) {
//	        // implementation to get FixedWing airplane by ID
//	    }
//
//	    private Helicopter getHelicopterById(String helicopterId) {
//	        // implementation to get Helicopter by ID
//	    }
	}
}
