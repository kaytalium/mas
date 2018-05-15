package cw.heslop.mas.objects;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection{

	//Connection strings 
	private String host		= "localhost";
	private String username	= "root";
	private String password	= "admin";
	private String database	= "system_users";
	
	//private vars
	private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

	public DatabaseConnection(){
		connectToDatabase();
	}
	
	public DatabaseConnection(String database){
		this.database = database;
		connectToDatabase();
	}
	
	public DatabaseConnection(String host, String username, String password, String database){
		this.host = host;
		this.username = username;
		this.password = password;
		this.database = database;
		
		connectToDatabase();
	}
	
	
	public void connectToDatabase() {
		try {
			  Class.forName("com.mysql.jdbc.Driver");
		      
		      // Setup the connection with local  server and DB
		      connect = DriverManager
		    		  .getConnection("jdbc:mysql://" + host + "/" + database +"?"
		    	              + "user=" + username + "&password=" + password );
		  }catch (Exception e){
			//Turn this off for production and add your own error
			  e.printStackTrace();
		  }
		 
	}
	
	public ResultSet executeStatementReturnResult(String query) {
	      try {
	    	// Statements allow to issue SQL queries to the database
			statement = this.connect.createStatement();
			 
			// Result set get the result of the SQL query
			return  resultSet = statement.executeQuery(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	     
	    
	}
	
	public void CRUD(String query){
		try {
			this.preparedStatement = connect.prepareStatement(query);
			this.preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void CRUD(String query, String[] params) {
		try {
			this.preparedStatement = connect.prepareStatement(query);
			this.preparedStatement.setString(1, params[1]);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	
}
