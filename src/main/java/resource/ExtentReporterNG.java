package resource;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {


	    public ExtentReports getReportObject() {

	        String reportDirectory =
	                System.getProperty("user.dir") + "/reports";

	        File directory = new File(reportDirectory);

	        // Create reports folder if it does not exist
	        if (!directory.exists()) {
	            boolean created = directory.mkdirs();

	            if (!created) {
	                throw new RuntimeException(
	                        "Failed to create reports directory: "
	                        + reportDirectory);
	            }
	        }

	        String path = reportDirectory + "/index.html";

	        System.out.println("Report location: " + path);

	        ExtentSparkReporter reporter =
	                new ExtentSparkReporter(path);

	        reporter.config().setReportName("Web Automation Result");
	        reporter.config().setDocumentTitle("Test Results");

	        ExtentReports extent = new ExtentReports();
	        extent.attachReporter(reporter);

	        extent.setSystemInfo("Tester", "Automation Tester");
	        extent.setSystemInfo("Environment", "QA");
	        extent.setSystemInfo("Browser", "Chrome");

	        return extent;
	    }
	
}
