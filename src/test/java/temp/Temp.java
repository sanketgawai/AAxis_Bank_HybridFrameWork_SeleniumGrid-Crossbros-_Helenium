package temp;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Temp {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://www.axis.bank.in/");
		
//		WebElement allowOnlyNecessaryPopup = driver.findElement(By.xpath("//button[text()='Accept All']/following-sibling::button[text()='Allow Only Necessary']"));
//		wait.until(ExpectedConditions.visibilityOf(allowOnlyNecessaryPopup));
//		boolean popup1 = allowOnlyNecessaryPopup.isDisplayed();
//		if(popup1==true)
//		{
//			allowOnlyNecessaryPopup.click();
//		}
//		
//		WebElement homePagePopup = driver.findElement(By.xpath("//button[@id='leapPopupClose' and text()='×']"));
//		
//		wait.until(ExpectedConditions.visibilityOf(homePagePopup));
//		//boolean popup2 = homePagePopup.isDisplayed();
//		if(homePagePopup.isDisplayed())
//		{
//			homePagePopup.click();
//		}
		
		try {
		    WebElement allowOnlyNecessaryPopup = wait.until(
		        ExpectedConditions.elementToBeClickable(
		            By.xpath("//button[text()='Accept All']/following-sibling::button[text()='Allow Only Necessary']")
		        )
		    );

		    allowOnlyNecessaryPopup.click();

		} catch (TimeoutException e) {
		    // Allow Only Necessary popup did not appear - continue test
		}


		try {
		    WebElement homePagePopup = wait.until(
		        ExpectedConditions.elementToBeClickable(
		            By.xpath("//button[@id='leapPopupClose' and text()='×']")
		        )
		    );

		    homePagePopup.click();

		} catch (TimeoutException e) {
		    // Home page popup did not appear - continue test
		}
			
		

		
//		Personal -> Accounts -> NRI Saving Account -> all account 
//		-> prestige saving account
		
		
//		WebElement personal = driver.findElement(By.xpath("(//a[text()='Personal'])[1]"));
//		wait.until(ExpectedConditions.visibilityOf(personal));
//		personal.click();
		
		Actions act = new Actions(driver);
		WebElement accounts = driver.findElement(By.xpath("(//a[text()='Accounts' and @href='/accounts'])"));
		wait.until(ExpectedConditions.visibilityOf(accounts));
		act.moveToElement(accounts).perform();
		
		WebElement NRISavingAccount = driver.findElement(By.xpath("(//a[text()='NRI Savings Account'])[1]"));
		wait.until(ExpectedConditions.visibilityOf(NRISavingAccount));
		NRISavingAccount.click();
		
		WebElement allAccount = driver.findElement(By.xpath("//a[text()='All Accounts']"));
		wait.until(ExpectedConditions.visibilityOf(allAccount));
		
		allAccount.click();
		
		WebElement prestigeSavingsAccount = driver.findElement(By.xpath("//h3[text()='Prestige Savings Account']/ancestor::div[@class='top-content']/following-sibling::div/div//a[normalize-space()='Apply Now']"));
		wait.until(ExpectedConditions.visibilityOf(prestigeSavingsAccount));
		prestigeSavingsAccount.click();
		
		
		ArrayList<String> addr = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(addr.get(1));
		wait.until(ExpectedConditions.urlContains("https://application.axis.bank.in/webforms/NRI_NEW_ONLINE_APPLICATION_FORM/NRILogIn.aspx?cta=nri-account-page"));
		Assert.assertEquals(driver.getCurrentUrl(), "https://application.axis.bank.in/webforms/NRI_NEW_ONLINE_APPLICATION_FORM/NRILogIn.aspx?cta=nri-account-page");

		WebElement title = driver.findElement(By.xpath("//label[text()='Title']/parent::div/div/select"));
		Select s = new Select(title);
		s.selectByVisibleText("Mr.");
		
		//*** use same xpath for all
		WebElement firstName = driver.findElement(By.xpath("//label[text()='First Name']/following-sibling::input"));
		firstName.sendKeys("sage of six path");
		
		WebElement middleName = driver.findElement(By.xpath("//label[text()='Middle Name (Optional)']/following-sibling::input"));
		middleName.sendKeys("god");
		
		WebElement lastName = driver.findElement(By.xpath("//label[text()='Last Name']/following-sibling::input"));
		lastName.sendKeys("lastName");
		
		WebElement overSeasCountry = driver.findElement(By.xpath("//label[text()='Overseas Country']/parent::div/div/select"));
		Select s2 = new Select(overSeasCountry);
		s2.selectByVisibleText("American Samoa");
		
		WebElement mobNo = driver.findElement(By.xpath("//label[text()='Mobile Number']/following-sibling::input[@placeholder='Mobile Number']"));
		mobNo.sendKeys("9512879645");
		
		WebElement emailId = driver.findElement(By.xpath("//label[text()='Email ID']/following-sibling::input"));
		emailId.sendKeys("www.sageofsixpath@gmail.com");
		
		WebElement password = driver.findElement(By.xpath("//label[text()='Password']/following-sibling::input"));
		password.sendKeys("sageofsixpaath@124");
		
		WebElement confirmPassword = driver.findElement(By.xpath("//label[text()='Confirm Password']/following-sibling::input"));
		confirmPassword.sendKeys("sageofsixpaath@124");
		
		
		
		
		
		
		
	}
}
