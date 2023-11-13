public class ObjectExample {
    // constructor
    ObjectExample() {
        System.out.println("Constructor called.");
    }

    void show() {
        System.out.println("Test");
    }

    public static void main(String args[]) {
        ObjectExample obj = new ObjectExample();
        obj.show();
    }
}
