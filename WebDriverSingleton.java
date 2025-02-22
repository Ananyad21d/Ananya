package cucumber;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverSingleton {
    private static WebDriver driver;


    
    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;

        }
    }
	public static WebDriver getDriver() {
		// TODO Auto-generated method stub
		if (driver == null) {
			
          driver = new ChromeDriver();
          driver.manage().window().maximize();
      }
      return driver;	
      
	}

	}

