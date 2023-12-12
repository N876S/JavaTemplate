package sys;

import java.awt.Dimension;

import javax.swing.JFrame;

import manager.KeyManager;
import manager.MouseManager;
import manager.MouseMotionManager;
import manager.MouseWheelManager;

public class Window{
	MouseManager mm = new MouseManager();
	KeyManager km = new KeyManager();
	MouseMotionManager mmm = new MouseMotionManager();
	MouseWheelManager mwm = new MouseWheelManager();
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
		f.addMouseListener(mm);
		f.addKeyListener(km);
		f.addMouseMotionListener(mmm);
		f.addMouseWheelListener(mwm);
	}
}
