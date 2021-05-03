package Steps;
import Interfaces.IMainPage;
import Pages.MainPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Steps {
    protected final Logger log = LogManager.getLogger(this.getClass());
    IMainPage iMainPage = new MainPage();
}
