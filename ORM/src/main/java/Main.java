import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        ORM orm = new ORM();
        System.out.println(orm.selectAll(Employee.class));
        //Connected to the PostgreSQL server successfully.
        //[Employee{id=1, name='Vasya', id_dep=1}, Employee{id=2, name='Sveta', id_dep=1}, Employee{id=3, name='Vitya', id_dep=1}]
    }
}

