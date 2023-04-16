package NT.day16_SeleniumExceptions_130423;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C02_TimeOutException extends TestBase {
    @Test
    public void timeOutException() {
        /*
        timeOutException: sayfa da aradigimiz elementi wait ile belirledigimiz max sürede bulamadigi durumda
        timeOutException hatasi aliriz.
         */

        //TEchproeducation sayfasina gidelim
        driver.get("https://techproeducation.com/");
        driver.findElement(By.xpath("//*[@class='eicon-close']")).click(); //Reklami kapatir

        //Exception alabilmek icin visibleofelementlocater methodunu kullanarak yanlis locate aldik.
        visibleWait(By.xpath("YanlisLocate"),30);
        //Web elementi beklerken o web elementin locateni bulamadigi icin max belirttigimiz süre kadar bekler ve
        //org.openqa.selenium.TimeoutException hatasi verir.

    }

    @Test
    public void timeOutException2() {
        //adrese gidelim
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        //Start butonuna tiklayalim
        driver.findElement(By.xpath("//*[.='Start']")).click();

        //Hello World textinin ciktigini dogrulayin
        WebElement helloWorldText= driver.findElement(By.xpath("(//h4)[2]"));
        visibleWait(helloWorldText,2);
        //HelloWord yazisi ort. 6 sn de gözüktügü icin explicit waitte max 2 sn verdigimizden dolayi
        //org.openqa.selenium.TimeoutException hatasi aldik
        Assert.assertTrue(helloWorldText.isDisplayed());
    }
}
