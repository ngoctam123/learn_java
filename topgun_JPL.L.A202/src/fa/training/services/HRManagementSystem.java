package fa.training.services;
import fa.training.entities.*;
import java.util.ArrayList;
import java.util.List;

public class HRManagementSystem {
    private List<Department> departments;

    public HRManagementSystem() {
        this.departments = new ArrayList<>();
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }

    public void addDepartment(Department department) {
        departments.add(department);
    }

    public void removeDepartment(Department department) {
        departments.remove(department);
    }

    public List<Employee> getAllEmployees() {
        List<Employee> allEmployees = new ArrayList<>();
        for (Department department : departments) {
            allEmployees.addAll(department.getEmployees());
        }
        return allEmployees;
    }

    public List<Employee> searchByDepartment(String departmentName) {
        List<Employee> employees = new ArrayList<>();
        for (Department department : departments) {
            if (department.getName().equals(departmentName)) {
                employees.addAll(department.getEmployees());
            }
        }
        return employees;
    }

    public List<Employee> searchByName(String name) {
        List<Employee> employees = new ArrayList<>();
        for (Department department : departments) {
            for (Employee employee : department.getEmployees()) {
                if (employee.getFirstName().equals(name) || employee.getLastName().equals(name)) {
                    employees.add(employee);
                }
            }
        }
        return employees;
    }

    public void displayEmployees() {
        for (Employee employee : getAllEmployees()) {
            System.out.println(employee);
        }
    }

    public void classifyEmployees() {
        for (Employee employee : getAllEmployees()) {
            if (employee instanceof SalariedEmployee) {
                System.out.println(employee.getFirstName() + " " + employee.getLastName() + " is a salaried employee.");
            } else if (employee instanceof HourlyEmployee) {
                System.out.println(employee.getFirstName() + " " + employee.getLastName() + " is an hourly employee.");
            } else {
                System.out.println(employee.getFirstName() + " " + employee.getLastName() + " is an unknown type of employee.");
            }
        }
    }

    public void displayDepartmentReport() {
        for (Department department : departments) {
            System.out.println(department.getName() + ": " + department.getEmployees().size() + " employees");
        }
    }
}
