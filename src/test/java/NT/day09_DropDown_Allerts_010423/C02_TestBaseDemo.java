package NT.day09_DropDown_Allerts_010423;

import utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;

public class C02_TestBaseDemo extends TestBase {
    @Test
    public void test01() {
        //Techproeducation sayfasina gidelim.
        driver.get("https://www.techproeducation.com/");

        //Basligin "Bootcamp" icerdigini test edelim.
        String actualTitle= driver.getTitle();
        String expectedTitle="Bootcamp";
        Assert.assertTrue(actualTitle.contains(expectedTitle));

    }
}
