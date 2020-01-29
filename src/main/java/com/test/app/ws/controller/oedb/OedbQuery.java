package com.test.app.ws.controller.oedb;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.test.app.ws.controller.collections.response.Collection;
import com.test.app.ws.controller.collections.response.CollectionsObject;

public class OedbQuery {

	private Connection con;
	private String query;
	private Statement stmt = null;

	public OedbQuery(Connection con) throws SQLException {
		super();
		this.con = con;
	}	
	
	public OedbQuery(Connection con, String query) throws SQLException {
		super();
		this.con = con;
		this.query = query;
	}

	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}
	
	public CollectionsObject executeQuery() throws SQLException{
		
		if(con == null){
		  System.out.println("Connection = null, do not execute query");
		  return null;
		}
		
		stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		
		if (rs.next() == false) {
			System.out.println("ResultSet in empty");
			throw new SQLException();
		}
		
		CollectionsObject co = new CollectionsObject();
		ArrayList<Collection> sco = new ArrayList<Collection>();
		co.setTestDescription("Test resultset");
		// use rs.next() to check if the result set retrieved any record if it did, we are now at the first row.
		// So in order not to miss the first row we will use it and go to the next after we do execute the logic 
		do {
			System.out.println(rs.getInt("iCollectionNumber"));
			/* create some object or return result set directly ? */
			sco.add(new Collection(rs.getInt("iCollectionNumber"), rs.getString("cCollectionName")));
		} while(rs.next());

		co.setCollectionObjectArray(sco);
		co.setResult("OK");
		
		System.out.println("Done");

		// Clean-up environment
		rs.close();
		stmt.close();		
		
		return co;

	}
	
	
}
