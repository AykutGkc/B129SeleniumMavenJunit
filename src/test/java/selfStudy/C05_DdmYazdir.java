package selfStudy;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.stream.Collectors;

public class C05_DdmYazdir extends TestBase {

    /*
    -Amazon sayfasına gidelim
    -Arama Kutusundaki Dropdown menuyu yazdıralım
    -Dropdown menuden sırasıyla ilk 5 başlığı (Arts&Crafts ile başlayıp Books'a kadar Books dahil) seçip
    başlık altındakileri aratalım. Her aramada sayfa başlığını yazdıralım
    Not: Select Class'ı kullanalım
     */
    @Test
    public void ddm() {

        //-Amazon sayfasına gidelim
        driver.get("https://www.amazon.com/");

        //    -Arama Kutusundaki Dropdown menuyu yazdıralım
        WebElement ddm=driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select select=new Select(ddm);


        for (WebElement w :select.getOptions() ) {
            System.out.println(w.getText());
        }



        //    -Dropdown menuden sırasıyla ilk 5 başlığı (Arts&Crafts ile başlayıp Books'a kadar Books dahil) seçip
        //    başlık altındakileri aratalım. Her aramada sayfa başlığını yazdıralım
        int sayac=1;
        for (WebElement w : select.getOptions() ) {
            Select option=new Select(driver.findElement(By.xpath("//select[@id='searchDropdownBox']")));
            option.selectByIndex(sayac);
            driver.findElement(By.xpath("//*[@type='submit']")).click();
            System.out.println(driver.getTitle());
            waitWithThreadSleep(2);
            driver.navigate().back();
            waitWithThreadSleep(2);
            sayac++;
            if (sayac>=6){
                break;
            }
        }


        //    Not: Select Class'ı kullanalım

    }
}
