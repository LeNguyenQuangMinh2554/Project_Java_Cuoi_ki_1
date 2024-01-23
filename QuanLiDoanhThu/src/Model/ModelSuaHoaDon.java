package Model;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;

import Database.JDBCUtil;

public class ModelSuaHoaDon {

    public void updateHoaDon(int idHoaDon, String tenNguoiMua, int soDienThoai, String ngayMua, int idSanPham,
            String tenSanPham, int soLuongMua, Double tongGia) {
        Connection connection = JDBCUtil.getConnection();
        String sql = "UPDATE HoaDon SET TenNguoiMua = ?, SoDienThoai = ?, NgayMua = ?, IDSanPham = ?, TenSanPham = ?, SoLuongMua = ?, TongGia = ? WHERE IDHoaDon = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, tenNguoiMua);
            statement.setInt(2, soDienThoai);
            statement.setString(3, ngayMua);
            statement.setInt(4, idSanPham);
            statement.setString(5, tenSanPham);
            statement.setInt(6, soLuongMua);
            statement.setDouble(7, tongGia);
            statement.setInt(8, idHoaDon);
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}