import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args)  {

        Class<?> clazz = TestWork.class;
        ClassTest classTest = new ClassTest();

        try {
            classTest.start(clazz);
        } catch (InvocationTargetException | IllegalAccessException | NoSuchMethodException | InstantiationException e) {
            e.printStackTrace();
        }
    }
}
