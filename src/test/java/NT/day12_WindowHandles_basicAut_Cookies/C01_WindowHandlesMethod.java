package NT.day12_WindowHandles_basicAut_Cookies;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01_WindowHandlesMethod extends TestBase {
    @Test
    public void windowHandles() {
        //https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");


        //    Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        WebElement sayfaTexti = driver.findElement(By.xpath("//h3"));
        Assert.assertEquals("Opening a new window", sayfaTexti.getText());

        //    Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String actualTile = driver.getTitle();
        Assert.assertEquals("The Internet", actualTile);

        //    "Click Here" butonuna tıklayın.
        driver.findElement(By.xpath("//*[text()='Click Here']")).click();

        //    Açılan pencereye geçin.
        /*
        Eger bitim kontrolümüz disinda yeni bir pencere aciliyorsa, o pencere icindeki Web elementleri
        handle edebilmem icin switchTo() methodu ile gecis yapmam gerekir.Fakat kontrolümüz disinda
        acildigi icin handle degerini bilmeyiz.Tüm acilan pencereleri getWindowHandles() methodu ile
        bir SET'e assign ederiz. Ya da ArrayList'e assing ederiz.
         */

        swithToWindow(1);

        //    Açılan yeni pencerenin sayfa başlığının(title) “New Window” olduğunu doğrulayın.
        String actualTitle = driver.getTitle();
        Assert.assertEquals("New Window", actualTitle);
        String ikinciSayfaHandleDegeri = driver.getWindowHandle();

        //    Bir önceki pencereye dönüp sayfa başlığının “The Internet” olduğunu  doğrulayın.
        window(0);
        Assert.assertEquals("The Internet", driver.getTitle());
        waitWithThreadSleep(3);

        //    2. pencereye tekrar geçin.
        swithToWindow(1);
        waitWithThreadSleep(3);

        //    1. pencereye tekrar dönün.
        swithToWindow(0);
    }
}
