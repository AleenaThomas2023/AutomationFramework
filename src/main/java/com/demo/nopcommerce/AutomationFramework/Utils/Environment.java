package com.demo.nopcommerce.AutomationFramework.Utils;

public enum Environment {
	DEV("Dev","https://demo.nopcommerceDev.com/"),
	STAGE("Stage","https://demo.nopcommerceStge.com/"),
	QA("qa","https://demo.nopcommerceqa.com/"),
	PROD("Prod","https://demo.nopcommerce.com/");
	
	String env;
	String URL;

	private Environment(String env, String URL) {

		this.env = env;
		this.URL = URL;
	}

	public String getEnv() {
		return env;
	}

	public String getURL() {
		return URL;
	}
	
	

}
