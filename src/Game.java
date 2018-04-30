package botw;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable {

	public static final int WIDTH = 800, HEIGTH = WIDTH/12*9;

	private Thread thread;
	private boolean runnig = false;

	private Handler h;

	public Game() {
		h = new Handler();

		this.addKeyListener(new KInput(h));

		new Window(WIDTH, HEIGTH, "Bread of the Wild", this);

		h.addObject(new PJ(WIDTH/2-32, HEIGTH/2-32, ID.Player));
	}

	public synchronized void start() {
		thread = new Thread(this);
		thread.start();
		runnig = true;
	}

	public synchronized void stop() {
		try{
			thread.join();
			runnig = false;
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void run() {
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		while(runnig) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while(delta >= 1) {
				tick();
				delta--;
			}
			if(runnig)
				render();
			frames ++;

			if(System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				System.out.println("FPS: " + frames);
				frames = 0;
			}
		}
		stop();
	}

	private void tick() {
		h.tick();
	}

	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null) {
			this.createBufferStrategy(3);
			return;
		}	

		Graphics g = bs.getDrawGraphics();

		g.setColor(Color.black);
		g.fillRect(0,0, WIDTH, HEIGTH);

		h.render(g);

		g.dispose();
		bs.show();
	}


	public static void main(String[] args) {
		new Game();
	}
}