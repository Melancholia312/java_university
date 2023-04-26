import com.sun.jdi.InterfaceType;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ORM {

    private static final String SELECT_ALL_QUERY = "select * from %s";
    private final Connection connection = new DBConnection().connect();

    public <T> List<T> selectAll(Class<T> tClass) throws SQLException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        String className = String.format("public.\"%s\"", tClass.getName());
        PreparedStatement preparedStatement = connection.prepareStatement(
                String.format(SELECT_ALL_QUERY, className));
        ResultSet resultSet = preparedStatement.executeQuery();
        List<T> list = new ArrayList<>();
        Map<String, Method> methods =
                Arrays.stream(tClass.getDeclaredMethods())
                        .filter(method -> method.getName().startsWith("set"))
                        .collect(Collectors.toMap(method -> method.getName().toLowerCase(), Function.identity()));
        while (resultSet.next()) {
            T o = tClass.newInstance();

            for (int i = 1; i <= methods.size(); i++) {
                Method method = methods.get(
                        "set" + resultSet.getMetaData().getColumnName(i).toLowerCase());
                Method getMethod = ResultSet.class.getDeclaredMethod(createNameOfGetMethod(
                        method.getParameterTypes()[0]), int.class);
                method.invoke(o, getMethod.invoke(resultSet, i));
            }
            list.add(o);
        }
        return list;
    }

    private static String createNameOfGetMethod(Class<?> parameterType){
        String[] splitWord = parameterType.toString().split("\\.");
        String word = splitWord[splitWord.length - 1];
        return "get" + word.substring(0, 1).toUpperCase() + word.substring(1);
    }
}

