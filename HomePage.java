package merli;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    private WebDriver driver;

    // Locators for the cookie accept button
    @FindBy(id = "closeprem")
    private WebElement cookieAcceptButton;

    // Constructor to initialize WebDriver and PageFactory
    public HomePage(WebDriver driver2) {
        this.driver = driver2;
        // Initialize PageFactory elements
        PageFactory.initElements(driver, this);
    }

    

    public void acceptCookiePopup() {
        try {
            
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.visibilityOf(cookieAcceptButton));

           
            cookieAcceptButton.click();
            System.out.println("Cookie popup accepted.");
        } catch (Exception e) {
            System.out.println("Error accepting cookie popup: " + e.getMessage());
        }
    }

   
    public String getPageTitle() {
        return driver.getTitle();
    }

}
