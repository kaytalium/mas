package cw.heslop.mas.objects;
import java.sql.ResultSet;
import java.sql.SQLException;

public class IDGenerator extends DatabaseConnection{

	private int idLength = 2;
	private int newID;
	
	
	public IDGenerator() {
		// TODO Auto-generated constructor stub
		super("mas");
	}


	public int getIdLength() {
		return idLength;
	}


	public void setIdLength(int idLength) {
		this.idLength = idLength;
	}


	public int getNewID() {
		try {
			newID = ID();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return newID;
	}
	
	private int ID() throws SQLException {
		
		int number= 1;
		String query = "Select id from person";
		this.connectToDatabase();
		ResultSet rs = this.executeStatementReturnResult(query);
		
		int lastRow = 0;
		while(rs.next()) {
			lastRow = rs.getInt("id");
		}
		
		//we need the know how far the database is with the ids and the create the next id in sequence or create random numbers greater than the count 
		//or on the same level as db
		if(lastRow > 0) {
			number = lastRow + 1;
		}
		return number;
	}
	
	
}
