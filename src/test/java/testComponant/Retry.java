package testComponant;

import java.io.IOException;
import java.util.HashMap;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.annotations.Test;

public class Retry implements IRetryAnalyzer {

	//
    private int count = 0;
    private static final int maxRetry = 1; // 🔁 run failed test only 1 extra time

    @Override
    public boolean retry(ITestResult result) {

        if (count < maxRetry) {
            count++;
            return true; // rerun test
        }
        return false;
    }

}


//*****use Retry like this and it need Listnerclass
//@Test(dataProvider="getLoginData",retryAnalyzer = testComponant.Retry.class)
//public void verifyLogin(HashMap<String,String> input) throws IOException