package colony.graphics;

import colony.handler.ColonistHandler;
import colony.handler.EventHandler;
import colony.minion.Alien;
import colony.minion.Colonist;

import java.awt.*;
import java.awt.Graphics;
import java.awt.event.*;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Frame extends JPanel implements ActionListener {
    private int screen_height;
    private int screen_width;
    private final int ICOLONIST_X = 40;
    private final int ICOLONIST_Y = 60;
    private final int DELAY = 10;
    private Timer timer;
    private Alien alien;
    public colony.temp.Frame frame;
    private boolean mouseDown = false;

    /**TEMP FOR TESTING:*/
    //private Colonist colonist;
    private static ColonistHandler colonist_handler; // THIS MIGHT NEED TO BE HERE LATER (DEPENDS ON DESIGN)
    private EventHandler event_handler; // THIS MIGHT NEED TO BE HERE LATER (DEPENDS ON DESIGN)
    private colony.graphics.Graphics gx;

    public Frame(int x, int y) {
        this.screen_width = x;
        this.screen_height = y;
        initFrame();
    }

    private void initFrame() {

        event_handler = new EventHandler();
        colonist_handler = new ColonistHandler();
        gx = new colony.graphics.Graphics();

        addKeyListener(new TAdapter());
        addMouseListener(new MAdapter());
        setFocusable(true);
        setBackground(Color.BLACK);
        setDoubleBuffered(true);

        //this.colonist = new Colonist(200,200, 10); /** OLD WAY OF CREATING COLONIST, REMOVE LATER */

        /** Test adding a couple of colonists */
        colonist_handler.addColonist(400,400);
        colonist_handler.addColonist(650,350);
        colonist_handler.addColonist(850,950);
        colonist_handler.addColonist(550,750);

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

        Graphics2D g2d = (Graphics2D) g;
        colonist_handler.drawColonists(g, this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        /** Timer interrupt, update and redraw
         * everything!
         */

        //colonist.updateColonist();
        colonist_handler.updateColonists();
        repaint();
    }

    private class TAdapter extends KeyAdapter {
        @Override
        public void keyReleased(KeyEvent e) {
            event_handler.keyReleased(e);
            //colonist.keyReleased(e);
        }

        @Override
        public void keyPressed(KeyEvent e) {
            event_handler.keyPressed(e);
            //colonist.keyPressed(e);
        }
    }

    private class MAdapter extends MouseAdapter{
        // Check all clickable objects if clicked
        public void mousePressed(MouseEvent e){
            /*mouseDown = true;
            colonist.mkeyPressed(e);*/
            //System.out.println("Printed in board");
            event_handler.mousePressed(e);
        }
        public void mouseReleased(MouseEvent e){
            /*mouseDown = false;
            colonist.mkeyReleased(e);*/
            event_handler.mouseReleased(e);
        }
    }


    public static ColonistHandler getColonistHandler(){
        return colonist_handler;
    }

}