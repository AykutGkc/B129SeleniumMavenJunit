package NT.day17_ScreenShot_150423;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class C01_ScreenShot extends TestBase {
    @Test
    public void screenShotTest() throws IOException {
        /*
        Tüm ekran görüntüsünü SElenium'Dan gelen getScreenShotAs() methodu ile aliriz.
        Bu methpd selenium'Daki TakeScreenShot arayüzünden gelir
         */

        //Techpro education sayfasina gidelim
        driver.get("https://techproeducation.com/");
        //1.AdimIlk olarak dosyayi nereye kaydedicegimizi belirtiriz
        //String dosyaYolu="screenShot.png";
        //Proje seviyesinden new directory deyip resim dosyalarimii bu klasore atsin
        String dosyaYolu="TestOutput/screenShot.png";
        //2.adim TakesScreenShot arayüzünden obje olusturmak
        TakesScreenshot ts= (TakesScreenshot) driver;

       // 3.Adim
        /*
        FileUtils class'i file nesneleri ile birlikte kullanabilecegimiz methodlar icerir.
        Bu methodlari kullanarak dosyalari okuma,yazma,kopyalama,silne islemlerini daha kolay yapabiliriz.
        Not:Files.write() methoduda ayni islemi görür.
         */

        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE),new File(dosyaYolu));


        //Ekran resmini projemize kaydedelim

    }

    @Test
    public void test02() throws IOException {

        driver.get("https://www.amazon.com/");
        //Kaydettigimiz ekran resmi her seferinde ayni dosya üzerine yazmamasi icin dosya isminden sonra bir tarih atayabiliriz.
        String tarih=new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu="TestOutput/screenShot"+tarih+".png";
        TakesScreenshot ts= (TakesScreenshot) driver;
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE),new File(dosyaYolu));


    }
}
