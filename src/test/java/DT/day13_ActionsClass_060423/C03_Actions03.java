package DT.day13_ActionsClass_060423;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C03_Actions03 extends TestBase {
      /*
https://techproeducation.com adresine gidin
 Sayfanın alt tarafına gidin
 Sayfanın üst tarafına gidin
 */

    @Test
    public void actionsTest() {
        //https://techproeducation.com adresine gidin
        driver.get("https://techproeducation.com/");
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();

        // Sayfanın alt tarafına gidin
        Actions actions=new Actions(driver);
        waitWithThreadSleep(2);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        waitWithThreadSleep(2);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        waitWithThreadSleep(2);
        actions.sendKeys(Keys.ARROW_DOWN).perform(); //ARROW_DOWN tusu PAGE_DOWN tusundan daha az asagi kaydiriyor.
        waitWithThreadSleep(2);
        actions.sendKeys(Keys.ARROW_DOWN).perform();

        waitWithThreadSleep(3);
        actions.
                sendKeys(Keys.PAGE_DOWN).
                sendKeys(Keys.PAGE_DOWN).
                sendKeys(Keys.ARROW_DOWN).
                sendKeys(Keys.ARROW_DOWN).
                build(). //Baglantiyi daha saglam hale getirmek icin kullanilir.
                perform();

        // Sayfanın üst tarafına gidin
        waitWithThreadSleep(3);
        actions.sendKeys(Keys.PAGE_UP).perform();
        waitWithThreadSleep(3);
        actions.sendKeys(Keys.ARROW_UP).perform();



    }
}
