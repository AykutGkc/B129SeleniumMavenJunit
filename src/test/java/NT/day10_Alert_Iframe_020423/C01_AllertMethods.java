package NT.day10_Alert_Iframe_020423;

import NT.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class C01_AllertMethods extends TestBase {
    @Test
    public void acceptAlert() throws InterruptedException {
        // https://testcenter.techproeducation.com/index.php?page=javascript-alerts adresine gidin.
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");

        //    1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının  “You successfully clicked an alert” oldugunu test edin.
        driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();
        waitWithThreadSleep(4);
        allertAccept();
        waitWithThreadSleep(4);
        String actualText=driver.findElement(By.xpath("//*[@id='result']")).getText();
        String expectedText="You successfully clicked an alert";

        Assert.assertEquals(expectedText,actualText);


    }

    @Test
    public void dismissAllert() throws InterruptedException {
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        //    2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
        //    “successfuly” icermedigini test edin.
        driver.findElement(By.cssSelector("button[onclick='jsConfirm()ss']")).click();
        waitWithThreadSleep(4);
        allertDismiss();

        //    “successfuly” icermedigini test edin.
        waitWithThreadSleep(4);
        String actualTest=driver.findElement(By.xpath("//*[@id='result']")).getText();
        String expectedTest="successfuly";
        Assert.assertFalse(actualTest.contains(expectedTest));

    }

    @Test
    public void sendKeysAllert() throws InterruptedException {
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        //    3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna tiklayin
        driver.findElement(By.cssSelector("button[onclick='jsPrompt()']")).click();
        waitWithThreadSleep(4);
        //    tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.
        allertPrompt("Aykut");
        allertAccept();
        waitWithThreadSleep(3);
        //   result mesajında isminizin görüntülendiğini doğrulayın.
        WebElement result= driver.findElement(By.cssSelector("p[id='result']"));
        Assert.assertTrue(result.getText().contains("Aykut"));
        System.out.println(result.getText());
    }
}
