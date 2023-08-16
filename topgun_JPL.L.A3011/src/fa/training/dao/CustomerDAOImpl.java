package fa.training.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fa.training.entities.Customer;
import fa.training.utils.DBUtils;

public class CustomerDAOImpl implements CustomerDAO {

    private Connection conn;

    public CustomerDAOImpl() {
        conn = DBUtils.getConnection();
    }
    

    @Override
    public void addCustomer(Customer customer) {
    	new CustomerDAOImpl();// dùng new hứng biến 
        try {
            String sql = "INSERT INTO customer (customer_name) VALUES (?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, customer.getCustomerName());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateCustomer(Customer customer) {
    	new CustomerDAOImpl();
        try {
            String sql = "UPDATE customer SET customer_name = ? WHERE customer_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, customer.getCustomerName());
            ps.setInt(2, customer.getCustomerId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteCustomer(int customerId) {
    	new CustomerDAOImpl();
        try {
            String sql = "DELETE FROM customer WHERE customer_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, customerId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Customer getCustomerById(int customerId) {
    	new CustomerDAOImpl();
        Customer customer = null;
        try {
            String sql = "SELECT * FROM customer WHERE customer_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, customerId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                customer = new Customer();
                customer.setCustomerId(rs.getInt("customer_id"));
                customer.setCustomerName(rs.getString("customer_name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }
    @Override
    public List<Customer> listAllCustomers() {
      List<Customer> customers = null;
      Customer customer = null;
      try {
        customers = new ArrayList<>();
        PreparedStatement ps = conn.prepareStatement("select * from customer");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
          customer = new Customer();

          customer.setCustomerId(rs.getInt("customer_id"));
          customer.setCustomerName(rs.getString("customer_name"));

          customers.add(customer);
        }
      } catch (SQLException e) {
      } finally {
        try {
          if (conn != null) {
        	  conn.close();
          }
        } catch (SQLException e) {
        }
      }
      return customers;
    }
}