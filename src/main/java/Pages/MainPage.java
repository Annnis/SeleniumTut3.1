package Pages;

import Core.DriverFactory;
import Interfaces.IMainPage;
import lombok.Getter;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@Getter

public class MainPage implements IMainPage {
    WebDriver driver;
    public MainPage() {
        PageFactory.initElements(DriverFactory.getDriver(), this);
    }

    //Выбрать рандомное имя
    @FindBy(css = "#pre_rand")
    private WebElement nameBut;

    @FindBy(id = "pre_button")
    private WebElement randomName;

    //Раскрыть дропдаун домена
    @FindBy(css = "#domain")
    private WebElement dropdownBut;

    //и выбрать "rover.info"
    @FindBy(css = "#pre_form > div > div.dropdown.mb-30.mb-md-0.show > div > button:nth-child(6)")
    private WebElement rover;

    public String secretName() {
        waitForVisibility(dropdownBut, 8);
        return secretAddress.
                getAttribute("textContent");
    }

    public String secretAddress() {
        return getRandomName().getAttribute("value")
                + getDropdownBut().getText();
    }
    //Нажать настройки,
    @FindBy(css = "#pre_settings")
    private WebElement settingsBut;

    // выбрать "Выберите срок жизни почтового ящика" = 10 минут.
    @FindBy(css = "#modal-settings > div > form > div.modal-body > div:nth-child(1) > div.btn-group.btn-group-toggle.d-flex > label:nth-child(1)")
    private WebElement durationBut;

    //Проверить, что окно настроек закрылось (Используем Assert.assertTrue например)
    @FindBy(xpath = "//*[@id=\"modal-settings\"]/div/form/div[2]/div/button")
    private WebElement exitBut;

    public void isClosed() {
        MainPage.waitForVisibility(getWriteBut(), 5);
        Assertions.assertTrue(getWriteBut().isDisplayed());
    }

    @FindBy(css = "#modal-settings > div > form > div.modal-header > div > span")
    private WebElement textSettings;

    //Проверить что видна надпись "В ожидании новых писем..."
    @FindBy(css = "#container-body > div > div.inbox > div > span")
    private WebElement text;

    public void visibilityOfText() {
        MainPage.waitForVisibility(getText(), 5);
        Assertions.assertTrue(getText().isDisplayed());
    }

    //Проверить что видна надпись "В ожидании новых писем..."
    @FindBy(css = "#modal-settings > div > form > div.modal-body > div:nth-child(2) > div.d-flex.align-items-center > button")
    private WebElement eye;

    //Нажать кнопку "Написать".
    @FindBy(css = "#compose")
    private WebElement writeBut;

    public void checkWindow() {
        MainPage.waitForVisibility(getAttach(), 10);
        Assertions.assertTrue(getAttach().isDisplayed());
    }

    //и заполнить поля кому ("имя почтового ящика"),
    @FindBy(css = "#to")
    private WebElement inputTO;
    //тема ("MyTest"),
    @FindBy(css = "#subject")
    private WebElement inputTopic;
    // текст ("секретный адрес").
    @FindBy(css = "#secret-address")
    private WebElement secretAddress;

    @FindBy(css = "#text")
    private WebElement textField;
    @FindBy(css = "#modal-settings > div > form > div.modal-header > div > button")
    private WebElement exitBtn;
    @FindBy(css = "#back")
    private WebElement backBtn;
    @FindBy(css = "#container-body > div > div.inbox > div:nth-child(2) > div > div.subj.col-12.col-md-7.px-md-3 > span")
    private WebElement retest;
    @FindBy(css = "#info > div.overflow-auto.mb-20")
    private WebElement newText;
    @FindBy(xpath = "//*[@id=\"confirm_mail\"]")
    private WebElement confirm;
    @FindBy(css = "#submit")
    private WebElement sendBtn;
    @FindBy(css = "#container-body > div > div.inbox > div.mail > div > div.from.col-9.col-md-4 > span")
    private WebElement massNew;
    @FindBy(css = "#delete_mail")
    private WebElement deleteMailBtn;
    @FindBy(css = "#info > div.row.row-info.no-gutters > div.col.d-flex.mb-10 > span")
    private WebElement mailString;
    @FindBy(css = "#info > div.subject.mb-20")
    private WebElement themeString;
    @FindBy(css = "#info > div.overflow-auto.mb-20")
    private WebElement bodyOfMess;
    @FindBy(css = "#reply")
    private WebElement replyBtn;
    @FindBy(css = "#form > div.modal-footer.justify-content-md-start.shadow > label")
    private WebElement attach;
    @FindBy(xpath = "//*[@id=\"text\"]")
    private WebElement newBodyMess;
    @FindBy(xpath = "//*[@id=\"modal-destroy-mail\"]/div/div/div")
    private WebElement formConfirmDelete;

    public static WebElement waitForVisibility(WebElement element, int timeOfWait, int... timeOfTryOut) {
        WebElement webElement = null;
        int timeOfRevision = timeOfTryOut.length == 0
                ? 100
                : timeOfTryOut[0];
        try {
            webElement = new WebDriverWait(DriverFactory.getDriver(),
                    timeOfWait,
                    timeOfRevision
            ).until(ExpectedConditions.visibilityOf(element));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return webElement;
    }

}

