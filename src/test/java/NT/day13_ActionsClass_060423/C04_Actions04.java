package NT.day13_ActionsClass_060423;

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
    public void actions() {
// https://jqueryui.com/droppable/ adresine gidin
        driver.get("https://jqueryui.com/droppable/");

//    "Drag me to my target" elementini "Drop here" elementi üzerine bırakınız.
        driver.switchTo().frame(0);
        WebElement drag= driver.findElement(By.xpath("//*[@id='draggable']"));
        WebElement drop=driver.findElement(By.xpath("//*[@id='droppable']"));

        Actions actions=new Actions(driver);
        actions.dragAndDrop(drag,drop).perform();
        //Source(drag) web elementini alip target(drop) web elementinin üzerine tasir.



    }

    @Test
    public void actions2() {
        // https://jqueryui.com/droppable/ adresine gidin
        driver.get("https://jqueryui.com/droppable/");

//    "Drag me to my target" elementini "Drop here" elementi üzerine bırakınız.
        driver.switchTo().frame(0);
        WebElement drag= driver.findElement(By.xpath("//*[@id='draggable']"));
        WebElement drop=driver.findElement(By.xpath("//*[@id='droppable']"));
        Actions actions=new Actions(driver);
        actions.clickAndHold(drag). //Web elementi tutup bekler
                moveToElement(drop). //mouse web elementi üzerine tasir
                release(). // sebest birakir
                perform();

    }

    @Test
    public void actions3() {
        // https://jqueryui.com/droppable/ adresine gidin
        driver.get("https://jqueryui.com/droppable/");

//    "Drag me to my target" elementini "Drop here" elementi üzerine bırakınız.
        driver.switchTo().frame(0);
        WebElement drag= driver.findElement(By.xpath("//*[@id='draggable']"));
        WebElement drop=driver.findElement(By.xpath("//*[@id='droppable']"));
        Actions actions=new Actions(driver);
        actions.clickAndHold(drag).
                moveByOffset(84,28). //Web elementi istediginiz koordinata getirir.
                release().perform();
    }
}
