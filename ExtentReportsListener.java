//package cucumber;
//
//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
//import org.testng.ITestContext;
//import org.testng.ITestListener;
//import org.testng.ITestResult;
//
//public class ExtentReportsListener implements ITestListener {
//
//    private static ExtentReports extentReports;
//    private static ExtentTest extentTest;
//
//    // This method will run before every test
//    @Override
//    public void onTestStart(ITestResult result) {
//        extentTest = extentReports.createTest(result.getMethod().getMethodName());
//    }
//
//    // This method will run after every test method
//    @Override
//    public void onTestSuccess(ITestResult result) {
//        extentTest.pass("Test passed: " + result.getMethod().getMethodName());
//    }
//
//    // This method will run if the test fails
//    @Override
//    public void onTestFailure(ITestResult result) {
//        extentTest.fail("Test failed: " + result.getMethod().getMethodName());
//    }
//
//    @Override
//    public void onTestSkipped(ITestResult result) {
//        extentTest.skip("Test skipped: " + result.getMethod().getMethodName());
//    }
//
//    @Override
//    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {}
//
//    @Override
//    public void onStart(ITestContext context) {}
//
//    @Override
//    public void onFinish(ITestContext context) {
//        extentReports.flush();
//    }
//
//    public static void setUp() {
//        // Create an HTML reporter
//        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("target/ExtentReports/extent_report.html");
//        extentReports = new ExtentReports();
//        extentReports.attachReporter(htmlReporter);
//    }
//}
