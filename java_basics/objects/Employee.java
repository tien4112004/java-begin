import java.io.Serializable;

public class Employee implements Serializable {
    int emp_id; 
    String emp_name;
    public Employee(int emp_id, String emp_name) {
        this.emp_id = emp_id;
        this.emp_name = emp_name;
    }
}
