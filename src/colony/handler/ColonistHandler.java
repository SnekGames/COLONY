package colony.handler;

import colony.minion.Colonist;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

/**
 * Created by Viktor on 2017-02-21.
 */
public class ColonistHandler extends MinionHandler {

    protected ArrayList colonists;

    public ColonistHandler(){
        colonists = new ArrayList<Colonist>();
    }

    public void addColonist(int pos_x, int pos_y){
        //int id = colonists.size(); /** Index of new colonist in handler */
        //colonists.add(new Colonist(pos_x,pos_y,id));
        int id = colonists.size(); /** Index of new colonist in handler */
        colonists.add(new Colonist(pos_x,pos_y,id));
    }

    /*public Colonist getColonist(int id){
        return (Colonist) colonists.get(id);
    }*/

    public Colonist getColonist(int id){
        return (Colonist) colonists.get(id);
    }

    public void updateColonists(){

        for( int i=0; i<colonists.size(); i++ ){
            Colonist c = (Colonist) colonists.get(i);
            c.updateColonist();
        }
    }

    public void drawColonists(Graphics g, colony.graphics.Frame frame){

        for( int i=0; i<colonists.size(); i++ ){

            Colonist c = (Colonist) colonists.get(i);
            if( c.isVisible() == true ) {
                g.drawImage(c.getImage(), c.getPosX() - c.getImageDimensionX() / 2,
                        c.getPosY() - c.getImageDimensionY() / 2, frame);
            }
        }
    }

    public void checkMouseEventPressed(MouseEvent e){

        for( int i=0; i<colonists.size(); i++ ){
            Colonist c = (Colonist) colonists.get(i);
            c.mkeyPressed(e);
        }
    }

    public void checkMouseEventReleased(MouseEvent e){
        for( int i=0; i<colonists.size(); i++ ){
            Colonist c = (Colonist) colonists.get(i);
            c.mkeyReleased(e);
        }
    }

    public void checkKeyEventPressed(KeyEvent e){
        for( int i=0; i<colonists.size(); i++ ){
            Colonist c = (Colonist) colonists.get(i);
            c.keyPressed(e);
        }
    }

    public void checkKeyEventReleased(KeyEvent e){
        for( int i=0; i<colonists.size(); i++ ){
            Colonist c = (Colonist) colonists.get(i);
            c.keyReleased(e);
        }
    }
}
