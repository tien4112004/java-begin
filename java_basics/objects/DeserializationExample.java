import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class DeserializationExample {
    public static void main(String args[]) {
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("employee.txt"));
            Employee e = (Employee)in.readObject();

            System.out.println(e.emp_id);
            System.out.println(e.emp_name);
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
