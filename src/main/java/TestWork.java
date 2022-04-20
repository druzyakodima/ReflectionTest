public class TestWork {

    @BeforeSuite
    public static void testBefore() {
        System.out.println("test before");
    }

    @Test(priority = 3)
    public static void test1() {
        System.out.println("test 1");
    }

    @Test(priority = 4)
    public static void test2() {
        System.out.println("test 2");
    }

    @Test(priority = 5)
    public static void test3() {
        System.out.println("test 3");
    }

    @Test(priority = 6)
    public static void test4() {
        System.out.println("test 4");
    }

    @Test(priority = 7)
    public static void test5() {
        System.out.println("test 5");
    }

    @AfterSuite
    public static void testAfter() {
        System.out.println("test after");
    }
}
