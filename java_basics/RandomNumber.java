import java.lang.Math;
import java.util.Scanner;
import java.util.Random;

public class RandomNumber {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int max, min;
        max = s.nextInt();
        min = s.nextInt();

        String a = new String("Test");
        String b = new String("Test");
        System.out.println(a == b);
        System.out.println(a.equals(b));

        int num = min + (int)(Math.random() * (max - min));
        System.out.println("Random number: " + num);
        
        Random random = new Random();
        int x = random.nextInt();
        System.out.println(x);
    }
}
