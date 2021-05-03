package Interfaces;

import Pages.MainPage;
import org.openqa.selenium.WebElement;

public interface IMainPage extends IPage {

    WebElement getNameBut();

    WebElement getDropdownBut();

    WebElement getRover();

    WebElement getSettingsBut();

    String secretName();

    String secretAddress();

    void isClosed();

    WebElement getExitBtn();

    WebElement getWriteBut();

    void visibilityOfText();

    void checkWindow();

    WebElement getInputTO();

    WebElement getInputTopic();

    WebElement getTextField();

    WebElement getSendBtn();

    WebElement getMassNew();

    WebElement getMailString();

    WebElement getThemeString();

    WebElement getBodyOfMess();

    WebElement getReplyBtn();

    WebElement getNewBodyMess();

    WebElement getBackBtn();

    WebElement getRetest();

    WebElement getDeleteMailBtn();

    WebElement getConfirm();

    WebElement getAttach();

    WebElement getFormConfirmDelete();
}
