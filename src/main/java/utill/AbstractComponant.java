package utill;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;


public class AbstractComponant {

	WebDriver driver;
	JavascriptExecutor js;
	Actions act;
	WebDriverWait wait;
	Select s;
	
	public AbstractComponant(WebDriver driver)
	{
		this.driver=driver;
		this.wait = new WebDriverWait(driver,Duration.ofSeconds(3));
		this.js = (JavascriptExecutor) driver;
		this.act = new Actions(driver);
		
	}
	
	
	
	public void waitForElementToAppear(By locator)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	public void waitForElementToAppearUsingWebElement(WebElement webElement)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(webElement));
	}
	
	public void waitForElementToAppearUsingListOfWebElement(List<WebElement> countries)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfAllElements(countries));
	}
	
	public void waitForElementToDisappear(WebElement ele)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOf(ele));
	}
	

	public void scrollDown()
	{
	    js.executeScript("window.scrollBy(0,500)");
	}
	
	public void scrollToTopOfThePage()
	{
		js.executeScript("window.scrollTo(0,0);");
	}
	
	public void scrollIntoView(WebElement ele) 
    {
	    js.executeScript("arguments[0].scrollIntoView(true);", ele);
    }
	
	public void moveToElement(WebElement ele)
	{
		//Actions actions = new Actions(driver);
							//*****if this pause not use it will not work
		act.moveToElement(ele).pause(Duration.ofMillis(200)).perform();
	}
	public void moveToElementAndClick(WebElement ele)
	{
		//Actions actions = new Actions(driver);
							//*****if this pause not use it will not work
		act.moveToElement(ele).pause(Duration.ofMillis(200)).click().perform();
	}
	
	public void clickOnAndOpenInAnotherTabUsingKey(WebElement ele)
	{
		//signUp.sendKeys(Keys.chord(Keys.CONTROL,Keys.ENTER));//***** it work only when use xpath start with tag(a,input,button
		ele.sendKeys(Keys.chord(Keys.CONTROL,Keys.ENTER));
	}
	
	public void clickOnAndOpenInAnotherTabUsingActionClass(WebElement ele)
	{
		act.keyDown(Keys.CONTROL).click(ele).keyUp(Keys.CONTROL).build().perform();
	}
	
	public void moveToWebElementAndClickOnItUsingActionClass(WebElement ele)
	{
		act.moveToElement(ele).click().build().perform();
	}
	
	public void clickOnWebElementUsingJavascriptExecutor(WebElement ele)
	{
		js.executeScript("arguments[0].click();", ele);
	}
	
	public void switchWindowByIndex(int no)
	{
		ArrayList<String> addr = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(addr.get(no));
	}
	
	//********** this switch window method is generic it will apply to any next window switch
	public void switchToNewWindow(Set<String> oldWindows) 
	{
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(d -> d.getWindowHandles().size() > oldWindows.size());

	    Set<String> newWindows = driver.getWindowHandles();
	    newWindows.removeAll(oldWindows);

	    if (newWindows.size() == 1) {
	        driver.switchTo().window(newWindows.iterator().next());
	    } else {
	        throw new RuntimeException("Unexpected number of new windows: " + newWindows.size());
	    }
	}
	
	//***** this is in pomclass this use it like this 
//	public InstagramLoginPage clickOnInstagram()
//	{
//		Set<String> oldWindows = driver.getWindowHandles();  // capture BEFORE click
//		clickOnAndOpenInAnotherTabUsingKey(instagram);
//		switchToNewWindow(oldWindows);
//		return new InstagramLoginPage(driver);
//	}

	//***new 
	//if popup not open then get error but using these method it will not show error even if not visible popup
	public void handlePopupIfPresent(WebElement element)
	{
	    try
	    {
	        wait.until(ExpectedConditions.elementToBeClickable(element));
	        element.click();
	        
	    }
	    catch (TimeoutException e)
	    {
	        // Popup did not appear, continue execution
	    }
	}
	
	public String errorMsgIfPresent(WebElement element) {
	    try {
	        wait.until(ExpectedConditions.visibilityOf(element));
	        return element.getText();
	    } catch (TimeoutException e) {
	        return null;
	    }
	}
	
	public void selectDropDown(WebElement ele,String txt)
	{
		s = new Select(ele);
		s.selectByVisibleText(txt);
	}
	
}
