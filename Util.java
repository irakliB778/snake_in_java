import java.util.Random;
import java.awt.*;
public class Util {
    
   public Color createColor(){
        int red=new Random().nextInt((int)255);
        int green=new Random().nextInt((int)255);
        int blue=new Random().nextInt((int)255);

        return new Color(red,green,blue);
    }
}
