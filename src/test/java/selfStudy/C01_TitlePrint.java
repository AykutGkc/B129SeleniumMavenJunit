package selfStudy;

import utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class C01_TitlePrint extends TestBase {
/*
- ebay sayfasına gidiniz
- electronics bölümüne tıklayınız
- Genişliği 225 ve Uzunluğu 225 olan resimlerin hepsine tıklayalım
- Her sayfanın sayfa başlığını yazdıralım
- sayfayı kapatalım
 */

    @Test
    public void titlePrint() {
        //- ebay sayfasına gidiniz
        driver.get("https://www.ebay.com/");

        //- electronics bölümüne tıklayınız
        driver.findElement(By.xpath("//a[@_sp='p2481888.m1380.l3250']")).click();

        //- Genişliği 225 ve Uzunluğu 225 olan resimlerin hepsine tıklayalım
       List<WebElement> urunler;
        urunler=driver.findElements(By.xpath("//img[@width='225' and @height='225']"));
        //- Her sayfanın sayfa başlığını yazdıralım
        for (int i=0; i<urunler.size() ; i++){
            urunler=driver.findElements(By.xpath("//img[@width='225' and @height='225']"));
            urunler.get(i).click();
            //waitWithThreadSleep(2);
            System.out.println(i+1 + ". baslik: " +driver.getTitle());
            driver.navigate().back();
            //waitWithThreadSleep(2);
        }
        //- sayfayı kapatalım
        driver.close();


    }
}
