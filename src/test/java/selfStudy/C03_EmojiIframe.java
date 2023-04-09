package selfStudy;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C03_EmojiIframe extends TestBase {
    // https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/ sitesine gidin
    // ikinci emojiye tıklayın
    // İkinci emoji öğelerini yazdırınız
    // Parent iframe e geri donun
    // Formu doldurun,(Formu istediğiniz metinlerle doldurun)
    // Apply button a basiniz


    @Test
    public void test01() {
        driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/");

        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[2]")));
        WebElement emoji2=driver.findElement(By.xpath("(//a[@class='mdl-tabs__tab'])[1]"));
        emoji2.click();
    }
}
