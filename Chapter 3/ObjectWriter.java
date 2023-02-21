import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ObjectWriter {

    private final String fileName;

    public ObjectWriter(String fileName) {
        this.fileName = fileName;
    }

    public void write(Object ... objects) throws IllegalAccessException, IOException {
        File f = new File(fileName);
        FileWriter writer = new FileWriter(f);
        for (Object obj : objects){
            writer.write(convertToString(obj));
            writer.write("\n");
        }
        writer.close();
    }

    private String convertToString(Object object) throws IllegalAccessException {
        StringBuilder sb = new StringBuilder();
        sb.append(object.getClass().toString().substring(6));
        sb.append("{");
        Class<?> objClass = object.getClass();
        List<Field> fields = new ArrayList<>(Arrays.asList(objClass.getDeclaredFields()));

        while (objClass.getSuperclass() != Object.class){
            objClass = objClass.getSuperclass();
            fields.addAll(Arrays.asList(objClass.getDeclaredFields()));
        }

        for (Field field : fields){
            field.setAccessible(true);
            String name = field.getName();
            if (field.getType().isPrimitive()){
                String value = "";
                try {
                    value = field.get(object).toString();
                } catch (IllegalAccessException e) {

                    throw new RuntimeException(e);
                }
                sb.append(String.format("%s=%s,", name, value));
            } else {

                sb.append(String.format("%s=%s,", name, convertToString(field.get(object))));
            }

        }
        sb.replace(sb.length()-1, sb.length(), "}");
        return sb.toString();
    }
}
