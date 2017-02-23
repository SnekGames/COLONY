package tester;

import colony.application.Application;

import java.awt.*;

/**
 * Created by Viktor on 2017-01-23.
 */
public class Tester1 {

    void run(){
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Application ex = new Application();
                ex.setVisible(true);
            }
        });
    }
}
