package testComponant;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

import pomclasses.HomePage;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Optional;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.URL;
import com.epam.healenium.SelfHealingDriver;

public class BaseTest {

//	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();//single line is the key to making your Selenium tests thread-safe when running in parallel.
//	HomePage homePage;
//	public static WebDriver initalizeDriver() throws IOException 
//	{
//		//properties class
//		Properties prop = new Properties();
//		File file = new File(System.getProperty("user.dir")+"/src/main/java/resource/global.properties");
//		FileInputStream fis = new FileInputStream(file);
//		prop.load(fis);
//		
//		//String browserName = prop.getProperty("browser");
//		
//					//this will give priority to get variable from command or from jenkins 			//if not : it will take value from property class
//		String browserName	=	System.getProperty("browserName")!=null ? System.getProperty("browserName") : prop.getProperty("browserName");
//															      //? if true do this
//					//if you don't send variable form cmd or from jenkins it will take variable from property class
//		//new
//		 WebDriver localDriver = null;
//		if(browserName.equalsIgnoreCase("chrome"))
//		{
//			WebDriverManager.chromedriver().setup();
//			
//			//driver = new ChromeDriver();
//			localDriver = new ChromeDriver();
//		}
//		else if(browserName.equalsIgnoreCase("firefox"))
//		{
//			WebDriverManager.firefoxdriver().setup();
//			//driver = new FirefoxDriver();
//			localDriver = new ChromeDriver();
//		}
//		else if(browserName.equalsIgnoreCase("edge"))
//		{
//			WebDriverManager.edgedriver().setup();
//			//driver = new EdgeDriver();
//			localDriver = new ChromeDriver();
//		}
//		
//			localDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//			localDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
//			localDriver.manage().window().maximize();
//			driver.set(localDriver);
//			return getDriver();
//		}
//		//new 
//	  	public static WebDriver getDriver() {
//	        return driver.get(); //every test thread has its own WebDriver instance stored inside it.
//	        					 //When you call driver.get(), Java automatically gives you the WebDriver instance belonging to the current test thread.
//	        					 //That’s what makes it thread-safe — each parallel test gets its own isolated driver.
//	    }
//		
//		public HomePage launchApplication() throws IOException
//		{
//			//driver=initalizeDriver();
//			//new 
//			initalizeDriver();				//new
//			homePage = new HomePage(getDriver());			
//			return homePage;
//		}
//		
//														//can not give any driver give that perticular test case driver will giver from listners
//		
//		public String getScreenshot(String testCaseName,WebDriver driver) throws IOException
//		{
//			TakesScreenshot t =(TakesScreenshot)driver;
//			File src = t.getScreenshotAs(OutputType.FILE);
//			File dest = new File(System.getProperty("user.dir")+"//reports//"+testCaseName+".png");
//			FileUtils.copyFile(src, dest);
//			return System.getProperty("user.dir")+"//reports//"+testCaseName+".png";
//		}
		
		
	//====================***with selenuim grid prallel testing***//============================================
	
//	private static final ThreadLocal<WebDriver> driver =
//            new ThreadLocal<>();
//
//    protected HomePage homePage;
//
//    private static final String GRID_URL =
//            "http://localhost:4444";
//
//    @BeforeMethod(alwaysRun = true)
//    @Parameters({"browserName"})
//    public void setUp(
//            @Optional("") String browserName) throws Exception {
//
//        try {
//            Properties prop = new Properties();
//
//            File file = new File(
//                    System.getProperty("user.dir")
//                    + "/src/main/java/resource/global.properties");
//
//            try (FileInputStream fis = new FileInputStream(file)) {
//                prop.load(fis);
//            }
//
//            // Priority: TestNG XML > command line > properties
//            if (browserName == null || browserName.isBlank()) {
//                browserName = System.getProperty("browserName");
//            }
//
//            if (browserName == null || browserName.isBlank()) {
//                browserName = prop.getProperty("browserName", "chrome");
//            }
//
//            WebDriver localDriver;
//
//            if (browserName.equalsIgnoreCase("chrome")) {
//                ChromeOptions options = new ChromeOptions();
//
//                localDriver = new RemoteWebDriver(
//                        new URL(GRID_URL), options);
//
//            } else if (browserName.equalsIgnoreCase("edge")) {
//                EdgeOptions options = new EdgeOptions();
//
//                localDriver = new RemoteWebDriver(
//                        new URL(GRID_URL), options);
//
//            } else {
//                throw new IllegalArgumentException(
//                        "Unsupported browser: " + browserName);
//            }
//
//            driver.set(localDriver);
//
//            localDriver.manage().timeouts()
//                    .implicitlyWait(Duration.ofSeconds(10));
//
//            localDriver.manage().timeouts()
//                    .pageLoadTimeout(Duration.ofSeconds(30));
//
//            localDriver.manage().window().maximize();
//
//            System.out.println(
//                    "Started browser: " + browserName
//                    + " | Thread: " + Thread.currentThread().getName());
//
//        } catch (Exception e) {
//            System.err.println(
//                    "Browser setup failed for: " + browserName);
//            e.printStackTrace();
//            throw e;
//        }
//    }
//
//    public static WebDriver getDriver() {
//        return driver.get();
//    }
//
//
//		public String getScreenshot(String testCaseName,WebDriver driver) throws IOException
//		{
//			TakesScreenshot t =(TakesScreenshot)driver;
//			File src = t.getScreenshotAs(OutputType.FILE);
//			File dest = new File(System.getProperty("user.dir")+"//reports//"+testCaseName+".png");
//			FileUtils.copyFile(src, dest);
//			return System.getProperty("user.dir")+"//reports//"+testCaseName+".png";
//		}
//
//    @AfterMethod(alwaysRun = true)
//    public void tearDown() {
//        WebDriver localDriver = driver.get();
//
//        try {
//            if (localDriver != null) {
//                localDriver.quit();
//            }
//        } finally {
//            driver.remove();
//        }
//    }
		
