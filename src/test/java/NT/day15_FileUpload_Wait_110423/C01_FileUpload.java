package NT.day15_FileUpload_Wait_110423;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.awt.*;

public class C01_FileUpload extends TestBase {
    @Test
    public void fileUpload() {
        /*
        Bir Web sayfasında upload işlemi yapmamız gerekirse;
            1-Öncelikle upload edeceğimiz webelementi locate ederiz
            2-Upload edeceğimiz dosya yolunu bir string'e assingn ederiz
            3-Locate ettiğimiz webelement'e sendkeys() methodu ile dosyayolunu aldığımız string değişkeni göndeririz
         */

        //https://the-internet.herokuapp.com/upload adresine gidin
        driver.get("https://the-internet.herokuapp.com/upload");
        //Adsiz.pages dosyasını yükleyin(upload)
        WebElement dosyaSecWebElement= driver.findElement(By.id("file-upload"));
        waitWithThreadSleep(3);
        String dosyaYolu="/Users/aykutgkc/Desktop/b129/Adsız.pages";
        //String dosyaYolu=System.getProperty("user.home")+"/Desktop/b129/Adsiz.pages";
        dosyaSecWebElement.sendKeys(dosyaYolu);
        waitWithThreadSleep(3);
        driver.findElement(By.id("file-submit")).click();

        //“File Uploaded!” textinin görüntülendiğini test edin
        Assert.assertTrue(driver.findElement(By.xpath("//h3")).isDisplayed());



    }
}
