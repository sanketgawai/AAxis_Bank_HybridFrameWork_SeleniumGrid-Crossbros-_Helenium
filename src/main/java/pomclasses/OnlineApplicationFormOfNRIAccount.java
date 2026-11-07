package pomclasses;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OnlineApplicationFormOfNRIAccount extends utill.AbstractComponant {

WebDriver driver;
	
	public OnlineApplicationFormOfNRIAccount(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//label[text()='Title']/parent::div/div/select")
	public WebElement title;

	@FindBy(xpath = "//label[text()='First Name']/following-sibling::input")
	public WebElement firstName;

	@FindBy(xpath = "//label[text()='Middle Name (Optional)']/following-sibling::input")
	public WebElement middleName;

	@FindBy(xpath = "//label[text()='Last Name']/following-sibling::input")
	public WebElement lastName;

	@FindBy(xpath = "//label[text()='Overseas Country']/parent::div/div/select")
	public WebElement overSeasCountry;

	@FindBy(xpath = "//label[text()='Mobile Number']/following-sibling::input[@placeholder='Mobile Number']")
	public WebElement mobNo;

	@FindBy(xpath = "//label[text()='Email ID']/following-sibling::input")
	public WebElement emailId;

	@FindBy(xpath = "//label[text()='Password']/following-sibling::input")
	public WebElement password;

	@FindBy(xpath = "//label[text()='Confirm Password']/following-sibling::input")
	public WebElement confirmPassword;

	@FindBy(xpath="//label[text()='Call Me Later']/preceding-sibling::input")
	public WebElement callMeLetterRedioButton;
	
	@FindBy(xpath="//input[@value='Submit' and @type='submit']")
	public WebElement submit;
	
	@FindBy(xpath="//span[text()='Please enter Mobile Number']")
	public WebElement emptyMobNoErrorMessage;
	
	
	
	
//	public String fillThePrestigeAccountForm()
//	{
//		selectDropDown(title,"Mr.");
//		firstName.sendKeys("sage of six path");
//		middleName.sendKeys("god");
//		lastName.sendKeys("last sage");
//		selectDropDown(overSeasCountry,"American Samoa");
//		mobNo.sendKeys("9512879645");
//		emailId.sendKeys("www.sageofsixpath@gmail.com");
//		password.sendKeys("sageofsixpaath@124");
//		confirmPassword.sendKeys("sageofsixpaath@124");
//		callMeLetterRedioButton.click();
//		submit.click();
//		return errorMsgIfPresent(emptyMobNoErrorMessage);
//	}
	
	public String fillThePrestigeAccountForm(String titl,String firstNam,String middleNam,String lastNam,String overSeasCountr,String mobN,String gmailI,String pas,String confirmPas)
	{
		selectDropDown(title, titl);
	    this.firstName.sendKeys(firstNam);
	    this.middleName.sendKeys(middleNam);
	    this.lastName.sendKeys(lastNam);
	    selectDropDown(overSeasCountry, overSeasCountr);
	    this.mobNo.sendKeys(mobN);
	    this.emailId.sendKeys(gmailI);
	    this.password.sendKeys(pas);
	    this.confirmPassword.sendKeys(confirmPas);

	    callMeLetterRedioButton.click();
	    submit.click();

	    return errorMsgIfPresent(emptyMobNoErrorMessage);
	}
	
}

