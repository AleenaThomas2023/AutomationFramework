package com.demo.nopcommerce.AutomationFramework.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.BeforeClass;

import com.demo.nopcommerce.AutomationFramework.Listeners.WebdriverEvents;
import com.demo.nopcommerce.AutomationFramework.Utils.Browsers;
import com.demo.nopcommerce.AutomationFramework.Utils.Environment;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public static WebDriver wd;// parent of all drivers
	FileInputStream fileInputStream;
	Properties prop;
	public static Logger logger;
	private WebdriverEvents events;
	private EventFiringWebDriver eDriver;
	private Browsers BROWSER = Browsers.CHROME;
	private Environment ENV = Environment.PROD;

	public TestBase() { // constructor same as class name
		prop = new Properties();

		try {
			fileInputStream = new FileInputStream(
					"./src\\main\\java\\com\\demo\\nopcommerce\\AutomationFramework\\config\\config.properties2");
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
		try {
			prop.load(fileInputStream);
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	@BeforeClass
	public void setUpLogger() {
		logger = Logger.getLogger(TestBase.class);
		PropertyConfigurator.configure("log4j.properties");
		BasicConfigurator.configure();
		logger.setLevel(Level.ALL);

	}

	public void initialisation() {

		switch (BROWSER.getBrowserName()) {
		case "Chrome":
			wd = WebDriverManager.chromedriver().create();// create method returns instance of webdriver
//			wd = new ChromeDriver(); //parent class reference variable initialized with child class constructor
			break;
		case "Edge":
			wd = WebDriverManager.edgedriver().create();
//			wd = new EdgeDriver();//parent class reference variable initialized with child class constructor
			break;
		default:
			System.out.println("Not a valid browser name");
			break;
		}

		eDriver = new EventFiringWebDriver(wd);
		events = new WebdriverEvents();
		eDriver.register(events);
		wd = eDriver;
		wd.get(ENV.getURL());
		wd.manage().timeouts().implicitlyWait(Long.parseLong(prop.getProperty("IMPLICIT_WAIT")), TimeUnit.SECONDS);

		wd.manage().window().maximize();

	}

	public void tearDown() {
		wd.quit();
	}

}
