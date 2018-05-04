package botw;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Font;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;


public class Fight{

  public Rectangle attack = new Rectangle (50, 450, 240,40);
  public Rectangle specialAttack = new Rectangle(50,500, 240, 40);
  public Rectangle defend = new Rectangle(50, 550, 240, 40);
  public Rectangle backButton = new Rectangle(720, 590, 100, 40);
  //public Rectangle creditsButton = new Rectangle(Game.WIDTH/5+120, 360, 200, 50);

  ImageLoader loader = new ImageLoader();
  public BufferedImage arena, muffin, enemy;

  public Fight(){
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

		g.drawString(">Attack", attack.x + 15, attack.y + 30);
		g2d.draw(attack);

		g.drawString(">Special Attack", specialAttack.x + 15, specialAttack.y + 30);
		g2d.draw(specialAttack);

		g.drawString(">Defend", defend.x + 15, defend.y + 30);
		g2d.draw(defend);

    g.drawString("Back", backButton.x + 15, backButton.y +30);
    g2d.draw(backButton);


	}

  public void renderfight(Graphics g){

  }
}
