package Model;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import Database.JDBCUtil;

public class ModelXoaSanPham {

	public void deleteSanPham(int[] ids) throws SQLException {
		  Connection connection = JDBCUtil.getConnection();
		  String sql = "DELETE FROM SanPham WHERE IDSanPham IN (?";
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