package botw;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Font;
import java.awt.Color;
import java.awt.Rectangle;
//import java.awt.event.MouseListener;
//import java.awt.event.MouseEvent;

public class Menu{

	//MenuInput menin = new MenuInput();

	public Rectangle playButton = new Rectangle(Game.WIDTH/5+120, 150, 200, 50);
	public Rectangle newGButton = new Rectangle(Game.WIDTH/5+120, 210, 200, 50);
	public Rectangle loadButton = new Rectangle(Game.WIDTH/5+120, 260, 200, 50);
	public Rectangle quitButton = new Rectangle(Game.WIDTH/5+120, 310, 200, 50);
	public Rectangle creditsButton = new Rectangle(Game.WIDTH/5+120, 360, 200, 50);

	public void render(Graphics g){

		Graphics2D g2d = (Graphics2D)g;

		Font fnt = new Font("arial", Font.BOLD, 50);
		g.setFont(fnt);
		g.setColor(Color.white);
		g.drawString("Bread of the Wild", Game.WIDTH/5, 100);

		Font fnt1 = new Font("arial", Font.BOLD, 30);
		g.setFont(fnt1);
		g.setColor(Color.white);

		g.drawString("Play", playButton.x + 15, playButton.y + 30);
		g2d.draw(playButton);
		//playButton.addMouseListener(menin);

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
