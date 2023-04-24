package NT.day21_JSExecutor_240423;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C03_JSExecutor_Type extends TestBase {
    /*
Techpro education ana sayfasina git
Arama kutusuna QA yaz
 */

    @Test
    public void jsExecutorType() {
        //Techpro education ana sayfasina git
        driver.get("https://techproeducation.com/");
        waitWithThreadSleep(2);
        driver.findElement(By.xpath("//*[@class='eicon-close']")).click();

        //Arama kutusuna QA yaz

        WebElement aramaKutusu = driver.findElement(By.xpath("//input[@title='Search']"));
        JavascriptExecutor js= (JavascriptExecutor) driver;
        /*
        Bazi giris kutulari normal sendKeys() methodu ile metin gönderilmesine izin vermez
        Bu gibi durumlarda asagidaki örnekteki gibi JSExecutor kullanilir.
         */
        //js.executeScript("arguments[0].value='QA'",aramaKutusu);
        //sendKeysJS(aramaKutusu,"QA");

        /*
        Eğer js.executeScript("arguments[0].value='QA'",aramaKutusu); bu kullanımdaki gibi metin gönderemezsek
        aşağıdaki örnekteki gibi value attribute'ne değer atayabiliriz
         */
       // js.executeScript("arguments[0].setAttribute('value','QA')",aramaKutusu);
        sendAttributeJS(aramaKutusu,"QA");

        aramaKutusu.submit();


    }
}
