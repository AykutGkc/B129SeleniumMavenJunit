package NT.day18_ScreenShot_ExtendReport_160423;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class C02_WebElementScreenShot extends TestBase {
    @Test
    public void WebElementSS() throws IOException {
        //Amazon sayfasina gidiniz
        driver.get("https://www.amazon.com/");
        //Arama bölümünde iphone aratiniz
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);
        //Sonuc yazisinin resmini aliniz
        WebElement sonucYaziis=driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[1]"));
        String date=new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String FilePath="TestOutput/webElementScreenShot"+date+".png";
        FileUtils.copyFile(sonucYaziis.getScreenshotAs(OutputType.FILE),new File(FilePath));
        /*
            Sadece bir webelementin resmini almak istersek, FileUtils.copyFile() methoduyla locate ettiğimiz
        webelementi getScreenshotAs() methoduyla kullanarak resmini alabiliriz
         */

    }
}
