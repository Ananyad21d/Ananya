package merli;
import org.openqa.selenium.*;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.TakesScreenshot;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class reportgenerator {
    private WebDriver driver;
    private StringBuilder reportContent = new StringBuilder();
    private static final String SCREENSHOT_FOLDER = "C:\\Users\\I19-labuser154440\\eclipse-workspace\\meril\\screenshot\\";
    private static final String REPORT_FOLDER = "C:\\Users\\I19-labuser154440\\eclipse-workspace\\meril\\reports\\";
    public reportgenerator(WebDriver driver) {
        this.driver = driver;
        // Ensure the screenshot and report folders exist
        try {
            Files.createDirectories(Paths.get(SCREENSHOT_FOLDER));
            Files.createDirectories(Paths.get(REPORT_FOLDER));
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Initialize HTML report structure
        reportContent.append("<html><head><title>Test Report</title></head><body>");
        reportContent.append("<h1>Test Execution Report</h1>");
        reportContent.append("<h3>Test Executed on: " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) + "</h3>");
        reportContent.append("<table border='1'><tr><th>Test Step</th><th>Status</th><th>Screenshot</th></tr>");
    }
    public String captureScreenshot(String screenshotName) {
        try {
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String screenshotPath = SCREENSHOT_FOLDER + screenshotName + ".png";
            FileHandler.copy(screenshot, new File(screenshotPath));
            return screenshotPath;
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }
    public void addReportEntry(String testStep, boolean isSuccess, String screenshotPath) {
        String status = isSuccess ? "Pass" : "Fail";
        reportContent.append("<tr><td>").append(testStep).append("</td><td>").append(status)
                     .append("</td><td><img src='").append(screenshotPath)
                     .append("' width='200'></td></tr>");
    }
    public void finalizeReport() {
        reportContent.append("</table></body></html>");
        String reportFileName = "TestReport_" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss")) + ".html";
        String reportFilePath = REPORT_FOLDER + reportFileName;
        try (FileWriter writer = new FileWriter(reportFilePath)) {
            writer.write(reportContent.toString());
            System.out.println("HTML Report generated at: " + reportFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}



