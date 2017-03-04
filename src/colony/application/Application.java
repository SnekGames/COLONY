package colony.application;
/**
 * Created by Viktor on 2016-11-18.
 */


import colony.graphics.Board;

import java.awt.*;
import javax.swing.JFrame;

public class Application extends JFrame {
    int screen_height;
    int screen_width;

    public Application() {
        initUI();
    }

    private void initUI() {
        // Send size of screen to the Board
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        screen_width = (int) screenSize.getWidth();
        screen_height = (int) screenSize.getHeight();

        setSize(screen_width,screen_height);
        add(new Board(screen_width,screen_height)); /** Create graphic window */
        setResizable(false);
        //pack();

        setTitle("Colony");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
}
