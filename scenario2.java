package merli;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import merli.HomePage;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Set;
import merli.reportgenerator;
@Listeners(TestListener.class)
public class scenario2 {
    WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor js;
    String outputFilePath = "TextSpec.txt";
    private reportgenerator reportGenerator;
       
    
    @BeforeClass
	public void setUp(ITestContext context) {
        // Initialize the ChromeDriver
        driver = new ChromeDriver();
        driver.manage().window().maximize(); 
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        js = (JavascriptExecutor) driver;
        reportGenerator = new reportgenerator(driver);
        context.setAttribute("driver",driver);
    }
    
    @Test(priority = 1, dataProvider = "urlProvider", dataProviderClass = merli.dataprovider.class)
    public void openURLAndVerifyTitle(String url) {
        driver.get(url);

        String title = driver.getTitle();

        if (title.contains("Meril Life")) {
            System.out.println("Title is correct!");
        } else {
            System.out.println("Title does not match!");
            Assert.fail("Title does not match");
        }
}



    @Test(priority = 2)
    public void acceptCookiePopup() {
       
        HomePage homePage = new HomePage(driver);
        homePage.acceptCookiePopup();
    }



   
//
//    
//   @Test(priority = 2)
//    public void handleCookiePopup() {
//    	String screenshotPath = "";
//        boolean isSuccess = true;
////        try {
////        try {
//            WebElement cook = driver.findElement(By.id("closeprem"));
//            cook.click();
//            System.out.println("Cookie popup was present and closed.");
//            captureScreenshot();
////                    } catch (NoSuchElementException e) {
////            System.out.println("Cookie popup was not present.");
//            
//        }
////        screenshotPath = reportGenerator.captureScreenshot("Cookie clicked");
////        }catch (Exception e) {
////            isSuccess = false;
////            e.printStackTrace();
////        } finally {
////            reportGenerator.addReportEntry("Cookie clicked", isSuccess, screenshotPath);
////        }
////    }
    

