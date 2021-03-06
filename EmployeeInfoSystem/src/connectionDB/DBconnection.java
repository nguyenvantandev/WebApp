package connectionDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnection {
	public java.sql.Connection connection;
	
	public Connection connect() throws ClassNotFoundException, SQLException{
		try{
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/employee", "postgres", "123");
			connection.setAutoCommit(false);
		}catch(ClassNotFoundException e){
			System.out.println("Cannot find PostgreSQL JDBC Driver!");
			e.printStackTrace();
		}catch(SQLException e){
			System.out.println("Connection Failed");
			e.printStackTrace();
			throw e;
		}
		return connection;
	}

}
