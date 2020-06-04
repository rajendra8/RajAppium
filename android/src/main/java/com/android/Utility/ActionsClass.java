package com.android.Utility;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.testng.Assert;

import com.android.Base.BaseClass;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class ActionsClass extends BaseClass{
	
	public static boolean scrollToElement(String strElementName, MobileElement mobileElement) {
        System.out.print("We will be scrolling till the element:" + strElementName + " is displayed");
        try {
            TouchActions action = new TouchActions(driver);
            while (!mobileElement.isDisplayed()) {
            	 System.out.println("We are scrolling since the element is not displayed");
                action.scroll(mobileElement, 100, 10);
                action.perform();
            }

            return mobileElement.isDisplayed();
        } catch (Exception e) {
        	 System.out.println("Unable to scroll to element:" + strElementName);
           
            return false;
        }
    }

	 public static boolean scrollToText(String strTextToScroll) {
		 System.out.println("We will scroll to text:" + strTextToScroll);
	        String strCriteria = "";
	        By byCriteria = null;
	        strCriteria = "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(" + "new UiSelector().textMatches(\"" + strTextToScroll + "\")" + ");";
	       
	        byCriteria = MobileBy.AndroidUIAutomator(strCriteria);
	        
	        try {
	            List lstUsers = ((AndroidDriver) driver).findElementsByAndroidUIAutomator(strCriteria);
	            if (lstUsers.size() != 0 || lstUsers.size() == 0) {
	                //Scrolling to text
	                ((AndroidDriver) driver).findElementByAndroidUIAutomator(strCriteria);
	               
	              Assert.assertTrue(driver.findElementByAndroidUIAutomator(strCriteria).isDisplayed());
	            //    obj_SeleniumMethods.performSleep(3);
	                return true;
	            } else {
	                //Text is not present
	              //  Log.error("The text:" + strTextToScroll + ", is not present in the screen");
	               // obj_SeleniumMethods.performSleep(3);
	            	 Assert.assertTrue(driver.findElementByAndroidUIAutomator(strCriteria).isDisplayed());
	               // obj_SeleniumMethods.performSleep(3);
	                return false;
	            }
	        }
	        catch(Exception e)
	            {
	                return false;
	            }
	    }

}