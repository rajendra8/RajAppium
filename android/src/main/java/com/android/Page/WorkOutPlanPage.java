package com.android.Page;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.android.Base.BaseClass;
import com.android.Utility.ActionsClass;
import com.android.Utility.GetDateAndTime;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class WorkOutPlanPage extends BaseClass {
	private AndroidDriver<MobileElement> driver;
	GetDateAndTime getDate;
	ActionsClass actionsClass;
	List<MobileElement>list;
	@AndroidFindBy(id = "com.healthifyme.basic:id/tv_view_all")
	private MobileElement VIEW_ALL;

	@AndroidFindBy(id = "com.healthifyme.basic:id/tv_workout_summary_date")
	private MobileElement SummaryDate;

	@AndroidFindBy(xpath = "//*[@resource-id='com.healthifyme.basic:id/tv_date' and @selected='true' ]")
	private MobileElement selectedDate;

	@AndroidFindBy(xpath = "//*[@resource-id='com.healthifyme.basic:id/tv_day' and @selected='true' ]")
	private MobileElement selectedDay;

	@AndroidFindBy(uiAutomator = "text(\"Warm Up\")")
	private MobileElement Warm_Up;

	@AndroidFindBy(xpath = "text(\"Cool Down\")")
	private MobileElement Cool_Down;

	@AndroidFindBy(uiAutomator = "text(\"Workout\")")
	public MobileElement Workout;

	@AndroidFindBy(id = "com.healthifyme.basic:id/ib_track")
	public MobileElement PlusButton;

	@AndroidFindBy(uiAutomator = "text(\"TRACK ALL\")")
	public MobileElement TRACK_ALL;

	public WorkOutPlanPage(AndroidDriver<MobileElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		wait = new WebDriverWait(driver, 30);
	}

	public void selectViewAll() {
		if (VIEW_ALL.isDisplayed()) {
			VIEW_ALL.click();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		}
	}

	public void selectTodaysDate() {
		getDate = new GetDateAndTime();
		String Date = GetDateAndTime.getDateTime("date");

		driver.findElement(By.xpath("(//android.widget.TextView[@text='" + Date + "'])")).click();

	}

	public void validateDay() {
		if (selectedDay.isDisplayed()) {
			String dayName = selectedDay.getText();

			String Day = GetDateAndTime.getDateTime("day");
			Assert.assertTrue(Day.contains(dayName));
		}
	}

	public void validateDate() {
		if (selectedDate.isDisplayed()) {
			String date = selectedDate.getText();
			String Date = GetDateAndTime.getDateTime("date");
			Assert.assertTrue(Date.contains(date));
		}
	}

	public void validateAndSelectWarmUp() {
		Warm_Up.click();
		actionsClass = new ActionsClass();
		ActionsClass.scrollToText("Cool Down");
		// ActionsClass.scrollToElement("Warm Up", Warm_Up);
		List<MobileElement>list=new ArrayList<MobileElement>();
		list =  driver.findElementsByXPath("//*[@resource-id='com.healthifyme.basic:id/ib_track']");
		if(list.size()<=3) {
			
		
		for (MobileElement s : list) {
			s.click();
		}
		}
		ActionsClass.scrollToElement("Cool_Down", Cool_Down);
		// List<MobileElement> listOfPlus=(List<MobileElement>)
		// driver.findElementByXPath("//*[@resource-id='com.healthifyme.basic:id/ib_track']");
		for (MobileElement s : list) {
			s.click();
		}

	}

	public void validateAndSelectWorkOut() {
		ActionsClass.scrollToElement("Workout", Workout);

	}

	public void validateAndSelectCoolDown() {
		ActionsClass.scrollToElement("Cool Down", Cool_Down);

	}

	public void TrackALL() {
		ActionsClass.scrollToElement("Warm Up", Warm_Up);
		list=new ArrayList<MobileElement>();
		list = driver.findElementsByXPath("//*[@resource-id='com.healthifyme.basic:id/ib_track']");
		for (MobileElement s : list) {
			s.click();
			TRACK_ALL.click();

		}

	}

}