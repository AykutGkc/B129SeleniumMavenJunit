package practice.day03_120423;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class C02_WindowHandle extends TestBase {

    // 1- https://www.amazon.com sayfasina gidelim
    // 2- url'in 'amazon' icerdigini test edelim
    // 3- yeni bir pencere acip https://www.bestbuy.com sayfasina gidelim
    // 4- title'in 'Best Buy' icerdigini test edelim
    // 5- ilk sayfaya(amazon) donup sayfada java aratalım
    // 6- arama sonuclarının 'Java' icerdigini test edelim
    // 7- ikinci sayfaya(bestbuy) donelim
    // 8- logonun gorundugunu test edelim

    @Test
    public void test01() {

        // 1- https://www.amazon.com sayfasina gidelim
        driver.get("https://www.amazon.com/");
        String sayfa1Handle=driver.getWindowHandle();
        waitWithThreadSleep(2);

        // 2- url'in 'amazon' icerdigini test edelim
        String amazonUrl=driver.getCurrentUrl();
        Assert.assertTrue(amazonUrl.contains("amazon"));
        waitWithThreadSleep(2);

        // 3- yeni bir pencere acip https://www.bestbuy.com sayfasina gidelim
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.bestbuy.com/");
        String sayfa2Handle=driver.getWindowHandle();
        driver.getWindowHandles();
        waitWithThreadSleep(2);

        // 4- title'in 'Best Buy' icerdigini test edelim
        String bestBuyTitle=driver.getTitle();
        Assert.assertTrue(bestBuyTitle.contains("Best Buy"));
        waitWithThreadSleep(2);

        // 5- ilk sayfaya(amazon) donup sayfada java aratalım
        driver.switchTo().window(sayfa1Handle);
        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Java"+ Keys.ENTER);
        waitWithThreadSleep(2);

        // 6- arama sonuclarının 'Java' icerdigini test edelim
        WebElement aramaSonucu=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        String aramaSonucustr=aramaSonucu.getText();
        Assert.assertTrue(aramaSonucustr.contains("Java"));
        waitWithThreadSleep(2);

        // 7- ikinci sayfaya(bestbuy) donelim
        driver.switchTo().window(sayfa2Handle);
        waitWithThreadSleep(2);

        // 8- logonun gorundugunu test edelim
        WebElement logo=driver.findElement(By.xpath("(//img[@class='logo'])[1]"));
        Assert.assertTrue(logo.isDisplayed());
        waitWithThreadSleep(2);
       swithToWindow(0);

    }
}
