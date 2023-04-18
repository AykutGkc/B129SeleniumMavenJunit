package NT.day18_ScreenShot_ExtendReport_160423;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C05_ExtentReport extends TestBase {
    @Test
    public void test() {
        extentReport();
        extentTest=extentReports.createTest("ExtentTest", "Test Raporu");

        //Techpro sayfasina gidelim
        driver.get("https://www.techproeducation.com/");
        extentTest.info("TechPro sayfasina gidildi");
        waitWithThreadSleep(3);
        extentTest.info("3 Saniye Bekletildi");
        driver.findElement(By.xpath("//*[@class='eicon-close']")).click();//Reklam kapatmak için
        extentTest.info("Cikan reklam kapatildi");
        //sayfanin resmini alalim
        fullScrennShot();
        extentTest.info("Tüm sayfanin resmi alidi");

        //arama bölümünde java aratalim
        driver.findElement(By.xpath("//input[@class='elementor-search-form__input']")).sendKeys("java", Keys.ENTER);
        extentTest.info("Arama bölümünde Java aratildi");
        //Sonuc yazisinin resmini alalim
        WebElement sonucYazisi= driver.findElement(By.xpath("//h1"));
        webElementScreenShot(sonucYazisi);
        extentTest.info("Sonuc yazisinin resmi alindi");
        extentTest.pass("Sayfa kapatildi");
        extentReports.flush();
    }
}
