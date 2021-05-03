package Core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {
    public static WebDriver driver = null;

    public static WebDriver getDriver(){
        if (driver == null) {
                System.setProperty("webdriver.chrome.driver","src/main/ChromeDriver/chromedriver.exe");
                driver = new ChromeDriver();
            }
                return driver;
    }

    public static void initPage(){
        getDriver();
        driver.manage().window().maximize();
    }

    public static void quit(){
        driver.quit();
         }
    }







