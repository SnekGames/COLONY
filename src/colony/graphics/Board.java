package colony.graphics;

import colony.handler.ColonistHandler;
import colony.application.Events;
import colony.handler.HandlerTracker;
import colony.physics.Collisions;

import java.awt.*;
import java.awt.Graphics;
import java.awt.event.*;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel implements ActionListener {
    private int screen_height;
    private int screen_width;
    //private final int ICOLONIST_X = 40;
    //private final int ICOLONIST_Y = 60;
    private final int DELAY = 10;
    private Timer timer;
    //private Alien alien;
    public colony.temp.Frame frame;
    //private boolean mouseDown = false;
    public HandlerTracker ht;
    private Events events; // THIS MIGHT NEED TO BE HERE LATER (DEPENDS ON DESIGN)

    /**TEMP FOR TESTING:*/
    //private Colonist colonist;
    private static ColonistHandler colonist_handler; // THIS MIGHT NEED TO BE HERE LATER (DEPENDS ON DESIGN)

    private colony.graphics.Graphics gx;
    private Collisions col;

    public Board(int x, int y) {
        this.screen_width = x;
        this.screen_height = y;
        initFrame();
    }

    private void initFrame() {

        events = new Events();
        colonist_handler = new ColonistHandler();
        gx = new colony.graphics.Graphics();
        col = new Collisions();
        ht = new HandlerTracker();

        addKeyListener(new TAdapter());
        addMouseListener(new MAdapter());
        setFocusable(true);
        setBackground(Color.BLACK);
        setDoubleBuffered(true);


        int id1 = ht.addHandler( "ColonistHandler" );
        int id2 = ht.addHandler( "ColonistHandler" );

        ColonistHandler c_handle1 = (ColonistHandler) ht.getHandler(id1);
        ColonistHandler c_handle2 = (ColonistHandler) ht.getHandler(id2);

        c_handle1.addColonist(200,300); c_handle1.addColonist(200,370);
        c_handle2.addColonist(700,300); c_handle2.addColonist(700,370);
        //c_handle1.printColonists(); c_handle2.printColonists();
        //ht.removeHandler(id2);





        // OLD CODE BELOW
        //this.colonist = new Colonist(200,200, 10); /** OLD WAY OF CREATING COLONIST, REMOVE LATER */

        //int handler1_id = ht.addHandler("ColonistHandler");
        //int handler2_id = ht.addHandler("ColonistHandler");
        //ht.addHandler("ColonistHandler");

        //ColonistHandler handler1 = (ColonistHandler) ht.getHandler( handler1_id );
        //ColonistHandler handler2 = (ColonistHandler) ht.getHandler( handler2_id );
        //ColonistHandler handler3 = (ColonistHandler) ht.getHandler( handler3_id );


        /** Test adding a couple of colonists */
        //handler1.addColonist(400,400);
        //handler1.addColonist(650,350);
        //handler1.addColonist(850,950);
        //handler2.addColonist(550,750);
        /*colonist_handler.addColonist(400,400);
        colonist_handler.addColonist(650,350);
        colonist_handler.addColonist(850,950);
        colonist_handler.addColonist(550,750);*/

        //ht.removeHandler(1);

        //handler1.printColonists();
        //handler2.printColonists();

        /*colonist_handler.removeColonist(2);
        colonist_handler.removeColonist(0);
        colonist_handler.removeColonist(0);
        colonist_handler.removeColonist(0);*/



        timer = new Timer(DELAY, this);
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawFrame(g);
        Toolkit.getDefaultToolkit().sync();
    }

    private void drawFrame(Graphics g) {

        /** Draw physical objects in all handlers in HandlerTracker,
         * with the graphics g, on this board.
         */
        gx.drawPhysicalObjects(ht, g, this  );

        //Graphics2D g2d = (Graphics2D) g;
        //colonist_handler.drawColonists(g, this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        /** Timer interrupt, update and redraw
         * everything!
         */

        //colonist.updateColonist();
        //colonist_handler.updateColonists();
        ht.updateAllObjects(); /** Update all physical objects */
        col.checkCollisions(ht);
        repaint();
    }


    private class TAdapter extends KeyAdapter {
        @Override
        public void keyReleased(KeyEvent e) {
            //events.keyReleased(e);
            //colonist.keyReleased(e);
            events.checkInteractionKeyReleased(ht,e);
        }

        @Override
        public void keyPressed(KeyEvent e) {
            //events.keyPressed(e);
            //colonist.keyPressed(e);
            events.checkInteractionKeyPressed(ht,e);
        }
    }

    private class MAdapter extends MouseAdapter{
        // Check all clickable objects if clicked
        public void mousePressed(MouseEvent e){
            /*mouseDown = true;
            colonist.mkeyPressed(e);*/
            //System.out.println("Printed in board");
            //events.mousePressed(e);
            events.checkInteractionKeyPressed( ht, e );
        }
        public void mouseReleased(MouseEvent e){
            /*mouseDown = false;
            colonist.mkeyReleased(e);*/
            //events.mouseReleased(e);
            events.checkInteractionKeyReleased( ht, e );
        }
    }

    /** Objects need to be able to get the obj_handlers, to operate on them */
    public static ColonistHandler getColonistHandler(){
        return colonist_handler;
    }

}