package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class MortgageCalculator {
	
	WebDriver driver;
	
	@FindBy(name="param[homevalue]")
	WebElement homeValueElement;
	
	@FindBy(how=How.ID, using="loanamt")
	WebElement loanAmountElement;
	
	@FindBy(how=How.ID,using="intrstsrate")
	WebElement interestRateElement;
	
	@FindBy(how=How.ID,using="loanterm")
	WebElement loanTermElement;
	
	@FindBy(how=How.NAME,using="param[start_month]")
	WebElement startMonthElement;
	
	@FindBy(how=How.NAME,using="param[start_year]")
	WebElement startYearElement;
	
	@FindBy(how=How.ID,using="pptytax")
	WebElement propertyTaxElement;
	
	@FindBy(how=How.ID,using="pmi")
	WebElement pmiElement;
	
	@FindBy(how=How.NAME,using="cal")
	WebElement clickButton;
	
	
	public void setHomeValue(String value){
		homeValueElement.clear();
		System.out.println(value);
		homeValueElement.sendKeys(value);
	}
	
	public void setLoanAmount(String amount){
		loanAmountElement.clear();
		loanAmountElement.sendKeys(amount);
	}
	
	public void setInterestRate(String interest){
		interestRateElement.clear();
		interestRateElement.sendKeys(interest);
	}
	
	public void setLoanTerm(String lterm){
		loanTermElement.clear();
		loanTermElement.sendKeys(lterm);
	}
	
	public void selectStartMonth(String startMonth){
		Select s1 = new Select(startMonthElement);
		s1.selectByVisibleText(startMonth);
	}
	
	public void selectStartYear(String startYear){
		Select s2 = new Select(startYearElement);
		s2.selectByValue(startYear);
	}
	
	public void setpropertyTax(String pTax){
		propertyTaxElement.clear();
		propertyTaxElement.sendKeys(pTax);
	}
	
	public void setPMI(String pmi){
		pmiElement.clear();
		pmiElement.sendKeys(pmi);
	}
	
	public void clickCalculateButton(){
		clickButton.click();
	}
}
