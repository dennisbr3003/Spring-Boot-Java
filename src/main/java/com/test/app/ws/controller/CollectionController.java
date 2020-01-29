package com.test.app.ws.controller;

import java.sql.SQLException;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.app.ws.controller.collections.response.CollectionsObject;
import com.test.app.ws.controller.oedb.OedbConnection;
import com.test.app.ws.controller.oedb.OedbQuery;
import com.test.app.ws.controller.test.response.ConObjectTest;

@RestController
@RequestMapping("Collections")

public class CollectionController {

	@GetMapping(path = "/{ConnectionCheck}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ConObjectTest> testConnection (@PathVariable String ConnectionCheck){
	
		OedbConnection oedb = new OedbConnection();
		return new ResponseEntity<ConObjectTest>(oedb.getConnectionObjectCheck(), HttpStatus.OK);
		
	}
	//TODO TESTEN
	@GetMapping (produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CollectionsObject> getCollections(){
	
		OedbConnection oedb = new OedbConnection();
		try {
			OedbQuery oequery = new OedbQuery(oedb.getConnectionObject(), "SELECT * FROM PUB.CollectionIndex");
			return new ResponseEntity<CollectionsObject>(oequery.executeQuery(), HttpStatus.OK);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<CollectionsObject>(HttpStatus.BAD_REQUEST);
		}
		finally{
			oedb.closeConnection();
		}
		
	}	
	
	
}
