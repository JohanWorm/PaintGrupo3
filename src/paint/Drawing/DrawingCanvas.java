package paint.Drawing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.util.*;
import java.io.*;
import java.awt.event.*;
import java.util.EventListener;
import javax.swing.*;
import paint.ScribblePad.*;
import paint.Tool.*;

public class DrawingCanvas extends ScribbleCanvas {

    protected DrawingCanvasListener drawingCanvasListener;
    
    public DrawingCanvas() {
    }

    public void setTool(Tool tool) {
        drawingCanvasListener.setTool(tool);
    }

    public Tool getTool() {
        return drawingCanvasListener.getTool();
    }

    // factory method 
    protected EventListener makeCanvasListener() {
        return (drawingCanvasListener = new DrawingCanvasListener(this));
    }

}
