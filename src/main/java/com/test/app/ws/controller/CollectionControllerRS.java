package com.test.app.ws.controller;

import java.sql.SQLException;

import org.json.JSONArray;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.app.ws.controller.oedb.OedbConnection;
import com.test.app.ws.controller.oedb.OedbQuery;

@RestController
@RequestMapping("CollectionsRS")
public class CollectionControllerRS {

	@GetMapping (produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> getCollectionsRS(){
	
		OedbConnection oedb = new OedbConnection();
		try {
			OedbQuery oequery = new OedbQuery(oedb.getConnectionObject(), "SELECT * FROM PUB.CollectionIndex");
			return new ResponseEntity<String>(oequery.executeQueryJson(), HttpStatus.OK);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
		finally{
			
			oedb.closeConnection();
		}
		
	}
	
}
