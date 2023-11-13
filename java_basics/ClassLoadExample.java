public class ClassLoadExample {
    public static void main (String args[]) {
        // Application/System classloader
        Class c = ClassLoadExample.class;
        System.out.println(c.getClassLoader());

        // Classloader name of String. It will print null because it is an 
        // builtin class which is found in rt.jar -> loaded by bootstrap classloader
        System.out.println(String.class.getClassLoader());
    }
}