package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSource {
	private String hostname;
	private int porta;
	private String database;
	private String username;
	private String password;
	private Connection connection;
	
	public DataSource() {
		try{
			hostname ="localhost";
			porta = 3306;
			database = "clienteWeb";
			username ="root";
			password ="senha";
			
			String url = "jdbc:mysql://"+hostname+":"+porta+"/"+database;
			
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			connection = DriverManager.getConnection(url, username, password);
			System.out.println("deu bom a connection!!  !");
		}
		catch(SQLException ex) {
			System.err.println("erro de conexão!! "+ex.getMessage());
		}
		catch(Exception ex) {
			System.err.println("erro generico!! "+ ex.getMessage());
		}

	}
	
	public Connection getConnection() {
		return this.connection;
	}
	
	public void closeDataSource() {
		try {
			connection.close();
		}
		catch (Exception e) {
			System.err.println("erro ao desconectar: "+ e.getMessage());
		}
	}
	
}
