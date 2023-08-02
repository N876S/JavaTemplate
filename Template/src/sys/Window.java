package sys;

import java.awt.Dimension;

import javax.swing.JFrame;

public class Window{
	public Window(int width, int height, String name){
		JFrame f = new JFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setResizable(false);
		f.setPreferredSize(new Dimension(width,height));
		f.setVisible(true);
		f.setTitle(name);
		f.pack();
		f.add(Main.m);
		f.setLocationRelativeTo(null);
	}
}
