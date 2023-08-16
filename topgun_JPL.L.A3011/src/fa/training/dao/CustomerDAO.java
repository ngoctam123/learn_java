package fa.training.dao;

import java.util.List;

import fa.training.entities.*;

public interface CustomerDAO {
    void addCustomer(Customer customer);
    void updateCustomer(Customer customer);
    void deleteCustomer(int customerId);
    Customer getCustomerById(int customerId);
    List<Customer> listAllCustomers();
}