package com.test.app.ws.controller.test.response;

public class ConObjectTest {

	private String productName;
	private String productVersion;
	
	public ConObjectTest() {
		super();
	}
	
	public ConObjectTest(String productName, String productVersion) {
		super();
		this.productName = productName;
		this.productVersion = productVersion;
	}
	
	public String getProductName() {
		return productName;
	}
	
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public String getProductVersion() {
		return productVersion;
	}
	
	public void setProductVersion(String productVersion) {
		this.productVersion = productVersion;
	}	
	
}
