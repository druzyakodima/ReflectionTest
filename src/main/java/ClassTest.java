import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;

public class ClassTest {

    public static void start(Class cl) throws InvocationTargetException, IllegalAccessException {

        Method[] methods = cl.getDeclaredMethods();
        ArrayList<Method> methodArrayList = new ArrayList<>();

        for (Method method : methods) {
            if (method.isAnnotationPresent(BeforeSuite.class)) {
                method.invoke(cl);
            }
            if (method.isAnnotationPresent(Test.class)) {
                methodArrayList.add(method);
            }
        }

        methodArrayList.sort(Comparator.comparingInt(o -> o.getAnnotation(Test.class).priority()));

        for (int i = 0; i <= methodArrayList.size() - 1; i++) {
            System.out.print("Приоритет: " + methodArrayList.get(i).getAnnotation(Test.class).priority() + " Тест: ");
            methodArrayList.get(i).invoke(cl);
        }

        for (Method method : methods) {
            if (method.isAnnotationPresent(AfterSuite.class)) {
                method.invoke(cl);
            }
        }
    }
}
