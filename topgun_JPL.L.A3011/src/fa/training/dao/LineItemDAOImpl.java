package fa.training.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fa.training.entities.LineItem;
import fa.training.utils.DBUtils;

public class LineItemDAOImpl implements LineItemDAO {

    private Connection conn;

    public LineItemDAOImpl() {
        conn = DBUtils.getConnection();
    }

    @Override
    public void addLineItem(LineItem lineItem) {
        try {
            String sql = "INSERT INTO line_items (order_id, product_id, quantity, price) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, lineItem.getOrderId());
            ps.setInt(2, lineItem.getProductId());
            ps.setInt(3, lineItem.getQuantity());
            ps.setDouble(4, lineItem.getPrice());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateLineItem(LineItem lineItem) {
        try {
            String sql = "UPDATE line_items SET quantity = ?, price = ? WHERE order_id = ? AND product_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, lineItem.getQuantity());
            ps.setDouble(2, lineItem.getPrice());
            ps.setInt(3, lineItem.getOrderId());
            ps.setInt(4, lineItem.getProductId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteLineItem(int orderId, int productId) {
        try {
            String sql = "DELETE FROM line_items WHERE order_id = ? AND product_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, orderId);
            ps.setInt(2, productId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<LineItem> getLineItemsByOrderId(int orderId) {
        List<LineItem> lineItems = new ArrayList<>();
        try {
            String sql = "SELECT * FROM line_items WHERE order_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, orderId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                LineItem lineItem = new LineItem();
                lineItem.setOrderId(rs.getInt("order_id"));
                lineItem.setProductId(rs.getInt("product_id"));
                lineItem.setQuantity(rs.getInt("quantity"));
                lineItem.setPrice(rs.getDouble("price"));
                lineItems.add(lineItem);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lineItems;
    }
}
