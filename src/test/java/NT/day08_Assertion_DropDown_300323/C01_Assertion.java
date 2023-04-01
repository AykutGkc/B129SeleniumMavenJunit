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

import java.time.Duration;

public class C01_Assertion {
    /*
1)https://amazon.com adresine gidin
2)Aşağıdaki adları kullanarak 4 test metodu oluşturun ve gerekli testleriyapin
    ○ title Test  => Sayfa başlığının “Amazon” kelimesini içerip içermediğini test edin
    ○ image Test => Amazon resminin görüntülendiğini (isDisplayed()) test edin
    ○ Search Box 'in erisilebilir oldugunu test edin(isEnabled())
    ○ wrongTitleTest => Sayfa basliginin “amazon” içermediğini doğrulayın
*/

    WebDriver driver;
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://amazon.com");
    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(3000);
        driver.close();

    }

    @Test
    public void titleTest() {
        //○ title Test  => Sayfa başlığının “Amazon” kelimesini içerip içermediğini test edin
        Assert.assertTrue(driver.getTitle().contains("Amazon"));
    }

    @Test
    public void imageTest() {
        // ○ image Test => Amazon resminin görüntülendiğini (isDisplayed()) test edin
        WebElement logo= driver.findElement(By.id("nav-logo-sprites"));
        Assert.assertTrue(logo.isDisplayed());

    }

    @Test
    public void searchBoxTest() {
        //    ○ Search Box 'in erisilebilir oldugunu test edin(isEnabled())
        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        Assert.assertTrue((aramaKutusu.isEnabled()));

    }

    @Test
    public void wrongTitleTest() {
        //    ○ wrongTitleTest => Sayfa basliginin “amazon” içermediğini doğrulayın
        Assert.assertFalse(driver.getTitle().contains("amazon"));


        //Assert.assertTrue("Gercek Baslik Amazon",driver.getTitle().contains("amazon"));
    }
}
