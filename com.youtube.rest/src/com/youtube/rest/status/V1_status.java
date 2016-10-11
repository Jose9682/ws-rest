package com.youtube.rest.status;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.sql.*;

import com.youtube.dao.*;


@Path("/v1/status")
public class V1_status {

	
	//private static final String api_version = "00.01.00"; //version of the api
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String returnTitle() {
		return "<p>Java Web Service Jose Medina OK</p>";
	}
	
	
	@Path("/version")
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String returnVersion() {
		
		String resultado="";
		
		
		//Map<Integer, String> map = new HashMap<Integer, String>();
		//Map<Integer, String> map = new TreeMap<Integer, String>();
		Map<Integer, String> map = new LinkedHashMap<Integer, String>();
		List<String> name = new ArrayList<String>();
		
		map.put(1, "Usando LinkedHashMap ");
		map.put(2, "Jose");
		map.put(3, "Gregorio");
		map.put(4, "Medinas");
		map.put(5, "Chauran");
		
		for(Integer valor : map.keySet()){
			
			System.out.println(map.get(valor));
			
			//resultado+= " "+ map.get(valor);
			
			
		}
		
		name.add("Usando ArrayList");
		name.add("Jose");
		name.add(" Gregorio");
		name.add(" Medina");
		name.add(" Chauran");
		
		//Collections.sort(name);
		for(String v : name){
			
			resultado+= v;
		}
		
		
		
		
		
		return "<h1>"+resultado+"</h1>";
	}
	
	
	
	@Path("/database")
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String returnDatabaseStatus() throws Exception {
		
		PreparedStatement query = null;
		String myString = null;
		String returnString = null;
		Connection conn = null;
		
		try {
			
			conn = Oracle308tube.Oracle308tubeConn().getConnection(); //calls the method defined in the Oracle308tube package
			
			//simple sql query to return the date/time
			query = conn.prepareStatement("select to_char(sysdate,'YYYY-MM-DD HH24:MI:SS') DATETIME " +
					"from sys.dual");
			
			//query = conn.prepareStatement("select nombre from jm.LOGIN");
			
			ResultSet rs = query.executeQuery();
			
			//loops through the results and save it into myString
			while (rs.next()) {
				// /*Debug*/ System.out.println(rs.getString("DATETIME"));
				myString = rs.getString("DATETIME");
				//myString = rs.getString("NOMBRE");
			}
			
			query.close(); //close connection
			
			returnString = "<p>Database Status</p> " +
				"<p>Database Date/Time return: " + myString + "</p>";
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		/**
		 * The finally cause will always run. Even if the the method get a error.
		 * You want to make sure the connection to the database is closed.
		 */
		finally {
			if (conn != null) conn.close();
		}
		
		return returnString; 
	}

	
	
}
