package fa.training.dao;

import fa.training.entities.Order;

public interface OrderDAO {
    void addOrder(Order order);
    void updateOrder(Order order);
    void deleteOrder(int orderId);
    Order getOrderById(int orderId);
}