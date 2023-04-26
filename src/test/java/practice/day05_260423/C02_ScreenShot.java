package practice.day05_260423;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class C02_ScreenShot extends TestBase {
    // https://www.teknosa.com/ adresine gidin
    // arama cubuguna oppo yazip enter'a basınız
    // sonuc sayisini yazdiriniz
    // ikinci urunun fotografını cekin
    // cikan ikinci urune tiklayiniz
    // iki ArrowDown sayfayı asagiya kaydirin
    // sepete ekleyiniz
    // sepetim'e git tilayiniz
    // "Siparis Ozeti" webelementinin text'ini yazdiriniz
    // Alisverisi tamamlayiniz
    // "Teknosa'ya hos geldiniz" webelementinin text'ini yazdiriniz
    // driver'i kapatiniz
    @Test
    public void test01() throws IOException {
        // https://www.teknosa.com/ adresine gidin
        driver.get("https://www.teknosa.com/ ");

        try {
            driver.findElement(By.xpath("//div[@id='ins-editable-button-1580496494']")).click();
        } catch (Exception e) {
            System.out.println("cookies cıkmadı");
        }

        // arama cubuguna oppo yazip enter'a basınız
        driver.findElement(By.xpath("//input[@id='search-input']")).sendKeys("Oppo", Keys.ENTER);

        // sonuc yazisini yazdiriniz
       WebElement sonucYazisi= driver.findElement(By.xpath("//div[@class='plp-panel-block1']"));
        System.out.println(sonucYazisi.getText());


        // ilk urunun fotografını cekin
        LocalDateTime date=LocalDateTime.now();
        DateTimeFormatter dtf=DateTimeFormatter.ofPattern("YYMMddHHmmss");
        String tarih=date.format(dtf);

        WebElement ilkÜrun= driver.findElement(By.xpath("(//a[@class='prd-link gowitPlp-js'])[1]"));

        File tümsayfa=new File("TestOutput/tumSayfa"+tarih+".jpeg");

        File gecici=ilkÜrun.getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(gecici,tümsayfa);


        // cikan ilk urune tiklayiniz
        ilkÜrun.click();
        waitWithThreadSleep(2);
        // Bir PageDown sayfayı asagiya kaydirin
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).perform();
        waitWithThreadSleep(2);

        // sepete ekleyiniz
        driver.findElement(By.xpath("//button[@id='addToCartButton']")).click();
        waitWithThreadSleep(2);

        // sepetim'e git tilayiniz
        driver.findElement(By.xpath("//a[@class='btn btn-primary']")).click();
        waitWithThreadSleep(2);

        // "Siparis Ozeti" webelementinin text'ini yazdiriniz
        WebElement siprisOzeti= driver.findElement(By.xpath("//div[text()='Sipariş Özeti']"));
        System.out.println("siprisOzeti = " + siprisOzeti.getText());
        waitWithThreadSleep(2);

        // Alisverisi tamamlayiniz
        driver.findElement(By.xpath("//a[@class='btn btn-primary js-checkout-controls']")).click();
        waitWithThreadSleep(2);

        // "Teknosa'ya hos geldiniz" webelementinin text'ini yazdiriniz
        WebElement teknosayaHosGeldiniz=driver.findElement(By.xpath("//div[text()='Teknosa’ya Hoş Geldiniz']"));
        System.out.println("teknosayaHosGeldiniz Text= " + teknosayaHosGeldiniz.getText());
        waitWithThreadSleep(2);

    }
}
