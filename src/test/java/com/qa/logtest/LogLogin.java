package com.qa.logtest;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;



public class LogLogin {
	
	//What is log?
	//Capturing the information/activity at the time of proram execution.
	//Types of logs-
	//info
	//warning
	//error
	//fatal

	WebDriver driver;
	@BeforeMethod
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver","G:\\All Drivers\\drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		//driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.freecrm.com/index.html");
	}
	
	@Test(priority=1)
	public void freeCrmTestTitle()
	{
		String title=driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title, "#1 Free CRM software in the cloud for sales and service");
	}
	
	@Test(priority=2)
	public void freeCrmLogo()
	{
		Boolean b=driver.findElement(By.xpath("//img[@class='img-responsive' and @alt='free crm logo']")).isDisplayed();
		Assert.assertTrue(b);
	}
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
}
