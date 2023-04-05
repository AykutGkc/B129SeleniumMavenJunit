package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public abstract class TestBase {
    //TestBase classindan obje olusturmanin önüne gecebilmek icin abstract yapilabilir.
    //orn:TestBase base = new TestBase();
    //Bu class'i extends ettigimiz test classlarindan ulasabiliriz.
    protected static WebDriver driver;

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(3000);
        driver.quit();
    }

    //HARD WAIT METHOD
    public static void waitWithThreadSleep(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    //Allert ACCEPT
    public static void allertAccept() {
        driver.switchTo().alert().accept();
    }

    //Alelrt DISMISS
    public static void allertDismiss() {
        driver.switchTo().alert().dismiss();
    }

    //Allert GETTEXT
    public static void allertText() {
        System.out.println(driver.switchTo().alert().getText());
    }

    //Allert ALLERTPROMPT
    public static void allertPrompt(String text) {
        driver.switchTo().alert().sendKeys(text);
    }

    //DropDown VisibileTest
    /*
          Select select2=new Select(gun);
        select2.selectByVisibleText("7");

        //ddmVisibletext(gun,"7");--> Yukaridaki kullanim yerine sadece method ile handle edebilirim.
     */
    public static void ddmVisibletext(WebElement ddm, String option) {
        Select select = new Select(ddm);
        select.selectByVisibleText(option);
    }

    //DropDown Index
    public static void ddmIndex(WebElement ddm, int index) {
        Select select = new Select(ddm);
        select.selectByIndex(index);
    }

    //DropDownValue
    public static void ddmValue(WebElement ddm, String value) {
        Select select = new Select(ddm);
        select.selectByValue(value);
    }

    //SwitchToWindow
    public static void swithToWindow(int sayi) {

        List<String> tumWindowHandles = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tumWindowHandles.get(1));
    }

    //SwitchToWindow2
    public static void window(int sayi) {
        driver.switchTo().window(driver.getWindowHandles().toArray()[sayi].toString());
    }

}
