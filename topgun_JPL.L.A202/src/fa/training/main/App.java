package fa.training.main;

import fa.training.entities.*;

import java.util.List;
import java.util.Scanner;
import fa.training.services.*;

public class App {

	private static final Scanner scanner = new Scanner(System.in);
	private static final HRManagementSystem hrManagementSystem = new HRManagementSystem();
	public static void main(String[] args) {
//	    System.out.println(hrDepartment);
//	    System.out.println("Total salary: " + hrDepartment.calculateTotalPay());
//	    System.out.println(itDepartment);import java.text.ParseException;

	boolean quit = false;
	while(!quit)
	{
		System.out.println("HR Management System Menu:");
		System.out.println("1. Create employee");
		System.out.println("2. Display employees");
		System.out.println("3. Classify employees");
		System.out.println("4. Search employee by department name");
		System.out.println("5. Search employee by employee name");
		System.out.println("6. Report");
		System.out.println("7. Data Sample");
		System.out.println("8. Quit");

		System.out.print("Enter your choice: ");
		int choice = scanner.nextInt();
		scanner.nextLine();

		switch (choice) {
		case 1:
			createEmployee();
			break;
		case 2:
			datasample();
			displayEmployees();
			break;
		case 3:
			classifyEmployees();
			break;
		case 4:
			searchEmployeeByDepartmentName();
			break;
		case 5:
			searchEmployeeByEmployeeName();
			break;
		case 6:
			displayDepartmentReport();
			break;
		case 7:
			datasample();
			break;
		case 8:
			quit = true;
			break;
		default:
			System.out.println("Invalid choice");
			break;
		}
	}
	}
	private static void datasample() {
		Department hrDepartment = new Department("HR");
		SalariedEmployee manager = new SalariedEmployee("123-45-6789", "John", "Doe", "27-12-1999", "555-1234",
				"john.doe@example.com", 0.1, 1000000, 50000);
		hrDepartment.addEmployee(manager);

		HourlyEmployee employee1 = new HourlyEmployee("987-65-4321", "Jane", "Doe", "27-12-1999", "555-5678",
				"jane.doe@example.com", 20, 160);
		hrDepartment.addEmployee(employee1);

		HourlyEmployee employee2 = new HourlyEmployee("111-22-3333", "Bob", "Smith", "27-12-1999", "555-9012",
				"bob.smith@example.com", 15, 200);
		hrDepartment.addEmployee(employee2);

		Department itDepartment = new Department("IT");

		SalariedEmployee manager2 = new SalariedEmployee("555-55-5555", "Alice", "Smith", "27-12-1999", "555-5555",
				"alice.smith@example.com", 0.2, 2000000, 75000);
		itDepartment.addEmployee(manager2);

		HourlyEmployee employee3 = new HourlyEmployee("444-44-4444", "Tom", "Jones", "27-12-1999", "555-4444",
				"tom.jones@example.com", 25, 180);
		itDepartment.addEmployee(employee3);
		
	}

	private static void createEmployee() {
                System.out.print("Enter employee type (Salaried or Hourly): ");
                String employeeType = scanner.nextLine();

                System.out.print("Enter SSN: ");
                String ssn = scanner.nextLine();

                System.out.print("Enter first name: ");
                String firstName = scanner.nextLine();

                System.out.print("Enter last name: ");
                String lastName = scanner.nextLine();

                System.out.print("Enter birth date (dd/MM/yyyy): ");
                String birthDateString = scanner.nextLine();

                System.out.print("Enter phone: ");
                String phone = scanner.nextLine();

                System.out.print("Enter email: ");
                String email = scanner.nextLine();

                if (employeeType.equalsIgnoreCase("Salaried")) {
                    System.out.print("Enter commission rate: ");
                    double commissionRate = scanner.nextDouble();

                    System.out.print("Enter gross sales: ");
                    double grossSales = scanner.nextDouble();

                    System.out.print("Enter basic salary: ");
                    double basicSalary = scanner.nextDouble();

                    SalariedEmployee salariedEmployee = new SalariedEmployee(ssn, firstName, lastName, birthDateString, phone, email,
                            commissionRate, grossSales, basicSalary);
                    System.out.print("Enter department name: ");
                    String departmentName = scanner.nextLine();
                    departmentName = scanner.nextLine();
                    Department department = findDepartment(departmentName);
                    if (department == null) {
                        department = new Department(departmentName);
                        hrManagementSystem.addDepartment(department);
                    }
                    department.addEmployee(salariedEmployee);
                } else if (employeeType.equalsIgnoreCase("Hourly")) {
                    System.out.print("Enter rate: ");
                    double rate = scanner.nextDouble();

                    System.out.print("Enter working hours: ");
                    double workingHours = scanner.nextDouble();

                    HourlyEmployee hourlyEmployee = new HourlyEmployee(ssn, firstName, lastName, birthDateString, phone, email,
                            rate, workingHours);
                    System.out.print("Enter department name: ");
                    String departmentName = scanner.nextLine();
                    departmentName = scanner.nextLine();
                    Department department = findDepartment(departmentName);
                    if (department == null) {
                        department = new Department(departmentName);
                        hrManagementSystem.addDepartment(department);
                    }
                    department.addEmployee(hourlyEmployee);
                } else {
                    System.out.println("Invalid employee type");
                }
            }

	private static void displayEmployees() {
                hrManagementSystem.displayEmployees();
            }

	private static void classifyEmployees() {
                hrManagementSystem.classifyEmployees();
            }

	private static void searchEmployeeByDepartmentName() {
                System.out.print("Enter department name: ");
                String departmentName = scanner.nextLine();
                List<Employee> employees = hrManagementSystem.searchByDepartment(departmentName);
                if (employees.isEmpty()) {
                    System.out.println("No employees found in department " + departmentName);
                } else {
                    System.out.println("Employees in department " + departmentName + ":");
                    for (Employee employee : employees) {
                        System.out.println(employee);
                    }
                }
            }

	private static void searchEmployeeByEmployeeName() {
	    System.out.print("Enter employee name: ");
	    String name = scanner.nextLine();
	    List<Employee> employees = hrManagementSystem.searchByName(name);
	    if (employees.isEmpty()) {
	        System.out.println("No employees found with name " + name);
	    } else {
	        System.out.println("Employees with name " + name + ":");
	        for (Employee employee : employees) {
	            System.out.println(employee);
	        }
	    }
	}

	private static void displayDepartmentReport() {
		    System.out.println("Department report:");
		    for (Department department : hrManagementSystem.getDepartments()) {
		        System.out.println(department.getName() + ": " + department.getEmployees().size() + " employees");
		    }
		}

	private static Department findDepartment(String departmentName) {
		    for (Department department : hrManagementSystem.getDepartments()) {
		        if (department.getName().equalsIgnoreCase(departmentName)) {
		            return department;
		        }
		    }
		    return null;
		}
}
