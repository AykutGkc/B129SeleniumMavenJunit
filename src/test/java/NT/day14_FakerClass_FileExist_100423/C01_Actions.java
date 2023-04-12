package NT.day14_FakerClass_FileExist_100423;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C01_Actions extends TestBase {
    @Test
    public void actions() {
        //"https://techproeducation.com/" gidin
        driver.get("https://techproeducation.com/");
        waitWithThreadSleep(5);
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();

        // İlk kelime SHIFT tuşuna basılı şekilde, ikinci kelime basılmadan "TECHPRO education" araması yapın.
        WebElement search=driver.findElement(By.xpath("//*[@type='search']"));
        Actions actions=new Actions(driver);
        actions.keyDown(search, Keys.SHIFT). //Search üzerinde Shift basili tutar
                sendKeys("techpro").
                keyUp(Keys.SHIFT).//Shift tusuna basma islemini sonlandirir.
                sendKeys(" education",Keys.ENTER).perform();
        waitWithThreadSleep(3);
        //Sayfayi Richmond College Enrollment Form linkine kadar scroll yapalım
        WebElement richmondCollege= driver.findElement(By.xpath("(//h3//a)[9]"));
        actions.scrollToElement(richmondCollege).perform();

        //scrollToElement() methodu ile locate ettiğiniz bir webelemente kadar yani o element görünene kadar scroll
        //yapabilirsiniz


    }
}
