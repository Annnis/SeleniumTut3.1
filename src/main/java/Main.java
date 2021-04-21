
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Test;
import junit.framework.Assert;
import static javax.swing.text.html.CSS.getAttribute;


public class Main {
    @Test
    public void testest(){
        System.setProperty("webdriver.chrome.driver", "D://Silenium Jars and drivers//Drivers//ChromeDrivers//chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://tempmail.plus/ru/#!");
        driver.manage().window().maximize();
        //Выбрать рандомное имя
        driver.findElement(By.id("pre_rand")).click();
        //Раскрыть дропдаун домена
         driver.findElement(By.id("domain")).click();
         //и выбрать "rover.info"
        driver.findElement(By.xpath("/html/body/div[8]/div[1]/div[2]/div[1]/form/div/div[2]/div/button[6]")).click();
        //Запомнить "имя почтового ящика".
        String nameOfEmail = driver.findElement(By.id("pre_button")).getAttribute("value")+"@rover.info";
        driver.findElement(By.id("pre_button")).getAttribute("value");
        //Нажать настройки, выбрать "Выберите срок жизни почтового ящика" = 10 минут.
         driver.findElement(By.id("pre_settings")).click();
         WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[4]/div/form/div[3]/div[1]/div[2]/label[1]"))).click();
        // Сохранить настройки.
        //driver.findElement(By.xpath("/html/body/div[4]/div/form/div[3]/div[2]/input")).click();
        String secretAddress = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("secret-address"))).
                getAttribute("textContent");

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[4]/div/form/div[3]/div[1]/div[2]/label[1]"))).click();
        driver.findElement(By.xpath("/html/body/div[4]/div/form/div[2]/div/button")).click();

        //Проверить, что окно настроек закрылось (Используем Assert.assertTrue например)
        WebElement randomName = driver.findElement(By.id("pre_rand"));
        Assertions.assertTrue(randomName.isDisplayed());

        //Проверить что видна надпись "В ожидании новых писем..."
        Assertions.assertTrue(driver.getPageSource().contains("В ожидании новых писем..."));

        //Нажать кнопку "Написать".
        driver.findElement(By.id("compose")).click();

        //Убедиться, что открылась форма для отправки письма
        WebElement sendButton = driver.findElement(By.xpath("/html/body/div[3]/div/form[1]/div[5]/input"));
        wait.until(ExpectedConditions.visibilityOf(sendButton));
        Assertions.assertTrue(sendButton.isDisplayed());

        //и заполнить поля кому ("имя почтового ящика"),
        wait.until(ExpectedConditions.elementToBeClickable(By.
                xpath("//*[@id=\"to\"]")));
        driver.findElement(By.xpath("//*[@id=\"to\"]")).sendKeys(nameOfEmail);
        //тема ("Testss"),
        wait.until(ExpectedConditions.elementToBeClickable(By.
                xpath("//*[@id=\"to\"]")));
        driver.findElement(By.xpath("/html/body/div[3]/div/form[1]/div[2]/div[4]/input")).sendKeys("Testss");
        // текст ("секретный адрес").
        wait.until(ExpectedConditions.elementToBeClickable(By.
                xpath("//*[@id=\"to\"]")));
        driver.findElement(By.xpath("/html/body/div[3]/div/form[1]/div[3]/div[1]")).sendKeys(secretAddress);

        driver.findElement(By.id("submit")).click();

        //Дождаться появления нового письма от "имя почтового ящика" и кликнуть по новому письму.
        wait.until(ExpectedConditions.elementToBeClickable(By.
                xpath("/html/body/div[8]/div[2]/div/div[1]/div[2]/div/div[1]/span"))).click();
      //  В раскрывшемся письме проверить отправителя ("имя почтового ящика"), тему письма ("Testss"), содержимое письма ("секретный адрес").
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[8]/div[2]/div/div[2]/button"))); // 3.13
        String senderName = driver.findElement(By.xpath("/html/body/div[8]/div[2]/div/div[1]/div[2]/div[1]/div[1]/span")).getAttribute("textContent");
        Assertions.assertEquals(nameOfEmail, senderName);
        String themeOfEmail = driver.findElement(By.xpath("/html/body/div[8]/div[2]/div/div[1]/div[2]/div[2]")).getAttribute("textContent");
        Assertions.assertEquals("Testss", themeOfEmail);
        String textOfEmail = driver.findElement(By.xpath("/html/body/div[8]/div[2]/div/div[1]/div[2]/div[3]")).getAttribute("textContent");
        Assertions.assertEquals(secretAddress, textOfEmail);



        //Нажать кнопку Reply, дождаться открытия формы нового сообщения.
        driver.findElement(By.xpath("/html/body/div[8]/div[2]/div/div[2]/button")).click();
        //Вписать в тело сообщения "Test2" и отправить письмо.
        wait.until(ExpectedConditions.elementToBeClickable(By.
                xpath("//*[@id=\"to\"]")));
        driver.findElement(By.xpath("/html/body/div[3]/div/form[1]/div[3]/div[1]")).sendKeys("Test2");

        driver.findElement(By.xpath("/html/body/div[3]/div/form[1]/div[5]/input")).click();

       driver.findElement(By.xpath("/html/body/div[8]/div[2]/div/div[1]/div[1]/button[1]")).click();


        //Убедиться, что пришло новое письмо с темой "Re: Testss". Раскрыть его, кликнув по нему.String resendEmail = "Re: " + themeOfEmail; // 3.16
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[8]/div[2]/div/div[2]/button[2]")));
        String toCheckRe = driver.findElement(By.xpath("/html/body/div[8]/div[2]/div/div[1]/div[2]/div/div[3]/span")).getAttribute("textContent");
        Assertions.assertEquals("Re: Testss", toCheckRe);
        driver.findElement(By.xpath("/html/body/div[8]/div[2]/div/div[1]/div[2]/div/div[3]")).click();
        //Убедиться, что в теле письма содержится "Test2"
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[8]/div[2]/div/div[1]/div[2]/div[3]")));  // 3.17
        String textOfEmailRe = driver.findElement(By.xpath("/html/body/div[8]/div[2]/div/div[1]/div[2]/div[3]")).getAttribute("textContent");
        Assertions.assertEquals("Test2", textOfEmailRe);
       //Нажать кнопку удалить письмо. Дождаться модального окна. Подтвердить удаление письма.

        driver.findElement(By.xpath("/html/body/div[8]/div[2]/div/div[1]/div[1]/button[2]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[7]/div/div/div/div/button[1]"))).click();

      //  Убедиться, что во входящих нет письма с темой "Re: Testss"
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("delete")));
        Assertions.assertFalse(driver.getPageSource().contains("Re: Testss"));


    }
}
