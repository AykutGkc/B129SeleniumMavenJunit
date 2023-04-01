package NT.day08_Assertion_DropDown_300323;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C02_DropDown {
    /*
    Given kullanici https://testcenter.techproeducation.com/index.php?page=dropdown sayfasindayken
    -3 farklı test methodu oluşturalım
        1.Method:
            a. Yil,ay,gün dropdown menu'leri locate ediniz
            b. Select objesi olustur
            c. Select object i kullaarak 3 farkli sekilde secim yapiniz
        2.Method:
            a. Tüm eyalet isimlerini yazdıralım
        3.Method:
            a. State dropdownindaki varsayilan secili secenegin 'Select a State' oldugunu verify edelim

     */
  WebDriver driver;
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(3000);
        driver.close();
    }

    @Test
    public void test01() {
       // 1.Method:
        //a. Yil,ay,gün dropdown menu'leri locate ediniz
        // b. Select objesi olustur
        // c. Select object i kullaarak 3 farkli sekilde secim yapiniz

        WebElement yil=driver.findElement(By.xpath("//*[@id='year']"));
        Select select=new Select(yil);
        select.selectByIndex(5); //index 0 dan baslar DropDown menüde 6. alir.

        //yil.sendKeys("2018"); -->Bu sekilde de secebiliriz

        //driver.findElement(By.xpath("//*[@value='2016']")).click();-->bu sekilde de secebilirim.

        WebElement ay=driver.findElement(By.xpath("//*[@id='month']"));
        Select select1=new Select(ay);
        //select1.selectByVisibleText("May");
        select1.selectByValue("6");

        WebElement gun=driver.findElement(By.xpath("//*[@id='day']"));
        Select select2=new Select(gun);
        select2.selectByVisibleText("7");
    }

    @Test
    public void test02() {
        // 2.Method:  a. Tüm eyalet isimlerini yazdıralım
        WebElement tümEyaleteler=driver.findElement(By.cssSelector("select[id='state']"));
        Select select=new Select(tümEyaleteler);
        List<WebElement> stateList=select.getOptions(); //Bütün options tagleerini getirir
        for (WebElement w : stateList) {
            System.out.println(w.getText());
        }

        //stateList.forEach(t-> System.out.println(t.getText())); -->LAmbda ile cözüm
    }

    @Test
    public void test03() {
       // 3.Method: a. State dropdownindaki varsayilan secili secenegin 'Select a State' oldugunu verify edelim
        WebElement tümEyaleteler=driver.findElement(By.cssSelector("select[id='state']"));
        Select select=new Select(tümEyaleteler);
        String sonSecilenTest= select.getFirstSelectedOption().getText();
        //getFirstSelectedOption() --> son secilen option'i verir.
        System.out.println(sonSecilenTest);
        Assert.assertEquals("Select a State",sonSecilenTest);


    }
}
