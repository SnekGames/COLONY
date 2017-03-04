package colony.application;

import colony.graphics.Board;
import colony.handler.ColonistHandler;
import colony.handler.HandlerTracker;
import colony.minion.Colonist;

import java.awt.event.*;

//import static com.sun.java.accessibility.util.AWTEventMonitor.addKeyListener;
//import static com.sun.java.accessibility.util.AWTEventMonitor.addMouseListener;

/**
 * Created by Viktor on 2017-02-22.
 *
 *  Class checks interrupt events (e.g. keys) with all objects, to se what was clicked on.
 *
 */


public class Events {

    public Events(){

    }

    public void checkInteractionKeyPressed( HandlerTracker ht, Object e ) {
        ht.checkInteractionKeyPressed( e );
    }

    public void checkInteractionKeyReleased( HandlerTracker ht, Object e ) {
        ht.checkInteractionKeyReleased( e );
    }


/*    // THESE WORK, CALL THEM FROM TA/MA ADAPTER IN BOARD WITH
    // events.checkInteractionKeyPressed(ht,e);
public void checkInteractionKeyPressed( HandlerTracker ht, Object e ){

    for (int i = 0; i < ht.getHandlerTracker().size(); i++) {

        int h_id = i;
        // For the specific type of handler, tell it to check its objects
        // for interaction event
        if (ht.getHandler(h_id) instanceof ColonistHandler) {

            ColonistHandler c_handler = (ColonistHandler) ht.getHandler(h_id);
            c_handler.checkInteractionKeyPressed( e );
        }
    }
}

    public void checkInteractionKeyReleased( HandlerTracker ht, Object e ){

        for (int i = 0; i < ht.getHandlerTracker().size(); i++) {

            int h_id = i;
            // For the specific type of handler, tell it to check its objects
            // for interaction event
            if (ht.getHandler(h_id) instanceof ColonistHandler) {

                ColonistHandler c_handler = (ColonistHandler) ht.getHandler(h_id);
                c_handler.checkInteractionKeyReleased( e );
            }
        }
    }
*/
/*    // THESE WORK, CALL THEM FROM TA/MA ADAPTER IN BOARD WITH
    // events.checkInteractionKeyPressed(ht,e);
    public void checkInteractionKeyPressed(HandlerTracker ht, Object e ){


        // Get all handlers of physical objects from the tracker
        for (int i = 0; i < ht.getHandlerTracker().size(); i++) {

            int h_id = i;
            // For the specific type of handler, get its objects
            if (ht.getHandler(h_id) instanceof ColonistHandler) {

                ColonistHandler c_handler = (ColonistHandler) ht.getHandler(h_id);
                //  Get all objects and check if key/mouse key pressed has
                //  interacted with them
                for (int k = 0; k < c_handler.getHandler().size(); k++) {

                    int c_id = k;
                    Colonist c = c_handler.getColonist(c_id);

                    if( e instanceof KeyEvent ){
                        c.keyPressed( (KeyEvent) e );
                    }
                    if( e instanceof MouseEvent ){
                        c.mkeyPressed( (MouseEvent) e );
                        //System.out.println("e " + e);
                    }

                    // * If more types of events are introduced, add them here .
                    // *
                    // *
                    //

                }

            }

            // * If more types of handlers are introduced, add them here.
            // *
            // *
            // *
            //

        }

    }

    public void checkInteractionKeyReleased(HandlerTracker ht, Object e ){

        // Get all handlers of physical objects from the tracker
        for (int i = 0; i < ht.getHandlerTracker().size(); i++) {

            int h_id = i;
            // For the specific type of handler, get its objects
            if (ht.getHandler(h_id) instanceof ColonistHandler) {

                ColonistHandler c_handler = (ColonistHandler) ht.getHandler(h_id);
                // Get all objects and check if key/mouse key pressed has
                // interacted with them
                for (int k = 0; k < c_handler.getHandler().size(); k++) {

                    int c_id = k;
                    Colonist c = c_handler.getColonist(c_id);

                    if( e instanceof KeyEvent ){
                        c.keyReleased( (KeyEvent) e );
                    }
                    if( e instanceof MouseEvent ){
                        //System.out.println("in mouse event released");
                        c.mkeyReleased( (MouseEvent) e );
                    }

                    //** If more types of events are introduced, add them here.
                    // *
                    // *
                    // *

                }

            }

            // * If more types of handlers are introduced, add them here.
            // *
            // *
            // *
            //

        }

    }
*/



    // OLD FUNCTIONS
    /*public void keyReleased(KeyEvent e) {
        //colonist.keyReleased(e);
    }

    public void keyPressed(KeyEvent e) {
        //colonist.keyPressed(e);
    }

    public void mousePressed(MouseEvent e){

        ColonistHandler cm = Board.getColonistHandler();
        mouseDown = true;
        cm.checkMouseEventPressed(e);

    }

    public void mouseReleased(MouseEvent e){

        ColonistHandler cm = Board.getColonistHandler();
        mouseDown = false;
        cm.checkMouseEventReleased(e);

    }*/

}
