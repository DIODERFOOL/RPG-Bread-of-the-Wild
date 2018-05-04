package botw;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Font;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;


public class Item{

  public Rectangle item1 = new Rectangle (50, 440, 120,30);
  public Rectangle item2 = new Rectangle(50,490, 120, 30);
  public Rectangle item3 = new Rectangle(50, 540, 120, 30);
  public Rectangle item4 = new Rectangle(50, 590, 120, 30);
  public Rectangle backButton = new Rectangle(720, 590, 100, 40);


  //public Rectangle backButton = new Rectangle(, 310, 200, 50);
  //public Rectangle creditsButton = new Rectangle(Game.WIDTH/5+120, 360, 200, 50);

  ImageLoader loader = new ImageLoader();
  public BufferedImage arena, muffin, enemy;

  public Item(){
    try {
      arena = loader.load("/battleArena.jpg");
      muffin = loader.load("/testMcMuffin.png");
      enemy = loader.load("/testEnemy.png");
    }catch (Exception e) {
      e.printStackTrace();
      System.out.println("Image not loaded, restart the game");
    }
  }

  public void render(Graphics g){

		Graphics2D g2d = (Graphics2D)g;
    g.drawImage(arena,-9,-5,1100,675, null);
    g.drawImage(muffin, 100,170,250,250,null);
    g.drawImage(enemy, 550, 170,250,250,null);

		Font fnt = new Font("arial", Font.BOLD, 30);
		g.setFont(fnt);
		g.setColor(Color.white);
		g.drawString("McMuffin", 30, 30);
    g.drawString("Spoiled Bread",650, 30);

		Font fnt1 = new Font("arial", Font.PLAIN, 30);
		g.setFont(fnt1);
		g.setColor(Color.white);

		g.drawString(">Item1", item1.x + 15, item1.y + 26);
		g2d.draw(item1);

		g.drawString(">Item2", item2.x + 15, item2.y + 26);
		g2d.draw(item2);

		g.drawString(">Item3", item3.x + 15, item3.y + 26);
		g2d.draw(item3);

    g.drawString(">Item4", item4.x + 15, item4.y + 26);
    g2d.draw(item4);

    g.drawString("Back", backButton.x + 15, backButton.y +30);
    g2d.draw(backButton);

	}

}
