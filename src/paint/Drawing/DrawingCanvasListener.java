package paint.Drawing;


import java.awt.*;
import java.awt.event.*;
import paint.ScribblePad.*;
import paint.Tool.*;

public class DrawingCanvasListener extends ScribbleCanvasListener {

    public DrawingCanvasListener(DrawingCanvas canvas) {
        super(canvas, null);
    }

    public Tool getTool() {
        return tool;
    }

    public void setTool(Tool tool) {
        this.tool = tool;
    }

}
