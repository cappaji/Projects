package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FooterFactory {
	
	WebDriver driver;
	
	@FindBy(xpath="//footer[@id='footer']//a[text()='Learn More']")
	WebElement learnMoreEle;
	
	@FindBy(xpath="(//footer[@id='footer']//img[@alt='twitter: @uptake'])[1]")
	WebElement twitterEle;
	
	@FindBy(xpath="(//footer[@id='footer']//img[@alt='instagram: @theuptakers'])[1]")
	WebElement instaEle;
	
	@FindBy(xpath="(//footer[@id='footer']//img[@alt='linkedIn'])[1]")
	WebElement linkedInEle;
	
	@FindBy(xpath="//footer[@id='footer']//a[text()='Privacy Policy']")
	WebElement privPolicyEle;
	
	@FindBy(xpath="(//footer[@id='footer']//a[text()='Careers'])[1]")
	WebElement careersEle;
	
	@FindBy(xpath="(//footer[@id='footer']//button[text()='Contact'])[1]")
	WebElement contactButton;
	
	public FooterFactory(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void ClickOnLearnMore(){
		learnMoreEle.click();
	}
	
	public void ClickOnTwitterImage(){
		twitterEle.click();
	}
	
	public void ClickOnInstagramImage(){
		instaEle.click();
	}
	
	public void ClickOnLinkedInImage(){
		linkedInEle.click();
	}
	
	public void ClickOnPrivacyPolicy(){
		privPolicyEle.click();
	}
	
	public void ClickOnCareers(){
		careersEle.click();
	}
	
	public void ClickOnContactButton(){
		contactButton.click();
	}

}
