package com.test.app.ws.controller.collections.response;

import java.util.ArrayList;
import java.util.List;

public class CollectionsObject {

	private String testDescription;
	private String result;
	private List<Collection> CollectionObjectArray = new ArrayList<Collection>(); //array with elements of collection

	public CollectionsObject(String testDescription, String result,
			List<Collection> collectionObjectArray) {
		super();
		this.testDescription = testDescription;
		this.result = result;
		CollectionObjectArray = collectionObjectArray;
	}
	
	public CollectionsObject(String testDescription, String result) {
		super();
		this.testDescription = testDescription;
		this.result = result;
	}

	public CollectionsObject() {
		super();
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
	public List<Collection> getCollectionObjectArray() {
		return CollectionObjectArray;
	}
	public void setCollectionObjectArray(
			List<Collection> collectionObjectArray) {
		CollectionObjectArray = collectionObjectArray;
	}
	
	
}
