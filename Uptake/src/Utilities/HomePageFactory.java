package Utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageFactory {
	
	WebDriver driver;
	JavascriptExecutor js;
	
	@FindBy(xpath="(//article[@id='home']//button[text()='Learn More'])[1]")
	WebElement actionableLearnMoreEle;
	
	@FindBy(xpath="(//article[@id='home']//button[text()='Learn more'])[1]")
	WebElement transformWorldLearnMoreEle;
	
	@FindBy(xpath="(//article[@id='home']//button[text()='Ready for Results?'])[1]")
	WebElement turningDataReadyResultsEle;
	
	@FindBy(xpath="//article[@id='home']//button[text()='View Open Positions' and @class='homeSlide__button ui default button large']")
	WebElement viewOpenPositionsEle;
	
	public HomePageFactory(WebDriver driver) throws AWTException{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		js = (JavascriptExecutor) driver;
	}
	
	public void clickOnActionableInsightsLearnMore(){	
		actionableLearnMoreEle.click();
	}
	
	public void clickOnTransformingWorldLearnMore() {
		js.executeScript("arguments[0].scrollIntoView(true);", transformWorldLearnMoreEle);
		js.executeScript("arguments[0].click();", transformWorldLearnMoreEle);
	}
	
	public void clickOnTurningDataReadyForResults() {
		js.executeScript("arguments[0].scrollIntoView(true);", turningDataReadyResultsEle);
		js.executeScript("arguments[0].click();", turningDataReadyResultsEle);
	}
	
	public void clickOnViewOpenPositions() {
		js.executeScript("arguments[0].scrollIntoView(true);", viewOpenPositionsEle);
		js.executeScript("arguments[0].click();", viewOpenPositionsEle);
	}

}
