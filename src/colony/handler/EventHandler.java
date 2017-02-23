package colony.handler;

import colony.graphics.Frame;

import java.awt.event.*;

//import static com.sun.java.accessibility.util.AWTEventMonitor.addKeyListener;
//import static com.sun.java.accessibility.util.AWTEventMonitor.addMouseListener;

/**
 * Created by Viktor on 2017-02-22.
 *
 *  Class checks interrupt events (e.g. keys) with all objects, to se what was clicked on.
 *
 */


public class EventHandler {

    private boolean mouseDown = false;

    public EventHandler(){

    }

    public void keyReleased(KeyEvent e) {
        //colonist.keyReleased(e);
    }

    public void keyPressed(KeyEvent e) {
        //colonist.keyPressed(e);
    }

    public void mousePressed(MouseEvent e){

        ColonistHandler cm = Frame.getColonistHandler();
        mouseDown = true;
        cm.checkMouseEventPressed(e);

    }

    public void mouseReleased(MouseEvent e){

        ColonistHandler cm = Frame.getColonistHandler();
        mouseDown = false;
        cm.checkMouseEventReleased(e);

    }

}
