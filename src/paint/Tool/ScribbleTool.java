package paint.Tool;

import java.awt.*;
import paint.ScribblePad.ScribbleCanvas;
import paint.ScribbleMenu.Stroke;

public class ScribbleTool extends AbstractTool { 

  public ScribbleTool(ScribbleCanvas canvas, String name) {
    super(canvas, name);
  }

  public void startShape(Point p) {
    curStroke = new Stroke(canvas.getCurColor()) {}; 
    curStroke.addPoint(p); 
  }

  public void addPointToShape(Point p) {
    if (curStroke != null) { 
      curStroke.addPoint(p); 
      Graphics g = canvas.getGraphics();
      g.setColor(canvas.getCurColor());
      g.drawLine(canvas.x, canvas.y, p.x, p.y); 
    }
  }

  public void endShape(Point p) {
    if (curStroke != null) { 
      curStroke.addPoint(p); 
      canvas.addShape(curStroke); 
      curStroke = null; 
    }
  }

  protected Stroke curStroke = null; 

}
