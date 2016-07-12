package co.jp.myapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDao {

	public java.sql.Connection connection;

	public Connection connect() throws ClassNotFoundException, SQLException {
		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/japanese", "postgres", "123");
			connection.setAutoCommit(false);
		} catch (ClassNotFoundException e) {
			System.out.println("Cannot find PostgreSQL JDBC Driver!");
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			System.out.println("Connection Failed!");
			e.printStackTrace();
			throw e;
		}
		return connection;
	}

	public void closeConnect() throws SQLException {
		try {
			if (this.connection != null && !this.connection.isClosed()) {
				this.connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
	}
}