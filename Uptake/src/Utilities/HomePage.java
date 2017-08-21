package Utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver;
	Robot robot;
	Actions action;
	
	public HomePage(WebDriver driver) throws AWTException{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		robot = new Robot();
		action = new Actions(driver);
	}
	
	@FindBy(xpath="(//article[@id='home']//button[text()='Learn More'])[1]")
	WebElement actionableLearnMoreEle;
	
	@FindBy(xpath="(//article[@id='home']//button[text()='Learn more'])[1]")
	WebElement transformWorldLearnMoreEle;
	
	@FindBy(xpath="(//article[@id='home']//button[text()='Ready for Results?'])[1]")
	WebElement turningDataReadyResultsEle;
	
	@FindBy(xpath="//article[@id='home']//button[text()='View Open Positions' and @class='homeSlide__button ui default button large']")
	WebElement viewOpenPositionsEle;
	
	public void clickOnActionableInsightsLearnMore(){	
		actionableLearnMoreEle.click();
	}
	
	public void clickOnTransformingWorldLearnMore() throws InterruptedException{
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(2000);
		transformWorldLearnMoreEle.click();
	}
	
	public void clickOnTurningDataReadyForResults() throws InterruptedException{
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(2000);
		action.moveToElement(turningDataReadyResultsEle).click().build().perform();
	}
	
	public void clickOnViewOpenPositions(WebDriver driver) throws InterruptedException{
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(2000);
		action.moveToElement(viewOpenPositionsEle).click().perform();
	}

}
