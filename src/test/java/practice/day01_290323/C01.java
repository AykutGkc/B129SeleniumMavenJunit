package practice.day01_290323;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01 {

    // https://www.amazon.com/ adresine gidin
    // arama kutusunun, tagName'inin 'input' oldugunu test ediniz
    // arama kutusunun, name attribute'nun degerinin 'field-keywords' oldugunu test edin
    // sayfayi kapatiniz

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // https://www.amazon.com/ adresine gidin
        driver.get("https://www.amazon.com/");

        // arama kutusunun, tagName'inin 'input' oldugunu test ediniz
        WebElement aramaKutusu=driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        String actualTagName=aramaKutusu.getTagName();
        String expectedTagName="input";

        if (actualTagName.equals(actualTagName)){
            System.out.println("TagName input");
        }else {
            System.out.println("TagName input degil");
        }

        // arama kutusunun, name attribute'nun degerinin 'field-keywords' oldugunu test edin
        String actualNameDegeri= aramaKutusu.getAttribute("name");
        String expectedNameDegeri="field-keywords";

        if (expectedNameDegeri.equals(actualNameDegeri)){
            System.out.println("Name attiributenin degeri field keywords");
        }else {
            System.out.println("Name attiributenin degeri field keywords degil");

        }
        // sayfayi kapatiniz
        driver.close();
    }

}
