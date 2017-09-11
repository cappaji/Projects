package Utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IndustriesPageFactory {
	
	WebDriver driver;
	JavascriptExecutor js;
	
	@FindBy(xpath="//article[@id='industries']//div[text()='Agriculture']")
	WebElement agricultureEle;
	
	@FindBy(xpath="//article[@id='industries']//div[text()='Aviation']")
	WebElement aviationEle;
	
	@FindBy(xpath="//article[@id='industries']//div[text()='Retail']")
	WebElement retailEle;
	
	@FindBy(xpath="//article[@id='industries']//div[text()='Mining']")
	WebElement miningEle;
	
	@FindBy(xpath="//article[@id='industries']//div[text()='construction']")
	WebElement constructionEle;
	
	@FindBy(xpath="//article[@id='industries']//div[text()='Energy']")
	WebElement energyEle;
	
	@FindBy(xpath="//article[@id='industries']//div[text()='Equipment Dealers']")
	WebElement equipmentEle;
	
	@FindBy(xpath="//article[@id='industries']//div[text()='Rail']")
	WebElement railEle;
	
	@FindBy(xpath="//article[@id='industries']//span[contains(text(),'another industry')]")
	WebElement getInTouchEle;
	
	@FindBy(xpath="//article[@id='industries']//a[text()='Visit the Uptake Newsroom']")
	WebElement nextPageEle;
	
	public IndustriesPageFactory(WebDriver driver) throws AWTException{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		js = (JavascriptExecutor) driver;
	}
	
	public void ClickOnAgriculture(){
		agricultureEle.click();
	}
	
	public void ClickOnAviation(){
		aviationEle.click();
	}
	
	public void ClickOnRetail(){
		retailEle.click();
	}
	
	public void ClickOnMining(){
		miningEle.click();
	}
	
	public void ClickOnConstruction(){
		constructionEle.click();
	}
	
	public void ClickOnEnergy(){
		energyEle.click();
	}
	
	public void ClickOnEquipmentDealers(){
		equipmentEle.click();
	}
	
	public void ClickOnRail(){
		railEle.click();
	}
	
	public void ScrollAndClickOnNextPageLink() throws InterruptedException{
		js.executeScript("arguments[0].scrollIntoView(true);", nextPageEle);
		js.executeScript("arguments[0].click();", nextPageEle);
	}

}
