package fa.training.main;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import fa.training.dao.CustomerDAO;
import fa.training.dao.CustomerDAOImpl;
import fa.training.dao.EmployeeDAO;
import fa.training.dao.EmployeeDAOImpl;
import fa.training.dao.LineItemDAO;
import fa.training.dao.LineItemDAOImpl;
import fa.training.dao.OrderDAO;
import fa.training.dao.OrderDAOImpl;
import fa.training.dao.ProductDAO;
import fa.training.dao.ProductDAOImpl;
import fa.training.entities.Customer;
import fa.training.entities.Employee;
import fa.training.entities.LineItem;
import fa.training.entities.Order;
import fa.training.entities.Product;

public class App {

	private static Scanner scanner = new Scanner(System.in);

	private static CustomerDAO customerDAO = new CustomerDAOImpl();
	private static EmployeeDAO employeeDAO = new EmployeeDAOImpl();
	private static ProductDAO productDAO = new ProductDAOImpl();
	private static OrderDAO orderDAO = new OrderDAOImpl();
	private static LineItemDAO lineItemDAO = new LineItemDAOImpl();

	public static void main(String[] args) {
		while (true) {
			System.out.println("1. Manage Customers");
			System.out.println("2. Manage Employees");
			System.out.println("3. Manage Products");
			System.out.println("4. Manage Orders");
			System.out.println("5. Exit");
			System.out.print("Enter your choice: ");
			int choice = scanner.nextInt();
			scanner.nextLine();
			switch (choice) {
			case 1:
				manageCustomers();
				break;
			case 2:
				manageEmployees();
				break;
			case 3:
				manageProducts();
				break;
			case 4:
				manageOrders();
				break;
			case 5:
				System.out.println("Goodbye!");
				System.exit(0);
			default:
				System.out.println("Invalid choice. Please try again.");
			}
		}
	}

	private static void manageCustomers() {
		while (true) {
			System.out.println("1. Add Customer");
			System.out.println("2. Update Customer");
			System.out.println("3. Delete Customer");
			System.out.println("4. View Customer");
			System.out.println("5. View All Customers");
			System.out.println("6. Back");
			System.out.print("Enter your choice: ");
			int choice = scanner.nextInt();
			scanner.nextLine();
			switch (choice) {
			case 1:
				addCustomer();
				break;
			case 2:
				updateCustomer();
				break;
			case 3:
				deleteCustomer();
				break;
			case 4:
				viewCustomer();
				break;
			case 5:
				viewAllCustomers();
				break;
			case 6:
				return;
			default:
				System.out.println("Invalid choice. Please try again.");
			}
		}
	}

	private static void addCustomer() {
		System.out.print("Enter customer name: ");
		String customerName = scanner.nextLine();
		Customer customer = new Customer();
		customer.setCustomerName(customerName);
		customerDAO.addCustomer(customer);
		System.out.println("Customer added successfully.");
	}

	private static void updateCustomer() {
		System.out.print("Enter customer id: ");
		int customerId = scanner.nextInt();
		scanner.nextLine();
		Customer customer = customerDAO.getCustomerById(customerId);
		if (customer == null) {
			System.out.println("Customer not found.");
			return;
		}
		System.out.print("Enter new customer name: ");
		String customerName = scanner.nextLine();
		customer.setCustomerName(customerName);
		customerDAO.updateCustomer(customer);
		System.out.println("Customer updated successfully.");
	}

	private static void deleteCustomer() {
		System.out.print("Enter customer id: ");
		int customerId = scanner.nextInt();
		scanner.nextLine();
		Customer customer = customerDAO.getCustomerById(customerId);
		if (customer == null) {
			System.out.println("Customer not found.");
			return;
		}
		customerDAO.deleteCustomer(customerId);
		System.out.println("Customer deleted successfully.");
	}

	private static void viewCustomer() {
		System.out.print("Enter customer id: ");
		int customerId = scanner.nextInt();
		scanner.nextLine();
		Customer customer = customerDAO.getCustomerById(customerId);
		if (customer == null) {
			System.out.println("Customer not found.");
			return;
		}
		System.out.println("Customer ID: " + customer.getCustomerId());
		System.out.println("Customer Name: " + customer.getCustomerName());
	}

	private static void viewAllCustomers() {
		List<Customer> customers = customerDAO.listAllCustomers();
		if (customers.isEmpty()) {
			System.out.println("No customers found.");
			return;
		}
		System.out.println("Customer ID\tCustomer Name");
		for (Customer customer : customers) {
			System.out.println(customer.getCustomerId() + "\t\t" + customer.getCustomerName());
		}
	}

	private static void manageEmployees() {
		while (true) {
			System.out.println("1. Add Employee");
			System.out.println("2. Update Employee");
			System.out.println("3. Delete Employee");
			System.out.println("4. View Employee");
			System.out.println("5. View All Employees");
			System.out.println("6. Back");
			System.out.print("Enter your choice: ");
			int choice = scanner.nextInt();
			scanner.nextLine();
			switch (choice) {
			case 1:
				addEmployee();
				break;
			case 2:
				updateEmployee();
				break;
			case 3:
				deleteEmployee();
				break;
			case 4:
				viewEmployee();
				break;
			case 5:
				viewAllEmployees();
				break;
			case 6:
				return;
			default:
				System.out.println("Invalid choice. Please try again.");
			}
		}
	}

	private static void addEmployee() {
		System.out.print("Enter employee name: ");
		String employeeName = scanner.nextLine();
		Employee employee = new Employee();
		employee.setEmployeeName(employeeName);
		employeeDAO.addEmployee(employee);
		System.out.println("Employee added successfully.");
	}

	private static void updateEmployee() {
		System.out.print("Enter employee id: ");
		int employeeId = scanner.nextInt();
		scanner.nextLine();
		Employee employee = employeeDAO.getEmployeeById(employeeId);
		if (employee == null) {
			System.out.println("Employee not found.");
			return;
		}
		System.out.print("Enter new employee name: ");
		String employeeName = scanner.nextLine();
		employee.setEmployeeName(employeeName);
		employeeDAO.updateEmployee(employee);
		System.out.println("Employee updated successfully.");
	}

	private static void deleteEmployee() {
		System.out.print("Enter employee id: ");
		int employeeId = scanner.nextInt();
		scanner.nextLine();
		Employee employee = employeeDAO.getEmployeeById(employeeId);
		if (employee == null) {
			System.out.println("Employee not found.");
			return;
		}
		employeeDAO.deleteEmployee(employeeId);
		System.out.println("Employee deleted successfully.");
	}

	private static void viewEmployee() {
		System.out.print("Enter employee id: ");
		int employeeId = scanner.nextInt();
		scanner.nextLine();
		Employee employee = employeeDAO.getEmployeeById(employeeId);
		if (employee == null) {
			System.out.println("Employee not found.");
			return;
		}
		System.out.println("Employee ID: " + employee.getEmployeeId());
		System.out.println("Employee Name: " + employee.getEmployeeName());
	}

	private static void viewAllEmployees() {
		List<Employee> employees = employeeDAO.listAllEmployees();
		if (employees.isEmpty()) {
			System.out.println("No employees found.");
			return;
		}
		System.out.println("Employee ID\tEmployee Name");
		for (Employee employee : employees) {
			System.out.println(employee.getEmployeeId() + "\t\t" + employee.getEmployeeName() + "\t\t"
					+ employee.getSalary() + "\t\t" + employee.getSpvrId());
		}
	}

	private static void manageProducts() {
		// TODO: Implement manageProducts() method
	}

	private static void manageOrders() {
		// TODO: Implement manageOrders() method
	}
}