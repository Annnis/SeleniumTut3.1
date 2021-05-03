package Pages;

import Core.DriverFactory;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.junit.jupiter.api.AfterEach;

public class Hooks {
    @Before
    public void beforeEachScenario(){
        DriverFactory.initPage();
    }
    @AfterEach
    public static void quit(){
        DriverFactory.quit();
    }
}
