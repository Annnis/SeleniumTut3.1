import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@Getter

public class PageObject {
//    public static void main(String[] args) {
//        PageObject ab = new PageObject();
//        System.out.println(getNameAddress());
//    }
    WebDriver driver;

    public PageObject() {
        PageFactory.initElements(Singleton.getDriver(), this);
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

    //Сохранить "секретный адрес"
    public  String getSecretName(){
        String secretAddres1 = secretAddress.
                getAttribute("textContent");
        return secretAddres1;

    }
    //Нажать настройки,
    @FindBy(css = "#pre_settings")
    private WebElement settingsBut;
    // выбрать "Выберите срок жизни почтового ящика" = 10 минут.
    @FindBy(css = "#modal-settings > div > form > div.modal-body > div:nth-child(1) > div.btn-group.btn-group-toggle.d-flex > label:nth-child(1)")
    private WebElement durationBut;
    //Проверить, что окно настроек закрылось (Используем Assert.assertTrue например)
    @FindBy(css = "#modal-settings > div > form > div.modal-header > div > button")
    private WebElement exitBut;
    @FindBy(css = "#modal-settings > div > form > div.modal-header > div > span")
    private WebElement textSettings;

    //Проверить что видна надпись "В ожидании новых писем..."
    @FindBy(css = "#container-body > div > div.inbox > div > span")
    private WebElement text;
 //Проверить что видна надпись "В ожидании новых писем..."
    @FindBy(css = "#modal-settings > div > form > div.modal-body > div:nth-child(2) > div.d-flex.align-items-center > button")
    private WebElement eye;


    //Нажать кнопку "Написать".
    @FindBy(css = "#compose")
    private WebElement writeBut;
    //и заполнить поля кому ("имя почтового ящика"),
    @FindBy(css = "#to")
    private WebElement inputTO;
    //тема ("Testss"),
    @FindBy(css = "#subject")
    private WebElement inputTHEME;
    // текст ("секретный адрес").

    @FindBy(css = "#secret-address")
    private WebElement secretAddress;

    @FindBy(css = "#text")
    private WebElement textField;
    @FindBy(css = "#form > div.modal-header.shadow-sm > div.bar > button")
    private WebElement exitBtn;
    @FindBy(css = "#back")
    private WebElement backBtn;
    @FindBy(css = "#container-body > div > div.inbox > div:nth-child(2) > div > div.subj.col-12.col-md-7.px-md-3 > span")
    private WebElement retest;
    @FindBy(css = "#info > div.overflow-auto.mb-20")
    private WebElement newText;
    @FindBy(css = "#confirm_mail")
    private WebElement confirm;


    @FindBy(css = "#submit")
    private WebElement sendBtn;
    //Дождаться появления нового письма от "имя почтового ящика" и кликнуть по новому письму.

    @FindBy(css = "#container-body > div > div.inbox > div.mail > div > div.from.col-9.col-md-4 > span")
    private WebElement massNew;

    @FindBy(css = "#delete_mail")
    private WebElement deleteMailBtn;
    @FindBy(css = "#info > div.row.row-info.no-gutters > div.col.d-flex.mb-10 > span")
    private WebElement mailString;
    @FindBy(css = "#info > div.subject.mb-20")
    private WebElement themeString;
    @FindBy(css = "#info > div.overflow-auto.mb-20")
    private WebElement bodeOfMess;
    @FindBy(css = "#reply")
    private WebElement replyBtn;











    public static WebElement waitForVisibility(WebElement element, int timeOfWait, int... timeOfTryOut) {
        WebElement webElement = null;
        int timeOfRevision = timeOfTryOut.length == 0
                ? 100
                : timeOfTryOut[0];
        try {
            webElement = new WebDriverWait(Singleton.getDriver(),
                    timeOfWait,
                    timeOfRevision
            ).until(ExpectedConditions.visibilityOf(element));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return webElement;
    }

}

