import java.lang.reflect.*;

public class newInstanceConstructor {
    private String str = "";
    newInstanceConstructor() {}
    public void setName(String name) {
        this.str = name;
    }

    public static void main(String args[]) {
        try {
            Constructor<newInstanceConstructor> constructor = newInstanceConstructor.class.getDeclaredConstructor();
            newInstanceConstructor r = constructor.newInstance();
            r.setName("dcm java");
            System.out.println(r.str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
} 