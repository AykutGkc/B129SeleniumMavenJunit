package NT.day15_FileUpload_Wait_110423;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class C02_ExplicitWait extends TestBase {
    @Test
    public void explicitWait() {
        //https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        //Start buttonuna tıklayın
        driver.findElement(By.xpath("//button")).click();
        //Hello World! Yazının sitede oldugunu test edin
        //Assert.assertTrue(driver.findElement(By.xpath("(//h4)[2]")).isDisplayed());
        //Bir webelementin görünürlüğünü implicitly wait ile bu sayfada çözemedik

        //Hello World! Yazının sitede oldugunu test edin
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(15));
        //1.yol
        WebElement helloWordText=wait.until(ExpectedConditions.
                visibilityOfElementLocated(By.xpath("(//h4)[2]")));
        //visibilityOfElementLocated() web elementin görünür olmasini bekler.
        //2.yol
        /*
        WebElement helloWordText1=driver.findElement(By.xpath("(//h4)[2]"));
        wait.until(ExpectedConditions.visibilityOf(helloWordText1));
        */

        Assert.assertTrue(helloWordText.isDisplayed());

    }
}
