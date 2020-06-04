package com.android.TestCase;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.android.Base.BaseClass;
import com.android.Page.DashBoardPage;
import com.android.Page.LoginPage;
import com.android.Page.WorkOutPlanPage;

public class LoginPageTest extends BaseClass{
    BaseClass baseClass;
	LoginPage loginpage;
	DashBoardPage dashBoardPage;
	WorkOutPlanPage workoutPage;
	public LoginPageTest() throws IOException {
		super();
		
	}
	
	@BeforeClass
	public void setUp() throws IOException {
		baseClass.setup();
		loginpage=new LoginPage(driver);
		dashBoardPage=new DashBoardPage(driver);
		workoutPage=new WorkOutPlanPage(driver);
	}
	
	@AfterClass
	public void quit() {
		driver.quit();
	}
	
	@Test(priority=1)
	public void allreadySinIn() throws Exception {
		Thread.sleep(1000);
		//boolean flag=loginpage.isDisplayed();
		//Assert.assertTrue(flag);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		loginpage.Already_Login();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		loginpage.LoginWithEmailAdress();
	}
	@Test(priority=2)
	public void loginTest() {
		loginpage.login(pro.getProperty("userId"), pro.getProperty("Password"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	//	wait=new WebDriverWait(10,)
	//	loginpage.acceptAlert();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println("Navigating Back");
		driver.navigate().back();
	
	}
	
	@Test(priority=3)
	public void  dashBoardScrren() {
		dashBoardPage.ClickOnCalBurnt();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//workoutPage.selectTodaysDate();
		workoutPage.selectViewAll();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		workoutPage.validateAndSelectWarmUp();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		workoutPage.validateAndSelectWorkOut();
		workoutPage.validateAndSelectCoolDown();
		workoutPage.TrackALL();
		
	}
}

