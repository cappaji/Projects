package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GmailComposeMail {
	
	WebDriver driver;
	
	@FindBy(id="Email")
	WebElement emailIdElement;
	
	@FindBy(id="next")
	WebElement nextButton;
	
	@FindBy(id="Passwd")
	WebElement passwordElement;
	
	@FindBy(id="signIn")
	WebElement signInButton;
	
	@FindBy(xpath="//div[text()='COMPOSE']")
	WebElement composeButton;
	
	@FindBy(xpath="//div[@class='wO nr l1']//textarea")
	WebElement toAddressElement;
	
	@FindBy(xpath="//input[@name='subjectbox']")
	WebElement subjectElement;
	
	@FindBy(xpath="//div[@class='Am Al editable LW-avf']")
	WebElement contentElement;
	
	@FindBy(xpath="//div[@class='a1 aaA aMZ']")
	WebElement attachFileButton;
	
	@FindBy(xpath="//div[text()='Send']")
	WebElement sendButton;
	
	public GmailComposeMail(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void setEmailIdField(String email){
		//emailIdElement.clear();
		emailIdElement.sendKeys(email);
	}
	
	public void clickNextBuuton(){
		nextButton.click();
	}
	
	public void setPasswordField(String password){
		passwordElement.clear();
		passwordElement.sendKeys(password);
	}
	
	public void clickSignInButton(){
		signInButton.click();
	}
	
	public void clickComposeButton(){
		composeButton.click();
	}
	
	public void setToAddressField(String address){
		toAddressElement.sendKeys(address);
	}
	
	public void setSubjectField(String subject){
		subjectElement.sendKeys(subject);
	}
	
	public void setMailContent(String content){
		contentElement.sendKeys(content);
	}
	
	public void clickAttachFileButton(){
		attachFileButton.click();
	}
	
	public void clickSendButton(){
		sendButton.click();
	}

}
