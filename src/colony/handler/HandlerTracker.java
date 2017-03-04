package colony.handler;

import colony.minion.Colonist;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Viktor on 2017-02-27.
 */
public class HandlerTracker {



    protected ArrayList obj_handlers;
    //protected ArrayList event_handler;

    public HandlerTracker(){

        obj_handlers = new ArrayList<>();
        //event_handler
    }

    // THIS VERSION WORKS
    public int addHandler(String HANDLER_TYPE){

        int id = obj_handlers.size();
        if( HANDLER_TYPE == "ColonistHandler") {
            obj_handlers.add(new ColonistHandler());
        }
        return id;
    }

    // This may look nicer but is clunky since you need to pass a
    // whole object as input
    /*public int addHandler( Object HandlerType ){
        int id = obj_handlers.size();
        if( HandlerType instanceof ColonistHandler ) {
            obj_handlers.add(new ColonistHandler());
        }
        return id;
    }*/

    public void removeHandler(int id){

        obj_handlers.remove(id);
        //System.out.println("obj_handlers size " + obj_handlers.size());
        for(int i = id; i< obj_handlers.size(); i++ ){
            /** check what instance it is? */
            //System.out.println("got here");
            if( obj_handlers.get(i) instanceof ColonistHandler ){
                ColonistHandler handler = (ColonistHandler) obj_handlers.get(i);
                handler.setId(i);

                //System.out.println(" in remove ");
            }
        }
    }

    public Object getHandler(int id  ){
        if( obj_handlers.get(id) instanceof ColonistHandler ) {
            return (ColonistHandler) obj_handlers.get(id);
        }

        else {
            System.out.println("ERROR: You tried to get a handler which has been removed. ");
            return null;
        }
    }

    public void updateAllObjects(){

        /** Get all handlers of physical objects from the tracker */
        for (int i = 0; i < obj_handlers.size(); i++) {

            int h_id = i;
            /** For the specific type of handler,
             * tell it to update all its physical objects */
            if (obj_handlers.get(h_id) instanceof ColonistHandler) {

                ColonistHandler ch = (ColonistHandler) obj_handlers.get(h_id);
                ch.updateColonists();
            }

            /** If more types of handlers are introduced, add them here.
             *
             *
             */

        }

    }

    public void checkInteractionKeyPressed( Object e ){

        for (int i = 0; i < obj_handlers.size(); i++) {

            int h_id = i; // Handler Id

            // For the specific type of handler, tell it to check its objects
            // for the key interaction event
            if (obj_handlers.get(h_id) instanceof ColonistHandler) {

                ColonistHandler c_handler = (ColonistHandler) obj_handlers.get(h_id);
                c_handler.checkInteractionKeyPressed( e );
            }

            //  If more types of handlers are introduced, add them here.
            //
            //
            //

        }
    }

    public void checkInteractionKeyReleased( Object e ){

        for (int i = 0; i < obj_handlers.size(); i++) {

            int h_id = i; // Handler Id

            // For the specific type of handler, tell it to check its objects
            // for the key interaction event
            if (obj_handlers.get(h_id) instanceof ColonistHandler) {

                ColonistHandler c_handler = (ColonistHandler) obj_handlers.get(h_id);
                c_handler.checkInteractionKeyReleased( e );
            }

            //  If more types of handlers are introduced, add them here.
            //
            //
            //

        }
    }

    public ArrayList getHandlerTracker(){ return obj_handlers; }
}
