package Database;

import java.sql.Connection;

import Database.JDBCUtil;

public class Tester {
	public static void main(String[] args) {
		Connection connection = JDBCUtil.getConnection();
		System.out.println(connection);
	}
}
