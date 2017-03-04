package colony.minion;

import colony.application.Constants;
import colony.temp.State;
import colony.tools.VectOp;

import java.awt.Image;
import java.awt.event.MouseEvent;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.swing.ImageIcon;

/**used to be sprite*/
public class Minion {
    protected class MinionConstants {
        static final int MINIONSPEED = 3;
    }

    protected State state =  new State("IDLE");
    protected String asset_dir;
    protected int id; /** Id represents (unique) position in the handler */
    protected int speed = MinionConstants.MINIONSPEED;
    protected double pos_x;
    protected double pos_y;
    protected double dest_x;
    protected double dest_y;
    //protected double[] dest = new double[Constants.DIM2D];
    //protected double[] pos = new double[Constants.DIM2D];
    protected double dx;
    protected double dy;
    protected double collision_boundary_xmin;
    protected double collision_boundary_xmax;
    protected double collision_boundary_ymin;
    protected double collision_boundary_ymax;
    protected boolean selected;
    protected boolean vis;
    protected Image image;
    protected Image im_left;
    protected Image im_right;
    protected Image im_up;
    protected Image im_down;
    protected Image im_up_left;
    protected Image im_up_right;
    protected Image im_down_left;
    protected Image im_down_right;

    public Minion(int x, int y, int id) {
        setPosition(x,y);
        setDestination(x,y);
        updateDirection();

        this.id = id;
        vis = true;
        selected = false;
    }

    ///** Distance between x2 and x1 */
    //int calcDistance(int x1, int x2){ return x2-x1; }

    public void move() {
        pos_x += dx*speed;
        pos_y += dy*speed;
        //pos[0] += dx*speed;
        //pos[1] += dy*speed;

        /** Stop moving if destination reached.
         * Step dx = dt*speed will end inside the interval */
        if( dest_x - (speed/2+1) <= pos_x &&
                pos_x <= dest_x + (speed/2+1)
                &&
                dest_y - (speed/2+1) <= pos_y &&
                pos_y <= dest_y + (speed/2+1) ){
            dx = 0;
            dy = 0;
            dest_x = pos_x;
            dest_y = pos_y;
            //dest[0] = pos_x;
            //dest[1] = pos_y;
        }
    }

    protected void updateImage(){
        /** Change image in the direction of movement*/
        if( !(dy == 0 && dx == 0) ){

            /*if( dy == 0 && dx>0 ){image = im_right;}
            if( dy == 0 && dx<0 ){image = im_left;}
            if( dx == 0 && dy<0 ){image = im_up; }
            if( dx == 0 && dy>0 ){image = im_down; }

            if( dy<0 && dx>0 ){image = im_up_right;}
            if( dy<0 && dx<0 ){image = im_up_left;}
            if( dy>0 && dx>0 ){image = im_down_right;}
            if( dy>0 && dx<0 ){image = im_down_left;}*/

            // Better solution
            double theta = Math.acos(dx/(Math.sqrt(Math.pow(dx,2)+Math.pow(dy,2))));

            if( dy <= 0 ) {

                if ( 0 <= theta && theta < Math.PI / 8 ){ image = im_right; }

                if (Math.PI / 8 <= theta && theta < 3 * Math.PI / 8){ image = im_up_right; }

                if( 3*Math.PI/8 <= theta && theta < 5*Math.PI / 8){ image = im_up; }

                if( 5*Math.PI/8 <= theta && theta < 7*Math.PI/8 ){ image = im_up_left; }

                if( 7*Math.PI/8 <= theta && theta < Math.PI){image = im_left;}

            }

            if( 0 < dy ) {

                if ( 0 <= theta && theta < Math.PI / 8 ){ image = im_right; }

                if (Math.PI / 8 <= theta && theta < 3 * Math.PI / 8){ image = im_down_right; }

                if( 3*Math.PI/8 <= theta && theta < 5*Math.PI / 8){ image = im_down; }

                if( 5*Math.PI/8 <= theta && theta < 7*Math.PI/8 ){ image = im_down_left; }

                if( 7*Math.PI/8 <= theta && theta < Math.PI){image = im_left;}
            }

        }

    }

