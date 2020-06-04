package com.android.Page;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.android.Base.BaseClass;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class DashBoardPage extends BaseClass {
	private AndroidDriver<MobileElement> driver;
	
	@AndroidFindBy(id="com.healthifyme.basic:id/fl_activity_summary_fragment")
	private MobileElement Cal_Burnt;
	
	@AndroidFindBy(id="com.healthifyme.basic:id/ll_action_bar_dashboard")
	private MobileElement Today;
	
	@AndroidFindBy(id="com.healthifyme.basic:id/iv_actionbar_dashboard")
	private MobileElement TodaysDropDown;
	
	
	//Today id=com.healthifyme.basic:id/ll_action_bar_dashboard
	//DropDow of Today id =com.healthifyme.basic:id/iv_actionbar_dashboard
	
	
	
	public DashBoardPage(AndroidDriver<MobileElement> driver) {
		 this.driver = driver;
	        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	        wait = new WebDriverWait(driver, 30);
	}
	public void ClickOnCalBurnt() {
		if(Cal_Burnt.isDisplayed())
			Cal_Burnt.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
}

