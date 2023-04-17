package NT.day18_ScreenShot_ExtendReport_160423;

import org.junit.Test;
import utilities.TestBase;

public class C01_ScrennShot extends TestBase {
    @Test
    public void ScrennShotTest01() {
        //Techpro sayfasina gidelim
        driver.get("https://techproeducation.com/");
        fullScrennShot();
        //sayfanin resmini alalim
        fullScrennShot();

        //sonra amazon sayfasina gidelim
        driver.get("https://www.amazon.com/");

        //Amazon sayfasinin ekran görüntüsünü alalim
        fullScrennShot();//Method kullanarak tüm ekran resmini aldik
    }
}
