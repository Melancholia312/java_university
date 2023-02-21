import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Entity {

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Class<?> objClass = this.getClass();
        List<Field> fields = new ArrayList<>(Arrays.asList(objClass.getDeclaredFields()));

        while (objClass.getSuperclass() != Object.class){
            objClass = objClass.getSuperclass();
            fields.addAll(Arrays.asList(objClass.getDeclaredFields()));
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
