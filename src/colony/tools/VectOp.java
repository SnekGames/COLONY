package colony.tools;

/**
 * Created by Viktor on 2017-02-16.
 */

import colony.application.Constants;

public class VectOp {
    /** Elementwise vector addition v2+v1 */
    public static int[] add(int [] v2, int[] v1){
        if( v2.length== Constants.DIM2D && v1.length== Constants.DIM2D ) { return new int[] { v2[0] + v1[0], v2[1] + v1[1]}; }
        if( v2.length== Constants.DIM3D && v1.length== Constants.DIM3D ) { System.out.println("Func. not implemented! "); return null; }
        else{ return null; }
    }

    /** Elementwise vector addition v2+v1 */
    public static double[] add(double [] v2, double[] v1){
        if( v2.length== Constants.DIM2D && v1.length== Constants.DIM2D ) { return new double[] { v2[0] + v1[0], v2[1] + v1[1]}; }
        if( v2.length== Constants.DIM3D && v1.length== Constants.DIM3D ) { System.out.println("Func. not implemented! "); return null; }
        else{ return null; }
    }

    /** Elementwise vector subtraction v2-v1 */
    public static int[] sub(int [] v2, int[] v1){
        if( v2.length== Constants.DIM2D && v1.length== Constants.DIM2D ) { return new int[] { v2[0] - v1[0], v2[1] - v1[1] }; }
        if( v2.length== Constants.DIM3D && v1.length== Constants.DIM3D ) { System.out.println("Func. not implemented! "); return null; }
        else{ return null; }
    }

    /** Elementwise vector subtraction v2-v1 */
    public static double[] sub(double [] v2, double[] v1){
        if( v2.length== Constants.DIM2D && v1.length== Constants.DIM2D ) { return new double[] { v2[0] - v1[0], v2[1] - v1[1] }; }
        if( v2.length== Constants.DIM3D && v1.length== Constants.DIM3D ) { System.out.println("Func. not implemented! "); return null; }
        else{ return null; }
    }

    /** Print a vector */
    public static int print(int [] v, String var_name){
        if( v.length== Constants.DIM2D ) {
            System.out.println( var_name + ": " );
            System.out.println( "[0]: " + v[0] );
            System.out.println( "[1]: " + v[1] );
            return 0;
        }
        if( v.length== Constants.DIM3D  ) { System.out.println("Func. not implemented! "); return -1; }
        else{ return -1; }
    }

    /** Print a vector */
    public static int print(double [] v, String var_name){
        if( v.length== Constants.DIM2D ) {
            System.out.println( var_name + ": " );
            System.out.println( "[0]: " + v[0] );
            System.out.println( "[1]: " + v[1] );
            return 0;
        }
        if( v.length== Constants.DIM3D  ) { System.out.println("Func. not implemented! "); return -1; }
        else{ return -1; }
    }

    /** Return norm of vector */
    public static double norm( int [] v ){
        if( v.length== Constants.DIM2D ) {
            //System.out.println(" v[0] " + v[0] + " v[1] " + v[1]);
            //System.out.println(" v[0]^2 " + Math.pow(v[0],2) + " v[1]^2 " + Math.pow(v[1],2));
            //System.out.println(" norm Math.sqrt(v[0]^2 + v[1]^2) " + Math.pow(v[0],2) + Math.pow(v[1],2) );
            return Math.sqrt( Math.pow(v[0],2) + Math.pow(v[1],2) );
        }
        if( v.length== Constants.DIM3D  ) {
            System.out.println("Func. not implemented! ");
            return -1; }
        else{ return -1; }
    }

    /** Return norm of vector */
    public static double norm( double [] v ){
        if( v.length== Constants.DIM2D ) {
            //System.out.println("v[0] " + v[0] + " v[1] " + v[1]);
            //System.out.println("v[0]^2 " + Math.pow(v[0],2) + " v[1]^2 " + Math.pow(v[1],2));
            return Math.sqrt( Math.pow(v[0],2) + Math.pow(v[1],2) );
        }
        if( v.length== Constants.DIM3D  ) {
            System.out.println("Func. not implemented! ");
            return -1; }
        else{ return -1; }
    }

    /** Return normalised vector */
    public static double [] normalise( int [] v ){
        //System.out.println("v " + VectOp.norm(v));
        if(Math.round(VectOp.norm(v)) == 0){
            return new double[] {0,0};
        }
        if( v.length== Constants.DIM2D ) {
            return new double[] { v[0]/norm(v), v[1]/norm(v) };
        }
        if( v.length== Constants.DIM3D  ) {
            System.out.println("Func. not implemented! ");
            return null; }
        else{ return null; }
    }

    /** Return normalised vector */
    public static double [] normalise( double [] v ){
        //System.out.println("v " + VectOp.norm(v));
        if(Math.round(VectOp.norm(v)) == 0){
            return new double[] {0,0};
        }
        if( v.length== Constants.DIM2D ) {
            return new double[] { v[0]/norm(v), v[1]/norm(v) };
        }
        if( v.length== Constants.DIM3D  ) {
            System.out.println("Func. not implemented! ");
            return null; }
        else{ return null; }
    }

}
