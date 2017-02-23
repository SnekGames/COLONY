package colony.temp;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Created by Viktor on 2016-11-23.
 */
public class State {

    /** Minions can have more than two feelings at once*/
    private ArrayList states;

    public State(String str){
        states = new ArrayList();
        states.add(str);
    }

    /** Returns -1 if state is not found */
    int findState(String str){
        int i = 0;

        for (i = 0; i < states.size(); i++) {
            if(Objects.equals(str, states.get(i))){
                return i;
            }
        }
        /** Could not find the state */
        return -1;
    }

    public void removeState(int i ){

            states.remove(i);
    }

    public void addState(String str){

    }

    public ArrayList getStates(){
        return states;
    }
}
