package NT.day21_JSExecutor_240423;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C04_JSExecutor_GetValue extends TestBase {

    //  1)getValueTest metotu olustur
//  2)https://www.priceline.com/ a git
//  3)Tarih kısmındaki Yazili metinleri al ve yazdır
    @Test
    public void getValueTest() {

       //  2)https://www.priceline.com/ a git
        driver.get("https://www.carettahotel.com/");
        driver.findElement(By.id("details-button")).click();
        driver.findElement(By.id("proceed-link")).click();

        //  3)Tarih kısmındaki Yazili metinleri al ve yazdır
        JavascriptExecutor js= (JavascriptExecutor) driver;
        WebElement date= (WebElement) js.executeScript("return document.getElementById('checkin_date')");

        /*
        Eğer bir webSayfasında web elementler oluşturulurken JS kullanılmışsa normal olarak locate almakta
        zorlanırız. Bu gibi durumlarda yukarıdaki örnekteki gibi JSExecutor kullanarak web elementi locate edebiliriz
         */

        date.clear();
        sendKeysJS(date,"5/24/2023");

        /*
        Eğer bir webelementin attribute değerini yazdırmak istersek aşağıdaki örnekteki gibi yaparız
         */

        String attributeValue= (String) js.executeScript("return document.getElementById('checkin_date').value");
        System.out.println("Value Attribute degeri: "+attributeValue);
    }
}
