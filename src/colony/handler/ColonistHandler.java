package colony.handler;

import colony.graphics.Board;
import colony.minion.Colonist;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

/**
 * Created by Viktor on 2017-02-21.
 */
public class ColonistHandler {

    protected ArrayList colonists;
    protected int id;

    public ColonistHandler(){
        colonists = new ArrayList<Colonist>();
    }

    public void addColonist(int pos_x, int pos_y){
        //int id = colonists.size(); /** Index of new colonist in handler */
        //colonists.add(new Colonist(pos_x,pos_y,id));
        int id = colonists.size(); /** Index of new colonist in handler */
        colonists.add(new Colonist(pos_x,pos_y,id));
    }

    public void removeColonist(int id){

        /*System.out.println("Before removal:");
        for( int i=0; i<colonists.size(); i++ ){
            Colonist c = (Colonist) colonists.get(i);
            System.out.println("Colonist["+i+"] id: " + c.getId());
        }*/

        colonists.remove(id);
        for( int i=id; i<colonists.size(); i++ ){
            Colonist c = (Colonist) colonists.get(i);
            c.setId(i);
        }

        /*System.out.println("After removal:");
        for( int i=0; i<colonists.size(); i++ ){
            Colonist c = (Colonist) colonists.get(i);
            System.out.println("Colonist["+i+"] id: " + c.getId());
        }*/

    }


    public Colonist getColonist(int id){
        return (Colonist) colonists.get(id);
    }

    public void updateColonists(){

        for( int i=0; i<colonists.size(); i++ ){
            Colonist c = (Colonist) colonists.get(i);
            c.updateColonist();
        }
    }

    public void drawColonists(Graphics g, Board frame){

        for( int i=0; i<colonists.size(); i++ ){

            Colonist c = (Colonist) colonists.get(i);
            if( c.isVisible() == true ) {
                g.drawImage(c.getImage(), c.getPosX() - c.getImageDimensionX() / 2,
                        c.getPosY() - c.getImageDimensionY() / 2, frame);
            }
        }
    }

        // OLD CODE
/*    public void checkMouseEventPressed(MouseEvent e){

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
    }*/

    public void setId( int id){ this.id = id; }

    public int getId(){ return this.id; }

    public void printColonists(){
        /*System.out.println("After removal:");*/
        for( int i=0; i<colonists.size(); i++ ){
            Colonist c = (Colonist) colonists.get(i);
            System.out.println("Colonist["+i+"] id: " + c.getId());
        }
    }

    public void checkInteractionKeyPressed(Object e){

        for (int i = 0; i < colonists.size(); i++) {

            int c_id = i;
            Colonist c = (Colonist) colonists.get(c_id);

            if (e instanceof KeyEvent) {
                c.keyPressed((KeyEvent) e);
            }
            if (e instanceof MouseEvent) {
                //System.out.println("in mouse event released");
                c.mkeyPressed((MouseEvent) e);
            }

            //** If more types of events are introduced, add them here.
            // *
            // *
        }
    }
    public void checkInteractionKeyReleased(Object e){

        for (int i = 0; i < colonists.size(); i++) {

            int c_id = i;
            Colonist c = (Colonist) colonists.get(c_id);

            if (e instanceof KeyEvent) {
                c.keyReleased((KeyEvent) e);
            }
            if (e instanceof MouseEvent) {
                //System.out.println("in mouse event released");
                c.mkeyReleased((MouseEvent) e);
            }

            //** If more types of events are introduced, add them here.
            // *
            // *
        }
    }

    public ArrayList getHandler(){ return colonists; }

}
