package com.demo.nopcommerce.AutomationFramework.Utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.demo.nopcommerce.AutomationFramework.base.TestBase;

public class Utils extends TestBase {

	public static void takeScreenShot(String testName) {

		// Time Stamp

		String timeStamp = new SimpleDateFormat("dd.mm.YYYY.HH.mm.ss").format(new Date());
//		System.out.println(timeStamp);

		// Take a screen shot

		File screenshotFile = ((TakesScreenshot) wd).getScreenshotAs(OutputType.FILE);

//Save Screen shot
		try {
			FileUtils.copyFile(screenshotFile, new File("./FailedTestsScreenShot\\" + " _" + testName + "_" + timeStamp + ".jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
