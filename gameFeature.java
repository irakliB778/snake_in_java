public interface gameFeature {
    static final int SCREEN_WIDTH=600;
    static final int SCREEN_HEIGHT=600;
    static final int UNIT_SIZE=15;
    static final int GAME_UNITS=(SCREEN_HEIGHT*SCREEN_WIDTH)/UNIT_SIZE;
    static final int DELAY=100;
    final int x[]=new int[GAME_UNITS];
    final int y[]=new int[GAME_UNITS];
    //int bodyParts=6;
}
