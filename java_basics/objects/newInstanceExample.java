import javax.management.InstanceAlreadyExistsException;
import javax.management.InstanceNotFoundException;

public class newInstanceExample {
    void show() {
        System.out.println("show()");
    }

    public static void main(String args[]) {
        // Create an instance of Class class
        try {
            Class cls = Class.forName("newInstanceExample");
            // create class using new instance
            newInstanceExample obj = (newInstanceExample) cls.newInstance();
            obj.show();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } 
    }
}