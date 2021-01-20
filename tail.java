import java.util.ArrayList;
import java.awt.*;

public class Tail  {
    ArrayList<TailBlock> tailBody = new ArrayList<TailBlock>();
    int initiallength=30;
    

    public int getTailLength(){
        return tailBody.size()-1;
    }
    
    public TailBlock getBlock(int index){
        return tailBody.get(index);
    }

    public void addBlock(){
        tailBody.add(new TailBlock(0, 0));
    }

    public void blinkColor(){
        for(int i=1;i<=getTailLength();i++){
            tailBody.get(i).createColor();
        }
    }
    public void paint(){
        
        for(int i=0;i<this.getTailLength();i++){
            TailBlock block = this.getBlock(i);
            block.paint(i);
        }
    }

    public void createInitialTail(){
        
        for(int i=0; i<=initiallength; i++){
           int x=(initiallength-1-i)*GameFeature.UNIT_SIZE;
           int y=0;
           TailBlock tailBlock=new TailBlock(x,y);
           //System.out.println(x);
           tailBody.add(tailBlock);
        }
        
    }
    
    public void updateTail(){
        for(int i=getTailLength(); i>0;i--){
            TailBlock currentBlock = tailBody.get(i);
            TailBlock nextBlock = tailBody.get(i-1);

            currentBlock.x=nextBlock.x;
            currentBlock.y=nextBlock.y;

        }
    }

}
class TailBlock extends GameFeature{
    int x;
    int y;
    int width=UNIT_SIZE;
    int height=UNIT_SIZE;
    Color color;
    Util util;
    TailBlock(int x, int y){
        this.x=x;
        this.y=y;
        util = new Util();
        color = util.createColor();

    }
    public void paint(int index){
        if(index==0){
            graphic.setColor(Color.green);
            graphic.fillRect(this.x, this.y, UNIT_SIZE, UNIT_SIZE);
        }else{
            graphic.setColor(this.color);
            graphic.fillRect(this.x, this.y, UNIT_SIZE, UNIT_SIZE);
        }
    }
    public void createColor(){
        color = util.createColor();
    }

}