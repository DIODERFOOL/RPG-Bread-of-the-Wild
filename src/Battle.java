package botw;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Font;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;


public class Battle{

  public Rectangle fight = new Rectangle (50, 450, 120,40);
  public Rectangle item = new Rectangle(50,500, 120, 40);
  public Rectangle run = new Rectangle(50, 550, 120, 40);

  //public Rectangle backButton = new Rectangle(, 310, 200, 50);
  //public Rectangle creditsButton = new Rectangle(Game.WIDTH/5+120, 360, 200, 50);

  ImageLoader loader = new ImageLoader();
  public BufferedImage arena, muffin, enemy;

  public Battle(){
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

  	g.drawString(">Fight", fight.x + 15, fight.y + 30);
  	g2d.draw(fight);

  	g.drawString(">Item", item.x + 15, item.y + 30);
  	g2d.draw(item);

  	g.drawString(">Run", run.x + 15, run.y + 30);
  	g2d.draw(run);

  }

  public void renderfight(Graphics g){
    
  }
}
