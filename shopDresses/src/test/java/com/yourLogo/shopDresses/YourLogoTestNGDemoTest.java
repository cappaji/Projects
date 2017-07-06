package com.yourLogo.shopDresses;

import org.testng.annotations.Test;

import Utilities.YourLogoHomePage;

import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;

public class YourLogoTestNGDemoTest {
	
	WebDriver driver;
	String baseUrl;
	YourLogoHomePage homePage;
	Actions action;
	
  @BeforeMethod
  public void beforeMethod() {
	  driver = new ChromeDriver();
		baseUrl = "http://automationpractice.com/";
		homePage = new YourLogoHomePage(driver);
		
		action = new Actions(driver);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
  }
  
  @Test
  public void testMethod() throws InterruptedException {
	  driver.get(baseUrl);
		
		homePage.setSearchTextBox("blouse");
		homePage.clickSearchButton();
		
		Thread.sleep(2000);
		homePage.mouseHoverWomenTab(action);
		Thread.sleep(2000);
		homePage.clickCasualDressesUnderWomenTab(action);
		
		Thread.sleep(2000);
		homePage.mouseHoverDressesTab(action);
		Thread.sleep(2000);
		homePage.clickEveningDressesUnderDressesTab(action);
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
