import javax.swing.JPanel;


import java.awt.event.*;
import java.awt.*;
import java.util.Random;

public class GamePanel extends JPanel implements ActionListener {
    // static final int SCREEN_WIDTH=600;
    // static final int SCREEN_HEIGHT=600;
    // static final int gameFeature.UNIT_SIZE=15;
    // static final int GAME_UNITS=(SCREEN_HEIGHT*SCREEN_WIDTH)/gameFeature.UNIT_SIZE;
    // static final int DELAY=80;
    // final int x[]=new int[GAME_UNITS];
    // final int y[]=new int[GAME_UNITS];
    
    char direction;
    Random random;
    boolean running=false;
    Apple apple;
    Tail tail;
    TailBlock head;
    Score score;
    GamePanel(){
        random=new Random();
        this.setPreferredSize(new Dimension(GameFeature.SCREEN_WIDTH,GameFeature.SCREEN_HEIGHT));
        this.setBackground(Color.black);
        this.setFocusable(true);
        this.addKeyListener(new MyKeyAdapter());
        initGame();
    }
    public void initGame(){
        tail = new Tail();
        apple = new Apple();
        score = new Score();

        newApple();

        tail.createInitialTail();
        head=tail.getBlock(0);

        direction = 'R';
        running=true;
        GameFeature.startGame(this);
        move();
    }
    public void paintComponent(Graphics graphicEngine){
        // Init graphic for the game
        GameFeature.graphic = graphicEngine;
        
        super.paintComponent(GameFeature.graphic);
        draw();

    }

    public void draw(){
        if(running){
            score.paint();

            apple.paint();

            tail.paint();
    
        } else {
            new GameOver();
        }
    }
    public void move(){
        // for(int i=bodyParts;i>0;i--){
        //     x[i]=x[i-1];
        //     y[i]=y[i-1];
        // }
        tail.updateTail();
        switch(direction){
            case 'U': head.y = head.y-GameFeature.UNIT_SIZE;
            break;
            case 'D': head.y = head.y+GameFeature.UNIT_SIZE;
            break;
            case 'R': head.x = head.x+GameFeature.UNIT_SIZE;
            break;
            case 'L':head.x = head.x-GameFeature.UNIT_SIZE;
            break;
        }

    }
    public void newApple(){
        apple.genCoordinats();
    }

    public void checkApple(){
        if((head.x==apple.appleX)&& head.y==apple.appleY){
            newApple();
            tail.addBlock();
            score.value++;
        }

    }
    public void checkColision(){
        for(int i=tail.getTailLength();i>0;i--){
            TailBlock block=tail.getBlock(i);
            if((head.x==block.x) && (head.y==block.y)){
                running=false;
            }
        }
        if(head.x>=GameFeature.SCREEN_WIDTH){
            running=false;

            
        }
        if(head.x < 0){
            running=false;

            
        }
        if(head.y>=GameFeature.SCREEN_HEIGHT){
            running=false;
            
            
        }
        if(head.y < 0){
            running=false;
        
        }
        if(!running){
            GameFeature.timer.stop();
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if(running){
            move();
            checkApple();
            checkColision();
            apple.createColor();
            tail.blinkColor();
        }
        repaint();

    }
    public class MyKeyAdapter extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e){
            switch(e.getKeyCode()){
                case KeyEvent.VK_LEFT:
                    if(direction!='R'){
                        direction='L';
                    }
                    break;
                case KeyEvent.VK_RIGHT:
                    if(direction!='L'){
                        direction='R';
                    }
                    break;
                case KeyEvent.VK_UP:
                    if(direction!='D'){
                        direction='U';
                    }
                    break;
                case KeyEvent.VK_DOWN:
                    if(direction!='U'){
                        direction='D';
                    }
                    break;
                case KeyEvent.VK_F:
                    if(running == false){
                        running = true;
                        initGame();
                    }
                    break;
            }
        }
    }

}