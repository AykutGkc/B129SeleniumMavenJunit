package NT.day18_ScreenShot_ExtendReport_160423;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.text.SimpleDateFormat;
import java.util.Date;

public class C04_ExtentsReport extends TestBase {
    /*
       EXTENTREPORT kullanabilmemiz için;
           1-pom.xml dosyasına extentreports dependency'si eklenir
           2-ExtentReports class'ından bir obje oluşturulur
           3-HTML formatında düzenleneceği için ExtentHtmlReporter class'ından obje oluşturulur
           4-Rapora test ile ilgili bilgiler girebilmek için ExtentTest class'ından bir obje oluşturulur
        */

    ExtentReports extentReports; //raporlamayi baslatir
    ExtentHtmlReporter extentHtmlReporter; //Raporu html formatinda düzenler
    ExtentTest extentTest; //Tüm test asamalarinda extentTest objesi ile bilgi ekleriz.

    @Test
    public void extentReport() {
        extentReports=new ExtentReports();
        String date=new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String FilePath="TestOutput/reports/extentReport"+date+".html";
        extentHtmlReporter=new ExtentHtmlReporter(FilePath);
        extentReports.attachReporter(extentHtmlReporter);

        //Raporda gözükmesini istedigimiz bilgileri icin
        extentReports.setSystemInfo("Browser","Chrome");
        extentReports.setSystemInfo("Tester","Aykut");
        extentHtmlReporter.config().setDocumentTitle("Extent Report");
        extentHtmlReporter.config().setReportName("Smoke Test Raporu");
        extentTest=extentReports.createTest("ExtentTest", "Test Raporu");

        driver.get("https://www.amazon.com/");
        extentTest.info("Amazon Sayfasina gidildi");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);
        extentTest.info("Amazon sayfasinda iphone aramasi yapildi;");
        WebElement sonucYazisi2=driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[1]"));
        System.out.println(sonucYazisi2.getText());
        extentTest.info("Sonuc sayisi yazdirildi");
        extentTest.pass("Sayfa Kapatildi");



        extentReports.flush();

    }
}
