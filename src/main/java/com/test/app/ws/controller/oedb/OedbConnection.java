package com.test.app.ws.controller.oedb;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.test.app.ws.controller.test.response.ConObjectTest;

public class OedbConnection {

	// JDBC driver name and database URL (hardcoded for now)
	static final String JDBC_DRIVER = "com.ddtek.jdbc.openedge.OpenEdgeDriver";
	static final String DB_URL = "jdbc:datadirect:openedge://localhost:20600;databaseName=MediaIndex"; //<-- service port or name (use -1 as portnumber) could also be ODBC port

	// Database credentials (should be a parameter retrieved from user)
	static final String USER = "PUB";
	static final String PASS = "PUB";
	
	Connection con = null;
	
	public OedbConnection() {
		
	}

	
	private Connection connect_db() throws SQLException  {

	   // Register the driver with the driver manager.
	   // If using Java SE 6 or higher, you can omit this step. 
	   // Java SE 6 and higher automatically registers the driver. 
	   // Still a good check weather the JAR is included or not
	   try {
		    Class.forName(JDBC_DRIVER);
	   } catch (ClassNotFoundException e) {				 
		    e.printStackTrace();
	   } 
	   // Establish the Connection
	   //String url = "jdbc:datadirect:openedge://localhost:20500;DatabaseName=Media2015";
	   con = DriverManager.getConnection(DB_URL, USER, PASS);

       // Verify the Connection
	   DatabaseMetaData metaData = con.getMetaData();
	   
	   System.out.println("Database Name: " + metaData.getDatabaseProductName());
	   System.out.println("Database Version: " + metaData.getDatabaseProductVersion());
	   
	   return con;
			   
	}
	
	public void closeConnection(){
		try{
			if(con!=null) con.close();		
		} catch(Exception e){
			e.printStackTrace();
		}	
	}
	
	public Connection getConnectionObject(){
		if(con == null){
		   try {
			   return connect_db();
		   } catch (SQLException e) {
			// TODO Auto-generated catch block
			   e.printStackTrace();
		   }
		}
		return con;
	}
	
	public ConObjectTest getConnectionObjectCheck(){
		if(con == null){
		   try {
			  con = connect_db();
		   } catch (SQLException e) {
			// TODO Auto-generated catch block
			   e.printStackTrace();
		   }
		}
        DatabaseMetaData metaData;
		try {
			metaData = con.getMetaData();
			return new ConObjectTest(metaData.getDatabaseProductName(), metaData.getDatabaseProductVersion());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ConObjectTest();		
	}	
	
}
