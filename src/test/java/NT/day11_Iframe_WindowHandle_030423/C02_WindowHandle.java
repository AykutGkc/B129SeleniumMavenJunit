package NT.day11_Iframe_WindowHandle_030423;

import utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;

import java.util.ArrayList;
import java.util.List;

public class C02_WindowHandle extends TestBase {
    /*
    //Window 1'de https://www.techproeducation.com adresine gidiniz
    //Başlığın "Techpro Education | Online It Courses & Bootcamps" olduğunu doğrulayın
    //Window 2'de https://www.youtube.com sayfasını açınız:
    //Window 3'te https://www.linkedin.com sayfasını açınız:
    //techproeducation sayfasına geçiniz:
    //youtube sayfasına geçiniz:
    //linkedIn sayfasına geçiniz:
     */

    @Test
    public void windowHandle() {
        //Window 1'de https://www.techproeducation.com adresine gidiniz
        driver.get("https://www.techproeducation.com");
        //String techProWindowHandle=driver.getWindowHandle();//TechPro sayfasinin handle degerini bir String'e assign ettik.
        //System.out.println(techProWindowHandle);

        //Başlığın "Techpro Education | Online It Courses & Bootcamps" olduğunu doğrulayın
        String actualTitle= driver.getTitle();
        String expectedTitle="Techpro Education | Online It Courses & Bootcamps";
        Assert.assertEquals(expectedTitle,actualTitle);

        //Window 2'de https://www.youtube.com sayfasını açınız:
        driver.switchTo(). //gecisYap
                            newWindow(WindowType.WINDOW); // -->Yeni bir pencereye driver'i tasir.
        //-->WindowType.TAB --> Yeni sekme acar.
        driver.get("https://www.youtube.com");
        //String youtubeWindowHandle=driver.getWindowHandle();//YouTube sayfasinin handle degerini bir String'e assign ettik.
        //System.out.println(youtubeWindowHandle);

        //Window 3'te https://www.linkedin.com sayfasını açınız:
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.linkedin.com");
        //String linkedinWindowHandle= driver.getWindowHandle();
        //System.out.println(linkedinWindowHandle);

        List<String> timWindowList=new ArrayList<>(driver.getWindowHandles());
        //Bütüna ctigim pencerelerin bütün handle degerlerini bir ArrayListe atadik

        //techproeducation sayfasına geçiniz:
        //driver.switchTo().window(techProWindowHandle);
        driver.switchTo().window(timWindowList.get(0)); //__>ilk actigimiz pencereye index ile gecebiliriz.

        //youtube sayfasına geçiniz:
        //driver.switchTo().window(youtubeWindowHandle);
        driver.switchTo().window(timWindowList.get(1));

        //linkedIn sayfasına geçiniz:
        //driver.switchTo().window(linkedinWindowHandle);
        driver.switchTo().window(timWindowList.get(2));
    }
}
