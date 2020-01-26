package com.test.app.ws.controller.test.response;

import java.util.ArrayList;
import java.util.List;

public class Test1Object {

	private String testDescription;
	private String result;
	private List<ArrayObject> firstObjectArray;
	
	public Test1Object(String testDescription, String result, ArrayList<ArrayObject> firstObjectArray){
		this.setTestDescription(testDescription);
		this.setResult(result);
		this.setFirstObjectArray(firstObjectArray);
	}

	public Test1Object(){		
		
	}	
	
	public List<ArrayObject> getFirstObjectArray() {
		return firstObjectArray;
	}

	public void setFirstObjectArray(List<ArrayObject> firstObjectArray) {
		this.firstObjectArray = firstObjectArray;
	}

	public String getTestDescription() {
		return testDescription;
	}
	public void setTestDescription(String testDescription) {
		this.testDescription = testDescription;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	
	
}
