package NT.day13_ActionsClass_060423;

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
    Alert’te cikan yazinin “You selected a context menu” oldugunu test edin
    Tamam diyerek alert’i kapatın
     */

    @Test
    public void actions() {
        //https://the-internet.herokuapp.com/context_menu  sitesine gidin
        driver.get("https://the-internet.herokuapp.com/context_menu");

        //    Kutuya sağ tıklayın
        WebElement kutu=driver.findElement(By.id("hot-spot"));
        //Web elemente sag click yapabilmek icin actions clasindan obje olusturmaliiz
        Actions actions=new Actions(driver);
        actions.
                contextClick(kutu). //actions objesi ile sag click methodu olan contextClick methodunu kullaniriz.
                     perform();//Actions'i sonlandirmak icin perform() methodunu kullaniriz.

        //    Alert’te cikan yazinin “You selected a context menu” oldugunu test edin
        String alertText=driver.switchTo().alert().getText();
        Assert.assertEquals("You selected a context menu",alertText);

        //    Tamam diyerek alert’i kapatın
        alertAccept();
    }
}
