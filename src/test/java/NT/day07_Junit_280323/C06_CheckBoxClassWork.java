package NT.day07_Junit_280323;

import com.sun.source.tree.AssertTree;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.hc.core5.util.Asserts;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C06_CheckBoxClassWork {
    /*
    Verilen web sayfasına gidin.
    https://the-internet.herokuapp.com/checkboxes
    Checkbox1 ve checkbox2 elementlerini locate edin.
    Checkbox1 seçili değilse onay kutusunu tıklayın
    Checkbox2 seçili değilse onay kutusunu tıklayın
     */

    static WebDriver driver;

    @BeforeClass
    public static void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @AfterClass
    public static void afterClass() throws Exception {
        Thread.sleep(2000);
        driver.close();
    }

    @Test
    public void checkBox() throws InterruptedException {
         // Verilen web sayfasına gidin.
        //    https://the-internet.herokuapp.com/checkboxes
        driver.get("https://the-internet.herokuapp.com/checkboxes");

        //    Checkbox1 ve checkbox2 elementlerini locate edin.
        WebElement checkbox1=driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
        WebElement checkbox2=driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));

        //    Checkbox1 seçili değilse onay kutusunu tıklayın
        Thread.sleep(3000);
        if (!checkbox1.isSelected()){
            checkbox1.click();
        }

        //    Checkbox2 seçili değilse onay kutusunu tıklayın
        Thread.sleep(3000);
        if (!checkbox2.isSelected()){
            checkbox2.click();
        }
    }

}
