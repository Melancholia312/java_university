import java.io.FileInputStream;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Collectors;

public class Util {

    public static HashMap<String, Object> collect(Class<?> someClass) throws Exception {
        HashMap<String, Object> map = new HashMap<>();
        List<Method> methods = new ArrayList<>(Arrays.asList(someClass.getDeclaredMethods()));
        for (Method method : methods){
            if(method.isAnnotationPresent(Invoke.class) &&
                    !method.getReturnType().equals(Void.TYPE) &&
                    method.getParameterCount() == 0
            ){
                method.setAccessible(true);
                map.put(method.getName(), method.invoke(someClass.newInstance()));
            }
        }
        return map;
    }

    public static void reset(Object someObject) throws Exception {
        List<Field> fields = new ArrayList<>();
        Class<?> defaultClass;
        Class<?> objClass = someObject.getClass();

        while (objClass.getSuperclass() != Object.class){
            objClass = objClass.getSuperclass();
            fields.addAll(Arrays.stream(objClass
                    .getDeclaredFields())
                    .filter(field -> field.isAnnotationPresent(Default.class))
                    .toList());
        }

        if (someObject.getClass().isAnnotationPresent(Default.class)){
            fields.addAll(Arrays.asList(someObject.getClass()
                    .getDeclaredFields()));
            defaultClass = someObject.getClass().getAnnotation(Default.class).value();
        } else {
            fields.addAll(Arrays.stream(someObject.getClass()
                    .getDeclaredFields())
                    .filter(field -> field.isAnnotationPresent(Default.class))
                    .toList());
            defaultClass = null;
        }

        for (Field field : fields) {
            field.setAccessible(true);
            if (defaultClass == null){
                field.set(someObject, field.getAnnotation(Default.class).value()
                     .getDeclaredField(field.getName()).get(null));
            } else {
                field.set(someObject, defaultClass.getDeclaredField(field.getName()).get(null));
            }
        }

    }

    public static void validate(Object someObject) throws Exception {
        Class<?> objClass = someObject.getClass();
        Class<?>[] testClasses = {};
        List<Method> testMethods;

        Annotation[] annotations = objClass.getAnnotations();
        for (Annotation annotation : annotations){
            if(annotation.annotationType().isAnnotationPresent(Validate.class)){
                testClasses = annotation.annotationType().getAnnotation(Validate.class).value();
                break;
            }
        }

        if(objClass.isAnnotationPresent(Validate.class)) {
            testClasses = objClass.getAnnotation(Validate.class).value();
            System.out.println(Arrays.toString(testClasses));
        }

        for (Class<?> testClass : testClasses){
            testMethods = Arrays.asList(testClass.getDeclaredMethods());

            for (Method method : testMethods){
                method.invoke(null, someObject);
            }
        }
    }

}




