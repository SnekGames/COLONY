package colony.physics;

import colony.handler.ColonistHandler;
import colony.handler.HandlerTracker;
import colony.minion.Colonist;

import java.util.ArrayList;

/**
 * Created by Viktor on 2017-02-22.
 */
public class Collisions {

    public Collisions() {

    }

    public void checkCollisions(HandlerTracker ht) {

        /**
         * Currently this function doesn't work well types of handlers/physical objects,
         * this needs to be addressed. Also, it doesn't handle well, what object was moving.
         * This works terribly. (Collision boxes get stuck inside each other)
         */

        ArrayList phys_objects = new ArrayList();
        ArrayList collided = new ArrayList();

        // Get all handlers, and store all their objects in phys_objects
        for (int i = 0; i < ht.getHandlerTracker().size(); i++) {

            int h_id = i;
            if (ht.getHandler(h_id) instanceof ColonistHandler) {

                ColonistHandler ch = (ColonistHandler) ht.getHandler(h_id);
                for (int k = 0; k < ch.getHandler().size(); k++) {

                    int c_id = k;
                    phys_objects.add(ch.getColonist(c_id));

                }

            }

        }

        // Detect collisions and store id:s in collided
        for (int i = 0; i < phys_objects.size(); i++) {

            if( phys_objects.get(i) instanceof Colonist ){

                // Get the object to be checked
                Colonist c_i =  (Colonist) phys_objects.get(i);

                for (int k = i+1; k < phys_objects.size(); k++) {

                    if( phys_objects.get(k) instanceof Colonist ) {

                        // Get objects to check collision with
                        Colonist c_k = (Colonist) phys_objects.get(k);

                        // Check if c_i and c_k collide

                        if((c_k.getCollisionBoundaryXmin()<c_i.getPosX() &&
                                c_i.getPosX()<c_k.getCollisionBoundaryXmax()) && (
                                c_k.getCollisionBoundaryYmin()<c_i.getPosY() &&
                                c_i.getPosY()<c_k.getCollisionBoundaryYmax())){

                            if( !(Math.round(c_i.getdx())==0 && Math.round(c_i.getdy())==0) ){
                                collided.add( c_i ); // c_i collided with c_k
                            }
                            else if( !(Math.round(c_k.getdx())==0 && Math.round(c_k.getdy())==0) ){
                                collided.add( c_k ); // c_k collided with c_i
                            }

                        }

                    }

                }

            }

        }

        for (int i = 0; i < collided.size(); i++) {

            Colonist c_i = (Colonist) collided.get(i);
            int col_id = c_i.getId();
            // Get all handlers
            for (int j = 0; j < ht.getHandlerTracker().size(); j++) {

                int h_id = j;
                if (ht.getHandler(h_id) instanceof ColonistHandler) {

                    ColonistHandler ch = (ColonistHandler) ht.getHandler(h_id);
                    Colonist c = (Colonist) ch.getColonist( col_id );

                    double dx = c.getdx();
                    double dy = c.getdy();
                    double pos_x = c.getPosX();
                    double pos_y = c.getPosY();
                    c.setPosX( pos_x - dx );
                    c.setPosY( pos_y - dy );
                    c.setdx( 0 );
                    c.setdy( 0 );

                }

            }


        }

    }

}