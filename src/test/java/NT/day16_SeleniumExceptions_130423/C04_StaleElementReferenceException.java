package NT.day16_SeleniumExceptions_130423;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C04_StaleElementReferenceException extends TestBase {
    /*
    StaleElementReferenceException: bir web sayfasindaki bir web elementin gecerliliginin kayboldugu durumlarda olusur.
    yani bir web elementi locate ettikten sonra sayfa da refresh yada back-forward kullaniyorsak yeniden o elemnte ulasmak istedigimizde bu hatayi aliriz.
    Bunnu handle edebilmek icin web elemente yeniden ayni locatei eklemeliyiz.(Web elementin locateni hatirlatma gibi denilebilir)
     */

    @Test
    public void StaleElementReferenceException() {
        //techpro sayfasina gidelim
        driver.get("https://www.techproeducation.com/");
        waitWithThreadSleep(3);
        driver.findElement(By.xpath("//*[@class='eicon-close']")).click();//Reklam kapatmak için
        //SAyfayi yenileyelim
        driver.navigate().refresh();
        //login butonuna tiklayalim.
        driver.findElement(By.xpath("(//*[text()='LMS LOGIN'])[1]"));


    }

    @Test
    public void test02() {
        //techpro sayfasina gidelim
        driver.get("https://www.techproeducation.com/");
        waitWithThreadSleep(3);
        driver.findElement(By.xpath("//*[@class='eicon-close']")).click();//Reklam kapatmak için

        //login butonuna tiklayalim.
        WebElement login=driver.findElement(By.xpath("(//*[text()='LMS LOGIN'])[1]"));

        //SAyfayi yenileyelim
        driver.navigate().refresh();

        //login'E tiklayiniz.
        login.click();
        //org.openqa.selenium.StaleElementReferenceException
        //Webelementi locate ettikten sonra sayfayı yeniledik ve sonrasında click yaptık ve StaleElementReferenceException
        // hatasını aldık çünkü locate ettiktan sonra refresh yaptığımız için element eskimiş oldu. Dolayısıyla bu
        // exception'ı handle edebilmek için click yapmadan önce tekrar aynı locati webelemente atamamız gerekir
    }

    @Test
    public void test03() {
        //techpro sayfasina gidelim
        driver.get("https://www.techproeducation.com/");
        waitWithThreadSleep(3);
        driver.findElement(By.xpath("//*[@class='eicon-close']")).click();//Reklam kapatmak için

        //login butonuna tiklayalim.
        WebElement login=driver.findElement(By.xpath("(//*[text()='LMS LOGIN'])[1]"));

        //SAyfayi yenileyelim
        driver.navigate().refresh();

        //login'E tiklayiniz.
        login=driver.findElement(By.xpath("(//*[text()='LMS LOGIN'])[1]"));
        login.click();

    }

    @Test
    public void test04() {
        //techpro sayfasina gidelim
        driver.get("https://www.techproeducation.com/");
        waitWithThreadSleep(3);
        driver.findElement(By.xpath("//*[@class='eicon-close']")).click();//Reklam kapatmak için

        //login butonuna tiklayalim.
        WebElement login=driver.findElement(By.xpath("(//*[text()='LMS LOGIN'])[1]"));
        login.click();

        //SAyfayi yenileyelim
        driver.navigate().back();

        //login'E tiklayiniz.
        //login=driver.findElement(By.xpath("(//*[text()='LMS LOGIN'])[1]"));
        Assert.assertTrue(login.isDisplayed());
        //Webelemente yeni locate atamadigimiz icin hata aliriz.
    }

    @Test
    public void test05() {
        /*NOT:StaleElementReferanceException hatası almamız gerekiyor
        //Amazon sayfasına gidelim
        //iphone aratalım
        //Çıkan sonuclardan ilk 5'ine tıklayıp sayfa başlıklarını alalım konsola yazdıralım
        //Sayfayı kapatalım
         */
    }

    @Test
    public void test06() {
        /*
        NOT:Exception almadan doğru şekilde yapalım
        //Amazon sayfasına gidelim
        //iphone aratalım
        //Çıkan sonuclardan ilk 5'ine tıklayıp sayfa başlıklarını alalım konsola yazdıralım
        //Sayfayı kapatalım
         */
    }
}
