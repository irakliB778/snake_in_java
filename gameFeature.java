import java.awt.*;
import javax.swing.Timer;
class GameFeature {
    static final int SCREEN_WIDTH=600;
    static final int SCREEN_HEIGHT=600;
    static final int UNIT_SIZE=10;
    static final int GAME_UNITS=(SCREEN_HEIGHT*SCREEN_WIDTH)/UNIT_SIZE;
    static final int DELAY=60;
    static Graphics graphic;
    static Timer timer;

    static public void startGame(GamePanel obj){
        timer=new Timer(DELAY, obj);
        timer.start();
    };
}
