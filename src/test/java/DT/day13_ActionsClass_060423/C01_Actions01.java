package DT.day13_ActionsClass_060423;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C01_Actions01 extends TestBase {
/*
https://the-internet.herokuapp.com/context_menu  sitesine gidin
Kutuya sağ tıklayın
Alert'te cikan yazinin "You selected a context menu" oldugunu test edin
Tamam diyerek alert'i kapatın
 */

    @Test
    public void actionsTest() {
        //https://the-internet.herokuapp.com/context_menu  sitesine gidin
        driver.get("https://the-internet.herokuapp.com/context_menu");

        //Kutuya sağ tıklayın
        //Sag tik islemi icin ContextClick() methoduna ihtiyacimiz var bunun icin Actions objesi olusturulmalidir.

        //1.Adim : Actions objesi olusturun.
        Actions actions=new Actions(driver);

        //2.Adim : Üzerinde islem yapilacak web elementi Locate edin.
        WebElement kutu=driver.findElement(By.id("hot-spot"));

        //3.Adim : Islemi uygulayin
        actions.contextClick(kutu).perform(); //perform() methodu son oalrak uygulanmalidir.

        //Alert'te cikan yazinin "You selected a context menu" oldugunu test edin
        String alerYazisi=driver.switchTo().alert().getText();
        Assert.assertEquals("You selected a context menu",alerYazisi);

        //Tamam diyerek alert'i kapatın
        driver.switchTo().alert().accept();
    }
}
