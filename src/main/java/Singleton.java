import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Singleton {
    public static WebDriver driver = null;

    public static WebDriver getDriver(){
        if (driver == null) {
                System.setProperty("webdriver.chrome.driver","src/main/chromedriver.exe");
                driver = new ChromeDriver();
            }
                return driver;
    }

    public static void initPage(){
        getDriver();
        driver.manage().window().maximize();
        driver.get("https://tempmail.plus/ru/");
    }

    public static void quit(){
        driver.quit();
        driver = null;
         }
    }







