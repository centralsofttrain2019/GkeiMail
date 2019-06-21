package jp.co.central_soft.train2019.wakaba.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dao {

	public static Connection getConnection()
			throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection con = null;

		con = DriverManager.getConnection(
			"jdbc:mysql://"
			+ "52.192.83.47"
			+ "/"
			+ "gkei_mail"
			+ "?serverTimezone=JST",
			"root",
			"root"
			);

		return con;

	}
}
