package paint.Drawing;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import paint.ScribblePad.*;
import paint.Tool.*;

public class DrawingPad extends Scribble {

    public DrawingPad(String title) {
        super(title);
        initTools();
        ActionListener toolListener = new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                Object source = event.getSource();
                if (source instanceof AbstractButton) {
                    AbstractButton button = (AbstractButton) source;
                    Tool tool = toolkit.setSelectedTool(button.getText());
                    drawingCanvas.setTool(tool);
                }
            }
        };
        JComponent toolbar = createToolBar(toolListener);
        getContentPane().add(toolbar, BorderLayout.WEST);
    }

    public Tool getSelectedTool() {
        return toolkit.getSelectedTool();
    }

    protected void initTools() {
        toolkit = new ToolKit();
        toolkit.addTool(new ScribbleTool(canvas, "Lapiz"));
        toolkit.addTool(new TwoEndsTool(canvas, "Linea", TwoEndsTool.LINE));
        toolkit.addTool(new TwoEndsTool(canvas, "Circulo", TwoEndsTool.OVAL));
        toolkit.addTool(new TwoEndsTool(canvas, "Rectangulo", TwoEndsTool.RECT));
        drawingCanvas.setTool(toolkit.getTool(0));
    }

    // factory method 
    protected ScribbleCanvas makeCanvas() {
        return (drawingCanvas = new DrawingCanvas());
    }

    protected JComponent createToolBar(ActionListener toolListener) {
        JPanel toolbar = new JPanel(new GridLayout(0, 1));
        int n = toolkit.getToolCount();
        for (int i = 0; i < n; i++) {
            Tool tool = toolkit.getTool(i);
            if (tool != null) {
                JButton button = new JButton(tool.getName());
                button.addActionListener(toolListener);
                toolbar.add(button);
            }
        }
        return toolbar;
    }

    protected ToolKit toolkit;
    protected DrawingCanvas drawingCanvas;

    public static void main(String[] args) {
        JFrame frame = new DrawingPad("Paint - Grupo 3");
        frame.setSize(width, height);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(screenSize.width / 2 - width / 2,
                screenSize.height / 2 - height / 2);
        frame.show();
    }

}
