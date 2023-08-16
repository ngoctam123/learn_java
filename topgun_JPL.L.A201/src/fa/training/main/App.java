package fa.training.main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.text.ParseException;
import fa.training.entities.*;

public class App {
    private static final List<Airport> airports = new ArrayList<>();
    private static final List<FixedWing> fixedWingAirplanes = new ArrayList<>();
    private static final List<Helicopter> helicopters = new ArrayList<>(); // final giúp cho helicopters này chỉ lưu và sử dụng đc duy nhất vùng nhớ 
    
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int choice = 0;
		do {
			System.out.println("Select function:");
			System.out.println("1. Input data from keyboard");
			System.out.println("2. Airport management");
			System.out.println("3. Fixed wing airplane management");
			System.out.println("4. Helicopter management");
			System.out.println("5. Close program");
			System.out.print("Enter your choice: ");
			try {
				choice = Integer.parseInt(scanner.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("Invalid choice");
				continue;
			}
			switch (choice) {
			case 1:
				inputDataFromKeyboard(scanner);
				addAirport();
				break;
			case 2:
				airportManagement(scanner);
				break;
			case 3:
				fixedWingAirplaneManagement(scanner);
				break;
			case 4:
				helicopterManagement(scanner);
				break;
			case 5:
				System.out.println("Closing program...");
				break;
			default:
				System.out.println("Invalid choice");
				break;
			}
		} while (choice != 5);
	}

    public static void addAirport() {
    	Airport airport = new Airport("001", "Airport 1", 5000, 10, 5);
		airports.add(airport);
		System.out.println("Dữ liệu mặc định");
    }
    private static void inputDataFromKeyboard(Scanner scanner) {
        System.out.println("Enter airport information:");
        System.out.print("ID: ");
        String airportId = scanner.nextLine();
        System.out.print("Name: ");
        String airportName = scanner.nextLine();
        System.out.print("Runway size: ");
        int runwaySize = Integer.parseInt(scanner.nextLine());
        System.out.print("Max fixed wing parking place: ");
        int maxFixedWingParkingPlace = Integer.parseInt(scanner.nextLine());
        System.out.print("Max rotated wing parking place: ");
        int maxRotatedWingParkingPlace = Integer.parseInt(scanner.nextLine());
        Airport airport = new Airport(airportId, airportName, runwaySize, maxFixedWingParkingPlace, maxRotatedWingParkingPlace);
        airports.add(airport);
        System.out.println("Airport added successfully");
    }

    private static void airportManagement(Scanner scanner) {
        int choice = 0;
        do {
            System.out.println("Airport management:");
            System.out.println("1. Display list of all airport information, sorted by airport ID");
            System.out.println("2. Display the status of one airport, selected by airport ID");
            System.out.println("3. Back to main menu");
            System.out.print("Enter your choice: ");
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid choice");
                continue;
            }
            switch (choice) {
                case 1:
                    displayAllAirports();
                    break;
                case 2:
                    displayAirportStatus(scanner);
                    break;
                case 3:
                    System.out.println("Returning to main menu...");
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        } while (choice != 3);
    }

    private static void displayAllAirports() {
        System.out.println("List of all airports:");
        System.out.println("ID\tName\tRunway Size\tMax Fixed Wing Parking Place\tMax Rotated Wing Parking Place");
        Collections.sort(airports, (a1, a2) -> a1.getId().compareTo(a2.getId()));
        for (Airport airport : airports) {
            System.out.println(airport.getId() + "\t" + airport.getName() + "\t" + airport.getRunwaySize() + "\t" + airport.getMaxFixedWingParkingPlace() + "\t" + airport.getMaxRotatedWingParkingPlace());
        }
    }

    private static void displayAirportStatus(Scanner scanner) {
        System.out.print("Enter airport ID: ");
        String airportId = scanner.nextLine();
        Airport airport = getAirportById(airportId);
        System.out.println("Airport status:");
        System.out.println("Name: " + airport.getName());
        System.out.println("Runway size: " + airport.getRunwaySize());
        System.out.println("Max fixed wing parking place: " + airport.getMaxFixedWingParkingPlace());
        System.out.println("Fixed wing airplanes parked: " + airport.getFixedWingAirplaneIds().size());
        System.out.println("Max rotated wing parking place: " + airport.getMaxRotatedWingParkingPlace());
        System.out.println("Helicopters parked: " + airport.getHelicopterIds().size());
    }

	private static void fixedWingAirplaneManagement(Scanner scanner) {
		int choice = 0;
		do {
			System.out.println("Fixed wing airplane management:");
			System.out.println("1. Display list of all fixed wing airplanes with its parking airport ID and name");
			System.out.println("2. Back to main menu");
			System.out.print("Enter your choice: ");
			try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid choice");
                continue;
            }
			switch (choice) {
			case 1:
				displayAllFixedWingAirplanes();
				break;
			case 2:
				System.out.println("Returning to main menu…");
				break;
			default:
				System.out.println("Invalid choice");
				break;
			}
		} while (choice != 2);
	}
    private static void displayAllFixedWingAirplanes() {
        System.out.println("List of all fixed wing airplanes:");
        System.out.println("ID\tModel\tType\tMin Needed Runway Size\tParking Airport ID\tParking Airport Name");
        for (FixedWing airplane : fixedWingAirplanes) {
            String parkingAirportId = "";
            String parkingAirportName = "";
            for (Airport airport : airports) {
                if (airport.getFixedWingAirplaneIds().contains(airplane.getId())) {
                    parkingAirportId = airport.getId();
                    parkingAirportName = airport.getName();
                    break;
                }
            }
            System.out.println(airplane.getId() + "\t" + airplane.getModel() + "\t" + airplane.getPlaneType() + "\t" + airplane.getMinNeededRunwaySize() + "\t" + parkingAirportId + "\t" + parkingAirportName);
        }
    }

    private static void helicopterManagement(Scanner scanner) {
        int choice = 0;
        do {
            System.out.println("Helicopter management:");
            System.out.println("1. Display list of all helicopters with its parking airport ID and name");
            System.out.println("2. Back to main menu");
            System.out.print("Enter your choice: ");
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid choice");
                continue;
            }
            switch (choice) {
                case 1:
                    displayAllHelicopters();
                    break;
                case 2:
                    System.out.println("Returning to main menu...");
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        } while (choice != 2);
    }

    private static void displayAllHelicopters() {
        System.out.println("List of all helicopters:");
        System.out.println("ID\tModel\tEmpty Weight\tMax Takeoff Weight\tParking Airport ID\tParking Airport Name");
        for (Helicopter helicopter : helicopters) {
            String parkingAirportId = "";
            String parkingAirportName = "";
            for (Airport airport : airports) {
                if (airport.getHelicopterIds().contains(helicopter.getId())) {
                    parkingAirportId = airport.getId();
                    parkingAirportName = airport.getName();
                    break;
                }
            }
            System.out.println(helicopter.getId() + "\t" + helicopter.getModel() + "\t" + helicopter.getEmptyWeight() + "\t" + helicopter.getMaxTakeoffWeight() + "\t" + parkingAirportId + "\t" + parkingAirportName);
        }
    }

    private static Airport getAirportById(String airportId) {
        for (Airport airport : airports) {
            if (airport.getId().equals(airportId)) {
                return airport;
            }
        }
        throw new RuntimeException("Airport not found");
    }
    
}
