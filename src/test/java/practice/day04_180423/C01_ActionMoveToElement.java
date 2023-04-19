package practice.day04_180423;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import javax.swing.*;
import java.util.Set;

public class C01_ActionMoveToElement extends TestBase {
    // https://amazon.com adresine gidiniz
    // sag ust bolumde bulunan dil secenek menusunun acilmasi icin mause'u bu menunun ustune getirelim
    // Change country/region butonuna basiniz
    // United States dropdown'undan 'Turkey (Türkiye)' seciniz
    // Go to website butonuna tiklayiniz
    // acilan yeni sayfadanin Title'inin Elektronik icerdigini test ediniz


    @Test
    public void tes01() {
        // https://amazon.com adresine gidiniz
        driver.get("https://www.amazon.com");
        String sayfa1Handle=driver.getWindowHandle();

        // sag ust bolumde bulunan dil secenek menusunun acilmasi icin mause'u bu menunun ustune getirelim
        WebElement dilMenu= driver.findElement(By.xpath("//div[text()='EN']"));
        Actions actions=new Actions(driver);
        actions.moveToElement(dilMenu).perform();
        waitWithThreadSleep(3);

        // Change country/region butonuna basiniz
        driver.findElement(By.xpath("(//div[text()='Change country/region.'])[1]")).click();


        // United States dropdown'undan 'Turkey (Türkiye)' seciniz
        WebElement ddm=driver.findElement(By.xpath("//select[@id='icp-dropdown']"));
        Select select=new Select(ddm);
        select.selectByVisibleText("Turkey (Türkiye)");
        waitWithThreadSleep(3);


        /*
        Drop down option listesi 'Go to website' butonuna basmamıza engel oldugu icin
        herhangi bir yere click yapıp drop down option listesinin toparlanmasını sagladık
        */
        driver.findElement(By.xpath("(//span[@class='a-text-bold'])[3]")).click();
        waitWithThreadSleep(3);

        // Go to website butonuna tiklayiniz
        driver.findElement(By.xpath("//input[@class='a-button-input']")).click();

        // acilan yeni sayfadanin Title'inin Elektronik icerdigini test ediniz
       Set<String> windowHandlesSeti=driver.getWindowHandles();
        System.out.println(windowHandlesSeti);
        System.out.println(sayfa1Handle);

        String sayfa2Handle="";
        for (String w : windowHandlesSeti) {
            if (!w.equals(sayfa1Handle)){
                sayfa2Handle=w;
            }
        }
        driver.switchTo().window(sayfa2Handle);
        String ikinciSAyfaTitle=driver.getTitle();
        System.out.println("ikinciSAyfaTitle = " + ikinciSAyfaTitle);

        Assert.assertTrue(ikinciSAyfaTitle.contains("Elektronik"));



    }
}
