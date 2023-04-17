package NT.day18_ScreenShot_ExtendReport_160423;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class C03_ScreenShotClassWork extends TestBase {
    @Test
    public void classWork() {
        //Techpro sayfasina gidelim
        driver.get("https://www.techproeducation.com/");
        waitWithThreadSleep(3);
        driver.findElement(By.xpath("//*[@class='eicon-close']")).click();//Reklam kapatmak için

        //sayfanin resmini alalim
        fullScrennShot();

        //arama bölümünde java aratalim
        driver.findElement(By.xpath("//input[@class='elementor-search-form__input']")).sendKeys("java", Keys.ENTER);

        //Sonuc yazisinin resmini alalim
        WebElement sonucYazisi= driver.findElement(By.xpath("//h1"));
        webElementScreenShot(sonucYazisi);

        //Yeni bir sekmede amazona godelim
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.amazon.com/");

        //Sayfanin resmini alalim
        fullScrennShot();
        //Arama bölümüne iphone yazalim
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);

        //ve sonuc yazisinin resmini alalim
        WebElement sonucYazisi2=driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[1]"));
        webElementScreenShot(sonucYazisi2);


        //tekrar techpro sayfasina gecelim ve sayfa resmini alalim
        window(0);
        fullScrennShot();
    }
}
