package NT.day09_DropDown_Allerts_010423;

import utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class C03_Allerts extends TestBase {
    /*
    https://testcenter.techproeducation.com/index.php?page=javascript-alerts adresine gidin.
    Bir metod olusturun: acceptAlert
    1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının  “You successfully clicked an alert” oldugunu test edin.
    Bir metod olusturun: dismissAlert
    2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
    “successfuly” icermedigini test edin.
    Bir metod olusturun: sendKeysAlert
    3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna
    tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.

     */

    @Test
    public void acceptAlert() throws InterruptedException {
        // https://testcenter.techproeducation.com/index.php?page=javascript-alerts adresine gidin.
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");

        //    1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının  “You successfully clicked an alert” oldugunu test edin.
        driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();
        Thread.sleep(4000);
        driver.switchTo(). //gecmek,degistirmek
                alert(). //allert'e gecis yap.
                accept(); //Cikan uyarida okey ya da tamam butonuna basar.
        Thread.sleep(5000);
        String actualText=driver.findElement(By.xpath("//*[@id='result']")).getText();
        String expectedText="You successfully clicked an alert";

        Assert.assertEquals(expectedText,actualText);


    }

    @Test
    public void dismissAllert() throws InterruptedException {
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        //    2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
        //    “successfuly” icermedigini test edin.
        driver.findElement(By.cssSelector("button[onclick='Confirm()']")).click();
        Thread.sleep(4000);
        driver.switchTo().alert().dismiss();

        //    “successfuly” icermedigini test edin.
        String actualTest=driver.findElement(By.xpath("//*[@id='result']")).getText();
        String expectedTest="successfuly";
        Assert.assertFalse(actualTest.contains(expectedTest));

    }

    @Test
    public void sendKeysAllert() throws InterruptedException {
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        //    3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna tiklayin
        driver.findElement(By.cssSelector("button[onclick='jsPrompt()']")).click();
        driver.switchTo().alert().sendKeys("Aykut");
        driver.switchTo().alert().accept();
        waitWithThreadSleep(3);
        WebElement result= driver.findElement(By.cssSelector("p[id='result']"));

        // result mesajında isminizin görüntülendiğini doğrulayın.
        Assert.assertTrue(result.getText().contains("Aykut"));
        System.out.println(result.getText());
    }
}
