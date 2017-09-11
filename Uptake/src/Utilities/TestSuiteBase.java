package Utilities;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import java.awt.AWTException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class TestSuiteBase {
	protected WebDriver driver;
	protected HomePageFactory homePage;
	protected IndustriesPageFactory indusPage;
	protected ProductsPageFactory prodsPage;
	protected HeaderFactory header;
	protected FooterFactory footer;
	ExcelUtil eUtil;
	String filePath;
	String sheetName;
	protected String choice;

	
	@DataProvider(name="HomePageTest")
	public static Object[][] buttonText(){
		 return new Object[][]{{"ActionableInsights"},{"TransformingWorld"},{"TurningDatatoValue"},{"OpenPositions"}}; 
	  }
	
	@Parameters({"browser","url"})
	@BeforeClass()
	public void beforeClass(String browser, String url) throws AWTException 
	{
		filePath = "C:/Users/ChethanKumar/Documents/Selenium/DataDriven_Excel_Files/ProductsData.xlsx";
		sheetName = "Sheet1";
		eUtil = new ExcelUtil(filePath, sheetName);
		driver = getDriverInstance(browser, url);
		homePage = new HomePageFactory(driver);
		indusPage = new IndustriesPageFactory(driver);
		prodsPage = new ProductsPageFactory(driver);
		header = new HeaderFactory(driver);
		footer = new FooterFactory(driver);
	}
	
	public WebDriver getDriverInstance(String browser, String url)
	{
		driver = null;
		
		try{
		// Browsers
		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}
		if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}
		
		// Maximize the browser's window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// Open the Application
		driver.get(url);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return driver;
	}
	
	public void clickOnHomepageLinks(String text){
		if(text == "ActionableInsights"){
			  homePage.clickOnActionableInsightsLearnMore();
			  header.ClickOnUptakeLogo();
		  }
		  else if(text == "TransformingWorld"){
			  homePage.clickOnTransformingWorldLearnMore();
		  }
		  else if(text == "TurningDatatoValue"){
			  homePage.clickOnTurningDataReadyForResults();
			  header.ClickOnUptakeLogo();
		  }	  
		  else if(text == "OpenPositions"){
			  homePage.clickOnViewOpenPositions();
		  }
	}
	
	public void clickOnProductsLinks() throws InterruptedException{
		for(int i=1;i<=eUtil.noOfRows();i++){
			for(int j=0;j<eUtil.noOfColumns();j++){
				choice = eUtil.getCellValue(i, j);
				if(choice.equalsIgnoreCase("EquipmentMonitoring")){
					prodsPage.ClickOnEquipmentMonitoring();
					prodsPage.ClickOnBackButton();
					System.out.println("Equipment Monitoring clicked");
				}
				else if(choice.equalsIgnoreCase("DiagnosticTroubleshooting")){
					prodsPage.ClickOnDiagnosticTroubleshooting();
					prodsPage.ClickOnBackButton();
					System.out.println("DiagnosticTroubleshooting clicked");
				}
				else if(choice.equalsIgnoreCase("Cybersecurity")){
					prodsPage.ClickOnCybersecurity();
					prodsPage.ClickOnBackButton();
					System.out.println("Cybersecurity clicked");
				}	  
				else if(choice.equalsIgnoreCase("KPIDashboards")){
					prodsPage.ClickOnKPIDashboards();
					prodsPage.ClickOnBackButton();
					System.out.println("KPIDashboards clicked");
				}
				else if(choice.equalsIgnoreCase("ActionRecommendation")){
					prodsPage.ClickOnActionRecommendation();
					prodsPage.ClickOnBackButton();
					System.out.println("ActionRecommendation clicked");
				}
				else if(choice.equalsIgnoreCase("Event&ConditionPrediction")){
					prodsPage.ClickOnEventAndConditionPrediction();
					prodsPage.ClickOnBackButton();
					System.out.println("Event&ConditionPrediction clicked");
				}	  
				else if(choice.equalsIgnoreCase("Rules&Alerts")){
					prodsPage.ClickOnRulesAndAlerts();
					prodsPage.ClickOnBackButton();
					System.out.println("Rules&Alerts clicked");
				}
			}
		}
	}
	
  @Test
  public void f() {
  }


  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
