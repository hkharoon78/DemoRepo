package com.qa.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestLogin {
	public WebDriver driver;
	
	@BeforeMethod
	public void setUp()
	
	{   
		
		System.setProperty("webdriver.chrome.driver", "G:\\All Drivers\\drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://www.freecrm.com/index.html");
		String title=driver.getTitle();
		System.out.print("crmPage Title:"+title);
		driver.manage().window().maximize();
		//driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
	}
	
	
	@Test
	public void testLogin() throws Exception
	{
		
		driver.findElement(By.xpath("//a[@href='https://www.freecrm.com/register/']//font[@color='red']")).click();
//		driver.findElement(By.xpath("//input[@name='username']")).clear();
//		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("naveenk");
//		driver.findElement(By.xpath("//input[@name='password']")).clear();
//		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("test@123");
//		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		Thread.sleep(4000);
		
	}
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	


}
