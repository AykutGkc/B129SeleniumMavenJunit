package selfStudy;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.TestBase;

import java.time.Duration;

public class C04  {

    /*
    -BeforeClass methodu ile driver ı olusturun ve Maximize edin, 15 sn bekletin
    -Before methodunda http://www.google.com adresine gidin
    -Üç farklı test methodu ile;
    -arama kutusuna "The God Father" yazip, cikan sonuc sayisini yazdirin
    -arama kutusuna  "Lord of the Rings" yazip, cikan sonuc sayisini yazdirin
    -arama kutusuna  "Kill Bill" yazip, cikan sonuc sayisini yazdirin
    -NOT: Çıkan sonuç sayılarını After methodunda yazdırınız
    -AfterClass ile kapatın
     */

    static WebDriver driver;
    @BeforeClass
    public static void beforeClass() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @AfterClass
    public static void afterClass() throws Exception {
        Thread.sleep(3000);
        driver.quit();
    }


    @Before
    public void setUp() throws Exception {

        driver.get("http://www.google.com/");
        TestBase.waitWithThreadSleep(2);
    }

    @After
    public void tearDown() throws Exception {
        String sonuc=driver.findElement(By.xpath("//*[@id='result-stats']")).getText();
        String sonucSayisi=sonuc.split(" ")[1];
        System.out.println("sonucSayisi = " + sonucSayisi);


    }

    @Test
    public void TheGodFather() {
        driver.findElement(By.xpath("//button[@id='L2AGLb']")).click();
        driver.findElement(By.xpath("//*[@class='gLFyf']")).sendKeys("The God Father"+ Keys.ENTER);
    }

    @Test
    public void LordOfTheKings() {


        driver.findElement(By.xpath("//*[@class='gLFyf']")).sendKeys("Lord of the Rings"+ Keys.ENTER);
    }

    @Test
    public void KillBill() {

        driver.findElement(By.xpath("//*[@class='gLFyf']")).sendKeys("Kill Bill"+ Keys.ENTER);
    }
}