    // Test to hover over the "Our Stakeholders" link and click on "Patients and Caregivers"
    @Test(priority = 3)
    public void hoverAndClickStakeholdersLink() {
    	String screenshotPath = "";
        boolean isSuccess = true;
    
    	try {
        try {
            WebElement stakeholdersLink = driver.findElement(By.xpath("//a[@title='Our Stakeholders']"));
            Actions actions = new Actions(driver);
            actions.moveToElement(stakeholdersLink).perform();
            System.out.println("Hovered over 'Our Stakeholders' link.");

            WebElement patientsLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='Patients And Caregivers']")));
            patientsLink.click();
            System.out.println("Clicked on 'Patients And Caregivers' link.");
            captureScreenshot();
        } catch (NoSuchElementException e) {
            System.out.println("Link was not found.");
        } catch (ElementClickInterceptedException e) {
            System.out.println("Click was intercepted: " + e.getMessage());
            
        }
        screenshotPath = reportGenerator.captureScreenshot("Stakeholder and patient caregiver clicked");}
        catch (Exception e) {
            isSuccess = false;
            e.printStackTrace();
        } finally {
            reportGenerator.addReportEntry("Stakeholder and caregiver clicked", isSuccess, screenshotPath);
        }
    
    }
    

        // Handle the "Angioplasty" element click
   @Test(priority = 4)
    public void scrollToAndClickAngioplasty() {
    	String screenshotPath = "";
        boolean isSuccess = true;
    	try {
    		
    	
        try {
            WebElement angioplastyElement = driver.findElement(By.xpath("//h2[text()='Angioplasty']"));
            js.executeScript("arguments[0].scrollIntoView(true);", angioplastyElement);
            System.out.println("Scrolled to the 'Angioplasty' element.");
            
            wait.until(ExpectedConditions.elementToBeClickable(angioplastyElement));
            angioplastyElement.click();
            System.out.println("Clicked on 'Angioplasty' element.");
            captureScreenshot();
        } catch (NoSuchElementException e) {
            System.out.println("'Angioplasty' element was not found.");
        } catch (ElementClickInterceptedException e) {
            System.out.println("Click was intercepted: " + e.getMessage());
        }        screenshotPath = reportGenerator.captureScreenshot("Angiopalstry navigated");}
     catch (Exception e) {
        isSuccess = false;
        e.printStackTrace();
    } finally {
        reportGenerator.addReportEntry("Angiopalstry clicked", isSuccess, screenshotPath);
    }
    }

    

    // Test to handle the "Coronary Artery Disease" link that opens in a new window
  @Test(priority = 5)
    public void handleCoronaryArteryDiseaseLink() {
    	String screenshotPath = "";
        boolean isSuccess = true;
        try {
        try {
            WebElement coronaryArteryDiseaseLink = driver.findElement(By.xpath("//a[@href='/patients-caregivers/heart-coronary-diseases/coronary-artery-disease']"));
            coronaryArteryDiseaseLink.click();
            System.out.println("Clicked on 'Coronary Artery Disease' link.");
            
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
            
            // Perform further actions or validation in the new window if needed
            System.out.println("Now in the new window.");
            captureScreenshot();
        } catch (NoSuchElementException e) {
            System.out.println("'Coronary Artery Disease' link was not found.");
        } catch (Exception e) {
            System.out.println("Error while handling window switch: " + e.getMessage());
        }screenshotPath = reportGenerator.captureScreenshot("Coronory artery disease clicked");}
        catch (Exception e) {
            isSuccess = false;
            e.printStackTrace();
        } finally {
            reportGenerator.addReportEntry("coronary artery disease clicked", isSuccess, screenshotPath);
        }
    }
    

            
            // Perform any actions in the new window
            
            
            // Click on the "Bare-metal stent" link in the new window
   @Test(priority = 6)
    public void handleBareMetalStentLink() {
    	String newWindowTitle = driver.getTitle();
        System.out.println("New Window Title: " + newWindowTitle);
        String screenshotPath = "";
        boolean isSuccess = true;
        try {
        try {
            WebElement bareMetalStentLink = driver.findElement(By.xpath("//a[@href='/medical-devices/vascular-intervention/coronary/stents/bare-metal-stent/nexgen' and text()='Bare-metal stent is a stent without a coating polymer.']"));
            bareMetalStentLink.click();
            System.out.println("Clicked on 'Bare-metal stent' link.");
            captureScreenshot();
        } catch (NoSuchElementException e) {
            System.out.println("'Bare-metal stent' link was not found.");
        } catch (ElementClickInterceptedException e) {
            System.out.println("Click was intercepted: " + e.getMessage());
            
        }
        screenshotPath = reportGenerator.captureScreenshot("Navigated to the link");
        }
        catch (Exception e) {
            isSuccess = false; 
            e.printStackTrace();
        } finally {
            reportGenerator.addReportEntry("Navigate to the link", isSuccess, screenshotPath);
        }
    }

    // Test to click on 'Tech Specifications' header and save table values to file
   @Test(priority = 7)
    public void clickTechSpecificationsHeader() {
    	String screenshotPath = "";
        boolean isSuccess = true; 
        try {
        try {
            WebElement techSpecsHeader = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h2[contains(text(), 'Tech Specifications')]")));
            js.executeScript("arguments[0].scrollIntoView(true);", techSpecsHeader);
            techSpecsHeader.click();
            System.out.println("Clicked on 'Tech Specifications' heading in the new window.");
            captureScreenshot();

            // Save tech specifications to file
            saveTableValuesToFile();
        } catch (NoSuchElementException e) {
            System.out.println("'Tech Specifications' header was not found.");
        }screenshotPath = reportGenerator.captureScreenshot("Saved to file ");}
    catch (Exception e) {
        isSuccess = false; // Mark as failed if an exception occurs
        e.printStackTrace();
    } finally {
        reportGenerator.addReportEntry("Tech spec values captured", isSuccess, screenshotPath);
    }
    }

    // Test to close the child window and return to the main window
   @Test(priority = 8)
    public void closeChildWindowAndSwitchBackAndClickPatientsCaregivers() {
    	String screenshotPath = "";
        boolean isSuccess = true; 
        // Store the main window handle
        String mainWindowHandle = driver.getWindowHandle();
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

        // Switch back to the main window
        driver.switchTo().window(mainWindowHandle);
        System.out.println("Switched back to the main window.");

        // Now, perform the hover and click on "Patients and Caregivers" again
        try {
        try {
            WebElement stakeholdersLinkMainWindow = driver.findElement(By.xpath("//a[@title='Our Stakeholders']"));
            Actions actionsMainWindow = new Actions(driver);
            actionsMainWindow.moveToElement(stakeholdersLinkMainWindow).perform();
            System.out.println("Hovered over 'Our Stakeholders' link again in the main window.");

            WebElement patientsLinkMainWindow = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='Patients And Caregivers']")));
            patientsLinkMainWindow.click();
            System.out.println("Clicked on 'Patients And Caregivers' link again in the main window.");
            captureScreenshot();
        } catch (NoSuchElementException e) {
            System.out.println("Link was not found in the main window.");
        } catch (ElementClickInterceptedException e) {
            System.out.println("Click was intercepted in the main window: " + e.getMessage());
        }            screenshotPath = reportGenerator.captureScreenshot("TestCase1");}
        catch (Exception e) {
            isSuccess = false; // Mark as failed if an exception occurs
            e.printStackTrace();
        } finally {
            reportGenerator.addReportEntry("Navigated to main window", isSuccess, screenshotPath);
        }

    }



    // Test to click on the "Coronary Artery Disease" image after switching back to the main window
   @Test(priority = 9)
    public void clickCoronaryArteryDiseaseImage() {
    	String screenshotPath = "";
        boolean isSuccess = true; 
        try {
        try {
            WebElement coronaryElement = driver.findElement(By.xpath("//h2[text()='Coronary Artery Disease']"));
            js.executeScript("arguments[0].scrollIntoView(true);", coronaryElement);
            System.out.println("Scrolled to the 'Coronary Artery Disease' element.");
            
            wait.until(ExpectedConditions.elementToBeClickable(coronaryElement));
            coronaryElement.click();
            System.out.println("Clicked on 'Coronary Artery Disease' element.");
        } catch (NoSuchElementException e) {
            System.out.println("'Coronary Artery Disease' element was not found.");
        } catch (ElementClickInterceptedException e) {
            System.out.println("Click was intercepted: " + e.getMessage());
        }screenshotPath = reportGenerator.captureScreenshot("TestCase1");
        }
        catch (Exception e) {
            isSuccess = false; // Mark as failed if an exception occurs
            e.printStackTrace();
        } finally {
            reportGenerator.addReportEntry("Coronery disease clicked", isSuccess, screenshotPath);
        }
    }

    // Test to click on the "Bare-metal stent" link again after returning to the main window
    @Test(priority = 10)
    public void clickBareMetalStentLinkAgain() {
    	String screenshotPath = "";
        boolean isSuccess = true; 
        try {
        try {
            WebElement bareMetalLink = driver.findElement(By.xpath("//a[@href='/medical-devices/vascular-intervention/coronary/stents/bare-metal-stent/nexgen' and text()='Bare-metal stent is a stent without a coating polymer.']"));
            bareMetalLink.click();
            System.out.println("Clicked on 'Bare-metal stent' link.");
        } catch (NoSuchElementException e) {
            System.out.println("'Bare-metal stent' link was not found.");
        } catch (ElementClickInterceptedException e) {
            System.out.println("Click was intercepted: " + e.getMessage());
        }            screenshotPath = reportGenerator.captureScreenshot("TestCase1");
        }
        catch (Exception e) {
            isSuccess = false; // Mark as failed if an exception occurs
            e.printStackTrace();
        } finally {
            reportGenerator.addReportEntry("Clicked the link", isSuccess, screenshotPath);
        }
    }

    // Test to click on the "Vascular Intervention" link
    @Test(priority = 11)
    public void clickVascularInterventionLink() {
    	String screenshotPath = "";
        boolean isSuccess = true; 
        try {
        try {
            WebElement vascularInterventionLink = driver.findElement(By.xpath("//a[@href='/medical-devices/vascular-intervention' and @class='breadcrumb--links' and text()='Vascular Intervention Medical Devices']"));
            vascularInterventionLink.click();
            System.out.println("Clicked on 'vascular' link.");
            captureScreenshot();
        } catch (NoSuchElementException e) {
            System.out.println("'vascular' link was not found.");
        } catch (ElementClickInterceptedException e) {
            System.out.println("Click was intercepted: " + e.getMessage());
        }
        screenshotPath = reportGenerator.captureScreenshot("TestCase1");
        }
        catch (Exception e) {
            isSuccess = false; // Mark as failed if an exception occurs
            e.printStackTrace();
        } finally {
            reportGenerator.addReportEntry("Navigated to vascular link", isSuccess, screenshotPath);
        }
    }

    // Test to click on the "Evermine50" drug link
    @Test(priority = 12)
    public void clickEvermine50DrugLink() {
    	String screenshotPath = "";
        boolean isSuccess = true; 
        try {
        try {
            WebElement evermine50Link = driver.findElement(By.xpath("//a[@href='/medical-devices/vascular-intervention/coronary/stents/drug-eluting-stents/evermine-50' and text()='Evermine50']"));
            evermine50Link.click();
            System.out.println("Clicked on 'Evermine50' drug link.");
            captureScreenshot();
        } catch (NoSuchElementException e) {
            System.out.println("'Evermine50' drug link was not found.");
        } catch (ElementClickInterceptedException e) {
            System.out.println("Click was intercepted: " + e.getMessage());
        }            screenshotPath = reportGenerator.captureScreenshot("TestCase1");
        }catch (Exception e) {
            isSuccess = false; // Mark as failed if an exception occurs
            e.printStackTrace();
        } finally {
            reportGenerator.addReportEntry("Select a drug", isSuccess, screenshotPath);
        }
    }

    // Test to click on the "Clinical Data" link and save data
    @Test(priority = 13)
    public void clickClinicalDataAndSave() {
    	String screenshotPath = "";
        boolean isSuccess = true; 
        try {
        try {
            WebElement clinicalDataHeader = driver.findElement(By.xpath("//h2[text()='Tech Specifications']"));
            clinicalDataHeader.click();
            System.out.println("Clicked on 'Clinical Data' link.");
           
            // Call the method after clicking on Clinical Data
            saveClinicalDataToFile();
        } catch (NoSuchElementException e) {
            System.out.println("'Clinical Data' link was not found.");
        } catch (ElementClickInterceptedException e) {
            System.out.println("Click was intercepted: " + e.getMessage());
        }            screenshotPath = reportGenerator.captureScreenshot("TestCase1");
        }catch (Exception e) {
            isSuccess = false; // Mark as failed if an exception occurs
            e.printStackTrace();
        } finally {
            reportGenerator.addReportEntry("Clinical data ", isSuccess, screenshotPath);
        }
    }
    @Test(priority = 14)
    public void clicklogo() {
    	 WebElement clicklogo=driver.findElement(By.xpath("//img[@alt='Meril Log']"));

    
    }


    

    private void saveClinicalDataToFile() {
        try {
            
            WebElement stentDesignRow = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[contains(text(),'Stent design')]/following-sibling::td")));
            WebElement stentMaterialRow = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[contains(text(),'Stent material')]/following-sibling::td")));

            // Get text from the relevant columns
            String stentDesign = stentDesignRow.getText();
            String stentMaterial = stentMaterialRow.getText();

           
            File outputFile = new File("C:\\Users\\I19-labuser154440\\eclipse-workspace\\meril\\clinical.txt");  
            outputFile.getParentFile().mkdirs();
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile, true));  
            
            
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
                
                File outputFile = new File("C:\\Users\\I19-labuser154440\\eclipse-workspace\\meril\\textspec.txt");
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

@AfterClass
public void tearDown() {
	   if (driver != null) {
   }
driver.quit();
System.out.println("Browser closed.");
reportGenerator.finalizeReport();

   }
 
			public void captureScreenshot() {
		    TakesScreenshot ts = (TakesScreenshot) driver;
		    File source = ts.getScreenshotAs(OutputType.FILE);
		    try {
		        // Ensure the target directory exists
		        File targetDir = new File("/home/zadmin/eclipse-workspace/ananyaa/scerrn");
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
