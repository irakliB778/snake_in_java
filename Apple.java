import java.util.Random;

import java.awt.*;


public class Apple implements gameFeature {
    int appleX;
    int appleY;
    Color appleColor;
    Util util;
    public Apple(){
        util=new Util();
        
    }
    public void createColor(){
        appleColor = util.createColor();
    }
    
    public void genCoordinats(){
        this.appleX=new Random().nextInt((int)SCREEN_WIDTH/UNIT_SIZE)*UNIT_SIZE;
        this.appleY=new Random().nextInt((int)SCREEN_HEIGHT/UNIT_SIZE)*UNIT_SIZE;
    }
    
}
