package testClasses;
import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pomclasses.HomePage;
import pomclasses.NriSavingAccounts;
import pomclasses.OnlineApplicationFormOfNRIAccount;
import testComponant.BaseTest;
import testData.DataDrivenFromExcel;

public class CreateNRISavingAccount extends BaseTest {

	
	HomePage homePage;
	NriSavingAccounts nriSavingAccounts;
	OnlineApplicationFormOfNRIAccount onlineApplicationFormOfNRIAccount;
	public WebDriver driver;
	
	
	@Test(enabled=false)
	public void validateNRISavingAccountPage() throws IOException
	{
		//driver = initalizeDriver();
		WebDriver driver = getDriver();

		homePage = new HomePage(driver);
		homePage.openApplciation();
		homePage.handleThePopUp();
		homePage.goToNRISavingAccountPage();
		
		//Assert.assertEquals(driver.getCurrentUrl(), "https://www.axis.bank.in/nri/nri-accounts");
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.axis.bank.in/nri/nri-accounts");
	}
	
	@Test(enabled=false)
	public void validateNRISavingAccountPagee() throws IOException
	{
		//driver = initalizeDriver();
		WebDriver driver = getDriver();

		homePage = new HomePage(driver);
		homePage.openApplciation();
		homePage.handleThePopUp();
		homePage.goToNRISavingAccountPage();
		
		//Assert.assertEquals(driver.getCurrentUrl(), "https://www.axis.bank.in/nri/nri-accounts");
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.axis.bank.in/nri/nri-accountss");
	}
	

	//@Test()
	@Test(dataProvider="getData")
	//public void createNRISavingAccount() throws IOException
	//public void createNRISavingAccount(String title,String firstName,String middleName,String lastName,String overSeasCountry,String mobNo,String gmailId,String pass,String confirmPass) throws IOException
	public void createNRISavingAccount(HashMap<String,String>data) throws IOException
	{
		//driver = initalizeDriver();
		WebDriver driver = getDriver();
		
		homePage = new HomePage(driver);
		homePage.openApplciation();
		homePage.handleThePopUp();
		homePage.goToNRISavingAccountPage();
		nriSavingAccounts = new NriSavingAccounts(driver);
		nriSavingAccounts.clickOnAllAccount();
		nriSavingAccounts.LandOnPrestigeSavingsAccount();
		onlineApplicationFormOfNRIAccount = new OnlineApplicationFormOfNRIAccount(driver);
//		String errorMsg = onlineApplicationFormOfNRIAccount.fillThePrestigeAccountForm("Mr.", "sage of six path", "god", "last sage", "American Samoa", "9512879645", "www.sageofsixpath@gmail.com", "sageofsixpaath@124", "sageofsixpaath@124");;
//		String errorMsg = onlineApplicationFormOfNRIAccount.fillThePrestigeAccountForm(title, firstName, middleName, lastName,overSeasCountry, mobNo, gmailId, pass, confirmPass);
		String errorMsg = onlineApplicationFormOfNRIAccount.fillThePrestigeAccountForm(
			    data.get("title"),
			    data.get("firstName"),
			    data.get("middleName"),
			    data.get("lastName"),
			    data.get("overSeasCountry"),
			    data.get("mobNo"),
			    data.get("gmailId"),
			    data.get("pass"),
			    data.get("confirmPass")
			);
		
		//Assert.assertEquals(errorMsg, "Please enter Mobile Number");
		Assert.assertEquals(errorMsg, "Please enter Mobile Number");
		
	}
	
	@DataProvider()
	public Object[][] getData() throws IOException 
	{
		//return new Object [][] {{"Mr.", "sage of six path", "god", "last sage","American Samoa", "9512879645", "www.sageofsixpath@gmail.com", "sageofsixpaath@124", "sageofsixpaath@124"}};
			
		DataDrivenFromExcel dataDrivenFromExcel = new DataDrivenFromExcel();
		return dataDrivenFromExcel.getDataFromExcel("Sheet1");
	}
	
	
}
