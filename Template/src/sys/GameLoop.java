package sys;

import java.awt.GraphicsEnvironment;

public class GameLoop implements Runnable {

	public static boolean isRunning;

	private final int monitorFps = GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices()[0]
			.getDisplayMode().getRefreshRate();
	//----fps cap is automatically synced with monitor----
	private final int maxFps = monitorFps;
	//----ups cap is 60----
	private final int maxUps = 60;

	long previousTime = System.nanoTime();

	private int frames = 0;
	private int updates = 0;
	long lastCheck = System.currentTimeMillis();

	double timePerFrame = 1000000000.0 / maxFps;
	double timePerUpdate = 1000000000.0 / maxUps;

	double deltaU = 0;
	double deltaF = 0;

	public void run() {
		isRunning = true;

		while (isRunning) {

			long currentTime = System.nanoTime();

			deltaU += (currentTime - previousTime) / timePerUpdate;
			deltaF += (currentTime - previousTime) / timePerFrame;
			previousTime = currentTime;

			if (deltaU >= 1) {
				Main.m.update();
				updates++;
				deltaU--;
			}

			if (deltaF >= 1) {

				Main.m.repaint();
				deltaF--;
				frames++;
			}

			if (System.currentTimeMillis() - lastCheck >= 1000) {
				lastCheck = System.currentTimeMillis();
				System.out.println("FPS: " + frames + " | UPS: " + updates);
				frames = 0;
				updates = 0;
			}
		}
	}
}
