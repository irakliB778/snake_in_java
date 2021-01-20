import java.util.Random;
import java.awt.*;
public class Util extends GameFeature {
   public Color createColor(){
        int red=new Random().nextInt((int)255);
        int green=new Random().nextInt((int)255);
        int blue=new Random().nextInt((int)255);

        return new Color(red,green,blue);
    }
    public void drawLine(){
        for(int i=0; i<SCREEN_HEIGHT/UNIT_SIZE;i++){
            graphic.drawLine(i*UNIT_SIZE, 0, i*UNIT_SIZE, SCREEN_HEIGHT);
            graphic.drawLine(0, i*UNIT_SIZE, SCREEN_WIDTH, i*UNIT_SIZE);
            graphic.setColor(Color.CYAN);
        }
    }
}
