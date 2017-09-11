package Utilities;

import java.awt.AWTException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPageFactory {
	
	WebDriver driver;
	JavascriptExecutor js;
	
	@FindBy(xpath="//article[@id='products']//div[text()='Equipment Monitoring']")
	WebElement equipMonitEle;
	
	@FindBy(xpath="//article[@id='products']//div[text()='Diagnostic Troubleshooting']")
	WebElement diagtroubleShootEle;
	
	@FindBy(xpath="//article[@id='products']//div[text()='Cybersecurity']")
	WebElement cybsecurEle;
	
	@FindBy(xpath="//article[@id='products']//div[text()='KPI Dashboards']")
	WebElement kpiDashboardEle;
	
	@FindBy(xpath="//article[@id='products']//div[text()='Action Recommendation']")
	WebElement actrecomendEle;
	
	@FindBy(xpath="//article[@id='products']//div[text()='Event & Condition Prediction']")
	WebElement eventcondPredEle;
	
	@FindBy(xpath="//article[@id='products']//div[text()='Rules & Alerts']")
	WebElement ruleAlertEle;
	
	@FindBy(xpath="//article[@id='products']//a[contains(text(),'Industries We Serve')]")
	WebElement indsPageLinkEle;
	
	@FindBy(xpath="//article[@id='appModal']//span[text()='back']")
	WebElement backButtonEle;
	
	public ProductsPageFactory(WebDriver driver) throws AWTException{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		js = (JavascriptExecutor) driver;
	}
	
	public void ClickOnEquipmentMonitoring(){
		js.executeScript("arguments[0].scrollIntoView(true);", equipMonitEle);
		js.executeScript("arguments[0].click();", equipMonitEle);
	}
	
	public void ClickOnDiagnosticTroubleshooting(){
		js.executeScript("arguments[0].scrollIntoView(true);", diagtroubleShootEle);
		js.executeScript("arguments[0].click();", diagtroubleShootEle);
	}
	
	public void ClickOnCybersecurity(){
		js.executeScript("arguments[0].scrollIntoView(true);", cybsecurEle);
		js.executeScript("arguments[0].click();", cybsecurEle);
	}
	
	public void ClickOnKPIDashboards(){
		js.executeScript("arguments[0].scrollIntoView(true);", kpiDashboardEle);
		js.executeScript("arguments[0].click();", kpiDashboardEle);
	}
	
	public void ClickOnActionRecommendation(){
		js.executeScript("arguments[0].scrollIntoView(true);", actrecomendEle);
		js.executeScript("arguments[0].click();", actrecomendEle);
	}
	
	public void ClickOnEventAndConditionPrediction(){
		js.executeScript("arguments[0].scrollIntoView(true);", eventcondPredEle);
		js.executeScript("arguments[0].click();", eventcondPredEle);
	}
	
	public void ClickOnRulesAndAlerts(){
		js.executeScript("arguments[0].scrollIntoView(true);", ruleAlertEle);
		js.executeScript("arguments[0].click();", ruleAlertEle);
	}
	
	public void ClickOnIndustriesWeServeLink(){
		js.executeScript("arguments[0].scrollIntoView(true);", indsPageLinkEle);
		js.executeScript("arguments[0].click();", indsPageLinkEle);
	}
	
	public void ClickOnBackButton(){
		backButtonEle.click();
	}

}
