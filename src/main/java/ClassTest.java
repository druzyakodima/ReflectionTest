import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;

public class ClassTest {

    public void start(Class<?> clazz) throws InvocationTargetException, IllegalAccessException, InstantiationException, NoSuchMethodException {

        Method[] methods = clazz.getDeclaredMethods();

        ArrayList<Method> methodArrayList = new ArrayList<>();

        for (Method method : methods) {
            if (method.isAnnotationPresent(BeforeSuite.class)) {
                method.invoke(clazz.getDeclaredConstructor().newInstance());

            }
            if (method.isAnnotationPresent(Test.class)) {
                methodArrayList.add(method);
            }
        }

        methodArrayList.sort(Comparator.comparingInt(o -> o.getAnnotation(Test.class).priority()));

        for (int i = 0; i <= methodArrayList.size() - 1; i++) {
            System.out.print("Приоритет: " + methodArrayList.get(i).getAnnotation(Test.class).priority() + " Тест: ");

            methodArrayList.get(i).invoke(clazz.getDeclaredConstructor().newInstance());
        }

        for (Method method : methods) {
            if (!method.isAnnotationPresent(AfterSuite.class)) {
                continue;
            }

            method.invoke(clazz.getDeclaredConstructor().newInstance());
        }
    }
}
