package com.test.app.ws.controller;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.app.ws.controller.oedb.OedbConnection;
import com.test.app.ws.controller.test.response.ArrayObject;
import com.test.app.ws.controller.test.response.ConObjectTest;
import com.test.app.ws.controller.test.response.Test1Object;
import com.test.app.ws.controller.test.response.Test2Object;

@RestController
// Start with this
@RequestMapping("tests")
// use plural
// http://localhost:8080/tests
public class TestController {
/*
	@GetMapping(path = "/{TestNr}", produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<Test1Object> getTestResult(@PathVariable String TestNr) {
		System.out.println("TestNr " + TestNr + (TestNr.equals("1")));
		if (TestNr.equals("1")) {
			System.out.println("Correct method");
			ArrayList<ArrayObject> firstObjectArray = new ArrayList<ArrayObject>();
			for (int i = 1; i < 10; i++) {
				firstObjectArray.add(new ArrayObject(i));
			}
			return new ResponseEntity<Test1Object>(new Test1Object(
					"Simple response in XML or JSON", "OK", firstObjectArray),
					HttpStatus.OK);
		}

		return new ResponseEntity<Test1Object>(HttpStatus.BAD_REQUEST);
	}
*/
	@GetMapping(path = "/{TestNr}/{TestSpec}", produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<Test2Object> getTestResult(
			@PathVariable String TestNr, @PathVariable String TestSpec) {
		
		System.out.println("TestNr " + TestNr + TestSpec);
		
		if (TestNr.equals("2") && TestSpec.equals("a")) {
			
			System.out.println("Correct method (2a)"); 
			
			for (int i = 1; i < 10; i++) {
											
				Test2Object TestObject = new Test2Object();
				
				ArrayList<ArrayObject> firstObjectArray = new ArrayList<ArrayObject>();
				for (int t = 1; t < 10; t++) {
  			       firstObjectArray.add(new ArrayObject(t));
				}
				System.out.println("Filled my array with array objects");
				TestObject.addArrayToTest2ObjectLevelArray(Integer.toString(i), "Level " + Integer.toString(i), firstObjectArray);
			}
			return new ResponseEntity<Test2Object>(new Test2Object(
					"Simple response in XML or JSON", "OK"),
					HttpStatus.OK);
		}

		return new ResponseEntity<Test2Object>(HttpStatus.BAD_REQUEST);
	}

	@GetMapping(path = "/{TestNr}", produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<ConObjectTest> getConnectionTestResult(
			@PathVariable String TestNr) {
		
		System.out.println("TestNr " + TestNr);
		
		OedbConnection oedb = new OedbConnection();
		
		if (TestNr.equals("3")){ 
				
			System.out.println("Correct method 3"); 			
			return new ResponseEntity<ConObjectTest>(oedb.getConnectionObjectCheck(), HttpStatus.OK);
		}

		return new ResponseEntity<ConObjectTest>(HttpStatus.BAD_REQUEST);
	}	
	
}
