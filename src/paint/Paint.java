/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paint;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*; 

public class Paint extends JFrame {

  public Paint() {
    setTitle("Scribble Pad");
    canvas = new ScribbleCanvas(); 
    canvas.setBackground(Color.white); 
    getContentPane().setLayout(new BorderLayout()); 
    getContentPane().add(canvas, BorderLayout.CENTER);
    addWindowListener(new WindowAdapter() {
	public void windowClosing(WindowEvent e) {
	  System.exit(0);
	}
      }); 
  }

  public static void main(String[] args) {
    int width = 600; 
    int height = 400; 
    JFrame frame = new Paint();
    frame.setSize(width, height);
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    frame.setLocation(screenSize.width/2 - width/2,
		      screenSize.height/2 - height/2);
    frame.show();
  }

  protected ScribbleCanvas canvas; 

}
