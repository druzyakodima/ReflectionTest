import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) {
        Class cl = TestWork.class;

        try {
            ClassTest.start(cl);
        } catch (InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
