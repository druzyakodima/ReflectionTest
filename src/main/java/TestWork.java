public class TestWork {

    @BeforeSuite
    public void testBefore() {
        System.out.println("test before");
    }

    @Test(priority = 3)
    public void test1() {
        System.out.println("test 1");
    }

    @Test(priority = 4)
    public void test2() {
        System.out.println("test 2");
    }

    @Test(priority = 5)
    public void test3() {
        System.out.println("test 3");
    }

    @Test(priority = 6)
    public void test4() {
        System.out.println("test 4");
    }

    @Test(priority = 7)
    public void test5() {
        System.out.println("test 5");
    }

    @AfterSuite
    public void testAfter() {
        System.out.println("test after");
    }

}
