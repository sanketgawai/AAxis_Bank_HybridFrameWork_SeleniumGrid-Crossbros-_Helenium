package pomclasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends utill.AbstractComponant {

	WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//button[text()='Accept All']/following-sibling::button[text()='Allow Only Necessary']")
	public WebElement allowOnlyNecessaryPopup;
	
	@FindBy(xpath="//button[@id='leapPopupClose' and text()='×']")
	public WebElement homePagePopup;
	
	@FindBy(xpath="(//a[text()='Accounts' and @href='/accounts'])")
	public WebElement accounts;
	
	@FindBy(xpath="(//a[text()='NRI Savings Account'])[1]")
	public WebElement NRISavingAccount;
	
	
	public void openApplciation()
	{
		driver.get("https://www.axis.bank.in/");
	}
	
	public void handleThePopUp()
	{
		handlePopupIfPresent(allowOnlyNecessaryPopup);
		
		handlePopupIfPresent(homePagePopup);
	}
	
//	public void goToNRISavingAccountPage()
//	{
//		waitForElementToAppearUsingWebElement(accounts);
//		accounts.click();
//		//waitForElementToAppearUsingWebElement(NRISavingAccount);
//		//moveToElementAndClick(NRISavingAccount);
//		moveToElement(NRISavingAccount);
//		NRISavingAccount.click();
//		
//		
//	}
	
	public void goToNRISavingAccountPage()
	{
	    // Wait for Accounts to be visible
	    waitForElementToAppearUsingWebElement(accounts);

	    // Hover over Accounts instead of clicking it
	    moveToElement(accounts);

	    // Wait for NRI Savings Account to become visible
	    waitForElementToAppearUsingWebElement(NRISavingAccount);

	    // Click NRI Savings Account
	    NRISavingAccount.click();
	    
	}
	
	
}
