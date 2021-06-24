import java.util.Random;

import java.awt.*;

;
public class Apple extends GameFeature{
    int appleX;
    int appleY;
    Util util;

    
    private int width = GameFeature.UNIT_SIZE;
    private int height = GameFeature.UNIT_SIZE;
    
    private int bounceStep = 0;
    private int bounceScale = 2;

    private Color appleColor;
    private int bounceX;
    private int bounceY;

    public Apple(){
        util=new Util();
    }

    public void paint(){
        this.bounce();
        graphic.setColor(this.appleColor);
        graphic.fillOval(this.bounceX, this.bounceY, this.width, this.height);
    };
    
    public void scaleApple(){
            this.width = this.width - bounceScale;
            this.height = this.height - bounceScale;

            this.bounceX += bounceScale/2;
            this.bounceY += bounceScale/2;
    }

    public void bounce(){
        if(bounceStep > 3 && bounceStep < 7){
            this.bounceScale *= (-1);
        }
        
        scaleApple();
        
        this.bounceStep++;

        if(bounceStep == 7){
            bounceStep=0;
        }
    }

    
    
    public void createColor(){
        appleColor = util.createColor();
    }
    
    public void genCoordinats(){
        this.bounceX = this.appleX = new Random().nextInt((int)SCREEN_WIDTH/GameFeature.UNIT_SIZE)*GameFeature.UNIT_SIZE;
        this.bounceY = this.appleY = new Random().nextInt((int)SCREEN_HEIGHT/GameFeature.UNIT_SIZE)*GameFeature.UNIT_SIZE;
    }
    
}
