import java.util.ArrayList;
import java.util.List;
import java.awt.*;

public class tail implements gameFeature {
    ArrayList<TailBlock> tailBody = new ArrayList<TailBlock>();
    int initiallength=6;

    public int getTailLength(){
        return tailBody.size()-1;
    }
    public TailBlock getBlock(int index){
        return tailBody.get(index);
    }
    public void addBlock(){
        tailBody.add(new TailBlock(0, 0));
    }
    public void createInitialTail(){
        
        for(int i=0; i<=initiallength;i++){
           int x=(initiallength-1-i)*UNIT_SIZE;
           int y=0;
           TailBlock tailB=new TailBlock(x,y);
           //System.out.println(x);
           tailBody.add(tailB);
        }
        
    }
    public void blinkColor(){
        for(int i=1;i<=getTailLength();i++){
            tailBody.get(i).createColor();
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
class TailBlock{
    int x;
    int y;
    Color color;
    Util util;
    TailBlock(int x, int y){
        this.x=x;
        this.y=y;
        util = new Util();
        color = util.createColor();

    }
    public void createColor(){
        color = util.createColor();
    }

}