package practice.day02_050423;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_Alert {
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
    public void name() throws InterruptedException {
        //http://demo.guru99.com/test/delete_customer.php adresine gidin
        driver.get("http://demo.guru99.com/test/delete_customer.php");


        //customer id kısmına 53920 yazın
        WebElement customerId=driver.findElement(By.xpath("//input[@name='cusid']"));
        customerId.sendKeys("53920");



        //submit butonuna tıklayın
        driver.findElement(By.xpath("//input[@name='submit']")).click();


        //cıkan alert mesajını yazdırın
        String alertYazisi=driver.switchTo().alert().getText();
        System.out.println("alertYazisi = " + alertYazisi);

        //alerti kabul edin
        driver.switchTo().alert().accept();

        //cıkan 2. alert mesajını yazdırın
        driver.switchTo().alert().getText();

        //cıkan 2. alerti kabul edin
       driver.switchTo().alert().accept();

    }
}
