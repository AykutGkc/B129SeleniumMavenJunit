package NT.day11_Iframe_WindowHandle_030423;

import NT.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class c03_WindowsHandles extends TestBase {
    /*
    https://the-internet.herokuapp.com/windows adresine gidin.
    İlk sayfanın ID'sini(Window Handle değerini) alın.
    Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
    Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
    "Click Here" butonuna tıklayın.
    Açılan pencereye geçin.
    Açılan yeni pencerenin sayfa başlığının(title) “New Window” olduğunu doğrulayın.
    Bir önceki pencereye dönüp sayfa başlığının “The Internet” olduğunu  doğrulayın.
    2. pencereye tekrar geçin.
    1. pencereye tekrar dönün.
     */

    @Test
    public void windowHandles() {
        //https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

        //    İlk sayfanın ID'sini(Window Handle değerini) alın.
        String ilkSayfaWindowHandle=driver.getWindowHandle();

        //    Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        WebElement sayfaTexti= driver.findElement(By.xpath("//h3"));
        Assert.assertEquals("Opening a new window",sayfaTexti.getText());

        //    Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String actualTile= driver.getTitle();
        Assert.assertEquals("The Internet",actualTile);

        //    "Click Here" butonuna tıklayın.
        driver.findElement(By.xpath("//*[text()='Click Here']")).click();

        //    Açılan pencereye geçin.
        /*
        Eger bitim kontrolümüz disinda yeni bir pencere aciliyorsa, o pencere icindeki Web elementleri
        handle edebilmem icin switchTo() methodu ile gecis yapmam gerekir.Fakat kontrolümüz disinda
        acildigi icin handle degerini bilmeyiz.Tüm acilan pencereleri getWindowHandles() methodu ile
        bir SET'e assign ederiz. Ya da ArrayList'e assing ederiz.
         */

        Set<String> tumPencereler=driver.getWindowHandles(); //Set unique'dir.
        for (String w:tumPencereler){
            if (!w.equals(ilkSayfaWindowHandle)){
                driver.switchTo().window(w);
            }
        }//Burada amac bitim kontrolümüz disinda acilan pencereye gecis yapmak.

       /*
       List<String> tumWindowHandles=new ArrayList<>(driver.getWindowHandles());
       driver.switchTo().window(tumWindowHandles.get(1));
         */

        //    Açılan yeni pencerenin sayfa başlığının(title) “New Window” olduğunu doğrulayın.
        String actualTitle= driver.getTitle();
        Assert.assertEquals("New Window",actualTitle);
        String ikinciSayfaHandleDegeri= driver.getWindowHandle();

        //    Bir önceki pencereye dönüp sayfa başlığının “The Internet” olduğunu  doğrulayın.
        driver.switchTo().window(ilkSayfaWindowHandle);
        Assert.assertEquals("The Internet",driver.getTitle());
        waitWithThreadSleep(3);

        //    2. pencereye tekrar geçin.
        driver.switchTo().window(ikinciSayfaHandleDegeri);
        waitWithThreadSleep(3);

        //    1. pencereye tekrar dönün.
        driver.switchTo().window(ilkSayfaWindowHandle);

    }
}
