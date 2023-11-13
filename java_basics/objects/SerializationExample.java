import java.io.*;

class SerializationExample {
    public static void main(String args[]) {
        try {
            Employee emp = new Employee(1232, "test");
            FileOutputStream fout = new FileOutputStream("employee.txt");
            ObjectOutputStream out = new ObjectOutputStream(fout);
            
            out.writeObject(emp);
            out.flush();

            out.close();
            System.out.println("END");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }    
}
