 package botw;

import javax.swing.JFrame;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.awt.Dimension;

public class Game extends Canvas implements Runnable {

	public static final int WIDTH = 800, HEIGTH = WIDTH/12*9;

	private Thread thread;
	private boolean runnig = false;

	public int tickCount = 0;

	private Handler h;

	public static BufferedImage ss;

	private BufferedImage persona = new BufferedImage(WIDTH, HEIGTH, BufferedImage.TYPE_INT_RGB);
	private int[] pixels = ((DataBufferInt)persona.getRaster().getDataBuffer()).getData();

/*----------Main Menu Stuff--------------*/
	private Menu menu;

	public static enum STATE{
		MENU,
		GAME
	};

	public static STATE State = STATE.MENU; 


	public Game() {
		h = new Handler();
		menu  = new Menu();

		ImageLoader loader = new ImageLoader();
		try {
			ss = loader.load("/testcharacter.png");
		}catch (Exception e) {
			e.printStackTrace();	
		}
		
		this.addKeyListener(new KInput(h));
		this.addMouseListener(new MenuInput() );

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
		int ticks = 0; 
		
		while(runnig) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			boolean shouldRender = true;

			while(delta >= 1) {
				ticks++;
				tick();
				delta--;
				shouldRender = true;
			}

			try{
				Thread.sleep(2);
			}catch (InterruptedException e){
				e.printStackTrace();
			}

			if(shouldRender){
				render();
				frames ++;
			}

			//if(runnig)

			if(System.currentTimeMillis() - timer >= 1000) {
				timer += 1000;
				System.out.println("FPS: " + frames + " TICKS(Updates): " + ticks);
				frames = 0;
				ticks = 0;
			}
		}
		stop();
	}

	private void tick() {
		tickCount++;

		for(int i=0; i<pixels.length; i++){
			pixels[i] = i+ tickCount;
		}

		if(State == STATE.GAME){
			h.tick();
		}
	}

	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null) {
			this.createBufferStrategy(3);
			return;
		}	

		Graphics g = bs.getDrawGraphics();

		g.drawImage(persona, 0, 0, WIDTH, HEIGTH, null);

		g.setColor(Color.black);
		g.fillRect(0,0, WIDTH, HEIGTH);

		if(State == STATE.GAME){
			h.render(g);
		}
		else if(State == STATE.MENU){
			menu.render(g);
		}

		g.dispose();
		bs.show();
	}


	public static void main(String[] args) {
		new Game();
	}
}