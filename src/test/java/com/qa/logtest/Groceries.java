package com.qa.logtest;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.log4testng.Logger;



public class Groceries {
	
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
		driver.get("http://162.222.32.20:1455/storeAdmin/login");
	    
	}
	
	@Test(priority=2)
	public void groceriesTest()
	{
		String title=driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title, "GroceriesAdmin");
	}
	
	@Test(priority=1)
	public void loginTest() throws Exception
	{
		WebElement username=driver.findElement(By.xpath("//input[@placeholder='Email id']"));
		username.sendKeys("emaidl");
		WebElement password=driver.findElement(By.xpath("//input[@placeholder='Password']"));
		password.sendKeys("lasdlsfjs");
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		WebElement btnButton=driver.findElement(By.xpath("//button[@type='submit']"));
		
		btnButton.click();
		Thread.sleep(4000);
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
}
