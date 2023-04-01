package NT.day07_Junit_280323;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C02_BeforeAfter {
    @Before
    public void setUp() throws Exception {
        System.out.println("Her test methodu öncesi bir kez calisir.");

    }

    @After
    public void tearDown() throws Exception {
        System.out.println("Her test methodu sonrasi bir kez calisir");
    }




    @Test
    public void test02() {
        System.out.println("Ikinci test");
    }

    @Test
    public void test01 () {
        System.out.println("Ilk test");
    }

}
