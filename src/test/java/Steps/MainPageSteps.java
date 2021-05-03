package Steps;

import Core.Config;
import Core.DriverFactory;
import Pages.MainPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.interactions.Actions;

public class MainPageSteps extends Steps {
    Actions action = new Actions(DriverFactory.getDriver());
    String savedMail;
    String savedSecretAdd;

    @Given("^i go to main page$")
    public void iGoToMainPage() {
        log.info("i go to main page");
        DriverFactory.getDriver().get(Config.BASE_URL);
    }

    @And("^i choose random name$")
    public void iChooseRandomName() {
        log.info("i choose random name");
        iMainPage.getNameBut().click();

    }

    @And("^i open dropdown menu$")
    public void iOpenDropdownMenu() {
        log.info("i open dropdown menu");
        iMainPage.getDropdownBut().click();
    }

    @And("^i choose domain name$")
    public void iChooseDomainName() {
        log.info("i choose domain name");
        iMainPage.getRover().click();
    }

    @And("^i save new e-mail$")
    public void iSaveNewEMail() {
        log.info("i save new e-mail");
        savedMail = iMainPage.secretAddress();
    }

    @And("^i open settings$")
    public void iOpenSettings() {
        log.info("i open settings");
        iMainPage.getSettingsBut().click();
    }

    @And("^i save secret address$")
    public void iSaveSecretAddress() {
        log.info("i save secret address");
        savedSecretAdd = iMainPage.secretName();
    }

    @And("^i close settings$")
    public void iCloseSettings() {
        log.info("i close settings");
        MainPage.waitForVisibility(iMainPage.getExitBtn(), 5);
        action.moveByOffset(10, 10).click().build().perform();
        iMainPage.getExitBtn().click();
    }

    @And("^i check that settings closed$")
    public void iCheckThatSettingsClosed() {
        log.info("i check that settings closed");
        MainPage.waitForVisibility(iMainPage.getWriteBut(), 5);
        iMainPage.isClosed();
    }

    @And("^i check visibility of text$")
    public void iCheckVisibilityOfText() {
        log.info("i check visibility of text");
        iMainPage.visibilityOfText();
    }

    @And("^i click on write button$")
    public void iClickOnWriteButton() {
        log.info("i click on write button");
        iMainPage.getWriteBut().click();
    }

    @And("^i check that modal window opened$")
    public void iCheckThatModalWindowOpened() {
        log.info("i check that modal window opened");
        iMainPage.checkWindow();
    }

    @Then("^i fill input to$")
    public void iFillInputTo() {
        log.info("i fill input to");
        iMainPage.getInputTO().sendKeys(iMainPage.secretAddress());
    }

    @Then("^i fill input topic$")
    public void iFillInputTopic() {
        log.info("i fill input topic");
        iMainPage.getInputTopic().sendKeys("Test");
    }

    @Then("i fill input text$")
    public void iFillInputText() {
        log.info("i fill input text");
        iMainPage.getTextField().sendKeys(iMainPage.secretName());
    }

    @Then("^i click send button$")
    public void iClickSendButton() {
        log.info("i click send button");
        iMainPage.getSendBtn().click();
    }

    @And("^i open new letter$")
    public void iOpenNewLetter() {
        log.info("i open new letter");
        MainPage.waitForVisibility(iMainPage.getMassNew(), 10);
        iMainPage.getMassNew().click();
    }

    @Then("^i check the sender$")
    public void iCheckTheSender() {
        log.info("i check the sender");
        MainPage.waitForVisibility(iMainPage.getMailString(), 5);
        Assertions.assertEquals(savedMail, iMainPage.getMailString().getAttribute("textContent"));
    }

    @Then("^i check the topic$")
    public void iCheckTheTopic() {
        log.info("i check the topic");
        Assertions.assertEquals("Test", iMainPage.getThemeString().getAttribute("textContent"));
    }

    @Then("^i check the text$")
    public void iCheckTheText() {
        log.info("i check the text");
        Assertions.assertEquals(savedSecretAdd, iMainPage.getBodyOfMess().getAttribute("textContent"));
    }

    @And("^i click reply button$")
    public void iClickReplyButton() {
        log.info("i check the text");
        MainPage.waitForVisibility(iMainPage.getReplyBtn(), 50);
        iMainPage.getReplyBtn().click();
    }

    @Then("^i write to the text field$")
    public void iWriteToTheTextField() {
        log.info("i write to the text field");
        MainPage.waitForVisibility(iMainPage.getNewBodyMess(), 5);
        iMainPage.getNewBodyMess().sendKeys("Test2");
    }

    @Then("^i send a letter$")
    public void iSendALetter() {
        log.info("i send a letter");
        MainPage.waitForVisibility(iMainPage.getSendBtn(), 5);
        iMainPage.getSendBtn().click();
    }

    @And("^i go back to main page$")
    public void iGoBackToMainPage() {
        log.info("i go back to main page");
        MainPage.waitForVisibility(iMainPage.getBackBtn(), 5);
        iMainPage.getBackBtn().click();
    }

    @Then("^i check that new letter received$")
    public void iCheckThatNewLetterReceived() {
        log.info("i check that new letter received");
        MainPage.waitForVisibility(iMainPage.getRetest(), 5);
        Assertions.assertTrue(DriverFactory.driver.getPageSource().contains("Re: Test"));
    }

    @And("^i open received letter$")
    public void iOpenReceivedLetter() {
        log.info("i open received letter");
        iMainPage.getRetest().click();
    }

    @Then("^i check that body consist testTwo$")
    public void iCheckThatBodyConsistTestTwo() {
        log.info("i check that body consist testTwo");
    }

    @And("^i delete message")
    public void iDeleteMessage() {
        log.info("i delete message");
        iMainPage.getDeleteMailBtn().click();
    }

    @Then("^i wait until modal window of deleting appear$")
    public void iWaitUntilModalWindowOfDeletingAppear() {
        log.info("i wait until modal window of deleting appear");

        MainPage.waitForVisibility(iMainPage.getFormConfirmDelete(), 80);
    }

    @And("^i confirm deleting$")
    public void iConfirmDeleting() {
        log.info("i confirm deleting");
        MainPage.waitForVisibility(iMainPage.getConfirm(), 10);
        iMainPage.getConfirm().click();
        action.moveByOffset(10, 10).click().build().perform();

    }

    @And("^i check that there are no Re Test$")
    public void iCheckThatThereAreNoReTest() {
        log.info("i check that there are no Re Test");
        MainPage.waitForVisibility(iMainPage.getWriteBut(), 20);
        Assertions.assertFalse(DriverFactory.driver.getPageSource().contains("Re: Test"));
    }

    @Then("^i close browser$")
    public void iCloseBrowser() {
        log.info("i close browser");
        DriverFactory.getDriver().close();
    }
}

