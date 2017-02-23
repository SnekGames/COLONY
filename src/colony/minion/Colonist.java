package colony.minion;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Colonist extends Minion {
    private ArrayList missiles;
    private boolean selected;

    public void updateColonist() {
        move();
        updateImage();
        updateDirection();
        updateCollisionBoundary();
    }

    public Colonist(int x, int y, int id) {
        super(x, y, id);
        selected = false;
        loadImages("colonist", ".png");
        asset_dir = "/assets/colonist/";
        //getImageDimensions();
    }

    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_SPACE) {
            //fire();
        }

        if (key == KeyEvent.VK_LEFT) {
            dx = -1;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 1;
        }

        if (key == KeyEvent.VK_UP) {
            dy = -1;
        }

        if (key == KeyEvent.VK_DOWN) {
            dy = 1;
        }
    }

    public void keyReleased(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_UP) {
            dy = 0;
        }

        if (key == KeyEvent.VK_DOWN) {
            dy = 0;
        }
    }

    @Override
    public void mkeyPressed(MouseEvent e) {
    }

    @Override
    public void mkeyReleased(MouseEvent e) {
        int key = e.getButton();
        if( key == 1 /**Left mouse click*/) {
            if ((collision_boundary_xmin < e.getX() && e.getX() < collision_boundary_xmax) &&
                    collision_boundary_ymin < e.getY() && e.getY() < collision_boundary_ymax) {
                selected = true;
                //image = im_right; //to test selection
            } else {
                selected = false;
                //image = im_left; //to test selection
            }
        }

        if( key == 3 && selected ){
            /** Set new destination
             * and direction to get
             * there */
            setDestination( (double) e.getX(), (double) e.getY() );
        }
    }
}