    void updateCollisionBoundary(){
        collision_boundary_xmin = pos_x - getImageDimensionX()/2;
        collision_boundary_xmax = pos_x + getImageDimensionX()/2;
        collision_boundary_ymin = pos_y - getImageDimensionY()/2;
        collision_boundary_ymax = pos_y + getImageDimensionY()/2;
    }

    protected void loadImages(String id, String extension) {

        Path curRelPath = Paths.get("");
        String project_dir = curRelPath.toAbsolutePath().toString();
        String im_path = project_dir + "/assets/colonist/";

        ImageIcon ii = new ImageIcon(im_path + id + "_left" + extension);
        im_left = ii.getImage();
        ii = new ImageIcon(im_path + id + "_right" + extension);
        im_right = ii.getImage();
        ii = new ImageIcon(im_path + id + "_down" + extension);
        im_down = ii.getImage();
        ii = new ImageIcon(im_path + id + "_up" + extension);
        im_up = ii.getImage();
        ii = new ImageIcon(im_path + id + "_down_left" + extension);
        im_down_left = ii.getImage();
        ii = new ImageIcon(im_path + id + "_down_right" + extension);
        im_down_right = ii.getImage();
        ii = new ImageIcon(im_path + id + "_up_left" + extension);
        im_up_left = ii.getImage();
        ii = new ImageIcon(im_path + id + "_up_right" + extension);
        im_up_right = ii.getImage();

        image = im_right;
    }

    public int getImageDimensionX() {
        return image.getWidth(null);
    }

    public int getImageDimensionY() {
        return image.getHeight(null);
    }

    public Image getImage() {
        return image;
    }

    public int getPosX() { return (int) Math.round( pos_x ); }

    public int getPosY() { return (int) Math.round( pos_y ); }

    public void setPosX(double pos_x) { this.pos_x=pos_x; }

    public void setPosY(double pos_y) { this.pos_y=pos_y; }

    public void setdx( int dx ){ this.dx = dx; }

    public void setdy( int dy ){ this.dy = dy; }

    public double getdx(){ return dx; }

    public double getdy(){ return dy; }

    public int getId() { return id; }

    public void setId( int id ) { this.id = id; }

    public boolean isVisible() {
        return vis;
    }

    public void setVisible(Boolean visible) {
        vis = visible;
    }

    public void mkeyPressed(MouseEvent e) {

    }

    public void mkeyReleased(MouseEvent e) {
        if((collision_boundary_xmin<e.getX() && e.getX()<collision_boundary_xmax) &&
                collision_boundary_ymin<e.getY() && e.getY()<collision_boundary_ymax){
            selected = true;
            //image = im_right; //to test selection
        }
        else{
            selected = false;
            //image = im_left; //to test selection
        }
    }

    public void setDestination ( int dest_x, int dest_y ){
        this.dest_x = dest_x; this.dest_y =  dest_y;
        //this.dest[0] = dest_x; this.dest[1] = dest_y;
    }

    public void setDestination ( double dest_x, double dest_y ){
        this.dest_x = dest_x; this.dest_y = dest_y;
        //this.dest[0] = dest_x; this.dest[1] = dest_y;
    }

    public void setPosition ( int pos_x, int pos_y ){
        this.pos_x = (double) pos_x; this.pos_y = (double) pos_y;
        //this.pos[0] = (double) pos_x; this.pos[1] = (double) pos_y;
    }

    public void setPosition ( double pos_x, double pos_y ){
        this.pos_x = pos_x; this.pos_y = pos_y;
        //this.pos[0] = pos_x; this.pos[1] = pos_y;
    }

    public void updateDirection(){
        double [] pos = new double[] {pos_x,pos_y};
        double [] dest = new double[] {dest_x,dest_y};
        double [] direction = VectOp.normalise(VectOp.sub(dest,pos));
        this.dx = direction[0];
        this.dy = direction[1];
    }

    public double getCollisionBoundaryXmin(){return collision_boundary_xmin;}
    public double getCollisionBoundaryYmin(){return collision_boundary_ymin;}
    public double getCollisionBoundaryXmax(){return collision_boundary_xmax;}
    public double getCollisionBoundaryYmax(){return collision_boundary_ymax;}
}