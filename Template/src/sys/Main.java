package sys;

import java.awt.Graphics;

import javax.swing.JPanel;

import manager.Game;

public class Main extends JPanel{
	
	private static final long serialVersionUID = 1L;
	static Main m = new Main();
	
	//-----set width, height, and name-----
	private static final int width = 800;
	private static final int height = 800;
	private static final String name = "";
	
	public static void main(String[] args) {
		new Window(width, height, name);
		new Thread(new GameLoop()).start();
	}
	
	public void paint(Graphics g) {
		Game.draw(g);
	}
	
	public void update() {
		Game.update();
	}
}
