import java.awt.*;
public class Score extends GameFeature{
    int value = 0;
    private String text="score ";
    private String fontName = "Italic";
    private int fontSize = 20;
    private int fontWeight = Font.BOLD;
    private Color color = Color.CYAN;
    private int x=250;
    private int y=30;

    public void paint(){
        graphic.setColor(color);
        graphic.setFont(new Font(this.fontName,this.fontWeight,this.fontSize));
        graphic.drawString(text+this.value, x, y);
    }
    
}
