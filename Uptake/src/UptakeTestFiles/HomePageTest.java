package UptakeTestFiles;

import org.testng.annotations.Test;
import Utilities.TestSuiteBase;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;

public class HomePageTest extends TestSuiteBase{
		 	
  @BeforeClass
  public void beforeClass() {
		
  }
  
  @Test(dataProvider="HomePageTest")
  public void UptakeHomePageTestCase(String text) {
	  clickOnHomepageLinks(text);
  }
  
  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
