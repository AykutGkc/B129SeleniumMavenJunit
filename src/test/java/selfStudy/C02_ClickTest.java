package selfStudy;

import org.junit.Assert;
import utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class C02_ClickTest extends TestBase {

    /*
    - http://the-internet.herokuapp.com/add_remove_elements/ adresine gidiniz
- Add Element butonuna 100 defa basınız
- 100 defa basıldığını test ediniz
- 90 defa delete butonuna basınız
- 90 defa basıldığını doğrulayınız
- Sayfayı kapatınız

     */
    @Test
    public void ClickTest() {
        // - http://the-internet.herokuapp.com/add_remove_elements/ adresine gidiniz
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");
        //- Add Element butonuna 100 defa basınız
        WebElement addElement;
        for (int i=0; i<100; i++){
            addElement=driver.findElement(By.xpath("//button[@onclick='addElement()']"));
            addElement.click();

        }
        //- 100 defa basıldığını test ediniz
        List<WebElement> deleteElements=driver.findElements(By.xpath("//button[@onclick='deleteElement()']"));
        Assert.assertEquals(100,deleteElements.size());

        //- 90 defa delete butonuna basınız
        WebElement deleteElement;
        for (int i=0; i<90; i++){
            deleteElement=driver.findElement(By.xpath("//button[@onclick='deleteElement()']"));
            deleteElement.click();
        }

        //- 90 defa basıldığını doğrulayınız
        List<WebElement> deleteButtons=driver.findElements(By.xpath("//button[@onclick='deleteElement()']"));
        Assert.assertEquals(deleteButtons.size(),10);

        //- Sayfayı kapatınız




    }
}
