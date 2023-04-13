package NT.day15_FileUpload_Wait_110423;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import utilities.TestBase;

import java.nio.file.WatchEvent;
import java.time.Duration;

public class C03_FluentWait extends TestBase {
    @Test
    public void fluentWait() {
        //https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        //Start buttonuna tıklayın
        driver.findElement(By.xpath("//button")).click();

        //Hello World! Yazının sitede oldugunu test edin
        Wait<WebDriver> wait=new FluentWait<>(driver).
                                    withTimeout(Duration.ofSeconds(30)). //Fluent wait icin max. sürei belirtir.
                                    pollingEvery(Duration.ofSeconds(3)). //her 3 saniyede bir web elementi kontrol eder
                                    withMessage("Ignore Exception"). //zorunlu degil
                                    ignoring(NoSuchElementException.class); //Zorunlu degil exception handle eder.

        WebElement helloWordText1=driver.findElement(By.xpath("(//h4)[2]"));
        wait.until(ExpectedConditions.visibilityOf(helloWordText1));

        Assert.assertTrue(helloWordText1.isDisplayed());
        /*
        Thread.sleep:Javadan gelen bu bekleme ile belirttigmiz süre kadar kodlari bekletir.
        Implictly Wait:Sayfada ki tüm web elementler icin max süre kadar sayfanin yüklenmesini bekler
        Explict Wait: Belirli bi kosul gerceklesene kadar belirttigimiz süre boyunca driver'in beklemesini saglar
        Fluent Wait: Belirli bir kosul gerceklesene kadar belirttigimiz araliklar ile beklemeye devam eder.
         */
    }
}
