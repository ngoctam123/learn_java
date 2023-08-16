package fa.training.dao;

import java.util.List;


import fa.training.entities.Employee;

public interface EmployeeDAO {
    void addEmployee(Employee employee);
    void updateEmployee(Employee employee);
    void deleteEmployee(int employeeId);
    Employee getEmployeeById(int employeeId);
    List<Employee> listAllEmployees();
}