package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
 
public class DBConnectionUtil {
	
	public static final String URL="jdbc:/postgresql://localhost:5432//ContactMangementSystem ";
	public static final String USERNAME="postgres";
    public static final String PASSWORD="vinisha@97";
    
    public static Connection getConnection() throws SQLException{
    	 
    	return DriverManager.getConnection(URL,USERNAME,PASSWORD);
    }
}
