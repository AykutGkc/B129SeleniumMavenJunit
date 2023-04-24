package NT.day21_JSExecutor_240423;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C02_JCExcecutor_Scroll extends TestBase {
    JavascriptExecutor js;
    /*
    Techpro education ana sayfasına git
    "We Offer" elementi görünür olacak şekilde üzerine scroll et ve ekran görüntüsünü al
    Aynı sayfada "Enroll Free "elementi görünür olacak sekilde scroll et ve ekran görüntüsünü al
    Aynı sayfada "WHY US?" elementi görünür olacak şekilde scroll et ve ekran görüntüsünü al
    Aynı sayfada tekrar "Enroll Free" elementi görünür olacak şekilde scroll et ve ekran görüntüsünü al
     */
    @Test
    public void JSexecutorScrollTest() {
        //Techpro education ana sayfasına git
        driver.get("https://techproeducation.com/");
        waitWithThreadSleep(2);
        driver.findElement(By.xpath("//*[@class='eicon-close']")).click();

        //    "We Offer" elementi görünür olacak şekilde üzerine scroll et ve ekran görüntüsünü al
        WebElement weOffer=driver.findElement(By.xpath("//*[text()='we offer']"));
        waitWithThreadSleep(2);
        /*js= (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);",weOffer);*/
        scrollWithJC(weOffer);
        waitWithThreadSleep(2);
        fullScrennShot();

        //    Aynı sayfada "Enroll Free "elementi görünür olacak sekilde scroll et ve ekran görüntüsünü al
        WebElement enrollFree= driver.findElement(By.xpath("//*[text()='Enroll Free Course']"));
        /*
        js= (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);",enrollFree);
         */
        scrollWithJC(enrollFree);
        waitWithThreadSleep(2);
        fullScrennShot();

        //    Aynı sayfada "WHY US?" elementi görünür olacak şekilde scroll et ve ekran görüntüsünü al
        WebElement whyUs=driver.findElement(By.xpath("//*[text()='WHY US?']"));
        scrollWithJC(whyUs);
        waitWithThreadSleep(2);
        fullScrennShot();


        //    Aynı sayfada tekrar "Enroll Free" elementi görünür olacak şekilde scroll et ve ekran görüntüsünü al
        /*
        js= (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);",enrollFree);
         */
        scrollWithJC(enrollFree);
        waitWithThreadSleep(2);
        fullScrennShot();

        //Sayfayi en alta scroll yapalim
        js= (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,document.body.scrollHeiht)");

        //SAyfayi en üste scroll yapalim

        js= (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,-document.body.scrollHeiht)");


    }
}
