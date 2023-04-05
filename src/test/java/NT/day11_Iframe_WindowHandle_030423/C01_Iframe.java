package NT.day11_Iframe_WindowHandle_030423;

import utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class C01_Iframe extends TestBase {
     /*
   https://the-internet.herokuapp.com/iframe sayfasına gidiniz
   Kalın yazının "Editor" kelimesini içerdiğini doğrulayınız
   Textbox içindeki yazıyı siliniz.
   Sildiğiniz yazı yerine "Bu textbox iFrame içinde yer almaktadır" yazınız.
   Sayfadaki "Elemental Selenium" yazısının görünür olduğunu doğrulayınız.
    */

    @Test
    public void iframe() {
        //https://the-internet.herokuapp.com/iframe sayfasına gidiniz
        driver.get("https://the-internet.herokuapp.com/iframe");

        //   Kalın yazının "Editor" kelimesini içerdiğini doğrulayınız
        WebElement baslikElement=driver.findElement(By.xpath("//h3"));
        Assert.assertTrue(baslikElement.getText().contains("Editor"));
        waitWithThreadSleep(2);

        //   Textbox içindeki yazıyı siliniz.
        driver.switchTo().frame(0);
        WebElement textBox= driver.findElement(By.xpath("//p"));
        textBox.clear(); //Textbox icindeki yaziyi siler
        waitWithThreadSleep(2);

        //   Sildiğiniz yazı yerine "Bu textbox iFrame içinde yer almaktadır" yazınız.
        textBox.sendKeys("Bu textbox iFrame içinde yer almaktadır");
        waitWithThreadSleep(2);

        //   Sayfadaki "Elemental Selenium" yazısının görünür olduğunu doğrulayınız.
        //driver.switchTo().defaultContent();
        //driver.switchTo().parentFrame();
        driver.navigate().refresh(); // Bu method ile sayfayi yeniledigi icin ilk bölüme gecmis olur.
        waitWithThreadSleep(2);
        WebElement elementalSElenium= driver.findElement(By.xpath("(//a)[3]"));
        Assert.assertTrue(elementalSElenium.isDisplayed());

    }
}
