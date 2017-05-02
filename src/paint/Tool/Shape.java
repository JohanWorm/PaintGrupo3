package paint.Tool;

import java.awt.*;
import java.io.Serializable;

public abstract class Shape implements Serializable {
    
    public abstract void draw(Graphics g);

    protected Color color = Color.black;

    public Shape() {
    }

    public Shape(Color color) {
        this.color = color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

}
