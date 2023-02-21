import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class HelloWorld {
        public static void main(String[] args) throws Throwable {
        }

        public static List<Field> fieldCollection(Object obj){
            Class<?> objClass = obj.getClass();
            List<Field> allFields = new ArrayList<>(Arrays.asList(objClass.getDeclaredFields()));

            while (objClass.getSuperclass() != Object.class){
                objClass = objClass.getSuperclass();
                allFields.addAll(Arrays.asList(objClass.getDeclaredFields()));
            }

            return allFields;
        }

        public static void lineConnector(Line firstLine, Line secondLine) throws Throwable {
            Field endField = Line.class.getDeclaredField("end");
            endField.setAccessible(true);
            Point endPoint = (Point) endField.get(firstLine);
            Field startField = Line.class.getDeclaredField("start");
            startField.setAccessible(true);
            startField.set(secondLine, endPoint);
        }

        public static void validate(Object object, Class<?> objectClass) throws InvocationTargetException, IllegalAccessException {
            Method[] tests = objectClass.getDeclaredMethods();
            for (Method method : tests){
                method.invoke(null, object);
            }
        }


}

