import javax.swing.JPanel;

import javax.swing.JPanel;

import java.awt.event.*;
import java.awt.*;
import java.util.Random;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, gameFeature {
    // static final int SCREEN_WIDTH=600;
    // static final int SCREEN_HEIGHT=600;
    // static final int UNIT_SIZE=15;
    // static final int GAME_UNITS=(SCREEN_HEIGHT*SCREEN_WIDTH)/UNIT_SIZE;
    // static final int DELAY=80;
    // final int x[]=new int[GAME_UNITS];
    // final int y[]=new int[GAME_UNITS];
    
    int applesEaten=0;
    int appleX;
    int appleY;
    char direction='R';
    Timer timer;
    Random random;
    boolean running=false;
    Apple apple=new Apple();
    tail newTail= new tail();
    TailBlock head;
    GamePanel(){
        random=new Random();
        apple=new Apple();
        this.setPreferredSize(new Dimension(SCREEN_WIDTH,SCREEN_HEIGHT));
        this.setBackground(Color.black);
        this.setFocusable(true);
        this.addKeyListener(new MyKeyAdapter());
        startGame();
    }
    public void startGame(){
        
        newApple();
        newTail.createInitialTail();
        head=newTail.tailBody.get(0);
        running=true;
        timer=new javax.swing.Timer(DELAY, this);
        timer.start();
        move();
        
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        draw(g);

    }
    public void draw(Graphics g){
        // for(int i=0; i<SCREEN_HEIGHT/UNIT_SIZE;i++){
        //     g.drawLine(i*UNIT_SIZE, 0, i*UNIT_SIZE, SCREEN_HEIGHT);
        //     g.drawLine(0, i*UNIT_SIZE, SCREEN_WIDTH, i*UNIT_SIZE);
        //     g.setColor(Color.CYAN);
        // }
        if(running){
            g.setColor(Color.CYAN);
            g.setFont(new Font("Italic",Font.BOLD,20));
            g.drawString("score "+applesEaten, 250, 30);

            g.setColor(apple.appleColor);
            g.fillOval(apple.appleX, apple.appleY, UNIT_SIZE, UNIT_SIZE);
    
            for(int i=0;i<newTail.getTailLength();i++){
                TailBlock block=newTail.getBlock(i);
                if(i==0){
                    g.setColor(Color.green);
                    g.fillRect(block.x, block.y, UNIT_SIZE, UNIT_SIZE);
                    // System.out.println(x[i]);
                    // System.out.println(y[i]);
                }else{
                    g.setColor(block.color);
                    g.fillRect(block.x, block.y, UNIT_SIZE, UNIT_SIZE);
                }
            }
        }else{
            gameOver(g);
        }

        

    }
    public void move(){
        // for(int i=bodyParts;i>0;i--){
        //     x[i]=x[i-1];
        //     y[i]=y[i-1];
        // }
        newTail.updateTail();
        switch(direction){
            case 'U': head.y = head.y-UNIT_SIZE;
            break;
            case 'D': head.y = head.y+UNIT_SIZE;
            break;
            case 'R': head.x = head.x+UNIT_SIZE;
            break;
            case 'L':head.x = head.x-UNIT_SIZE;
            break;
        }

    }
    public void newApple(){
        // appleX=random.nextInt((int)SCREEN_WIDTH/UNIT_SIZE)*UNIT_SIZE;
        // appleY=random.nextInt((int)SCREEN_HEIGHT/UNIT_SIZE)*UNIT_SIZE;
        apple.genCoordinats();
        
        System.out.println(apple.appleX);
    }
    public void checkApple(){
        if((head.x==apple.appleX)&& head.y==apple.appleY){
            newApple();
            newTail.addBlock();
            applesEaten++;
        }
         //System.out.println(applesEaten);

    }
    public void checkColision(){
        for(int i=newTail.getTailLength();i>0;i--){
            TailBlock block=newTail.getBlock(i);
            if((head.x==block.x) && (head.y==block.y)){
                running=false;
            }
        }
        if(head.x>SCREEN_WIDTH){
            running=false;

            
        }
        if(head.x<0){
            running=false;

            
        }
        if(head.y>SCREEN_HEIGHT){
            running=false;
            
            
        }
        if(head.y<0){
            running=false;
        
        }
        if(!running){
            timer.stop();
        }
    }
    public void gameOver(Graphics g){
        g.setColor(Color.red);
        g.setFont(new Font("Italic",Font.BOLD,80));
        g.drawString("Game Over", 100, SCREEN_HEIGHT/2);
        
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if(running){
            move();
            checkApple();
            checkColision();
            apple.createColor();
            newTail.blinkColor();
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
                }break;
                case KeyEvent.VK_RIGHT:
                if(direction!='L'){
                    direction='R';
                }break;
                case KeyEvent.VK_UP:
                if(direction!='D'){
                    direction='U';
                }break;
                case KeyEvent.VK_DOWN:
                if(direction!='U'){
                    direction='D';
                }break;
            }
        }
    }

}