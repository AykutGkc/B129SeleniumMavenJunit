package NT.day21_JSExecutor_240423;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import utilities.TestBase;

public class C01_JSExecutor_Click extends TestBase {

    /*
    http://www.uitestpractice.com/Students/Form sayfasına git
    Formu doldur
    Submit tuşuna tıkla
    Sayfa adresinin "http://www.uitestpractice.com/Students/Form?optradio=on" olduğunu doğrula.
    */
    @Test
    public void clickByJSTest() {
        /*
        Eger bir web sayfasinin html kodlari tamamen ya da kismen javaScript kullanilarak olusturuldu ise
        o sayfaya müdahale etmek icin genellikle javaScriptExecutor arayüzünü kullanmak gerekir.
        Bu durumda sayfayi manipüle etmek veya etkilesimde bulunmak icin standeart Web driver komutlari
        yetersiz kalabilir.Bu nedenle JSExecutor arayüzü sayfanin JS kodlarina dogrudan erisebilir.
        Ancak mümkünse WebDriver'in sundugu standart yöntemlerle sorunlari cözmek her zaman daha iyidir.
        Cünkü JS kullanimi sayfanin daha yavas yüklenmesine neden olabilir.
         */


        // http://www.uitestpractice.com/Students/Form sayfasına git
        driver.get("http://www.uitestpractice.com/Students/Form");

        //    Formu doldur
        Faker faker=new Faker();
        WebElement firstName=driver.findElement(By.id("firstname"));
        firstName.sendKeys(faker.name().firstName(), Keys.TAB,faker.name().lastName(),
                Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,faker.phoneNumber().cellPhone());
        //    Submit tuşuna tıkla
        WebElement submit=driver.findElement(By.xpath("//*[text()='Submit']"));
        //org.openqa.selenium.ElementClickInterceptedException--> eger JS kodlariyla bir web element olusturulmussa
        //normal click() methodunda bu exception'i aliriz.

        click(submit);

     /*   try {
            submit.click();
        } catch (Exception e) {
            JavascriptExecutor js= (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();",submit);
        }*/

        //    Sayfa adresinin "http://www.uitestpractice.com/Students/Form?optradio=on" olduğunu doğrula.
        Assert.assertNotEquals("http://www.uitestpractice.com/Students/Form?optradio=on",driver.getCurrentUrl());





    }
}
