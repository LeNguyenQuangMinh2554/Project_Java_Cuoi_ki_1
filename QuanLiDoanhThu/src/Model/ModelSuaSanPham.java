package Model;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;

import Database.JDBCUtil;

public class ModelSuaSanPham {

    public void updateSanPham(int idSanPham, String tenSanPham, String loai, double gia, String ngayNhapHang,
            String ngaySanXuat, int soLuongTrongKho) {
        Connection connection = JDBCUtil.getConnection();
        String sql = "UPDATE SanPham SET TenSanPham = ?, Loai = ?, Gia = ?, NgayNhapHang = ?, NgaySanXuat = ?, SoLuongTrongKho = ? WHERE IDSanPham = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, tenSanPham);
            statement.setString(2, loai);
            statement.setDouble(3, gia);
            statement.setString(4, ngayNhapHang);
            statement.setString(5, ngaySanXuat);
            statement.setInt(6, soLuongTrongKho);
            statement.setInt(7, idSanPham);
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}