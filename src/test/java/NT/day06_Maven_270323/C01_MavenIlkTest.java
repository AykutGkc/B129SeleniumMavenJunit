package NT.day06_Maven_270323;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class C01_MavenIlkTest {
    /*
    https://www.amazon.com/ sayfasina gidelim
arama kutusunu locate edelim
“Samsung headphones” ile arama yapalim
Bulunan sonuc sayisini yazdiralim
Ilk urunu tiklayalim
Sayfadaki tum basliklari yazdiralim
     */
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //    https://www.amazon.com/ sayfasina gidelim
        driver.get("https://www.amazon.com/");

        //arama kutusunu locate edelim
        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));

        //“Samsung headphones” ile arama yapalim
        aramaKutusu.sendKeys("Samsung headphones", Keys.ENTER);

        //Bulunan sonuc sayisini yazdiralim
        WebElement sonucSayisi=driver.findElement(By.xpath("(//*[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        String [] sonuc=sonucSayisi.getText().split(" ");
        System.out.println(sonuc[2]);

        //Lambda ile yazdiralim
        Arrays.stream(sonucSayisi.getText().split(" ")).skip(2).limit(1).forEach(t-> System.out.println("Sonuc Sayisi : " +t));

        //Ilk urunu tiklayalim
        driver.findElement(By.xpath("(//*[@class='a-link-normal s-underline-text s-underline-link-text s-link-style a-text-normal'])[1]")).click();

        //Sayfadaki tum basliklari yazdiralim
        List<WebElement> sayfaBasliklari=driver.findElements(By.xpath("//h1"));
        for (WebElement w : sayfaBasliklari) {
            System.out.println(w.getText());
        }

        sayfaBasliklari.forEach(t-> System.out.println(t.getText())); //lambda ile

    }
}
