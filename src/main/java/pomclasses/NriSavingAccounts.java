package pomclasses;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NriSavingAccounts extends utill.AbstractComponant {

WebDriver driver;
	
	public NriSavingAccounts(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[text()='All Accounts']")
	public WebElement allAccount;
	
	@FindBy(xpath="//h3[text()='Prestige Savings Account']/ancestor::div[@class='top-content']/following-sibling::div/div//a[normalize-space()='Apply Now']")
	public WebElement prestigeSavingsAccount;
	
	public void clickOnAllAccount()
	{
		allAccount.click();
	}
	
	public void LandOnPrestigeSavingsAccount()
	{
		Set<String> oldWindows = driver.getWindowHandles();  // capture BEFORE click
		clickOnWebElementUsingJavascriptExecutor(prestigeSavingsAccount);
		switchToNewWindow(oldWindows);
	}
	
	
}
