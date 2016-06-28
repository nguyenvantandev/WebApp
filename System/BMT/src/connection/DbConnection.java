package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

	public java.sql.Connection connection;
//	Statement stm = null;

	public Connection connect() throws ClassNotFoundException, SQLException {
		try {
			Class.forName("org.postgresql.Driver");
			
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/BMT", "postgres", "123");
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

//	public ResultSet resultSet(String stringSql) throws SQLException {
//		ResultSet rs = null;
//		try {
//			stm = this.connection.createStatement();
//			System.out.println(stringSql);
//			rs = stm.executeQuery(stringSql);
//
//		} catch (SQLException e) {
//			
//			System.out.println(e.toString());
//			throw e;
//		}
//		return rs;
//	}

	public void closeConnect() throws SQLException {
		try {
			if (this.connection != null && !this.connection.isClosed()){
				this.connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
	}

}
