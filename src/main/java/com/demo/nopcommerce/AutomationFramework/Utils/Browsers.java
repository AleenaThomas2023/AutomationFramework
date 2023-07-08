package com.demo.nopcommerce.AutomationFramework.Utils;

public enum Browsers {

	CHROME("Chrome"),
	EDGE("Edge"),
	FIREFOX("Firefox"),
	SAFARI("Safari");
	
	String browserName;

	// constructor
	Browsers(String nameOfBrowser) {
		browserName = nameOfBrowser;

	}

//getters
	public String getBrowserName() {
		return browserName;
	}
	
	 
	
}
