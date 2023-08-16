package fa.training.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fa.training.entities.Product;
import fa.training.utils.DBUtils;

public class ProductDAOImpl implements ProductDAO {

    private Connection conn;

    public ProductDAOImpl() {
        conn = DBUtils.getConnection();
    }

    @Override
    public void addProduct(Product product) {
        try {
            String sql = "INSERT INTO products (product_name, list_price) VALUES (?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, product.getProductName());
            ps.setDouble(2, product.getListPrice());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateProduct(Product product) {
        try {
            String sql = "UPDATE products SET product_name = ?, list_price = ? WHERE product_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, product.getProductName());
            ps.setDouble(2, product.getListPrice());
            ps.setInt(3, product.getProductId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteProduct(int productId) {
        try {
            String sql = "DELETE FROM products WHERE product_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, productId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Product getProductById(int productId) {
        Product product = null;
        try {
            String sql = "SELECT * FROM products WHERE product_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, productId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                product = new Product();
                product.setProductId(rs.getInt("product_id"));
                product.setProductName(rs.getString("product_name"));
                product.setListPrice(rs.getDouble("list_price"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }
}