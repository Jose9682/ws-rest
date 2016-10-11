package com.youtube.dao;
import javax.naming.*;
import javax.sql.*;

import java.sql.Connection;
 
public class Oracle308tube {

	private static DataSource Oracle308tube = null; //hold the database object
	private static Context context = null; //used to lookup the database connection in weblogic
	

	public static DataSource Oracle308tubeConn() throws Exception {
		
		/**
		 * check to see if the database object is already defined...
		 * if it is, then return the connection, no need to look it up again.
		 */
		if (Oracle308tube != null) {
			return Oracle308tube;
		}
		
		try {
			
			/**
			 * This only needs to run one time to get the database object.
			 * context is used to lookup the database object in weblogic
			 * Oracle308tube will hold the database object
			 */
			if (context == null) {
				context = new InitialContext();
			}
			
			Oracle308tube = (DataSource) context.lookup("308tubeOracle");
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return Oracle308tube;
		
	}
	
	
	/**
	 * This method will return the connection to the Oracle 308tube schema
	 * Note that the scope is protected which means only java class in the
	 * dao package can use this method.
	 * 
	 * @return Connection to 308tube Oracle database.
	 */
	protected static Connection oraclePcPartsConnection() {
		Connection conn = null;
		try {
			conn = Oracle308tubeConn().getConnection();
			return conn;
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
}