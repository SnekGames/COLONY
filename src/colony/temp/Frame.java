package colony.temp;

/**
 * Created by Viktor on 2016-11-23.
 */
public class Frame {
    private int boundary_top = 0;
    private int boundary_bottom = 0;
    private int boundary_left = 0;
    private int boundary_right = 0;
    private int pos_x = 0;
    private int pos_y = 0;
    private int frame_height;
    private int frame_width;

    public Frame(int frame_width, int frame_height){
        this.frame_width = frame_width;
        this.frame_height = frame_height;
    }

    void initFrame(){
        pos_x =  0;
        pos_y = 0;
        /** Set conceptual frame as origo, with screen dimension boundaries */
        boundary_top = pos_y + frame_height/2;
        boundary_bottom = pos_y - frame_height/2;
        boundary_right = pos_x + frame_width/2;
        boundary_left = pos_x - frame_width/2;
    }

    int getBoundary_top(){
        return boundary_top;
    }

    int getBoundary_bottom(){
        return boundary_bottom;
    }

    int getBoundary_left(){
        return boundary_left;
    }

    int getBoundary_right(){
        return boundary_right;
    }

    public void setBoundary_top(int boundary_top) {
        this.boundary_top = boundary_top;
    }

    public void setBoundary_bottom(int boundary_bottom) {
        this.boundary_bottom = boundary_bottom;
    }

    public void setBoundary_left(int boundary_left) {
        this.boundary_left = boundary_left;
    }

    public void setBoundary_right(int boundary_right) {
        this.boundary_right = boundary_right;
    }
}
