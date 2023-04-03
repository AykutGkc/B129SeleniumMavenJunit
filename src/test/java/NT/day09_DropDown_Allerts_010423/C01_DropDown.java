package NT.day09_DropDown_Allerts_010423;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C01_DropDown {
    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
    }
    
    /*
    -DropDown nedir : Altbasliklarin oldugu acilir menü listesi
    -DropDown nasil automate(Handle) edilir:
        a-DropDown menüyü ilk olarak locate ederiz
        b-Select objesi olustururuz
        c-select objesinin dropDownMenü(ddm) icerigine ce seceneklerine
          ersim saglamasi icin SELECT sinifina arguman olarak locate ttigimiz webElementi koyariz
          Syntax:Select select=new Select(ddm webElement);
        d-Select clas'i sadece <select> tag'i ile olusturulmus dropdown menülere uygulanabilir.
        e-select objesi ddm'yü handle edebilmek icin 3 method kullanilir.
           -selectByIndex() -> Index ile ulasmak icin kullanilir.(index 0 dan baslar)
           -selectByVisibleText() -> Ddm deki elemente görünür metin ile ulasmak icin kullanilir.
           -selectByValue() -> Elementin degeri ile ulasmak icin kullanilir.(option tag'inde ki deger ile)
        f-getOptions() -> Locate ettigimiz ddm'deki tüm secenekleri bize döndürür.
        g-getFirstSelectedOption() ->ddm'deki en son secili kalan ilk secenegi bize döndürür.
     */

    @Test
    public void test02() {
        /*
        // Tüm eyalet isimlerini yazdıralım
        WebElement tümEyaleteler = driver.findElement(By.cssSelector("select[id='state']"));
        Select select = new Select(tümEyaleteler);
        List<WebElement> stateList = select.getOptions(); //Bütün options tagleerini getirir
       //   for (WebElement w : stateList) {
       //     System.out.println(w.getText());
       // }
        stateList.forEach(t-> System.out.println(t.getText()));

       */
        // a. Tüm eyalet isimlerini yazdıralım
        List<WebElement> tumEyaletler=driver.findElements(By.xpath("//*[@id='state']//option"));
        System.out.println(tumEyaletler.get(2).getText());
        System.out.println("********************+");
        tumEyaletler.forEach(t-> System.out.println(t.getText()));

        //b.Sayfadaki tüm ddm lerdeki seceneklerin(option) konsola yazdirin
        System.out.println("************************");
        List<WebElement> eyalertlerList=driver.findElements(By.tagName("option"));
        eyalertlerList.forEach(t-> System.out.println(t.getText()));
        System.out.println("****************");
        System.out.println(eyalertlerList.size());

    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(3000);
    }
}

