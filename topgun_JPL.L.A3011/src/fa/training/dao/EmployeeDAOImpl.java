package fa.training.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fa.training.entities.Employee;
import fa.training.utils.DBUtils;

public class EmployeeDAOImpl implements EmployeeDAO {

    private Connection conn;

    public EmployeeDAOImpl() {
        conn = DBUtils.getConnection();
    }

    @Override
    public void addEmployee(Employee employee) {
        try {
            String sql = "INSERT INTO employees (employee_name, salary, spvr_id) VALUES (?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, employee.getEmployeeName());
            ps.setDouble(2, employee.getSalary());
            ps.setInt(3, employee.getSpvrId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateEmployee(Employee employee) {
        try {
            String sql = "UPDATE employees SET employee_name = ?, salary = ?, spvr_id = ? WHERE employee_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, employee.getEmployeeName());
            ps.setDouble(2, employee.getSalary());
            ps.setInt(3, employee.getSpvrId());
            ps.setInt(4, employee.getEmployeeId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteEmployee(int employeeId) {
        try {
            String sql = "DELETE FROM employees WHERE employee_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, employeeId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Employee getEmployeeById(int employeeId) {
        Employee employee = null;
        try {
            String sql = "SELECT * FROM employees WHERE employee_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, employeeId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                employee = new Employee();
                employee.setEmployeeId(rs.getInt("employee_id"));
                employee.setEmployeeName(rs.getString("employee_name"));
                employee.setSalary(rs.getDouble("salary"));
                employee.setSpvrId(rs.getInt("spvr_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employee;
    }
    @Override
    public List<Employee> listAllEmployees() {
      List<Employee> employees = null;
      Employee employee = null;
      try {
    	employees = new ArrayList<>();
        PreparedStatement ps = conn.prepareStatement("select * from Employee");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
        	employee = new Employee();

        	employee.setEmployeeId(rs.getInt("employee_id"));
        	employee.setEmployeeName(rs.getString("employee_name"));
        	employee.setSalary(rs.getDouble("salary"));
        	employee.setSpvrId(rs.getInt("supervisor_id"));
        	employees.add(employee);
        }
      } catch (SQLException e) {
      } finally {
        try {
          if (conn != null) {
        	  conn.close();
          }
//          if (ps != null) {
//        	  ps.close();
//          }
//          if (rs != null) {
//            rs.close();
//          }
        } catch (SQLException e) {
        }
      }
      return employees;
    }
}




