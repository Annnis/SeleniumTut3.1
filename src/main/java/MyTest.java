//import Core.DriverFactory;
//import Pages.MainPage;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.openqa.selenium.interactions.Actions;
//
//public class MyTest {
//
//MainPage po = new MainPage();
//Actions action = new Actions(DriverFactory.getDriver());
//
// @BeforeEach
//        public void init(){
//        DriverFactory.initPage();
//    }
//@AfterEach
//        public void setAfter(){
//        DriverFactory.quit();}
//        @Test
//        public void  check(){
//        po.getNameBut().click();
//        //Раскрыть дропдаун домена и выбрать "rover.info"
//        po.getDropdownBut().click();
//        MainPage.waitForVisibility(po.getRover(), 10).click();
//        //Запомнить "имя почтового ящика".
//        String myMail=  po.getRandomName().getAttribute("value")
//                +po.getDropdownBut().getText();
//        //Нажать настройки, выбрать "Выберите срок жизни почтового ящика" = 10 минут. Сохранить настройки.
//        po.getSettingsBut().click();
//        MainPage.waitForVisibility(po.getDurationBut(), 5).click();
//        action.moveByOffset(10, 10).click().build().perform();
//        //Сохранить "секретный адрес"
//        //po.getSecretName();
//        //Проверить, что окно настроек закрылось (Используем Assert.assertTrue например).
//        MainPage.waitForVisibility(po.getWriteBut(), 5);
//        Assertions.assertTrue(po.getWriteBut().isDisplayed());
//        //Проверить что видна надпись "В ожидании новых писем..."
//        MainPage.waitForVisibility(po.getText(), 5);
//        Assertions.assertTrue(po.getText().isDisplayed());
//        //Нажать кнопку "Написать".
//        po.getWriteBut().click();
//        MainPage.waitForVisibility(po.getSendBtn(), 10);
//        Assertions.assertTrue(po.getSendBtn().isDisplayed());
//
//        //кому ("имя почтового ящика"), тема ("Test"), текст ("секретный адрес")
//        po.getInputTO().sendKeys(myMail);
//        //theme
//        po.getInputTHEME().sendKeys("Test");
//
//       // po.getTextField().sendKeys(po.getSecretName());
//        po.getSendBtn().click();
//        //Дождаться появления нового письма от "имя почтового ящика" и кликнуть по новому письму.
//        MainPage.waitForVisibility(po.getMassNew(), 10).click();
//
//        //В раскрывшемся письме проверить отправителя ("имя почтового ящика"),
//        MainPage.waitForVisibility(po.getDeleteMailBtn(), 10);
//        Assertions.assertEquals(po.getMailString().getText(), myMail);
//        Assertions.assertEquals( po.getThemeString().getAttribute("textContent"), "Test" );
//        Assertions.assertEquals( po.getBodeOfMess().getAttribute("textContent"), po.getSecretName() );
//       // Нажать кнопку Reply, дождаться открытия формы нового сообщения. Вписать в тело сообщения "Test2" и отправить письмо.
//        po.getReplyBtn().click();
//        MainPage.waitForVisibility(po.getTextField(), 10).sendKeys("Test2");
//
//
//        po.getSendBtn().click();
//        action.moveByOffset(10, 10).click().build().perform();
//        po.getBackBtn().click();
//        MainPage.waitForVisibility(po.getWriteBut(),20);
//        Assertions.assertTrue(DriverFactory.driver.getPageSource().contains("Re: Test"));
//        po.getRetest().click();
//        MainPage.waitForVisibility(po.getNewText(), 10);
//        String text = po.getNewText().getText();
//        Assertions.assertEquals("Test2",text);
//        po.getDeleteMailBtn().click();
//        MainPage.waitForVisibility(po.getConfirm(), 20).click();
//        MainPage.waitForVisibility(po.getSettingsBut(), 20);
//        Assertions.assertFalse(DriverFactory.driver.getPageSource().contains("Re: Test"));
//    }
//}
