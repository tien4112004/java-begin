import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.gui2.*;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class Editor {
    public static void main(String[] args) {
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory();
        Screen screen = null;

        try {
            Terminal terminal = terminalFactory.createTerminal();
            screen = new TerminalScreen(terminal);

            screen.startScreen();

            final Panel panel = new Panel();
            panel.setLayoutManager(new GridLayout(2));

            panel.addComponent(new Label("Subject:"));
            TextBox subjectBox = new TextBox(new TerminalSize(50, 1));
            panel.addComponent(subjectBox);

            panel.addComponent(new Label("Content:"));
            TextBox contentBox = new TextBox(new TerminalSize(50, 10)).setMultiline(true);
            panel.addComponent(contentBox);

            BasicWindow window = new BasicWindow();
            window.setComponent(panel);

            MultiWindowTextGUI gui = new MultiWindowTextGUI(screen, new DefaultWindowManager(), new EmptySpace(TextColor.ANSI.BLUE));
            gui.addWindowAndWait(window);

        } catch (IOException e) {
            e.printStackTrace();

        } finally {
            if(screen != null) {
                try {
                    screen.stopScreen();
                } catch(IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}