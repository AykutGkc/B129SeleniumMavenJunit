package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class TestBase {
    //TestBase classindan obje olusturmanin önüne gecebilmek icin abstract yapilabilir.
    //orn:TestBase base = new TestBase();
    //Bu class'i extends ettigimiz test classlarindan ulasabiliriz.
    protected static WebDriver driver;
    protected static ExtentReports extentReports; //raporlamayi baslatir
    protected static ExtentHtmlReporter extentHtmlReporter; //Raporu html formatinda düzenler
    protected static ExtentTest extentTest; //Tüm test asamalarinda extentTest objesi ile bilgi ekleriz.

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //------------------------------

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
    public static void alertAccept() {
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
        driver.switchTo().window(tumWindowHandles.get(sayi-1));
    }

    //SwitchToWindow2
    public static void window(int sayi) {
        sayi=sayi-1;
        driver.switchTo().window(driver.getWindowHandles().toArray()[sayi].toString());
    }

    //Explicit Wait
    public static void visibleWait(WebElement element, int second){
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(second));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    //Alert Wait
    public static void allertWait(int second){
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(second));
        wait.until(ExpectedConditions.alertIsPresent());
    }

    //VisibleEleementLocater wait
    public static void visibleWait(By locator, int second){
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(second));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    //Tüm sayfa ScreenShot
    public static void fullScrennShot () {
        String date=new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String FilePath="TestOutput/screenShot"+date+".png";
        TakesScreenshot ts= (TakesScreenshot) driver;
        try {
            FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE),new File(FilePath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //Web element Screen Shot

    public static void webElementScreenShot(WebElement element){
        String date=new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String FilePath="TestOutput/webElementScreenShot"+date+".png";
        try {
            FileUtils.copyFile(element.getScreenshotAs(OutputType.FILE),new File(FilePath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //ExtentReports
    public void extentReport(){
        extentReports=new ExtentReports();
        String date=new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String FilePath="TestOutput/reports/extentReport"+date+".html";
        extentHtmlReporter=new ExtentHtmlReporter(FilePath);
        extentReports.attachReporter(extentHtmlReporter);

        //Raporda gözükmesini istedigimiz bilgileri icin
        extentReports.setSystemInfo("Browser","Chrome");
        extentReports.setSystemInfo("Tester","Aykut");
        extentHtmlReporter.config().setDocumentTitle("Extent Report");
        extentHtmlReporter.config().setReportName("Smoke Test Raporu");
    }
    //Web Table
    public static void webTable(int satir,int sutun){
        WebElement satirSutun=driver.findElement(By.xpath("(//tbody)[1]//tr["+satir+"]//td["+sutun+"]"));
        System.out.println(satirSutun.getText());
    }

}
