package NT.day07_Junit_280323;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_BeforeClassAfterClass {
    WebDriver driver;

    @BeforeClass
    public static void beforeClass() throws Exception {

    }


    @AfterClass
    public static void afterClass() throws Exception {
        System.out.println("Amazon testi sonuclandi");
    }

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com/");

    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }

    @Test
    public void test01() {
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);
    }

    @Test
    public void test02() {
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("samsung", Keys.ENTER);
    }



}
