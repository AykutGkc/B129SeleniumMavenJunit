package practice.day04_180423;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C03_FilesDownload extends TestBase {
    // 'https://the-internet.herokuapp.com/download' adresine gidiniz
    // some-file.txt dosyasini indirelim
    // dosyanin bilgisayarınızda Downloads(indirilenler)'a basariyla indirilip indirilmedigini test ediniz


    @Test
    public void test01() {
        // 'https://the-internet.herokuapp.com/download' adresine gidiniz
        driver.get("https://the-internet.herokuapp.com/download");
        waitWithThreadSleep(3);

        // some-file.txt dosyasini indirelim
        driver.findElement(By.xpath("//a[text()='some-file.txt']")).click();
        waitWithThreadSleep(3);
        // dosyanin bilgisayarınızda Downloads(indirilenler)'a basariyla indirilip indirilmedigini test ediniz

        /*
         Dosyanın, bilgisayarımda downloads'a basrıyla indirilip indirilmedigini Java ile test edecegim.
        Cunku seleniumi web sayfasını test eder. Selenium, bunim bilgisayarımdaki downloads'a mudahale edemez.
         */
        ///Users/aykutgkc/Downloads/some-file.txt

        String farkliKisim=System.getProperty("user.home");
        String ortakKisim="/Downloads/some-file.txt";
        String dosyaYolu=farkliKisim+ortakKisim;

        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

    }
}
