package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HeaderFactory {
	
	WebDriver driver;
	
	@FindBy(xpath="//header[@id='header']//img[@alt='UPTAKE' and @width='194']")
	WebElement uptakeLogoEle;
	
	@FindBy(xpath="//header[@id='header']//a[text() ='About' and @class='menu__item']")
	WebElement aboutEle;
	
	@FindBy(xpath="//header[@id='header']//a[text() ='Products' and @class='menu__item']")
	WebElement productsEle;
	
	@FindBy(xpath="//header[@id='header']//a[text() ='Industries' and @class='menu__item']")
	WebElement industriesEle;
	
	@FindBy(xpath="//header[@id='header']//a[text() ='Newsroom' and @class='menu__item']")
	WebElement newsroomEle;
	
	@FindBy(xpath="//header[@id='header']//a[text() ='Beyond.Uptake' and @class='menu__item']")
	WebElement beyondUptakeEle;
	
	@FindBy(xpath="//header[@id='header']//a[text() ='Blog' and @class='menu__item']")
	WebElement blogEle;
	
	@FindBy(xpath="//header[@id='header']//button[text()='Request More Info' and @class='ui primary button cta']")
	WebElement moreInfoButton;
	
	public HeaderFactory(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void ClickOnUptakeLogo(){
		uptakeLogoEle.click();
	}
	
	public void ClickOnAboutTab(){
		aboutEle.click();
	}
	
	public void ClickOnProductsTab(){
		productsEle.click();
	}
	
	public void ClickOnIndustriesTab(){
		industriesEle.click();
	}
	
	public void ClickOnNewsroomTab(){
		newsroomEle.click();
	}
	
	public void ClickOnBeyondUptakeTab(){
		beyondUptakeEle.click();
	}
	
	public void ClickOnBlogTab(){
		blogEle.click();
	}
	
	public void ClickOnRequestMoreInfoButton(){
		moreInfoButton.click();
	}

}