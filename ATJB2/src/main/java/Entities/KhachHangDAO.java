package Entities;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class KhachHangDAO {
    private Connection conn;

    public KhachHangDAO() {
        // khởi tạo kết nối đến cơ sở dữ liệu
        conn = DButils.getConnection();
    }

    public List<KhachHang> getAllKhachHang() {
        List<KhachHang> khachHangList = new ArrayList<>();
        String sql = "SELECT * FROM KhachHang";
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                KhachHang khachHang = new KhachHang();
                khachHang.setMaKH(resultSet.getString("MaKH"));
                khachHang.setTenKH(resultSet.getString("TenKH"));
                khachHang.setDiaChi(resultSet.getString("DiaChi"));
                khachHang.setSoDT(resultSet.getLong("SoDT"));
                khachHang.setDiaChiEmail(resultSet.getString("DiaChiEmail"));
                khachHangList.add(khachHang);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return khachHangList;
    }

    public KhachHang getKhachHangByMaKH(String maKH) {
        KhachHang khachHang = null;
        String sql = "SELECT * FROM KhachHang WHERE MaKH = ?";
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, maKH);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                khachHang = new KhachHang();
                khachHang.setMaKH(resultSet.getString("MaKH"));
                khachHang.setTenKH(resultSet.getString("TenKH"));
                khachHang.setDiaChi(resultSet.getString("DiaChi"));
                khachHang.setSoDT(resultSet.getLong("SoDT"));
                khachHang.setDiaChiEmail(resultSet.getString("DiaChiEmail"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return khachHang;
    }

    public void addKhachHang(KhachHang khachHang) {
        String sql = "INSERT INTO KhachHang (MaKH, TenKH, DiaChi, SoDT, DiaChiEmail) VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, khachHang.getMaKH());
            statement.setString(2, khachHang.getTenKH());
            statement.setString(3, khachHang.getDiaChi());
            statement.setLong(4, khachHang.getSoDT());
            statement.setString(5, khachHang.getDiaChiEmail());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateKhachHang(KhachHang khachHang) {
        String sql = "UPDATE KhachHang SET TenKH = ?, DiaChi = ?, SoDT = ?, DiaChiEmail = ? WHERE MaKH = ?";
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, khachHang.getTenKH());
            statement.setString(2, khachHang.getDiaChi());
            statement.setLong(3, khachHang.getSoDT());
            statement.setString(4, khachHang.getDiaChiEmail());
            statement.setString(5, khachHang.getMaKH());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteKhachHang(String maKH) {
        String sql = "DELETE FROM KhachHang WHERE MaKH = ?";
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, maKH);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
