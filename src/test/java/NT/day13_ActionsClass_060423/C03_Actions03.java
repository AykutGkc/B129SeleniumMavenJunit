package NT.day13_ActionsClass_060423;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.security.Key;

public class C03_Actions03 extends TestBase {
    /*
https://techproeducation.com adresine gidin
 Sayfanın alt tarafına gidin
 Sayfanın üst tarafına gidin
 */

    @Test
    public void actions() {
        //https://techproeducation.com adresine gidin
        driver.get("https://techproeducation.com");
        waitWithThreadSleep(2);
        driver.findElement(By.xpath("//*[@class='eicon-close']")).click();

        // Sayfanın alt tarafına gidin
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).
                sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).
                perform();
        // Sayfanın üst tarafına gidin
        waitWithThreadSleep(2);
        actions.sendKeys(Keys.PAGE_UP).sendKeys(Keys.PAGE_UP).sendKeys(Keys.ARROW_UP).perform();
    }

    @Test
    public void actions2() {
        driver.get("https://techproeducation.com");
        waitWithThreadSleep(2);
        driver.findElement(By.xpath("//*[@class='eicon-close']")).click();

        // Sayfanın alt tarafına gidin
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.END);
        // Sayfanın üst tarafına gidin
        waitWithThreadSleep(2);
        actions.sendKeys(Keys.HOME).build().perform(); //perform() ile action objemi isleme alir
        //build() methodu ile birden fazla olusturdugumuz action objesini birbirine baglayabiliriz.
    }

    @Test
    public void actions3() {
        //Amazon anasayfasına gidin
        driver.get("https://amazon.com");
        //Arama kutusuna büyük harfler ile samsung aratalim.
        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys(Keys.SHIFT,"sa",Keys.SHIFT,"msung",Keys.ENTER);//SAmsung
        driver.navigate().back();
        WebElement aramaKutusu2=driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu2.sendKeys(Keys.SHIFT,"iphone");//IPHONE

    }
}
