package botw;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Font;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Menu{


	public Rectangle playButton = new Rectangle(Game.WIDTH/5+120, 150, 200, 50);
	public Rectangle newGButton = new Rectangle(Game.WIDTH/5+120, 210, 200, 50);
	public Rectangle loadButton = new Rectangle(Game.WIDTH/5+120, 270, 200, 50);
	public Rectangle quitButton = new Rectangle(Game.WIDTH/5+120, 330, 200, 50);
	public Rectangle creditsButton = new Rectangle(Game.WIDTH/5+120, 390, 200, 50);

	ImageLoader loader = new ImageLoader();
 	public BufferedImage background;

 	public Menu(){
		try {
			background = loader.load("/texture.jpg");
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("Image not loaded, restart the game");
		}
 	}

	public void render(Graphics g){

		Graphics2D g2d = (Graphics2D)g;
		g.drawImage(background,Game.WIDTH/5 -200,Game.HEIGHT/5 -100, null);


		Font fnt = new Font("arial", Font.BOLD, 50);
		g.setFont(fnt);
		g.setColor(Color.white);
		g.drawString("Bread of the Wild", Game.WIDTH/5, 100);

		Font fnt1 = new Font("arial", Font.BOLD, 30);
		g.setFont(fnt1);
		g.setColor(Color.white);

		g.drawString("Play", playButton.x + 15, playButton.y + 30);
		g2d.draw(playButton);

		g.drawString("New Game", newGButton.x + 15, newGButton.y + 30);
		g2d.draw(newGButton);

		g.drawString("Load", loadButton.x + 15, loadButton.y + 30);
		g2d.draw(loadButton);

		g.drawString("Quit", quitButton.x + 15, quitButton.y + 30);
		g2d.draw(quitButton);

		g.drawString("Credits", creditsButton.x + 15, creditsButton.y + 30);
		g2d.draw(creditsButton);

	}
}
