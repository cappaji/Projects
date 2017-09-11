package UptakeTestFiles;

import org.testng.annotations.Test;

import Utilities.TestSuiteBase;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class UptakeProductsPageTest extends TestSuiteBase {
  
  @BeforeClass
  public void beforeClass() {
  }
  
  @Test
  public void ProductsPageTestCase() throws InterruptedException {
	  homePage.clickOnTurningDataReadyForResults();
	  clickOnProductsLinks();
	  prodsPage.ClickOnIndustriesWeServeLink();
  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
