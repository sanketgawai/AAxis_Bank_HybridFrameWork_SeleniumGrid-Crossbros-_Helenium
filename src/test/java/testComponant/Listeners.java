package testComponant;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resource.ExtentReporterNG;


public class Listeners implements ITestListener, ISuiteListener {
		
    private static final ExtentReports extent =
            new ExtentReporterNG().getReportObject();
    
    private static final ThreadLocal<ExtentTest> extentTest =
            new ThreadLocal<>();
    //@Override — tells Java that this method is intended to override a method declared in a parent class or interface
    
    @Override
    public void onTestStart(ITestResult result) {

        String testName = result.getMethod().getMethodName();

        ExtentTest test = extent.createTest(testName);

        extentTest.set(test);

        extentTest.get().log(
                Status.INFO,
                "Test execution started");

        System.out.println("Starting Test: " + testName);
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        ExtentTest test = getOrCreateTest(result);

        test.log(Status.PASS, "Test Passed");

        System.out.println(
                "Test Passed: " + result.getName());

        extentTest.remove();
    }

    @Override
    public void onTestFailure(ITestResult result) {

        ExtentTest test = getOrCreateTest(result);

        test.log(Status.FAIL, "Test Failed");

        if (result.getThrowable() != null) {
            test.fail(result.getThrowable());
        }

        System.out.println(
                "Test Failed: " + result.getName());

        // Get the driver belonging to the current test thread
        WebDriver driver = BaseTest.getDriver();

        if (driver != null) {
            try {
                String screenshotPath =
                        captureScreenshot(
                                result.getMethod().getMethodName(),
                                driver);

                test.addScreenCaptureFromPath(
                        screenshotPath,
                        "Failure Screenshot");

            } catch (IOException | RuntimeException e) {
                test.log(
                        Status.WARNING,
                        "Screenshot could not be captured: "
                                + e.getMessage());
            }
        } else {
            test.log(
                    Status.WARNING,
                    "WebDriver was unavailable for screenshot");
        }

        extentTest.remove();
    }

    @Override
    public void onTestSkipped(ITestResult result) {

        ExtentTest test = getOrCreateTest(result);

        test.log(Status.SKIP, "Test Skipped");

        if (result.getThrowable() != null) {
            test.skip(result.getThrowable());
        }

        System.out.println(
                "Test Skipped: " + result.getName());

        extentTest.remove();
    }

    private ExtentTest getOrCreateTest(ITestResult result) {

        ExtentTest test = extentTest.get();

        if (test == null) {
            test = extent.createTest(
                    result.getMethod().getMethodName());

            extentTest.set(test);
        }

        return test;
    }

    private String captureScreenshot(String testName,WebDriver driver) throws IOException {

        String screenshotDirectory = System.getProperty("user.dir")+ "/reports/screenshots";

        File directory = new File(screenshotDirectory);

        if (!directory.exists() && !directory.mkdirs()) {
            throw new IOException(
                    "Could not create screenshot directory");
        }

        // Avoid overwriting screenshots during parallel execution
        String safeTestName =
                testName.replaceAll("[^a-zA-Z0-9._-]", "_");
        
        String fileName =
                safeTestName
                + "_"
                + System.currentTimeMillis()
                + "_"
                + Thread.currentThread().getId()
                + ".png";

        File destination =
                new File(directory, fileName);

        File source = ((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.FILE);

        Files.copy(
                source.toPath(),
                destination.toPath(),
                StandardCopyOption.REPLACE_EXISTING);

        return destination.getAbsolutePath();
    }
    
    @Override
    public void onFinish(ISuite suite) {

        System.out.println(
                "Test Suite Completed: " + suite.getName());
        
        extent.flush();
    }
    
    	
    
}


