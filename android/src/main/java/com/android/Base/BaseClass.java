package com.android.Base;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.android.Utility.AppiumServerRunner;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class BaseClass {
 public static AndroidDriver<MobileElement> driver;
 public static WebDriverWait wait;
 public static AppiumDriverLocalService service;
 public static AppiumServerRunner Appiumserver;
 public static Properties pro;
 public static DesiredCapabilities dc;
 
 public BaseClass() {
	 pro=new Properties();
	 try {
		 FileInputStream fis=new FileInputStream(new File("/Users/rksahu/Documents/AppiumClasses/RajAppium/src/main/java/com/raj/Configration/config.Properties"));
         pro.load(fis);
      } catch(FileNotFoundException fnfe) {
         fnfe.printStackTrace();
      } catch(IOException ioe) {
         ioe.printStackTrace();
      } 

 }
 
 public static void setup() throws MalformedURLException {
	 
//     Appiumserver=new AppiumServerRunner();
//     
//	 if(!Appiumserver.checkIfServerIsRunnning()) {
//		 service = Appiumserver.startServer();
//        System.out.println("Appium Server start is successful");
//	 }
	 dc=new  DesiredCapabilities();
	 
	 dc.setCapability("platformName", "android");
	 dc.setCapability("plateformVersion", "11.0");
	 dc.setCapability("deviceName", "redmi");
	 dc.setCapability("udid", "6c8acc897d34");
	 dc.setCapability("automationName", "UiAutomator2");
	 dc.setCapability("autoGrantPermissions",true);
	 dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,"com.healthifyme.basic");
	 dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,"com.healthifyme.basic.activities.NewLoginSignupActivity");
	 driver= new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4724/wd/hub"), dc);
	// driver = new AndroidDriver<MobileElement>(service.getUrl(),dc);
	 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
 }
 
	
}

