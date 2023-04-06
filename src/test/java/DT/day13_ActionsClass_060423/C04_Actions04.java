package DT.day13_ActionsClass_060423;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C04_Actions04 extends TestBase {
     /*
    https://jqueryui.com/droppable/ adresine gidin
    "Drag me to my target" elementini "Drop here" elementi üzerine bırakınız.
    */

    @Test
    public void actionsTest() {
        // https://jqueryui.com/droppable/ adresine gidin
        driver.get("https://jqueryui.com/droppable/");

        //    "Drag me to my target" elementini "Drop here" elementi üzerine bırakınız.
        //sayfada iframe oldugu icin "switch" yapiyoruz.
        driver.switchTo().frame(0);

        //Kaynak ve Web elementlerini locate ediyoruz
        WebElement source= driver.findElement(By.id("draggable"));
        WebElement target= driver.findElement(By.id("droppable"));

        Actions actions=new Actions(driver);
        actions.dragAndDrop(source,target).perform(); //drogAndDrop() methodu kaynak elemani hedef elemani üzerine birakiyoruz.

    }
    @Test
    public void actionsTest2() {
        // https://jqueryui.com/droppable/ adresine gidin
        driver.get("https://jqueryui.com/droppable/");

        //    "Drag me to my target" elementini "Drop here" elementi üzerine bırakınız.
        //sayfada iframe oldugu icin "switch" yapiyoruz.
        driver.switchTo().frame(0);

        //Kaynak ve Web elementlerini locate ediyoruz
        WebElement source= driver.findElement(By.id("draggable"));
        WebElement target= driver.findElement(By.id("droppable"));

        Actions actions=new Actions(driver);
        waitWithThreadSleep(2);
        actions.
                clickAndHold(source). //Web elementi tiklar ve tutar,
                moveToElement(target). //Mouse'i diger element üzerine tasir,
                release().  //tiklamayi birakir.
                perform();
        //Burada dragAndDrop'tan farkli olarak islemleri kendimiz sirayla yaptik.

    }
    @Test
    public void actionsTest3() {
        // https://jqueryui.com/droppable/ adresine gidin
        driver.get("https://jqueryui.com/droppable/");

        //    "Drag me to my target" elementini "Drop here" elementi üzerine bırakınız.
        //sayfada iframe oldugu icin "switch" yapiyoruz.
        driver.switchTo().frame(0);

        //Kaynak ve Web elementlerini locate ediyoruz
        WebElement source= driver.findElement(By.id("draggable"));

        Actions actions=new Actions(driver);
        actions.
                clickAndHold(source).
                moveByOffset(388,34).//istedigimiz koordinata elementimizi tasiyabiliriz.
                release().
                build().
                perform();

    }
}
