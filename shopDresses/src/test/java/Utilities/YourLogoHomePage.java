package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YourLogoHomePage {
	WebDriver driver;
	Actions action;
	
	@FindBy(id="search_query_top")
	WebElement searchTextBox;
	
	@FindBy(name="submit_search")
	WebElement searchButton;
	
	@FindBy(xpath="//div[@id='block_top_menu']//a[text()='Women']")
	WebElement womenTab;
	
	@FindBy(xpath="//div[@id='block_top_menu']//a[text()='Tops']")
	WebElement womenTabTopsHead;
	
	@FindBy(xpath="(//div[@id='block_top_menu']//a[text()='T-shirts'])[1]")
	WebElement womenTabTshirtsDrill;
	
	@FindBy(xpath="//div[@id='block_top_menu']//a[text()='Blouses']")
	WebElement womenTabBlousesDrill;
	
	@FindBy(xpath="(//div[@id='block_top_menu']//a[text()='Dresses'])[1]")
	WebElement womenTabDressesHead;
	
	@FindBy(xpath="(//div[@id='block_top_menu']//a[text()='Casual Dresses'])[1]")
	WebElement womenTabCasualDressesDrill;
	
	@FindBy(xpath="(//div[@id='block_top_menu']//a[text()='Evening Dresses'])[1]")
	WebElement womenTabEveningDressesDrill;
	
	@FindBy(xpath="(//div[@id='block_top_menu']//a[text()='Summer Dresses'])[1]")
	WebElement womenTabSummerDressesDrill;
	
	@FindBy(xpath="(//div[@id='block_top_menu']//a[text()='Dresses'])[2]")
	WebElement dressesTab;
	
	@FindBy(xpath="(//div[@id='block_top_menu']//a[text()='Casual Dresses'])[2]")
	WebElement dressesTabCasualDresses;
	
	@FindBy(xpath="(//div[@id='block_top_menu']//a[text()='Evening Dresses'])[2]")
	WebElement dressesTabEveningDresses;
	
	@FindBy(xpath="(//div[@id='block_top_menu']//a[text()='Summer Dresses'])[2]")
	WebElement dressesTabSummerDressesDrill;
	
	@FindBy(xpath="(//div[@id='block_top_menu']//a[text()='T-shirts'])[2]")
	WebElement tshirtsTab;
	
	@FindBy(id="layered_id_attribute_group_2")
	WebElement sizeMCheckBox;
	
	
	public YourLogoHomePage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void setSearchTextBox(String text){
		searchTextBox.sendKeys(text);
	}
	
	public void clearSearchTextBox(){
		searchTextBox.clear();
	}
	
	public void clickSearchButton(){
		searchButton.click();
	}
	
	public void clickWomenTab(){
		womenTab.click();
	}
	
	public void clickDressesTab(){
		dressesTab.click();
	}
	
	public void clickTShirtsTab(){
		tshirtsTab.click();
	}
	
	public void mouseHoverWomenTab(Actions action){
		action.moveToElement(womenTab).perform();
	}
	
	public void clickTopUnderWomenTab(Actions action){
		action.moveToElement(womenTabTopsHead).click().perform();
	}
	
	public void clickTshirtsUnderWomenTab(Actions action){
		action.moveToElement(womenTabTshirtsDrill).click().perform();
	}
	
	public void clickBlousesUnderWomenTab(Actions action){
		action.moveToElement(womenTabBlousesDrill).click().perform();
	}
	
	public void clickDressesUnderWomenTab(Actions action){
		action.moveToElement(womenTabDressesHead).click().perform();
	}
	
	public void clickCasualDressesUnderWomenTab(Actions action){
		action.moveToElement(womenTabCasualDressesDrill).click().perform();
	}
	
	public void clickEveningDressesUnderWomenTab(Actions action){
		action.moveToElement(womenTabEveningDressesDrill).click().perform();
	}
	
	public void clickSummerDressesUnderWomenTab(Actions action){
		action.moveToElement(womenTabSummerDressesDrill).click().perform();
	}
	
	public void mouseHoverDressesTab(Actions action){
		action.moveToElement(dressesTab).perform();
	}
	
	public void clickCasualDressesUnderDressesTab(Actions action){
		action.moveToElement(dressesTabCasualDresses).click().perform();
	}
	
	public void clickEveningDressesUnderDressesTab(Actions action){
		action.moveToElement(dressesTabEveningDresses).click().perform();
	}
	
	public void clickSummerDressesUnderDressesTab(Actions action){
		action.moveToElement(dressesTabSummerDressesDrill).click().perform();
	}
	
	public void mouseHoverTShirtsTab(Actions action){
		action.moveToElement(tshirtsTab).perform();
	}
	
	public void selectSizeMCheckBox(){
		sizeMCheckBox.click();
	}
}
