package NT.day14_FakerClass_FileExist_100423;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class C04_FileDowloadTest extends TestBase {
    @Test
    public void fileDownload() {
    //"https://testcenter.techproeducation.com/index.php?page=file-download"   adresine gidin
        driver.get("https://testcenter.techproeducation.com/index.php?page=file-download");
        waitWithThreadSleep(5);
        File silinecekDosya=new File("/Users/aykutgkc/Downloads/b10 all test cases, code.docx");
        silinecekDosya.delete();

        /*
        //Eğer localinizden atomasyon ile bir dosya silmek için File class'ından obje oluşturup dosya yolumuzu
        içine yerleştiririz. Ve oluşturduğumuz obje ile delete() methodunu kullanarak o dosyayı silebiliriz.
        Bunu yapma sebebimiz test classlarımızı çalıştırdığımızda her çalıştırmada yeni bir dosya create edeceği için
        ordaki dosya kalabalığını önlemiş oluruz aynı zamanda doğrulama yaparken işimizi garantiye almış oluruz
        Birden fazlada dosya indirmis olsak aynı isimde her indirilenin yanına index vereceği için ve bizim ilk indirdiğimiz
        o klasörün içinde bulunacağı için her zaman ilk dosyanın varlığını test etmiş oluruz
         */

        //"b10 all test cases" dosyasını indirin
        driver.findElement(By.xpath("(//a)[3]")).click();
        waitWithThreadSleep(5);
        // Dosyanın başarıyla indirilip indirilmediğini test edin.
        //ILK OLARAK DOSYA YOLUNU ALIYORUZ
        String dosyaYolu=System.getProperty("user.home")+"/Downloads/b10 all test cases, code.docx";
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

    }
}
