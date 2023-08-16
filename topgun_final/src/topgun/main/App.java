package topgun.main;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.HashSet;
import java.util.Set;


import topgun.entities.*;
import java.sql.Connection;

public class App {
	private static Scanner scanner = new Scanner(System.in);
	private static final String URL = "jdbc:sqlserver://127.0.0.1:1433;databaseName=topgun;integratedSecurity=false;encrypt=false;trustServerCertificate=true;";
    private static final String USER = "sa";
    private static final String PASSWORD = "bigStrongPwd";

	public static void main(String[] args) {
		while (true) {
			System.out.println("1. Add phone");
			System.out.println("2. View add phone");
			System.out.println("3. Find phone");
			System.out.println("4. view hãng");
			System.out.println("4. thaydoigia");
			System.out.println("5. Exit");
			System.out.print("Enter your choice: ");
			int choice = scanner.nextInt();
			scanner.nextLine();
			switch (choice) {
			case 1:
				addphone();
				break;
			case 2:
				viewphone();
				break;
			case 3:
				findphone();
				break;
			case 4:
				Manufacturers();
				break;
			case 5:
				discount();
				break;
			case 6:
				System.out.println("Goodbye!");
				System.exit(0);
			default:
				System.out.println("Invalid choice. Please try again.");
			}
		}
	}

	/**
     * author Ngoc Tam.
     * @time 9:10:00 AM
     * @date May 18, 2023
     * thêm đt mới
     */
	private static void addphone() {
		System.out.println("Enter phone ID:");
		String ID = scanner.nextLine();
		try {
            PhoneValidator.validateId(ID);
        } catch (InvalidPhoneException e) {
            System.out.println(e.getMessage());
            return;
        }

		System.out.println("Enter phone name:");
		String name = scanner.nextLine();

		System.out.println("Enter phone size:");
		String size = scanner.nextLine();

		System.out.println("Enter phone chip name:");
		String chipName = scanner.nextLine();

		System.out.println("Enter phone RAM size:");
		String ramSize = scanner.nextLine();
		try {
			RamValidator.validateRamSize(ramSize);
        } catch (InvalidRamException e) {
            System.out.println(e.getMessage());
            return;
        }

		System.out.println("Enter phone storage size:");
		String storageSize = scanner.nextLine();

		System.out.println("Enter phone manufacturer:");
		String manufacturer = scanner.nextLine();

		System.out.println("Enter phone price:");
		String price = scanner.nextLine();

		System.out.println("Enter phone type (1 for official phone, 2 for grey phone, 3 for used phone):");
		int type = scanner.nextInt();
		scanner.nextLine();

		Phone phone = null;
		OfficialPhone officialPhone =null;
		if (type == 1) {
			System.out.println("Enter phone warranty:");
			String warranty = scanner.nextLine();

			System.out.println("Enter phone warranty scope:");
			String warrantyScope = scanner.nextLine();

			phone = new OfficialPhone(ID, name, size, chipName, ramSize, storageSize, manufacturer, price, warranty,
					warrantyScope);
		} else if (type == 2) {
			System.out.println("Enter phone import country:");
			String importCountry = scanner.nextLine();

			System.out.println("Enter phone warranty package:");
			String warrantyPackage = scanner.nextLine();

			phone = new GreyPhone(ID, name, size, chipName, ramSize, storageSize, manufacturer, price, importCountry,
					warrantyPackage);
		} else if (type == 3) {
			System.out.println("Enter phone classification:");
			String classification = scanner.nextLine();

			System.out.println("Enter phone condition:");
			String condition = scanner.nextLine();

			System.out.println("Enter phone warranty package:");
			String warrantyPackage = scanner.nextLine();

			phone = new UsedPhone(ID, name, size, chipName, ramSize, storageSize, manufacturer, price, classification,
					condition, warrantyPackage);
		}

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			connection = DriverManager.getConnection(URL, USER, PASSWORD);

			String sql = "INSERT INTO phones (id, name, size, chip_name, ram_size, storage_size, manufacturer, price) VALUES (?,?, ?, ?, ?, ?, ?, ?)";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, phone.getId());
			preparedStatement.setString(2, phone.getName());
			preparedStatement.setString(3, phone.getSize());
			preparedStatement.setString(4, phone.getChipName());
			preparedStatement.setString(5, phone.getRamSize());
			preparedStatement.setString(6, phone.getStorageSize());
			preparedStatement.setString(7, phone.getManufacturer());
			preparedStatement.setString(8, phone.getPrice());