  //====================***with selenuim grid prallel testing with helenium***//============================================
		
	private static final ThreadLocal<WebDriver> driver =
            new ThreadLocal<>();

    private static final String GRID_URL =
            "http://localhost:4444";

    private static final String GLOBAL_PROPERTIES_PATH =
            "src/main/java/resource/global.properties";

    @BeforeMethod(alwaysRun = true)
    @Parameters({"browserName"})
    public void setUp(@Optional("") String browserName)
            throws Exception {

        Properties properties = new Properties();

        File propertiesFile = new File(GLOBAL_PROPERTIES_PATH);

        if (propertiesFile.exists()) {
            try (FileInputStream fis =
                         new FileInputStream(propertiesFile)) {
                properties.load(fis);
            }
        }

        // Browser priority:
        // TestNG XML -> Maven/System property -> global.properties
        String configuredBrowser = browserName;

        if (configuredBrowser == null || configuredBrowser.isBlank()) {
            configuredBrowser = System.getProperty("browserName");
        }

        if (configuredBrowser == null || configuredBrowser.isBlank()) {
            configuredBrowser = properties.getProperty("browserName", "chrome");
        }

        configuredBrowser = configuredBrowser.trim().toLowerCase();

        WebDriver delegate;

        // Create the original Selenium Grid driver.
        if (configuredBrowser.equals("chrome")) {

            ChromeOptions options = new ChromeOptions();

            delegate = new RemoteWebDriver(
                    new URL(GRID_URL), options);

        } else if (configuredBrowser.equals("edge")) {

            EdgeOptions options = new EdgeOptions();

            delegate = new RemoteWebDriver(
                    new URL(GRID_URL), options);

        } else {
            throw new IllegalArgumentException(
                    "Unsupported browser: " + configuredBrowser
                    + ". Supported browsers: chrome, edge.");
        }

        try {
            // Wrap Selenium WebDriver with Healenium.
            WebDriver healingDriver =
                    SelfHealingDriver.create(delegate);

            driver.set(healingDriver);

            
            healingDriver.manage()
                    .timeouts()
                    .implicitlyWait(Duration.ofSeconds(10));

            healingDriver.manage()
                    .timeouts()
                    .pageLoadTimeout(Duration.ofSeconds(30));

            healingDriver.manage()
                    .window()
                    .maximize();

            System.out.println(
                    "Browser started with Healenium: "
                    + configuredBrowser);

        } catch (Exception e) {
            // Close the original driver if initialization fails.
            try {
                delegate.quit();
            } catch (Exception ignored) {
                // Preserve the original initialization exception.
            }

            driver.remove();
            throw e;
        }
    }

    public static WebDriver getDriver() {
        return driver.get();
    }


	public String getScreenshot(String testCaseName,WebDriver driver) throws IOException
	{
		TakesScreenshot t =(TakesScreenshot)driver;
		File src = t.getScreenshotAs(OutputType.FILE);
		File dest = new File(System.getProperty("user.dir")+"//reports//"+testCaseName+".png");
		FileUtils.copyFile(src, dest);
		return System.getProperty("user.dir")+"//reports//"+testCaseName+".png";
	}

		
    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        WebDriver localDriver = driver.get();
        try {
            if (localDriver != null) {
                localDriver.quit();
            }
        } finally {
            driver.remove();
        }
    }
    
    
}
