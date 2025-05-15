package dao;

import java.sql.Connection;
import java.sql.SQLException;

import util.DBConnectionUtil;

public  abstract class BaseDAO {
	
	protected Connection getConnection () throws SQLException{
		return DBConnectionUtil.getConnection();
		
	}

}