			int rowsInserted = preparedStatement.executeUpdate();
			if (rowsInserted > 0) {
				System.out.println("Phone added successfully!");
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	/**
     * author Ngoc Tam.
     * Hiển thị toàn bộ thông tin đt với sort
     */
	private static void viewphone() {
		

        ArrayList<Phone> phones = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String sql = "SELECT * FROM phones";
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                String id = result.getString("id");
                String name = result.getString("name");
                String size = result.getString("size");
                String chipName = result.getString("chip_name");
                String ramSize = result.getString("ram_size");
                String storageSize = result.getString("storage_size");
                String manufacturer = result.getString("manufacturer");
                String price = result.getString("price");
                phones.add(new Phone(id, name, size, chipName, ramSize, storageSize, manufacturer, price));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Sắp xếp danh sách các điện thoại theo giá giảm dần và RAM tăng dần
        Collections.sort(phones, new Comparator<Phone>() {
            @Override
            public int compare(Phone p1, Phone p2) {
                int priceCompare = Integer.parseInt(p2.getPrice()) - Integer.parseInt(p1.getPrice());
                if (priceCompare != 0) {
                    return priceCompare;
                } else {
                    int ramCompare = Integer.parseInt(p1.getRamSize()) - Integer.parseInt(p2.getRamSize());
                    return ramCompare;
                }
            }
        });

        // Hiển thị thông tin của các điện thoại
        for (Phone phone : phones) {
            phone.showInfo();
            System.out.println();
        }
    }
 
	/**
     * author Ngoc Tam.
     * find iphone theo yêu cầu
     * thêm đt mới
     */
	private static void findphone() {

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String sql = "SELECT * FROM phones WHERE price >= ? AND price <= ? AND ram_size >= ? AND storage_size >= ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setDouble(1, 5000000);
            statement.setDouble(2, 10000000);
            statement.setString(3, "4");
            statement.setString(4, "128");
            ResultSet result = statement.executeQuery();

            List<Phone> phones = new ArrayList<>();
            while (result.next()) {
                String id = result.getString("id");
                String name = result.getString("name");
                String size = result.getString("size");
                String chipName = result.getString("chip_name");
                String ramSize = result.getString("ram_size");
                String storageSize = result.getString("storage_size");
                String manufacturer = result.getString("manufacturer");
                String price = result.getString("price");
                
                phones.add(new Phone(id, name, size, chipName, ramSize, storageSize, manufacturer, price));


            }

            // Hiển thị danh sách điện thoại
            System.out.println("ID\tName\tSize\tChip Name\tRAM Size\tStorage Size\tManufacturer\tPrice");
            for (Phone phone : phones) {
            	phone.showInfo();
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	/**
     * author Ngoc Tam.
     * search sort
     * thêm đt mới
     */
	private static void Manufacturers() {

	        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
	            String sql = "SELECT DISTINCT manufacturer FROM phones";
	            PreparedStatement statement = conn.prepareStatement(sql);
	            ResultSet result = statement.executeQuery();

	            Set<String> manufacturers = new HashSet<>();
	            while (result.next()) {
	                String manufacturer = result.getString("manufacturer");
	                manufacturers.add(manufacturer);
	            }

	            // Hiển thị danh sách manufacturer
	            System.out.println("Manufacturers:");
	            for (String manufacturer : manufacturers) {
	                System.out.println(manufacturer);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		
	}
	/**
     * author Ngoc Tam.
     * yêu cầu 4 xử lý discount
     * thêm đt mới
     */
	private static void discount() {

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            // Cập nhật giá cho official_phones giảm giá 1 triệu
            String sql1 = "UPDATE phones SET price = price - 100000 WHERE id = 'P001'";
            PreparedStatement statement1 = conn.prepareStatement(sql1);
            statement1.executeUpdate();

            // Cập nhật giá cho grey_phones giảm giá 10% so với giá ban đầu
            String sql2 = "UPDATE phones SET price = price * 0.9 WHERE id = 'P005'";
            PreparedStatement statement2 = conn.prepareStatement(sql2);
            statement2.executeUpdate();

            // Cập nhật giá cho used_phones giảm 5% so với giá ban đầu
            String sql3 = "UPDATE phones SET price = price * 0.95 WHERE id = 'P006'";
            PreparedStatement statement3 = conn.prepareStatement(sql3);
            statement3.executeUpdate();

            System.out.println("Prices updated successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
		
	}
		
	}

class PhoneValidator {
	public static void validateId(String ID) throws InvalidPhoneException {
		if (ID == null || ID.length() != 6 || !ID.startsWith("DT")) {
			throw new InvalidPhoneException("Invalid phone ID");
		}
	}
}

class InvalidPhoneException extends Exception {
    public InvalidPhoneException(String message) {
        super(message);
    }
}
class RamValidator {
    public static void validateRamSize(String ramSize) throws InvalidRamException {
        if (ramSize == null || (!ramSize.equals("1") && !ramSize.equals("2") && !ramSize.equals("4") && !ramSize.equals("8") && !ramSize.equals("16") && !ramSize.equals("32"))) {
            throw new InvalidRamException("Invalid RAM size");
        }
    }
}

class InvalidRamException extends Exception {
    public InvalidRamException(String message) {
        super(message);
    }
}

