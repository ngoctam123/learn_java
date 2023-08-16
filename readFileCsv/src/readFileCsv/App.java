package readFileCsv;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
public class App {

	private static final String JDBC_URL = "jdbc:sqlserver://127.0.0.1:1433;databaseName=mydatabase;integratedSecurity=false;encrypt=false;trustServerCertificate=true;";
	private static final String JDBC_USERNAME = "sa";
	private static final String JDBC_PASSWORD = "bigStrongPwd";
	private static final String JDBC_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	
	private static Connection connection;

	public static void main(String[] args) throws CsvValidationException {
		String csvFile = "employees.csv";
		String[] line;
		String csvSplitBy = ",";
		int lineNumber = 0;

		try (CSVReader reader = new CSVReader(new FileReader(csvFile))) {
			connection = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
			PreparedStatement statement = connection.prepareStatement(
					"INSERT INTO employees (ssn, first_name, last_name, birth_date, phone, email, salary) VALUES (?, ?, ?, ?, ?, ?, ?)");
			PreparedStatement updateStatement = connection.prepareStatement(
					"UPDATE employees SET first_name = ?, last_name = ?, birth_date = ?, phone = ?, email = ?, salary = ? WHERE ssn = ?");
			PreparedStatement deleteStatement = connection.prepareStatement("DELETE FROM employees WHERE ssn = ?");
			PreparedStatement selectstatement = connection.prepareStatement("SELECT * FROM employees");
            ResultSet resultSet = selectstatement.executeQuery();
            

			while ((line = reader.readNext()) != null) {
				lineNumber++;
				if (lineNumber == 1) {
					// Skip header line
					continue;
				}

				if (line.length != 7) {
					System.out.println("Invalid data at line " + lineNumber);
					continue;
				}

				String ssn = line[0];
				String firstName = line[1];
				String lastName = line[2];
				String birthDateString = line[3];
				String phone = line[4];
				String email = line[5];
				String salaryString = line[6];

				if (ssn.isEmpty() || firstName.isEmpty() || lastName.isEmpty() || birthDateString.isEmpty()
						|| phone.isEmpty() || email.isEmpty() || salaryString.isEmpty()) {
					System.out.println("Missing data at line " + lineNumber);
					continue;
				}

				try {
					Date birthDate = new SimpleDateFormat("dd/MM/yyyy").parse(birthDateString);
					double salary = Double.parseDouble(salaryString);

					statement.setString(1, ssn);
					statement.setString(2, firstName);
					statement.setString(3, lastName);
					statement.setDate(4, new java.sql.Date(birthDate.getTime()));
					statement.setString(5, phone);
					statement.setString(6, email);
					statement.setDouble(7, salary);
					statement.executeUpdate();
				} catch (ParseException e) {
					System.out.println("Invalid date format at line " + lineNumber);
				} catch (NumberFormatException e) {
					System.out.println("Invalid salary format at line " + lineNumber);
				} catch (SQLException e) {
					System.out.println("Error inserting data at line " + lineNumber);
					e.printStackTrace();
				}
			}
			Scanner scanner = new Scanner(System.in);
			int choice = 0;

			do {
				System.out.println("1. Add employee");
				System.out.println("2. Update employee");
				System.out.println("3. Delete employee");
				System.out.println("4. Exit");
				System.out.print("Enter your choice: ");
				choice = scanner.nextInt();

				switch (choice) {
				case 1:
					System.out.print("Enter SSN: ");
					String ssn = scanner.next();
					
					PreparedStatement checksnnStatement = connection.prepareStatement("SELECT * FROM employees WHERE ssn = ?");
					checksnnStatement.setString(1, ssn);
		            ResultSet resultSetSnn = checksnnStatement.executeQuery();
					

		            if (resultSetSnn.next()) {
		                System.out.println("SSN already exists");
		            }
		            else {
					System.out.print("Enter first name: ");
					String firstName = scanner.next();
					System.out.print("Enter last name: ");
					String lastName = scanner.next();
					System.out.print("Enter birth date (dd/MM/yyyy): ");
					String birthDateString = scanner.next();
					System.out.print("Enter phone: ");
					String phone = scanner.next();
					System.out.print("Enter email: ");
					String email = scanner.next();
					System.out.print("Enter salary: ");
					double salary = scanner.nextDouble();

					try {
						Date birthDate = new SimpleDateFormat("dd/MM/yyyy").parse(birthDateString);

						statement.setString(1, ssn);
						statement.setString(2, firstName);
						statement.setString(3, lastName);
						statement.setDate(4, new java.sql.Date(birthDate.getTime()));
						statement.setString(5, phone);
						statement.setString(6, email);
						statement.setDouble(7, salary);
						statement.executeUpdate();
					} catch (ParseException e) {
						System.out.println("Invalid date format");
					} catch (SQLException e) {
						System.out.println("Error inserting data");
						e.printStackTrace();
					}
		            }

					break;
				case 2:
					System.out.print("Enter SSN: ");
					ssn = scanner.next();
					System.out.print("Enter first name: ");
					firstName = scanner.next();
					System.out.print("Enter last name: ");
					lastName = scanner.next();
					System.out.print("Enter birth date (dd/MM/yyyy): ");
					birthDateString = scanner.next();
					System.out.print("Enter phone: ");
					phone = scanner.next();
					System.out.print("Enter email: ");
					email = scanner.next();
					System.out.print("Enter salary: ");
					salary = scanner.nextDouble();

					try {
						Date birthDate = new SimpleDateFormat("dd/MM/yyyy").parse(birthDateString);

						updateStatement.setString(1, firstName);
						updateStatement.setString(2, lastName);
						updateStatement.setDate(3, new java.sql.Date(birthDate.getTime()));
						updateStatement.setString(4, phone);
						updateStatement.setString(5, email);
						updateStatement.setDouble(6, salary);
						updateStatement.setString(7, ssn);
						updateStatement.executeUpdate();
					} catch (ParseException e) {
						System.out.println("Invalid date format");
					} catch (SQLException e) {
						System.out.println("Error updating data");
						e.printStackTrace();
					}

					break;
				case 3:
					System.out.print("Enter SSN: ");
					ssn = scanner.next();

					try {
						deleteStatement.setString(1, ssn);
						deleteStatement.executeUpdate();
					} catch (SQLException e) {
						System.out.println("Error deleting data");
						e.printStackTrace();
					}
					break;
				case 4:
					while (resultSet.next()) {
		                String ssn1 = resultSet.getString("ssn");
		                String firstName1 = resultSet.getString("first_name");
		                String lastName1 = resultSet.getString("last_name");
		                String birthDate = resultSet.getString("birth_date");
		                String phone1 = resultSet.getString("phone");
		                String email1 = resultSet.getString("email");
		                double salary1 = resultSet.getDouble("salary");

		                System.out.println("SSN: " + ssn1);
		                System.out.println("First name: " + firstName1);
		                System.out.println("Last name: " + lastName1);
		                System.out.println("Birth date: " + birthDate);
		                System.out.println("Phone: " + phone1);
		                System.out.println("Email: " + email1);
		                System.out.println("Salary: " + salary1);
		                System.out.println();
		            }
					break;
				case 5:
					break;
				default:
					System.out.println("Invalid choice");
					break;
				}
			} while (choice != 5);

			updateStatement.close();
			deleteStatement.close();
			statement.close();
			selectstatement.close();
//			checksnnStatement.close();
			connection.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

