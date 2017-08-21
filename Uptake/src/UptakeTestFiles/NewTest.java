package UptakeTestFiles;

import org.testng.annotations.Test;

import Utilities.HomePage;
import Utilities.IndustriesPage;
import org.testng.annotations.BeforeClass;

import java.awt.AWTException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class NewTest {
  
	WebDriver driver;
	String baseUrl;
	String anotherUrl;
	HomePage homePage;
	IndustriesPage indusPage;
	
  @BeforeClass
  public void beforeClass() {
//	  driver = new FirefoxDriver();
	  /* Change the driver path in setProperty as per the driver location in the executable system*/
	  System.setProperty("webdriver.chrome.driver", "D:/Software/Selenium/BrowserDrivers/chromedriver.exe");
	  driver = new ChromeDriver();
	  baseUrl = "https://www.uptake.com/";
	  anotherUrl = "https://www.uptake.com/industries";
	  try {
		homePage = new HomePage(driver);
		indusPage = new IndustriesPage(driver);
	} catch (AWTException e) {
		e.printStackTrace();
	}
	  
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);	  
  }
  
  @Test
  public void HomePageTest() throws InterruptedException {
	  driver.get(baseUrl);
	  homePage.clickOnTurningDataReadyForResults();
	  Thread.sleep(2000);
  }
  
  @Test
  public void IndustriesPageTest() throws InterruptedException {
	  Thread.sleep(2000);
	  driver.navigate().to(anotherUrl);
	  Thread.sleep(2000);
	  indusPage.ClickOnEnergy();
	  Thread.sleep(2000);
	  driver.navigate().back();
  }

  @AfterClass
  public void afterClass() throws InterruptedException {
	  Thread.sleep(4000);
	  driver.quit();
  }

}
