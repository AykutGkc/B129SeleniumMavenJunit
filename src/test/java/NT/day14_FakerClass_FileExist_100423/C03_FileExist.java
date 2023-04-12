package NT.day14_FakerClass_FileExist_100423;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.edge.AddHasCasting;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C03_FileExist {
    @Test
    public void FileExist() {
        //Masaüstünde bir dosya olusturalim
        //bu sosyanin varligini sorgulayalim.
        System.out.println("System.getProperty(\"user.dir\") = " + System.getProperty("user.dir")); // /Users/aykutgkc/IdeaProjects/B129SeleniumMavenJunit
        //Projemizin icinde bulundugu yolu verir

        System.out.println(System.getProperty("user.home")); ///Users/aykutgkc
        //Localimizde ki kullanici yolunu verir

        //String dosyaYolu="/Users/aykutgkc/Desktop/b129"
        String farkliKisim=System.getProperty("user.home"); //Her kullanicinin ana yolu farkli oldugu icin farkli kisim dedik
        String ortakKisim="/Desktop/b129";//Ayni yerde olusturuldugu icin ortak kisimd edik.
        String dosyaYolu=farkliKisim+ortakKisim;//Dosya yolu olarak farkli ve ortak kismi aldik

        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));//Files.exists methodu ile dosyanin varligini dogruladik.




    }
}
