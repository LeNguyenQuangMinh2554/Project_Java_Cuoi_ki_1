package Model;

import java.sql.PreparedStatement;

import java.sql.Connection;

import java.sql.SQLException;

import Database.JDBCUtil;

public class ModelXoaHoaDon {

	public void deleteHoaDon(int[] ids) throws SQLException {
		  Connection connection = JDBCUtil.getConnection();
		  String sql = "DELETE FROM HoaDon WHERE IDHoaDon IN (?";
		  for (int i = 1; i < ids.length; i++) {
		    sql += ", ?";
		  }
		  sql += ")";

		  PreparedStatement statement = connection.prepareStatement(sql);
		  for (int i = 0; i < ids.length; i++) {
		    statement.setInt(i + 1, ids[i]);
		  }

		  statement.executeUpdate();
		}

}