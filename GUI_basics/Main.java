import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import javafx.scene.paint.Color;

public class Main {
    final static int ERROR_DIALOG = 0;
    final static int INFO_DIALOG = 1;
    final static int WARNING_DIALOG = 2;
    final static int PROMPT_DIALOG = 3;

    // public static void main(String args[]) {
    // String name = JOptionPane.showInputDialog("Name: ");
    // JOptionPane.showMessageDialog(null, "Hello, " + name, "Hello", ERROR_DIALOG);

    // int age = Integer.parseInt(JOptionPane.showInputDialog("Your age: "));
    // JOptionPane.showMessageDialog(null, "Your age = " + age, "Age dialogue",
    // INFO_DIALOG);

    // }
    public static void main(String args[]) {
        ImageIcon image = new ImageIcon("home.png");

        JLabel label = new JLabel();
        label.setText("Test label #1");
        label.setIcon(image);
        label.setHorizontalAlignment(JLabel.CENTER);

        JFrame frame = new JFrame();

        frame.setTitle("JFrame test");
        frame.setVisible(true);
        frame.setSize(420, 420);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);

        frame.add(label);
        // frame.add(image);

        // frame.getContentPane().setBackground(new Color(1.0, 1.0, 1.0));
    }
}