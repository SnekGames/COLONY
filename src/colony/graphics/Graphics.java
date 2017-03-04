package colony.graphics;


import colony.handler.ColonistHandler;
import colony.handler.HandlerTracker;
import colony.minion.Colonist;

import java.awt.*;

/**
 * Created by Viktor on 2017-02-22.
 */
public class Graphics {
    public Graphics() {

    }

    public void drawPhysicalObjects(HandlerTracker ht, java.awt.Graphics g, Board board) {

        //Graphics2D g2d = (Graphics2D) g;

        /** Loop through the list of handlers of different physical objects */
        for (int i = 0; i < ht.getHandlerTracker().size(); i++) {

            int id = i;
            /** For the specific type of handler, tell it to draw its physical objects
             *  on the board */
            if (ht.getHandler(id) instanceof ColonistHandler) {

                ColonistHandler c_handler = (ColonistHandler) ht.getHandler(id);
                c_handler.drawColonists(g, board);

            }


            /** If more types of handlers are introduced, add them here.
             *
             *
             *
             */

        }
    }

}