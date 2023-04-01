package NT.day07_Junit_280323;

import org.junit.*;

public class C04_BeforeClassArterClass {
    /*
    @BeforeClass ve @AfterClass methodlari sadece static metodlar ile calisir
     */

    @BeforeClass
    public static void beforeClass() throws Exception {
        System.out.println("Classta ki tüm testlerden önce bir kez calisir.");
    }

    @AfterClass
    public static void afterClass() throws Exception {
        System.out.println("Classta ki tüm testlerden sonra bir kez calisir");
    }

    @Before
    public void setUp() throws Exception {
        System.out.println("Her test methodundan önce ");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("Her test methodundan sonra");
    }

    @Test
    public void tes01() {
        System.out.println("ilk test");
    }

    @Test
    public void test02() {
        System.out.println("ikinci test");
    }
}
