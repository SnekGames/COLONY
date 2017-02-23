package colony.minion;

import colony.tools.RNG;

/**used to be missile*/


public class Alien extends Minion {

    private final int BOARD_WIDTH = 990;
    private final double BOARD_HEIGHT = 800;
    private final double ALIEN_SPEED = 20;
    private RNG rng;
    private double direction = 0;
    private int dx = 0;
    private int dy = 0;

    public Alien(int x, int y, int id) {
        super(x, y, id);

        initAlien();
    }

    void setBehaviour(){

        direction = (double) rng.randInt(0,360);
        dx = (int)(ALIEN_SPEED*Math.cos(direction*Math.PI/180));
        dy = (int)(ALIEN_SPEED*Math.sin(direction*Math.PI/180));

    }

    public void updateColonist() {

        move();
    }

    private void initAlien() {

        loadImages("alien1_left", ".png");
        //getImageDimensions();
    }

}