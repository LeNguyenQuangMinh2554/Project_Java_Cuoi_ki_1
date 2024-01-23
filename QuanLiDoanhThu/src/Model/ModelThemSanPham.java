package Model;

import java.sql.PreparedStatement;
import java.sql.Connection;

import java.sql.SQLException;

import Database.JDBCUtil;

public class ModelThemSanPham {

	public void insertSanPham(int idSanPham, String tenSanPham, String loai, double gia, String ngayNhapHang,
			String ngaySanXuat, int soLuongTrongKho) {
		Connection connection = JDBCUtil.getConnection();
		String sql = "INSERT INTO SanPham (IDSanPham, TenSanPham, Loai, Gia, NgayNhapHang, NgaySanXuat, SoLuongTrongKho) VALUES (?, ?, ?, ?, ?, ?, ?)";
		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setInt(1, idSanPham);
			statement.setString(2, tenSanPham);
			statement.setString(3, loai);
			statement.setDouble(4, gia);
			statement.setString(5, ngayNhapHang);
			statement.setString(6, ngaySanXuat);
			statement.setInt(7, soLuongTrongKho);
			statement.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}	
}