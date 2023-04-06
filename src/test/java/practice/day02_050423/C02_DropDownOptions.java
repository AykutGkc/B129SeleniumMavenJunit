package practice.day02_050423;

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

public class C02_DropDownOptions {
    // https://www.amazon.com/ sayfasina gidin
    // dropdown'dan "Baby" secenegini secin
    // sectiginiz option'i yazdirin
    // dropdown'daki optionlarin toplam sayısının 28'e esit oldugunu test edin
    // dropdown'daki optionların tamamını yazdırın

    WebDriver driver;
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

    @Test
    public void name() {
        // https://www.amazon.com/ sayfasina gidin
        driver.get("https://www.amazon.com/");

        // dropdown'dan "Baby" secenegini secin
        WebElement ddm=driver.findElement(By.id("searchDropdownBox"));
        Select select=new Select(ddm);
        select.selectByVisibleText("Baby");

        // sectiginiz option'i yazdirin
        String sectigimOption=select.getFirstSelectedOption().getText();
        System.out.println("sectigimOption = " + sectigimOption);

        // dropdown'daki optionlarin toplam sayısının 28'e esit oldugunu test edin
        List<WebElement> optionlarList=select.getOptions();
        int expectedOptionSayisi=28;
        int actualOPtionSayisi=optionlarList.size();

        Assert.assertEquals(expectedOptionSayisi,expectedOptionSayisi);

        // dropdown'daki optionların tamamını yazdırın
        int sayac=1;
        for (WebElement w : optionlarList) {
            System.out.println(sayac+". optiom: "+w.getText());
            sayac++;
        }
        System.out.println("select.getOptions().stream().count() = " + optionlarList.stream().count());
    }
}
