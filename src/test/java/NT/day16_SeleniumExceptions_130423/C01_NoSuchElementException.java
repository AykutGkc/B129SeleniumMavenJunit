package NT.day16_SeleniumExceptions_130423;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilities.TestBase;

public class C01_NoSuchElementException extends TestBase {
    @Test
    public void NosuchElementException() {
        /*
        NosuchElementException: Sayfada bulunmayan bir elemente erisim saglamaya calisildiginda karsilasilir.
         */

        //TEchproeducation sayfasina gidelim
        driver.get("https://techproeducation.com/");
        driver.findElement(By.xpath("//*[@class='eicon-close']")).click(); //Reklami kapatir

        //SearchBox elementini locate edelim
        driver.findElement(By.xpath("//*[@type='ssearch']")).sendKeys("java"+ Keys.ENTER);
        //org.openqa.selenium.NoSuchElementException:WEb elementin locatini degistirdigimiz icin 21. satirda NoSuchElementException hatasi aldik.
        //SearchBox'in locateni yeniden almamiz gerekir.

    }
}
