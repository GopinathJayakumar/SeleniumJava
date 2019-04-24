package selenium.db.pro;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DB_Connection {

	static final String jdbc_driver  = "com.mysql.cj.jdbc.Driver";
	static final String jdbc_url = "jdbc:mysql://localhost:3306/tapsg";
	static final String uName = "root";
	static final String pwd = "Arch@123";
	static Connection con = null;

	public static void main(String[] args) {
		createTable();
		post();
	}

	//load
	public static Connection getConnection() {		
		try {
			Class.forName(jdbc_driver);
			System.out.println("Driver loaded");
			con= DriverManager.getConnection(jdbc_url, uName, pwd);				
		}
		catch (ClassNotFoundException e) {System.out.println("Driver issue");}
		catch (SQLException e) {System.out.println("Unexpected error occured");}
		return con;
	}
	
	//Create Table
	public static void createTable() {
		con = getConnection();
		try {
			PreparedStatement create = con.prepareStatement("CREATE TABLE IF NOT EXISTS gopifirsttable(id int NOT NULL AUTO_INCREMENT,"
					+ "firstname varchar(255), lastname varchar(255), PRIMARY KEY(id))");			
			create.executeUpdate();			
		} catch (SQLException e) {System.out.println("Something wrong");}		
	}

	//Insert
	public static void post() {
		con = getConnection();
		try {
			PreparedStatement posted = con.prepareStatement("INSERT INTO gopifirsttable (firstname, lastname) VALUES ('Gopinath', 'Jayakumar')");
			posted.executeUpdate();
			System.out.println("Insert Completed");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Unexpected problem occured while inserting");}
	}
}
