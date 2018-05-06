 package botw;

import javax.swing.JFrame;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.awt.Dimension;
import java.awt.event.MouseListener;

public class Game extends Canvas implements Runnable {

	public static final int WIDTH = 900, HEIGTH = WIDTH/12*9;
	public static final int SCALE = 2;
	public final String TITLE = "Bread of the Wild";

	private Thread thread;
	private boolean runnig = false;
//  private boolean mouse = false;

	public int tickCount = 0;

	private Handler h;

	public static BufferedImage ss;
	public static BufferedImage sm;

	private BufferedImage persona = new BufferedImage(WIDTH, HEIGTH, BufferedImage.TYPE_INT_RGB);
	private int[] pixels = ((DataBufferInt)persona.getRaster().getDataBuffer()).getData();

/*----------Main Menu Stuff--------------*/
	private Menu menu;
	public static enum STATE{
		MENU,
		GAME,
    BATTLE,
    ITEM,
    FIGHT
	};

	public static STATE State = STATE.BATTLE;


	/*-------------Battle stuff--------------*/

private Battle battle;
private Fight fight;
private Item item;

  /*-------------------------------------*/

	public Game() {
		h = new Handler();
		menu  = new Menu();
    battle =new Battle();
    fight = new Fight();
    item = new Item();

		ImageLoader loader = new ImageLoader();
		try {
			sm = loader.load("/Map002.png");
			ss = loader.load("/testcharacter.png");
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("Image not loaded, restart the game");
		}

		this.addKeyListener(new KInput(h));
		this.addMouseListener(new MenuInput() ); //menu Input
    this.addMouseListener(new BattleInput() ); //battle input
    this.addMouseListener(new FightInput() ); //fight input

		new Window(WIDTH, HEIGTH, "Bread of the Wild", this);

		h.addObject(new Mapa(0, 0, ID.Mapa));
		h.addObject(new PJ(WIDTH/2-32, HEIGTH/2-32, ID.Player, 2, 3));
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


		h.render(g);



		g.setColor(Color.black);
		g.fillRect(0,0, WIDTH, HEIGTH);

		if(State == STATE.GAME){
			h.render(g);
		}
		else if(State == STATE.MENU){
			menu.render(g);

		}else if(State == STATE.BATTLE){
      battle.render(g);

    }else if(State == STATE.FIGHT){
      fight.render(g);

    }else if(State == STATE.ITEM){
      item.render(g);
    }


		g.dispose();
		bs.show();
	}



	public static void main(String[] args) {

		Game game = new Game();
		game.setPreferredSize(new Dimension(WIDTH*SCALE, HEIGTH*SCALE));
		game.setMaximumSize(new Dimension(WIDTH*SCALE, HEIGTH*SCALE));
		game.setMinimumSize(new Dimension(WIDTH*SCALE, HEIGTH*SCALE));


	}

}
