import javax.swing.JFrame;

public class MyFrame extends JFrame {
    MyFrame() {
        this.setTitle("JFrame test");
        this.setVisible(true);
        this.setSize(420, 420);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);
    }
}
