package com.test.app.ws.controller.test.response;

import java.util.ArrayList;
import java.util.List;

public class Test2Object {

	private String testDescription;
	private String result;
	private static List<Level> firstObjectArray = new ArrayList<Level>(); //array with elements of the inner class level
	
	private class Level{
		
		private String LevelNumber;
		private String LevelDescription;
		private List<ArrayObject> firstNestedObjectArray; // Level also has an object array with array objects
		
		
		public Level(String levelNumber, String levelDescription, ArrayList<ArrayObject> firstNestedObjectArray) {
			super();
			LevelNumber = levelNumber;
			LevelDescription = levelDescription;
			this.firstNestedObjectArray = firstNestedObjectArray;
			
			System.out.println("Level " + levelNumber + levelDescription + firstNestedObjectArray.size());
			
		}

		public Level(String levelNumber, String levelDescription) {
			super();
			LevelNumber = levelNumber;
			LevelDescription = levelDescription;
			
		}		
		
		public List<ArrayObject> getFirstNestedObjectArray() {
			return firstNestedObjectArray;
		}

		public void setFirstNestedObjecArray(List<ArrayObject> firstNestedObjectArray) {
			this.firstNestedObjectArray = firstNestedObjectArray;
		}

		public Level() {
			super();
		}

		public String getLevelNumber() {
			return LevelNumber;
		}
		public void setLevelNumber(String levelNumber) {
			LevelNumber = levelNumber;
		}
		public String getLevelDescription() {
			return LevelDescription;
		}
		public void setLevelDescription(String levelDescription) {
			LevelDescription = levelDescription;
		}
		
	}
	
	public Test2Object.Level returnLevelInstance(String LevelNumber, String LevelDescription){
		return new Test2Object.Level(LevelNumber, LevelDescription);
	}
	
	public Test2Object(String testDescription, String result, ArrayList<Level> firstObjectArray){
		this.setTestDescription(testDescription);
		this.setResult(result);
		this.setFirstObjectArray(firstObjectArray);
	}

	public Test2Object(String testDescription, String result){
		this.setTestDescription(testDescription);
		this.setResult(result);
		this.setFirstObjectArray(firstObjectArray);
	}	
	
	public Test2Object(){		
		//List<Level> firstObjectArray = new ArrayList<Level>();
	}	
	
	public void addArrayToTest2ObjectLevelArray(String levelNumber, String levelDescription, ArrayList<ArrayObject> firstNestedObjectArray){
		firstObjectArray.add(new Level(levelNumber,levelDescription, firstNestedObjectArray));
		System.out.println("Added element " + firstObjectArray.size());
	}
		
	
	public List<Level> getFirstObjectArray() {
		return firstObjectArray;
	}

	public void setFirstObjectArray(List<Level> firstObjectArray) {
		Test2Object.firstObjectArray = firstObjectArray;
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
