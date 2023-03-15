import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class Entity {

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Class<?> objClass = this.getClass();
        List<Field> fields = new ArrayList<>();

        if (objClass.isAnnotationPresent(ToString.class) &&
                objClass.getAnnotation(ToString.class).value() == Status.YES) {
            fields.addAll(Arrays.asList(objClass.getDeclaredFields()));
            while (objClass.getSuperclass() != Object.class){
                objClass = objClass.getSuperclass();
                fields.addAll(Arrays.asList(objClass.getDeclaredFields()));
            }
        } else {
            while (objClass.getSuperclass() != Object.class) {
                objClass = objClass.getSuperclass();
                fields.addAll(Arrays.stream(objClass
                                .getDeclaredFields())
                        .filter(field -> field.isAnnotationPresent(ToString.class))
                        .filter(field -> field.getAnnotation(ToString.class).value() == Status.YES)
                        .toList());
            }
            fields.addAll(Arrays.stream(objClass
                    .getDeclaredFields())
                    .filter(field -> field.isAnnotationPresent(ToString.class))
                    .filter(field -> field.getAnnotation(ToString.class).value() == Status.YES)
                    .toList());
        }

        if (fields.isEmpty()){
            return "{}";
        }

        for (Field field : fields){
            field.setAccessible(true);
            String name = field.getName();
            String value = "";
            try {
                value = field.get(this).toString();
            } catch (IllegalAccessException e) {

                throw new RuntimeException(e);
            }
            sb.append(String.format("%s=%s, ", name, value));
        }
        sb.insert(0, "{");
        sb.replace(sb.length()-2, sb.length(), "}");
        return sb.toString();
    }

}
