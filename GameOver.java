import java.awt.*;

public class GameOver extends GameFeature {
    private String text="Game Over";
    private String fontName = "Italic";
    private int fontSize = 80;
    private int fontWeight = Font.BOLD;
    private Color color = Color.red;
    private int x = 100;
    private int y = SCREEN_HEIGHT/2;
    
    GameOver(){
        graphic.setColor(color);
        graphic.setFont(new Font(this.fontName,this.fontWeight,this.fontSize));
        graphic.drawString(this.text, this.x, this.y);
        
    }
}
