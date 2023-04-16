package NT.day16_SeleniumExceptions_130423;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class C03_NullPointerException {

    /*
    NullPointerException:Degisken olusturup bu degiskene atama yapmadigimizda ya da esitlemedigimizde
    NullPointerException hatasi aliriz
     */
    WebDriver driver;
    Faker faker;
    Actions actions;
    Integer sayi;
    int number;
    String isim;

    @Test
    public void test01() {
        driver.get("Https://www.amazon.com/");
        //driver=new ChromeDriver(); bu atamayi yapmadigimiz icin
        //driver objemize atama yapmadigimiz icin NullPointerException hatasi aliriz,

    }

    @Test
    public void test02() {
        //faker=new Faker(); bu atamayi yapmadigimiz icin
        System.out.println(faker.name().firstName());  //java.lang.NullPointerException
    }

    @Test
    public void NullPointerExceptionTest3() {
        //actions = new Actions(driver); bu atamayı yapmadığım için bu hatayı aldık
        actions.doubleClick().perform();//java.lang.NullPointerException
    }

    @Test
    public void NullPointerExceptionTest4() {
        //sayi değişkenine atama yapılmadığı için java.lang.NullPointerException hatasını aldık
        //sayi=5;
        System.out.println(sayi+5);
    }

    @Test
    public void NullPointerExceptionTest5() {
        //isim değişkenine atama yapılmadığı için java.lang.NullPointerException hatasını aldık
        //isim="Erol";
        System.out.println(isim.charAt(0));
    }

    @Test
    public void NullPointerExceptionTest6() {
        System.out.println(number);
    }
}
