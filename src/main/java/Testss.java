import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class Testss {

PageObject po = new PageObject();
Actions action = new Actions(Singleton.getDriver());

 @BeforeEach
    public void init(){
        Singleton.initPage();
    }

@AfterEach
    public void setAfter(){Singleton.quit();}
    @Test
    public void  check(){
    po.getNameBut().click();
    //Раскрыть дропдаун домена и выбрать "rover.info"
        po.getDropdownBut().click();
        PageObject.waitForVisibility(po.getRover(), 10).click();
        //Запомнить "имя почтового ящика".
        String myMail=  po.getRandomName().getAttribute("value")
                +po.getDropdownBut().getText();

        //Нажать настройки, выбрать "Выберите срок жизни почтового ящика" = 10 минут. Сохранить настройки.
        po.getSettingsBut().click();
        PageObject.waitForVisibility(po.getDurationBut(), 5).click();
        action.moveByOffset(10, 10).click().build().perform();
        //Сохранить "секретный адрес"
        po.getSecretName();



        //Проверить, что окно настроек закрылось (Используем Assert.assertTrue например).
        PageObject.waitForVisibility(po.getWriteBut(), 5);
        Assertions.assertTrue(po.getWriteBut().isDisplayed());
        //Проверить что видна надпись "В ожидании новых писем..."
        PageObject.waitForVisibility(po.getText(), 5);
        Assertions.assertTrue(po.getText().isDisplayed());
        //Нажать кнопку "Написать".
        po.getWriteBut().click();
        PageObject.waitForVisibility(po.getSendBtn(), 10);
        Assertions.assertTrue(po.getSendBtn().isDisplayed());

      // кому ("имя почтового ящика"), тема ("Test"), текст ("секретный адрес")
        po.getInputTO().sendKeys(myMail);
        //theme
        po.getInputTHEME().sendKeys("Test");

        po.getTextField().sendKeys(po.getSecretName());
        po.getSendBtn().click();
        //Дождаться появления нового письма от "имя почтового ящика" и кликнуть по новому письму.
        PageObject.waitForVisibility(po.getMassNew(), 10).click();

        //В раскрывшемся письме проверить отправителя ("имя почтового ящика"),
        PageObject.waitForVisibility(po.getDeleteMailBtn(), 10);
        Assertions.assertEquals(po.getMailString().getText(), myMail);
        Assertions.assertEquals( po.getThemeString().getAttribute("textContent"), "Test" );
        Assertions.assertEquals( po.getBodeOfMess().getAttribute("textContent"), po.getSecretName() );
       // Нажать кнопку Reply, дождаться открытия формы нового сообщения. Вписать в тело сообщения "Test2" и отправить письмо.
        po.getReplyBtn().click();
        PageObject.waitForVisibility(po.getTextField(), 10).sendKeys("Test2");


        po.getSendBtn().click();
        action.moveByOffset(10, 10).click().build().perform();
        po.getBackBtn().click();
        PageObject.waitForVisibility(po.getWriteBut(),20);
        Assertions.assertTrue(Singleton.driver.getPageSource().contains("Re: Test"));
        po.getRetest().click();
        PageObject.waitForVisibility(po.getNewText(), 10);
        String text = po.getNewText().getText();
        Assertions.assertEquals("Test2",text);
        po.getDeleteMailBtn().click();
        PageObject.waitForVisibility(po.getConfirm(), 20).click();
        PageObject.waitForVisibility(po.getSettingsBut(), 20);
        Assertions.assertFalse(Singleton.driver.getPageSource().contains("Re: Test"));
    }
}
