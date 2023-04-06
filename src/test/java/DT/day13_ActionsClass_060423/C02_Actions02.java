package DT.day13_ActionsClass_060423;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C02_Actions02 extends TestBase {
    /*
    Amazon anasayfasına gidin
    "Account & List" üzerinde bekleyin (mouse over - hover over)
    Açılan menüde "Account" linkine tıklayın
    Açılan sayfanın başlığının "Your Account" içerdiğini doğrulayın
     */

    @Test
    public void actionsTest() {
        //Amazon anasayfasına gidin
        driver.get("https://www.amazon.com/");

        //    "Account & List" üzerinde bekleyin (mouse over - hover over)
        WebElement accountAndList=driver.findElement(By.id("nav-link-accountList"));
        Actions actions=new Actions(driver);
        actions.moveToElement(accountAndList).perform(); //moveToElement(9 methodu "hover over" islemini gerceklestirir.

        //    Açılan menüde "Account" linkine tıklayın
        driver.findElement(By.linkText("Account")).click();

        //    Açılan sayfanın başlığının "Your Account" içerdiğini doğrulayın
       String sayfabasligi = driver.getTitle();
        Assert.assertEquals("Your Account",sayfabasligi);
    }
}
