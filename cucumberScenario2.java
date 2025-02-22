package cucumber;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.interactions.Actions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.aventstack.extentreports.ExtentTest;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class cucumberScenario2 {
    private WebDriver driver = WebDriverSingleton.getDriver();
    private WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    private JavascriptExecutor js = (JavascriptExecutor) driver;
    private ExtentTest test = Hooks.test;  // Reference the ExtentTest instance from the Hooks class

    String mainWindowHandle;

    @Given("I open the URL {string}")
    public void i_open_the_URL(String url) {
        driver.get(url);
        test.info("Opened URL: " + url);  // Log the URL opening to the report
    }

    @When("I close the cookie popup if present")
    public void i_close_the_cookie_popup_if_present() {
        try {
            WebElement cookiePopup = driver.findElement(By.id("closeprem"));
            if (cookiePopup.isDisplayed()) {
                cookiePopup.click();
                test.info("Cookie popup closed.");
                captureScreenshot();
            } else {
                test.info("Cookie popup not present.");
            }
        } catch (Exception e) {
            test.warning("Cookie popup not found or already closed.");
        }
    }

    @And("I hover over Our Stakeholders link")
    public void i_hover_over_link() {
        WebElement stakeholdersLink = driver.findElement(By.xpath("//a[@title='Our Stakeholders']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(stakeholdersLink).perform();
        test.info("Hovered over 'Our Stakeholders' link.");
    }

    @Then("I click on Patients and Caregivers")
    public void i_click_on() {
        WebElement patientsLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='Patients And Caregivers']")));
        patientsLink.click();
        captureScreenshot();
        test.info("Clicked on 'Patients and Caregivers' link.");
    }

    @When("I scroll to and click on Angioplasty")
    public void iScrollToAndClickOn() {
        WebElement angioplastyElement = driver.findElement(By.xpath("//h2[text()='Angioplasty']"));
        js.executeScript("arguments[0].scrollIntoView(true);", angioplastyElement);
        wait.until(ExpectedConditions.elementToBeClickable(angioplastyElement));
        angioplastyElement.click();
        captureScreenshot();
        test.info("Scrolled to and clicked on 'Angioplasty'.");
    }

    @Then("I should see the Angioplasty page")
    public void iShouldSeeThePage() {
        String currentTitle = driver.getTitle();
        test.info("Current page title: " + currentTitle);
        captureScreenshot();
    }


@Given("I am on the page with the Coronary Artery Disease link I click on the Coronary Artery Disease link")
public void i_am_on_the_page_with_the_link() {
	WebElement coronaryArteryDiseaseLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/patients-caregivers/heart-coronary-diseases/coronary-artery-disease']")));
    coronaryArteryDiseaseLink.click();
    System.out.println("Clicked on 'Coronary Artery Disease' link.");
    captureScreenshot();
}
@Then("I should be switched to a new window")
public void i_should_be_switched_to_a_new_window() {
	 Set<String> windowHandles = driver.getWindowHandles();
     String originalWindow = driver.getWindowHandle();
     // Switch to the new window (the one that opened)
     for (String handle : windowHandles) {
         if (!handle.equals(originalWindow)) {
             driver.switchTo().window(handle);
             System.out.println("Switched to new window.");
             break;
}
}
}
@When("I click on the Bare-metal Stent link")
public void i_click_on_the_link() {
	 WebElement bareMetalStentLink = driver.findElement(By.xpath("//a[@href='/medical-devices/vascular-intervention/coronary/stents/bare-metal-stent/nexgen' and text()='Bare-metal stent is a stent without a coating polymer.']"));
     bareMetalStentLink.click();
}
@Then("I should be navigated to the new page and capture the screenshot")
public void i_should_be_navigated_to_the_new_page_and_capture_the_screenshot() {
    String newWindowTitle = driver.getTitle();
    System.out.println("New Window Title: " + newWindowTitle);
    captureScreenshot();
}
@When("I click on the Tech Specifications header")
public void i_click_on_the_header() {
	WebElement techSpecsHeader = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h2[contains(text(), 'Tech Specifications')]")));
    js.executeScript("arguments[0].scrollIntoView(true);", techSpecsHeader);
    techSpecsHeader.click();
    captureScreenshot();
}
@Then("The specifications should be saved to a file and a screenshot captured")
public void the_specifications_should_be_saved_to_a_file_and_a_screenshot_captured() {
	 saveTableValuesToFile();
	 captureScreenshot();
}
@When("I close the child window")
public void i_close_the_child_window()
{
	 mainWindowHandle = driver.getWindowHandle();
	    System.out.println("Main window handle: " + mainWindowHandle);
	
// After completing actions in the child window, close the child window
Set<String> allWindowHandles = driver.getWindowHandles();
// Iterate over all window handles
for (String windowHandle : allWindowHandles) {
    if (!windowHandle.equals(mainWindowHandle)) {
        driver.switchTo().window(windowHandle);
        System.out.println("Switching to child window: " + windowHandle);
        driver.close();  // Close the current child window
        System.out.println("Child window closed.");
    }
}
}
@And("I switch back to the main window")
public void i_switch_back_to_the_main_window() {
	 driver.switchTo().window(mainWindowHandle);
     System.out.println("Switched back to the main window.");
}
@And("I hover over the Our Stakeholders links")
public void i_hover_over_the_link() {
	WebElement stakeholdersLinkMainWindows = driver.findElement(By.xpath("//a[@title='Our Stakeholders']"));
    Actions actionsMainWindow = new Actions(driver);
    actionsMainWindow.moveToElement(stakeholdersLinkMainWindows).perform();
    System.out.println("Hovered over 'Our Stakeholders' link again in the main window.");
}
@And("I click the Patients And Caregivers links")
public void i_click_the_links() {
	WebElement patientsLinkMainWindows = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='Patients And Caregivers']")));
    patientsLinkMainWindows.click();
}
@Then("the Patients and Caregivers page should be opened")
public void the_page_should_be_openedd() {
	System.out.println("Clicked on 'Patients And Caregivers' link again in the main window.");
}
@When("I scroll to the Coronary Artery Disease element and I click")
public void i_scroll_to_the_element() {
	 WebElement coronaryElement = driver.findElement(By.xpath("//h2[text()='Coronary Artery Disease']"));
     js.executeScript("arguments[0].scrollIntoView(true);", coronaryElement);
     System.out.println("Scrolled to the 'Coronary Artery Disease' element.");
     wait.until(ExpectedConditions.elementToBeClickable(coronaryElement));
     coronaryElement.click();
}
@Then("the Patients and Caregivers page should  opened")
public void the_page_should() {
	System.out.println("Clicked on 'coronary' link again in the main window.");
}
@When ("I click on the Bare-metal stents link")
	public void click_bare() {
	WebElement bareMetalLink = driver.findElement(By.xpath("//a[@href='/medical-devices/vascular-intervention/coronary/stents/bare-metal-stent/nexgen' and text()='Bare-metal stent is a stent without a coating polymer.']"));
    bareMetalLink.click();
	
}
@And ("I click on the Vascular Intervention link")
public void click_vascular() {
	 WebElement vascularInterventionLink = driver.findElement(By.xpath("//a[@href='/medical-devices/vascular-intervention' and @class='breadcrumb--links' and text()='Vascular Intervention Medical Devices']"));
     vascularInterventionLink.click();
	
}
@Then ("I click on the Evermine50 drug link")
public void click_drug() {
	WebElement evermine50Link = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Evermine50']")));
//	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", evermine50Link);
	evermine50Link.click();

	
}
@When ("I click on the technical spec")
public void click_tech() {
	 WebElement clinicalDataHeader = driver.findElement(By.xpath("//h2[text()='Tech Specifications']"));
     clinicalDataHeader.click();
	
}
@Then ("Capture the values")
public void save() {
	saveClinicalDataToFile();
	
}
private void saveClinicalDataToFile() {
    try {
        // Example XPath to capture the specific rows with the required information
        WebElement stentDesignRow = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[contains(text(),'Stent design')]/following-sibling::td")));
        WebElement stentMaterialRow = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[contains(text(),'Stent material')]/following-sibling::td")));
        // Get text from the relevant columns
        String stentDesign = stentDesignRow.getText();
        String stentMaterial = stentMaterialRow.getText();
        // Write to the file
        File outputFile = new File("C:\\Users\\I19-labuser154440\\eclipse-workspace\\cucumber\\clinical.txt");  // or use the path you prefer
        outputFile.getParentFile().mkdirs();
        BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile, true));  // 'true' to append to file
        // Writing specific data to the file
        writer.write("Stent Design: " + stentDesign);
        writer.newLine();
        writer.write("Stent Material: " + stentMaterial);
        writer.newLine();
        writer.close();
        System.out.println("Clinical data saved to file.");
    } catch (Exception e) {
        System.out.println("Error while saving clinical data to file: " + e.getMessage());
    }
}
void saveTableValuesToFile() {
    try {
        WebElement table = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(text(), 'Tech Specifications')]//following::table[1]")));
        List<WebElement> rows = table.findElements(By.tagName("tr"));
        File outputFile = new File("C:\\Users\\I19-labuser154440\\eclipse-workspace\\cucumber\\output.txt");
        outputFile.getParentFile().mkdirs();
        BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
        for (WebElement row : rows) {
            List<WebElement> columns = row.findElements(By.tagName("td"));
            if (columns.size() > 1) {
                String label = columns.get(0).getText();
                String value = columns.get(1).getText();
                writer.write(label + ": " + value);
                writer.newLine();
            }
        }
        writer.close();
    } catch (Exception e) {
        System.out.println("Error while saving table values to file: " + e.getMessage());
    }
}

public void captureScreenshot() {
    TakesScreenshot ts = (TakesScreenshot) driver;
    File source = ts.getScreenshotAs(OutputType.FILE);
    try {
        // Ensure the target directory exists
        File targetDir = new File("C:\\Users\\I19-labuser154440\\eclipse-workspace\\cucumber\\screenshots\\");
        if (!targetDir.exists()) {
            targetDir.mkdirs();
        }
        // Generate timestamp and use it as the test name
        String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        String testName = "screenshot_" + timestamp;
        // Create the file with the generated test name and timestamp
        FileUtils.copyFile(source, new File(targetDir, testName + ".png"));
        System.out.println("Screenshot taken with name: " + testName);
    } catch (IOException e) {
        System.out.println("Exception while taking screenshot: " + e.getMessage());
    }
}

}