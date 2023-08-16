package fa.training.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;

import fa.training.entities.Order;
import fa.training.utils.DBUtils;

public class OrderDAOImpl implements OrderDAO {

    private Connection conn;

    public OrderDAOImpl() {
    	conn = DBUtils.getConnection();
    }

    @Override
    public void addOrder(Order order) {
        try {
            String sql = "INSERT INTO orders (order_date, customer_id, employee_id, total) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setDate(1, new java.sql.Date(order.getOrderDate().getTime()));
            ps.setInt(2, order.getCustomerId());
            ps.setInt(3, order.getEmployeeId());
            ps.setDouble(4, order.getTotal());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateOrder(Order order) {
        try {
            String sql = "UPDATE orders SET order_date = ?, customer_id = ?, employee_id = ?, total = ? WHERE order_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setDate(1, new java.sql.Date(order.getOrderDate().getTime()));
            ps.setInt(2, order.getCustomerId());
            ps.setInt(3, order.getEmployeeId());
            ps.setDouble(4, order.getTotal());
            ps.setInt(5, order.getOrderId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteOrder(int orderId) {
        try {
            String sql = "DELETE FROM orders WHERE order_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, orderId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Order getOrderById(int orderId) {
        Order order = null;
        try {
            String sql = "SELECT * FROM orders WHERE order_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, orderId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                order = new Order();
                order.setOrderId(rs.getInt("order_id"));
                order.setOrderDate(rs.getDate("order_date"));
                order.setCustomerId(rs.getInt("customer_id"));
                order.setEmployeeId(rs.getInt("employee_id"));
                order.setTotal(rs.getDouble("total"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return order;
    }
}