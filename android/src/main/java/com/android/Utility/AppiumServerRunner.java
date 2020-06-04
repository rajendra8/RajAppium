package com.android.Utility;


import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.net.UrlChecker;
import org.openqa.selenium.remote.DesiredCapabilities;


import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class AppiumServerRunner{
	private AppiumDriverLocalService service;
	private AppiumServiceBuilder builder;
	private Properties pro;
	private DesiredCapabilities dec;
	
	
	 public  AppiumDriverLocalService startServer() {
		 builder=new AppiumServiceBuilder();
		// dc=new DesiredCapabilities();
		
		 Map<String, String> env = new HashMap<String, String>(System.getenv());
	     env.put("PATH", "/usr/local/bin:" + env.get("PATH"));
	   //  dec.setCapability("noReset", "false");
	     //Build the Appium service
	     builder = new AppiumServiceBuilder();
	     builder.withIPAddress("127.0.0.1");
	     builder.usingAnyFreePort();
	     builder.withCapabilities(dec);
	     builder.withEnvironment(env);
	     builder.withArgument(GeneralServerFlag.SESSION_OVERRIDE);
	     builder.withArgument(GeneralServerFlag.LOCAL_TIMEZONE);
	     builder.withArgument(GeneralServerFlag.LOG_LEVEL, "info");
	     
	     service=AppiumDriverLocalService.buildService(builder);
	     
	     System.out.print("Server start On url"+service.getUrl());
	     
	     service.start();
	     System.out.println("Validating whether the url is up and running...");
	 
	 final URL status;
     try {
         status = new URL(service.getUrl() + "/sessions");
         new UrlChecker().waitUntilAvailable(1, TimeUnit.MINUTES, status);
        
     } catch (MalformedURLException e) {
         
         System.out.println("Error in the URL provided. " + e.toString());
         //instance.terminateAll("Could not start a new session with the URL provided. " + e.toString());
         e.printStackTrace();
     } catch (UrlChecker.TimeoutException e) {
        
         System.out.println(String.format("Server at the URL (%s) is not running. %s.", service.getUrl(), e.toString()));
         e.printStackTrace();
     }
     return service;
 }

 public void stopServer(AppiumDriverLocalService service) {
     service.stop();
 }

 public boolean checkIfServerIsRunnning() {
     boolean isServerRunning = false;
     ServerSocket serverSocket;
     try {
         serverSocket = new ServerSocket();
         serverSocket.close();
     } catch (IOException e) {
         //If control comes here, then it means that the port is in use
        
         isServerRunning = true;
     } finally {
         serverSocket = null;
     }
     return isServerRunning;
 }
}