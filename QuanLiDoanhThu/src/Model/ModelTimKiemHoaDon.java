package Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Database.JDBCUtil;

public class ModelTimKiemHoaDon {
	private JDBCUtil dbConnection;

    public ModelTimKiemHoaDon() {
        dbConnection = new JDBCUtil();
    }

    public ResultSet searchHoaDon(String tenNguoiMua, String soDienThoai) throws SQLException {
    	String query = "SELECT * FROM HoaDon WHERE TenNguoiMua = ? AND SoDienThoai = ?";
    	PreparedStatement preparedStatement = dbConnection.getConnection().prepareStatement(query);
    	preparedStatement.setString(1, tenNguoiMua);
    	preparedStatement.setString(2, soDienThoai);
    	return preparedStatement.executeQuery();
    	
    }
}